package com.liuge.z02sckhd_6wqgx.entity;

import java.util.List;

/**
 * Created by jiang on 2018/10/22.
 */

public class MallEntity {

    /**
     * status : success
     * msg : 获取成功
     * data : {"totalpage":1,"result":[{"id":"11","shopname":"虞大仙","banner":"","logo":"","sales":141,"total":0}]}
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
         * totalpage : 1
         * result : [{"id":"11","shopname":"虞大仙","banner":"","logo":"","sales":141,"total":0}]
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
             * id : 11
             * shopname : 虞大仙
             * banner :
             * logo :
             * sales : 141
             * total : 0
             */

            private String id;
            private String shopname;
            private String banner;
            private String logo;
            private int sales;
            private int total;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public int getSales() {
                return sales;
            }

            public void setSales(int sales) {
                this.sales = sales;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }
    }
}
