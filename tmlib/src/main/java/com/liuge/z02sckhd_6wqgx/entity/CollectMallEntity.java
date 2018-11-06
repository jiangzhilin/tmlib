package com.liuge.z02sckhd_6wqgx.entity;

import java.util.List;

/**
 * Created by jiang on 2018/10/28.
 */

public class CollectMallEntity {

    /**
     * status : success
     * msg : 获取成功
     * data : {"result":[{"rec_id":"128","user_id":"3","type":"2","goods_id":"8","add_time":"1539084957","is_attention":"0","shopname":"oppo旗舰店","banner":""},{"rec_id":"119","user_id":"3","type":"2","goods_id":"11","add_time":"1536584643","is_attention":"0","shopname":"虞大仙","banner":""}],"totalpage":1}
     */

    private String status;
    private String msg;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * result : [{"rec_id":"128","user_id":"3","type":"2","goods_id":"8","add_time":"1539084957","is_attention":"0","shopname":"oppo旗舰店","banner":""},{"rec_id":"119","user_id":"3","type":"2","goods_id":"11","add_time":"1536584643","is_attention":"0","shopname":"虞大仙","banner":""}]
         * totalpage : 1
         */

        private int totalpage;
        private List<ResultBean> result;

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * rec_id : 128
             * user_id : 3
             * type : 2
             * goods_id : 8
             * add_time : 1539084957
             * is_attention : 0
             * shopname : oppo旗舰店
             * banner :
             */

            private String rec_id;
            private String user_id;
            private String type;
            private String goods_id;
            private String add_time;
            private String is_attention;
            private String shopname;
            private String banner;

            public String getRec_id() {
                return rec_id;
            }

            public void setRec_id(String rec_id) {
                this.rec_id = rec_id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getIs_attention() {
                return is_attention;
            }

            public void setIs_attention(String is_attention) {
                this.is_attention = is_attention;
            }

            public String getShopname() {
                return shopname;
            }

            public void setShopname(String shopname) {
                this.shopname = shopname;
            }

            public String getBanner() {
                return banner;
            }

            public void setBanner(String banner) {
                this.banner = banner;
            }
        }
    }
}
