package com.liuge.TMShop.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jiang on 2018/10/25.
 */

public class SubmitCartEntity  implements Serializable{

    /**
     * status : success
     * msg : 获取成功
     * data : {"goods_list":{"goods":[{"sid":"10","pay_fee":"20.00","shopname":"郭","result":[{"rec_id":"1029","rec_type":"0","user_id":"4","market_price":"147.60","income":"0.00","session_id":"4","goods_id":"571","goods_name":"新卫衣@","spec_id":"785","specification":"M 黑色","price":"123.00","quantity":"1","goods_image":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/goods/20181022/aa4302c4acc4bce295fc9835dfe52be9.png","is_shipping":"1","sid":"10","give_integral":"18","integral":"5","extension_code":null,"extension_id":null},{"rec_id":"1030","rec_type":"0","user_id":"4","market_price":"129.60","income":"0.00","session_id":"4","goods_id":"540","goods_name":"Lilbetter卫衣男 秋装连帽上衣","spec_id":"770","specification":"M 黑色","price":"108.00","quantity":"3","goods_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","is_shipping":"1","sid":"10","give_integral":"-1","integral":"50","extension_code":null,"extension_id":null},{"rec_id":"1036","rec_type":"0","user_id":"4","market_price":"118.80","income":"0.00","session_id":"4","goods_id":"562","goods_name":"菠萝","spec_id":"761","specification":"大小","price":"99.00","quantity":"1","goods_image":"http://shop.dktoo.com/application/lee/uploads/goods/20180925/a98b4a9c628bdfb9929c540544be8ef3.png","is_shipping":"1","sid":"10","give_integral":"-1","integral":"20","extension_code":null,"extension_id":null},{"rec_id":"1038","rec_type":"0","user_id":"4","market_price":"120.00","income":"0.00","session_id":"4","goods_id":"568","goods_name":"激励激励","spec_id":"777","specification":"20 g","price":"100.00","quantity":"1","goods_image":"","is_shipping":"1","sid":"10","give_integral":"100","integral":"10","extension_code":null,"extension_id":null}]}],"amount":430,"quantity":6,"pay_fee":20},"consignee_default":[{"address_id":"101","address_name":"房管局医院","user_id":"4","consignee":"田哥哥","email":"","region_id":"0","address":"浙江省杭州市余杭区","zipcode":"","tel":"13439998803","mobile":"13439998803","sign_building":"","point_lng":null,"point_lat":null,"is_default":"0","best_time":""}],"total":{"goods_price":646,"my_integral":"0","my_money":null,"integral_money":0,"surplus":0,"pay_fee":0,"is_integral_pay":1,"market_price":775.1999999999999,"integral":85,"give_integral":0,"goods_price_formated":"￥646.00元"}}
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

    public static class DataBean implements Serializable{
        /**
         * goods_list : {"goods":[{"sid":"10","pay_fee":"20.00","shopname":"郭","result":[{"rec_id":"1029","rec_type":"0","user_id":"4","market_price":"147.60","income":"0.00","session_id":"4","goods_id":"571","goods_name":"新卫衣@","spec_id":"785","specification":"M 黑色","price":"123.00","quantity":"1","goods_image":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/goods/20181022/aa4302c4acc4bce295fc9835dfe52be9.png","is_shipping":"1","sid":"10","give_integral":"18","integral":"5","extension_code":null,"extension_id":null},{"rec_id":"1030","rec_type":"0","user_id":"4","market_price":"129.60","income":"0.00","session_id":"4","goods_id":"540","goods_name":"Lilbetter卫衣男 秋装连帽上衣","spec_id":"770","specification":"M 黑色","price":"108.00","quantity":"3","goods_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","is_shipping":"1","sid":"10","give_integral":"-1","integral":"50","extension_code":null,"extension_id":null},{"rec_id":"1036","rec_type":"0","user_id":"4","market_price":"118.80","income":"0.00","session_id":"4","goods_id":"562","goods_name":"菠萝","spec_id":"761","specification":"大小","price":"99.00","quantity":"1","goods_image":"http://shop.dktoo.com/application/lee/uploads/goods/20180925/a98b4a9c628bdfb9929c540544be8ef3.png","is_shipping":"1","sid":"10","give_integral":"-1","integral":"20","extension_code":null,"extension_id":null},{"rec_id":"1038","rec_type":"0","user_id":"4","market_price":"120.00","income":"0.00","session_id":"4","goods_id":"568","goods_name":"激励激励","spec_id":"777","specification":"20 g","price":"100.00","quantity":"1","goods_image":"","is_shipping":"1","sid":"10","give_integral":"100","integral":"10","extension_code":null,"extension_id":null}]}],"amount":430,"quantity":6,"pay_fee":20}
         * consignee_default : [{"address_id":"101","address_name":"房管局医院","user_id":"4","consignee":"田哥哥","email":"","region_id":"0","address":"浙江省杭州市余杭区","zipcode":"","tel":"13439998803","mobile":"13439998803","sign_building":"","point_lng":null,"point_lat":null,"is_default":"0","best_time":""}]
         * total : {"goods_price":646,"my_integral":"0","my_money":null,"integral_money":0,"surplus":0,"pay_fee":0,"is_integral_pay":1,"market_price":775.1999999999999,"integral":85,"give_integral":0,"goods_price_formated":"￥646.00元"}
         */

