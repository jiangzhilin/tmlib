package com.liuge.TMShop.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/10/18.
 */

public class CollectGoodsEntity {

    /**
     * status : success
     * msg : 获取成功
     * data : {"result":[{"rec_id":"135","user_id":"4","type":"1","goods_id":"540","add_time":"1539826350","is_attention":"0","default_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","goods_name":"Lilbetter卫衣男 秋装连帽上衣","price":"108.00","spec":null},{"rec_id":"132","user_id":"3","type":"1","goods_id":"92","add_time":"1539658511","is_attention":"0","default_image":"","goods_name":null,"price":null,"spec":null},{"rec_id":"124","user_id":"3","type":"1","goods_id":"539","add_time":"1539084913","is_attention":"0","default_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/73b0ec746b6c43b452e4a40eb7c79ff6.jpg","goods_name":"ONLY2018秋季新款毛边高腰九分牛仔裤","price":"98.00","spec":null},{"rec_id":"121","user_id":"3","type":"1","goods_id":"552","add_time":"1538019974","is_attention":"0","default_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/e50c6bb4ad548d9eede82fed0017aeff.jpg","goods_name":"口红","price":"19.90","spec":null}],"totalpage":1}
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
         * result : [{"rec_id":"135","user_id":"4","type":"1","goods_id":"540","add_time":"1539826350","is_attention":"0","default_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","goods_name":"Lilbetter卫衣男 秋装连帽上衣","price":"108.00","spec":null},{"rec_id":"132","user_id":"3","type":"1","goods_id":"92","add_time":"1539658511","is_attention":"0","default_image":"","goods_name":null,"price":null,"spec":null},{"rec_id":"124","user_id":"3","type":"1","goods_id":"539","add_time":"1539084913","is_attention":"0","default_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/73b0ec746b6c43b452e4a40eb7c79ff6.jpg","goods_name":"ONLY2018秋季新款毛边高腰九分牛仔裤","price":"98.00","spec":null},{"rec_id":"121","user_id":"3","type":"1","goods_id":"552","add_time":"1538019974","is_attention":"0","default_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/e50c6bb4ad548d9eede82fed0017aeff.jpg","goods_name":"口红","price":"19.90","spec":null}]
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
             * rec_id : 135
             * user_id : 4
             * type : 1
             * goods_id : 540
             * add_time : 1539826350
             * is_attention : 0
             * default_image : http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg
             * goods_name : Lilbetter卫衣男 秋装连帽上衣
             * price : 108.00
             * spec : null
             */

            private String rec_id;
            private String user_id;
            private String type;
            private String goods_id;
            private String add_time;
            private String is_attention;
            private String default_image;
            private String goods_name;
            private String price;
            private String spec;

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

            public String getDefault_image() {
                return default_image;
            }

            public void setDefault_image(String default_image) {
                this.default_image = default_image;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getSpec() {
                return spec;
            }

            public void setSpec(String spec) {
                this.spec = spec;
            }
        }
    }
}
