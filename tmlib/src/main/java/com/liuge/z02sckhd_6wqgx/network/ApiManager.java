package com.liuge.z02sckhd_6wqgx.network;

import android.graphics.Bitmap;
import android.util.Base64;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

/**
 * Created by jiang on 2018/2/22.
 */

public class ApiManager {
    private String URL;

    public ApiManager() {

    }
//
//    public ApiManager(Context mContext) {
//        ApplicationInfo info=TMAndroid.getApplicationInfo(mContext);
//    }


    /**
     * 获取商品分类
     * @param call
     */
    public void getGoodsClass(String pid, Callback.CommonCallback<String> call) {
        URL = SixGridContext.DO.GOODS_CLASS;
        RequestParams params = new RequestParams(URL);
        if(pid!=null) {
            params.addBodyParameter("pid", pid);
        }
        x.http().get(params, call);
    }

    /**
     * 获取商品列表
     * @param call
     */
    public void getGoodsList(String cate_id,String sid,String sort,String order,String p,String is_best,Callback.CommonCallback<String> call) {
        URL = SixGridContext.DO.GOODS_List;
        RequestParams params = new RequestParams(URL);
        params.addHeader("Connection","close");
        if(cate_id!=null){
            params.addBodyParameter("cate_id", cate_id);
        }
        if(sid!=null){
            params.addBodyParameter("sid", sid);
        }
        if(sort!=null){
            params.addBodyParameter("sort", sort);
        }
        if(order!=null){
            params.addBodyParameter("order", order);
        }
        if(p!=null){
            params.addBodyParameter("p", p);
        }
        if(is_best!=null){
            params.addBodyParameter("is_best", is_best);
        }
        x.http().get(params, call);
    }   /**
     * 获取商品列表
     * @param call
     */
    public void getGoodsSearch(String key,Callback.CommonCallback<String> call) {
        URL = SixGridContext.DO.GOODS_List;
        RequestParams params = new RequestParams(URL);

        params.addBodyParameter("keyword", key);

        x.http().get(params, call);
    }

    /**
     * 获取商品详情
     * @param id
     * @param call
     */
    public void getGoodsDetails(String id,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.GOODS_DETAIL;
        RequestParams params = new RequestParams(URL);
        params.addHeader("Connection","close");
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        if(id!=null){
            params.addBodyParameter("id", id);
        }
        x.http().get(params, call);
    }
    /**
     * 获取商品详情
     * @param id
     * @param call
     */
    public void getGoodsTuangou(String id,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.TUANGOU_DETAILS;
        RequestParams params = new RequestParams(URL);
        if(id!=null){
            params.addBodyParameter("id", id);
        }
        x.http().get(params, call);
    }
    /**
     * 获取商品详情
     * @param id
     * @param call
     */
    public void getGoodsCom(String id,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.GOODS_COMMENT;
        RequestParams params = new RequestParams(URL);
        if(id!=null){
            params.addBodyParameter("id", id);
        }
        x.http().get(params, call);
    }
    public void getBanner(Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.INDEX_BANNER;
        RequestParams params = new RequestParams(URL);
        params.addHeader("Connection","close");
        x.http().get(params, call);
    }
    public void getPaiMaiDetails(String id,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.INDEX_PAIMAI_DETAILS;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        if(id!=null){
            params.addBodyParameter("id", id);
        }
        x.http().get(params, call);
    }
    public void getMiaoshaDetails(String id,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.GOODS_MIAOSHA;
        RequestParams params = new RequestParams(URL);
        if(id!=null){
            params.addBodyParameter("id", id);
        }
        x.http().get(params, call);
    }
    public void toPaimai(String id,String monney,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.INDEX_PAIMAI_TO;
        RequestParams params = new RequestParams(URL);
        if(id!=null){
            params.addBodyParameter("id", id);
        }
        if(monney!=null){
            params.addBodyParameter("price", monney);
        }
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        x.http().get(params, call);
    }
    public void toTuangou(String id,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.TUANGOU_TO;
        RequestParams params = new RequestParams(URL);
        if(id!=null){
            params.addBodyParameter("id", id);
        }
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
            params.addBodyParameter("quantity", "1");
        }