        private GoodsListBean goods_list;
        private TotalBean total;
        private List<ConsigneeDefaultBean> consignee_default;

        public GoodsListBean getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(GoodsListBean goods_list) {
            this.goods_list = goods_list;
        }

        public TotalBean getTotal() {
            return total;
        }

        public void setTotal(TotalBean total) {
            this.total = total;
        }

        public List<ConsigneeDefaultBean> getConsignee_default() {
            return consignee_default;
        }

        public void setConsignee_default(List<ConsigneeDefaultBean> consignee_default) {
            this.consignee_default = consignee_default;
        }

        public static class GoodsListBean implements Serializable{
            /**
             * goods : [{"sid":"10","pay_fee":"20.00","shopname":"郭","result":[{"rec_id":"1029","rec_type":"0","user_id":"4","market_price":"147.60","income":"0.00","session_id":"4","goods_id":"571","goods_name":"新卫衣@","spec_id":"785","specification":"M 黑色","price":"123.00","quantity":"1","goods_image":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/goods/20181022/aa4302c4acc4bce295fc9835dfe52be9.png","is_shipping":"1","sid":"10","give_integral":"18","integral":"5","extension_code":null,"extension_id":null},{"rec_id":"1030","rec_type":"0","user_id":"4","market_price":"129.60","income":"0.00","session_id":"4","goods_id":"540","goods_name":"Lilbetter卫衣男 秋装连帽上衣","spec_id":"770","specification":"M 黑色","price":"108.00","quantity":"3","goods_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","is_shipping":"1","sid":"10","give_integral":"-1","integral":"50","extension_code":null,"extension_id":null},{"rec_id":"1036","rec_type":"0","user_id":"4","market_price":"118.80","income":"0.00","session_id":"4","goods_id":"562","goods_name":"菠萝","spec_id":"761","specification":"大小","price":"99.00","quantity":"1","goods_image":"http://shop.dktoo.com/application/lee/uploads/goods/20180925/a98b4a9c628bdfb9929c540544be8ef3.png","is_shipping":"1","sid":"10","give_integral":"-1","integral":"20","extension_code":null,"extension_id":null},{"rec_id":"1038","rec_type":"0","user_id":"4","market_price":"120.00","income":"0.00","session_id":"4","goods_id":"568","goods_name":"激励激励","spec_id":"777","specification":"20 g","price":"100.00","quantity":"1","goods_image":"","is_shipping":"1","sid":"10","give_integral":"100","integral":"10","extension_code":null,"extension_id":null}]}]
             * amount : 430
             * quantity : 6
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

            public static class GoodsBean implements Serializable{
                /**
                 * sid : 10
                 * pay_fee : 20.00
                 * shopname : 郭
                 * result : [{"rec_id":"1029","rec_type":"0","user_id":"4","market_price":"147.60","income":"0.00","session_id":"4","goods_id":"571","goods_name":"新卫衣@","spec_id":"785","specification":"M 黑色","price":"123.00","quantity":"1","goods_image":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/goods/20181022/aa4302c4acc4bce295fc9835dfe52be9.png","is_shipping":"1","sid":"10","give_integral":"18","integral":"5","extension_code":null,"extension_id":null},{"rec_id":"1030","rec_type":"0","user_id":"4","market_price":"129.60","income":"0.00","session_id":"4","goods_id":"540","goods_name":"Lilbetter卫衣男 秋装连帽上衣","spec_id":"770","specification":"M 黑色","price":"108.00","quantity":"3","goods_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","is_shipping":"1","sid":"10","give_integral":"-1","integral":"50","extension_code":null,"extension_id":null},{"rec_id":"1036","rec_type":"0","user_id":"4","market_price":"118.80","income":"0.00","session_id":"4","goods_id":"562","goods_name":"菠萝","spec_id":"761","specification":"大小","price":"99.00","quantity":"1","goods_image":"http://shop.dktoo.com/application/lee/uploads/goods/20180925/a98b4a9c628bdfb9929c540544be8ef3.png","is_shipping":"1","sid":"10","give_integral":"-1","integral":"20","extension_code":null,"extension_id":null},{"rec_id":"1038","rec_type":"0","user_id":"4","market_price":"120.00","income":"0.00","session_id":"4","goods_id":"568","goods_name":"激励激励","spec_id":"777","specification":"20 g","price":"100.00","quantity":"1","goods_image":"","is_shipping":"1","sid":"10","give_integral":"100","integral":"10","extension_code":null,"extension_id":null}]
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

                public static class ResultBean implements Serializable{
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

        public static class TotalBean implements Serializable{
            /**
             * goods_price : 646
             * my_integral : 0
             * my_money : null
             * integral_money : 0
             * surplus : 0
             * pay_fee : 0
             * is_integral_pay : 1
             * market_price : 775.1999999999999
             * integral : 85
             * give_integral : 0
             * goods_price_formated : ￥646.00元
             */

