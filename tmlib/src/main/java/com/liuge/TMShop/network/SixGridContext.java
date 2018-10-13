package com.liuge.TMShop.network;

import android.app.Application;

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
    public static String token= "80D721E4E9FFFF58CBB19FFCD231DC2F";

    public static String IMG="http://shop.dktoo.com/lee/";

    public static void init(Application app){
            x.Ext.init(app);
            x.Ext.setDebug(true);
    }

    public static class Type{
        public static String MAP="Pile/";
    }
    public static class Action{
        public static String INDEX_MARKER="GetPileSiteMap";


    }
    public static class DO{
        public static String GOODS_CLASS="http://shop.dktoo.com/z02sckhd_6wqgx/apigoods/category";
        public static String GOODS_List="http://shop.dktoo.com/z02sckhd_6wqgx/apigoods/index";
        public static String GOODS_DETAIL="http://shop.dktoo.com/z02sckhd_6wqgx/apigoods/detail";
        public static String GOODS_COMMENT="http://shop.dktoo.com/z02sckhd_6wqgx/apigoods/getcomment";
        public static String INDEX_BANNER="http://shop.dktoo.com/z02sckhd_6wqgx/apiuser/index";
        public static String INDEX_PAIMAI_DETAILS="http://shop.dktoo.com/z02sckhd_6wqgx/apiauction/detail";
        public static String INDEX_PAIMAI_TO="http://shop.dktoo.com/z02sckhd_6wqgx/apiauction/bidders";
        public static String TUANGOU_DETAILS="http://shop.dktoo.com/z02sckhd_6wqgx/apigroup/detail";
        public static String TUANGOU_TO="http://shop.dktoo.com/z02sckhd_6wqgx/apigroup/buy";
        public static String ADD_CART="http://shop.dktoo.com/z02sckhd_6wqgx/apicart/add";
        public static String GOODS_TO_BY="http://shop.dktoo.com/z02sckhd_6wqgx/apiorder/buy";
        public static String GOODS_MIAOSHA="http://shop.dktoo.com/z02sckhd_6wqgx/apispike/detail";
        public static String MALL_INFO="http://shop.dktoo.com/z02sckhd_6wqgx/apiuser/shopdetail";
        public static String GET_CART="http://shop.dktoo.com/z02sckhd_6wqgx/apicart/index";
        public static String MINE_SHOUYI="http://shop.dktoo.com/z02sckhd_6wqgx/apiuser/wallet";
        public static String MINE_ADDRESS="http://shop.dktoo.com/z02sckhd_6wqgx/apiuser/myaddress";
        public static String ADD_ADDRESS="http://shop.dktoo.com/z02sckhd_6wqgx/apiuser/add_address";
        public static String DEL_ADDRESS="http://shop.dktoo.com/z02sckhd_6wqgx/apiuser/deladdress";
        public static String BE_DEF="http://shop.dktoo.com/z02sckhd_6wqgx/apiuser/is_default";
        public static String EDIT_ADD="http://shop.dktoo.com/z02sckhd_6wqgx/apiuser/editress";
    }
}
