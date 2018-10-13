package com.liuge.TMShop.network;

import android.graphics.Bitmap;
import android.util.Base64;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.ByteArrayOutputStream;

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
    }

    /**
     * 获取商品详情
     * @param id
     * @param call
     */
    public void getGoodsDetails(String id,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.GOODS_DETAIL;
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
        x.http().get(params, call);
    }
    public void getPaiMaiDetails(String id,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.INDEX_PAIMAI_DETAILS;
        RequestParams params = new RequestParams(URL);
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
            params.addBodyParameter("monney", id);
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
    public void addCart(String id,String num ,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.ADD_CART;
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
    public void mallInfo(String id,Callback.CommonCallback<String> call){
        URL = SixGridContext.DO.MALL_INFO;
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
            params.addBodyParameter("status", ""+1);



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