            private int goods_price;
            private String my_integral;
            private Object my_money;
            private int integral_money;
            private int surplus;
            private int pay_fee;
            private int is_integral_pay;
            private double market_price;
            private int integral;
            private int give_integral;
            private String goods_price_formated;

            public int getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(int goods_price) {
                this.goods_price = goods_price;
            }

            public String getMy_integral() {
                return my_integral;
            }

            public void setMy_integral(String my_integral) {
                this.my_integral = my_integral;
            }

            public Object getMy_money() {
                return my_money;
            }

            public void setMy_money(Object my_money) {
                this.my_money = my_money;
            }

            public int getIntegral_money() {
                return integral_money;
            }

            public void setIntegral_money(int integral_money) {
                this.integral_money = integral_money;
            }

            public int getSurplus() {
                return surplus;
            }

            public void setSurplus(int surplus) {
                this.surplus = surplus;
            }

            public int getPay_fee() {
                return pay_fee;
            }

            public void setPay_fee(int pay_fee) {
                this.pay_fee = pay_fee;
            }

            public int getIs_integral_pay() {
                return is_integral_pay;
            }

            public void setIs_integral_pay(int is_integral_pay) {
                this.is_integral_pay = is_integral_pay;
            }

            public double getMarket_price() {
                return market_price;
            }

            public void setMarket_price(double market_price) {
                this.market_price = market_price;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public int getGive_integral() {
                return give_integral;
            }

            public void setGive_integral(int give_integral) {
                this.give_integral = give_integral;
            }

            public String getGoods_price_formated() {
                return goods_price_formated;
            }

            public void setGoods_price_formated(String goods_price_formated) {
                this.goods_price_formated = goods_price_formated;
            }
        }

        public static class ConsigneeDefaultBean implements Serializable{
            /**
             * address_id : 101
             * address_name : 房管局医院
             * user_id : 4
             * consignee : 田哥哥
             * email :
             * region_id : 0
             * address : 浙江省杭州市余杭区
             * zipcode :
             * tel : 13439998803
             * mobile : 13439998803
             * sign_building :
             * point_lng : null
             * point_lat : null
             * is_default : 0
             * best_time :
             */

            private String address_id;
            private String address_name;
            private String user_id;
            private String consignee;
            private String email;
            private String region_id;
            private String address;
            private String zipcode;
            private String tel;
            private String mobile;
            private String sign_building;
            private Object point_lng;
            private Object point_lat;
            private String is_default;
            private String best_time;

            public String getAddress_id() {
                return address_id;
            }

            public void setAddress_id(String address_id) {
                this.address_id = address_id;
            }

            public String getAddress_name() {
                return address_name;
            }

            public void setAddress_name(String address_name) {
                this.address_name = address_name;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getConsignee() {
                return consignee;
            }

            public void setConsignee(String consignee) {
                this.consignee = consignee;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getRegion_id() {
                return region_id;
            }

            public void setRegion_id(String region_id) {
                this.region_id = region_id;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getZipcode() {
                return zipcode;
            }

            public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getSign_building() {
                return sign_building;
            }

            public void setSign_building(String sign_building) {
                this.sign_building = sign_building;
            }

            public Object getPoint_lng() {
                return point_lng;
            }

            public void setPoint_lng(Object point_lng) {
                this.point_lng = point_lng;
            }

            public Object getPoint_lat() {
                return point_lat;
            }

            public void setPoint_lat(Object point_lat) {
                this.point_lat = point_lat;
            }

            public String getIs_default() {
                return is_default;
            }

            public void setIs_default(String is_default) {
                this.is_default = is_default;
            }

            public String getBest_time() {
                return best_time;
            }

            public void setBest_time(String best_time) {
                this.best_time = best_time;
            }
        }
    }
}
