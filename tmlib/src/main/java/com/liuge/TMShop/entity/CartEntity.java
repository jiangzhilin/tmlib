package com.liuge.TMShop.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/9/19.
 */

public class CartEntity {


    /**
     * status : success
     * msg : 获取成功
     * data : {"goods":[{"sid":"10","pay_fee":"20.00","shopname":"郭","result":[{"rec_id":"1029","rec_type":"0","user_id":"4","market_price":"147.60","income":"0.00","session_id":"4","goods_id":"571","goods_name":"新卫衣@","spec_id":"785","specification":"M 黑色","price":"123.00","quantity":"1","goods_image":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/goods/20181022/aa4302c4acc4bce295fc9835dfe52be9.png","is_shipping":"1","sid":"10","give_integral":"18","integral":"5","extension_code":null,"extension_id":null}]}],"amount":123,"quantity":1,"pay_fee":20}
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
         * goods : [{"sid":"10","pay_fee":"20.00","shopname":"郭","result":[{"rec_id":"1029","rec_type":"0","user_id":"4","market_price":"147.60","income":"0.00","session_id":"4","goods_id":"571","goods_name":"新卫衣@","spec_id":"785","specification":"M 黑色","price":"123.00","quantity":"1","goods_image":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/goods/20181022/aa4302c4acc4bce295fc9835dfe52be9.png","is_shipping":"1","sid":"10","give_integral":"18","integral":"5","extension_code":null,"extension_id":null}]}]
         * amount : 123
         * quantity : 1
         * pay_fee : 20
         */

        private int amount;
        private int quantity;
        private int pay_fee;
        private List<GoodsBean> goods;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getPay_fee() {
            return pay_fee;
        }

        public void setPay_fee(int pay_fee) {
            this.pay_fee = pay_fee;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class GoodsBean {
            /**
             * sid : 10
             * pay_fee : 20.00
             * shopname : 郭
             * result : [{"rec_id":"1029","rec_type":"0","user_id":"4","market_price":"147.60","income":"0.00","session_id":"4","goods_id":"571","goods_name":"新卫衣@","spec_id":"785","specification":"M 黑色","price":"123.00","quantity":"1","goods_image":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/goods/20181022/aa4302c4acc4bce295fc9835dfe52be9.png","is_shipping":"1","sid":"10","give_integral":"18","integral":"5","extension_code":null,"extension_id":null}]
             */

            private String sid;
            private String pay_fee;
            private String shopname;
            private List<ResultBean> result;

            public String getSid() {
                return sid;
            }

            public void setSid(String sid) {
                this.sid = sid;
            }

            public String getPay_fee() {
                return pay_fee;
            }

            public void setPay_fee(String pay_fee) {
                this.pay_fee = pay_fee;
            }

            public String getShopname() {
                return shopname;
            }

            public void setShopname(String shopname) {
                this.shopname = shopname;
            }

            public List<ResultBean> getResult() {
                return result;
            }

            public void setResult(List<ResultBean> result) {
                this.result = result;
            }

            public static class ResultBean {
                /**
                 * rec_id : 1029
                 * rec_type : 0
                 * user_id : 4
                 * market_price : 147.60
                 * income : 0.00
                 * session_id : 4
                 * goods_id : 571
                 * goods_name : 新卫衣@
                 * spec_id : 785
                 * specification : M 黑色
                 * price : 123.00
                 * quantity : 1
                 * goods_image : http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/goods/20181022/aa4302c4acc4bce295fc9835dfe52be9.png
                 * is_shipping : 1
                 * sid : 10
                 * give_integral : 18
                 * integral : 5
                 * extension_code : null
                 * extension_id : null
                 */

                private String rec_id;
                private String rec_type;
                private String user_id;
                private String market_price;
                private String income;
                private String session_id;
                private String goods_id;
                private String goods_name;
                private String spec_id;
                private String specification;
                private String price;
                private String quantity;
                private String goods_image;
                private String is_shipping;
                private String sid;
                private String give_integral;
                private String integral;
                private Object extension_code;
                private Object extension_id;

                public String getRec_id() {
                    return rec_id;
                }

                public void setRec_id(String rec_id) {
                    this.rec_id = rec_id;
                }

                public String getRec_type() {
                    return rec_type;
                }

                public void setRec_type(String rec_type) {
                    this.rec_type = rec_type;
                }

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public String getMarket_price() {
                    return market_price;
                }

                public void setMarket_price(String market_price) {
                    this.market_price = market_price;
                }

                public String getIncome() {
                    return income;
                }

                public void setIncome(String income) {
                    this.income = income;
                }

                public String getSession_id() {
                    return session_id;
                }

                public void setSession_id(String session_id) {
                    this.session_id = session_id;
                }

                public String getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(String goods_id) {
                    this.goods_id = goods_id;
                }

                public String getGoods_name() {
                    return goods_name;
                }

                public void setGoods_name(String goods_name) {
                    this.goods_name = goods_name;
                }

                public String getSpec_id() {
                    return spec_id;
                }

                public void setSpec_id(String spec_id) {
                    this.spec_id = spec_id;
                }

                public String getSpecification() {
                    return specification;
                }

                public void setSpecification(String specification) {
                    this.specification = specification;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getQuantity() {
                    return quantity;
                }

                public void setQuantity(String quantity) {
                    this.quantity = quantity;
                }

                public String getGoods_image() {
                    return goods_image;
                }

                public void setGoods_image(String goods_image) {
                    this.goods_image = goods_image;
                }

                public String getIs_shipping() {
                    return is_shipping;
                }

                public void setIs_shipping(String is_shipping) {
                    this.is_shipping = is_shipping;
                }

                public String getSid() {
                    return sid;
                }

                public void setSid(String sid) {
                    this.sid = sid;
                }

                public String getGive_integral() {
                    return give_integral;
                }

                public void setGive_integral(String give_integral) {
                    this.give_integral = give_integral;
                }

                public String getIntegral() {
                    return integral;
                }

                public void setIntegral(String integral) {
                    this.integral = integral;
                }

                public Object getExtension_code() {
                    return extension_code;
                }

                public void setExtension_code(Object extension_code) {
                    this.extension_code = extension_code;
                }

                public Object getExtension_id() {
                    return extension_id;
                }

                public void setExtension_id(Object extension_id) {
                    this.extension_id = extension_id;
                }
            }
        }
    }
}