        x.http().get(params, call);
    }
    public void addCart(String id,String num ,String guige,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.ADD_CART;
        RequestParams params = new RequestParams(URL);
        if(id!=null){
            params.addBodyParameter("id", id);
        }
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
            params.addBodyParameter("quantity", num);
            params.addBodyParameter("spec_id",guige);
        }

        x.http().get(params, call);
    }
    public void toBuy(String id,String num ,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.GOODS_TO_BY;
        RequestParams params = new RequestParams(URL);
        if(id!=null){
            params.addBodyParameter("spec_id", id);
        }
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
            params.addBodyParameter("quantity", num);
        }

        x.http().get(params, call);
    }
    public void miaoshaBuy(String id,String num ,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.MIAOSHA_BUY;
        RequestParams params = new RequestParams(URL);
        if(id!=null){
            params.addBodyParameter("id", id);
        }
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
            params.addBodyParameter("quantity", num);
        }

        x.http().get(params, call);
    }
    public void mallInfo(String id,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.MALL_DETAIL;
        RequestParams params = new RequestParams(URL);
        if(id!=null){
            params.addBodyParameter("sid", id);
        }

        x.http().get(params, call);
    }

    public void getCart(Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.GET_CART;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        x.http().get(params, call);
    }

    public void getShouyi(String type,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.MINE_SHOUYI;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        if(type!=null){
            params.addBodyParameter("type", type);
        }
            params.addBodyParameter("status", ""+0);

        x.http().get(params, call);
    }

    public void getAddress(Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.MINE_ADDRESS;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        x.http().get(params, call);
    }
    public void addAddress(String address,String address_name,String consignee,String tel,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.ADD_ADDRESS;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        if(address!=null){
            params.addBodyParameter("address", address);
        }
        if(address_name!=null){
            params.addBodyParameter("address_name", address_name);
        }
        if(consignee!=null){
            params.addBodyParameter("consignee", consignee);
        }
        if(tel!=null){
            params.addBodyParameter("tel", tel);
        }
        x.http().get(params, call);
    }
    public void editAddress(String id,String address,String address_name,String consignee,String tel,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.EDIT_ADD;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        if(id!=null){
            params.addBodyParameter("aid", id);
        }
        if(address!=null){
            params.addBodyParameter("address", address);
        }
        if(address_name!=null){
            params.addBodyParameter("address_name", address_name);
        }
        if(consignee!=null){
            params.addBodyParameter("consignee", consignee);
        }
        if(tel!=null){
            params.addBodyParameter("tel", tel);
        }
        x.http().get(params, call);
    }

    public void delAddress(String id,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.DEL_ADDRESS;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("aid", id);
        x.http().get(params, call);
    }
    public void beDef(String id,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.BE_DEF;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("address_id", id);
        x.http().get(params, call);
    }
    public void collect(String id,String type,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.COLLECT;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("id", id);
        params.addBodyParameter("type", type);
        x.http().get(params, call);
    }
    public void getCollect(String type,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.MINE_COLLECT;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("type", type);
        x.http().get(params, call);
    }
    public void delCollect(String id,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.DEL_COLLECT;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("id", id);
        x.http().get(params, call);
    }

    public void getSearch(String key, Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.SEARCH;
        RequestParams params = new RequestParams(URL);
//        if(SixGridContext.token!=null){
//            params.addBodyParameter("token", SixGridContext.token);
//        }

        params.addBodyParameter("keyword", key);
        x.http().get(params, call);
    }
    public void tuangou_buy(String id,String quantity, Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.TUANGOU_BUY;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("id", id);
        params.addBodyParameter("quantity", quantity);
        x.http().get(params, call);
    }
    public void cart_update(String id,String quantity, Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.CART_COUNT;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("spec_id", id);
        params.addBodyParameter("quantity", quantity);
        x.http().get(params, call);
    }
    public void chooseOne(String id,int status, Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.CART_CHOOSE;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("rec_id", id);
        params.addBodyParameter("status", ""+status);
        x.http().get(params, call);
    }
    public void chooseAll(String id,int status, Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.CART_CHOOSEALL;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        if(id!=null) {
            params.addBodyParameter("sid", id);
        }
        params.addBodyParameter("status", ""+status);
        x.http().get(params, call);
    }
    public void submitCart( Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.SUBMIT_CART;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        x.http().get(params, call);
    }
    public void createOrder(String flow_type,String address_id,String pay_id,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.CREATE_ORDER;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        if(flow_type!=null){
            params.addBodyParameter("flow_type", flow_type);
        }
        if(address_id!=null){
            params.addBodyParameter("address_id", address_id);
        }
        if(pay_id!=null){
            params.addBodyParameter("pay_id", pay_id);
        }
        x.http().get(params, call);
    }
    public void mineOrder(int order_status,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.MINE_ORDER;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
//        if(order_status!=-1){
            params.addBodyParameter("order_status", ""+order_status);
//        }
        x.http().get(params, call);
    }
    public void orderPay(String mid,String type,String sn,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.ORDER_PAY;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        params.addBodyParameter("mid", mid);
        params.addBodyParameter("type", type);
        params.addBodyParameter("form", sn);

        x.http().get(params, call);
    }
    public void userAccount(Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.USER_ACCOUNT;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        x.http().get(params, call);
    }
    public void addAccount(String type,String num,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.ADD_ACCOUNT;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("type", type);
        params.addBodyParameter("number", num);

        x.http().get(params, call);
    }
    public void delAccount(String id,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.DEL_ACCOUNT;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("id", id);

        x.http().get(params, call);
    }
    public void applyTixian(String id,String price,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.APPLY_TIXIAN;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("account_id", id);
        params.addBodyParameter("price", price);

        x.http().get(params, call);
    }
    public void cancal(String id,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.CANCAL_ORDER;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("mid", id);

        x.http().get(params, call);
    }
    public void returnOrder(String rec_id,String order_id,String type,String reason,String desc,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.RETURN_ORDER;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("rec_id", rec_id);
        params.addBodyParameter("order_id", order_id);
        params.addBodyParameter("type", type);
        params.addBodyParameter("reson", reason);
        params.addBodyParameter("desc", desc);

        x.http().get(params, call);
    }
    public void orderComment(String rec_id, String comment, String scor, List<String> img, Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.ORDER_COMMENT;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("rec_id", rec_id);
        params.addBodyParameter("comment", comment);
        params.addBodyParameter("Score", scor);
        String image="";
        for(int i=0;i<img.size();i++) {
            if(i==0) {
                image=img.get(i);
            }else{
                image=image+","+img.get(i);
            }
        }

        params.addBodyParameter("images", image);

        x.http().get(params, call);
    }

    public void orderRecive(String order,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.GOODS_RECEIVE;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("order_id", order);

        x.http().get(params, call);
    }

    public void orderDetails(String order,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.ORDER_DETAIL;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("mid", order);

        x.http().get(params, call);
    }
    public void cannalTixian(String mid,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.CANNAL_TIXIAN;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }

        params.addBodyParameter("mid", mid);

        x.http().get(params, call);
    }

    public void submitOrder( Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.SUBMIT_CART;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        params.addBodyParameter("flow_type", "5");
        x.http().get(params, call);
    }
    public void bindCode(String code,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.BIND;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        params.addBodyParameter("code", code);
        x.http().get(params, call);
    }
    public void mineCode(Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.CODE_DETAIL;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        x.http().get(params, call);
    }
    public void delGoods(String id,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.DEL_GOODS;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        params.addBodyParameter("rec_id", id);
        x.http().get(params, call);
    }
    public void mineVip(Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.MINE_VIP;
        RequestParams params = new RequestParams(URL);
        if(SixGridContext.token!=null){
            params.addBodyParameter("token", SixGridContext.token);
        }
        x.http().get(params, call);
    }
    public void uploadImg(String path,Callback.CommonCallback<String>call){
        URL = SixGridContext.DO.UPLOAD_IMG;
        RequestParams params = new RequestParams(URL);
        params.setMultipart(true);//强制转为表单文件
//        if(SixGridContext.token!=null){
            params.addBodyParameter("type", "6");
            params.addBodyParameter("file", new File(path));
//        }
        x.http().post(params, call);
    }


    /**
     * 通过Base32将Bitmap转换成Base64字符串
     *
     * @param bit
     * @return
     */
    public String Bitmap2StrByBase64(Bitmap bit) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG, 40, bos);//参数100表示不压缩
        byte[] bytes = bos.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

}
