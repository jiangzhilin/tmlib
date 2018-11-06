package com.liuge.z02sckhd_6wqgx.network;

import android.app.Activity;
import android.app.Application;

import com.tenma.ventures.bean.utils.TMSharedPUtil;

import org.xutils.x;

/**
 * Created by jiang on 2018/2/22.
 */

public class SixGridContext {

    public static String RMB="¥";
    public static String IMG_TAG= "data:image/png;base64,";
    public static String WX_ID= "wx9a3c30b2de9298dd";
    public static String WX_SCR= "11ba3b55f2cd46ca652d1b434695ae10";
    public static String QQ_ID= "1106604259";
    public static String token= null;
    public static String HOST="http://shop.dktoo.com/z02sckhd_6wqgx";

//    public static String IMG="http://shop.dktoo.com/lee/";

    public static void init(Application app){
            x.Ext.init(app);
            x.Ext.setDebug(true);
            token=TMSharedPUtil.getTMToken(app);
    }
    public static void init(Activity activity){
            x.Ext.init(activity.getApplication());
            x.Ext.setDebug(true);
            token=TMSharedPUtil.getTMToken(activity);
    }

    public static class Type{
        public static String MAP="Pile/";
    }
    public static class Action{
        public static String INDEX_MARKER="GetPileSiteMap";


    }
    public static class DO{
        public static String GOODS_CLASS=HOST+"/apigoods/category";
        public static String GOODS_List=HOST+"/apigoods/index";
        public static String GOODS_DETAIL=HOST+"/apigoods/detail";
        public static String GOODS_COMMENT=HOST+"/apigoods/getcomment";
        public static String INDEX_BANNER=HOST+"/apiuser/index";
        public static String INDEX_PAIMAI_DETAILS=HOST+"/apiauction/detail";
        public static String INDEX_PAIMAI_TO=HOST+"/apiauction/bidders";
        public static String TUANGOU_DETAILS=HOST+"/apigroup/detail";
        public static String TUANGOU_TO=HOST+"/apigroup/buy";
        public static String ADD_CART=HOST+"/apicart/add";
        public static String GOODS_TO_BY=HOST+"/apiorder/buy";
        public static String GOODS_MIAOSHA=HOST+"/apispike/detail";
        public static String MIAOSHA_BUY=HOST+"/apispike/buy";
        public static String MALL_INFO=HOST+"/apiuser/shopdetail";
        public static String GET_CART=HOST+"/apicart/index";
        public static String MINE_SHOUYI=HOST+"/apiuser/wallet";
        public static String MINE_ADDRESS=HOST+"/apiuser/myaddress";
        public static String ADD_ADDRESS=HOST+"/apiuser/add_address";
        public static String DEL_ADDRESS=HOST+"/apiuser/deladdress";
        public static String BE_DEF=HOST+"/apiuser/is_default";
        public static String EDIT_ADD=HOST+"/apiuser/editress";
        public static String COLLECT=HOST+"/apiuser/addcollect";
        public static String MINE_COLLECT=HOST+"/apiuser/collection";
        public static String DEL_COLLECT=HOST+"/apiuser/delcollect";
        public static String SEARCH=HOST+"/apiuser/shoplist";
        public static String TUANGOU_BUY=HOST+"/apigroup/buy";
        public static String CART_COUNT=HOST+"/apicart/update";
        public static String CART_CHOOSE=HOST+"/apicart/one_check";
        public static String CART_CHOOSEALL=HOST+"/apicart/all_check";
        public static String SUBMIT_CART=HOST+"/apiorder/index";
        public static String CREATE_ORDER=HOST+"/apiorder/done";
        public static String MINE_ORDER=HOST+"/apiuser/myorder";
        public static String ORDER_PAY=HOST+"/apipay/orderinfo";
        public static String MALL_DETAIL=HOST+"/apiuser/shopdetail";
        public static String USER_ACCOUNT=HOST+"/apiuser/myaccount";
        public static String ADD_ACCOUNT=HOST+"/apiuser/addaccount";
        public static String DEL_ACCOUNT=HOST+"/apiuser/delaccount";
        public static String APPLY_TIXIAN=HOST+"/apiuser/apptixian";
        public static String CANCAL_ORDER=HOST+"/apiuser/cancel";
        public static String RETURN_ORDER=HOST+"/apiuser/returngoods";
        public static String ORDER_COMMENT=HOST+"/apiuser/comment";
        public static String GOODS_RECEIVE=HOST+"/apiuser/receive";
        public static String ORDER_DETAIL=HOST+"/apiorder/orders_detail";
        public static String CANNAL_TIXIAN=HOST+"/apiuser/canceltixian";
        public static String BIND=HOST+"/apiuser/bind";
        public static String CODE_DETAIL=HOST+"/apiuser/detail";
        public static String DEL_GOODS=HOST+"/apicart/drop";
        public static String MINE_VIP=HOST+"/apiuser/myfriend";
        public static String UPLOAD_IMG=HOST+"/api/uploadfile";

    }
}
