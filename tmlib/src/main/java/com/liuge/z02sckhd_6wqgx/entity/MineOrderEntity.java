package com.liuge.z02sckhd_6wqgx.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jiang on 2018/10/25.
 */

public class MineOrderEntity implements Serializable{


    /**
     * status : success
     * msg : 获取成功
     * data : {"result":[{"mid":"94","order_sn":"2018102570924","status":"0","user_id":"4","tel":"","consignee":"田哥哥","address_name":"房管局医院","address":"浙江省杭州市余杭区","integral":"85","give_integral":"0","order_amount":"646.00","extension_code":"","extension_id":"0","is_pay":"0","pay_time":null,"pay_way":"1","add_time":"1540447167","_orders":[{"order_id":"72","myorder_id":"94","sid":"10","order_sn":"2018102570924","user_id":"4","order_status":"11","consignee":"田哥哥","address_name":"房管局医院","address":"浙江省杭州市余杭区","zipcode":"","tel":"13439998803","mobile":"13439998803","email":"","best_time":"","sign_building":"","postscript":"","shipping_id":"25","shipping_name":"自营配送","pay_id":"3","pay_name":"余额支付","how_surplus":"","pack_name":"","card_name":"","card_message":"","goods_amount":"646.00","pay_fee":"20.00","money_paid":"0.00","surplus":"0.00","integral":"85","integral_money":"0.00","give_integral":"0","bonus":"0.00","order_amount":"20.00","from_ad":"0","referer":"","add_time":"1540447167","confirm_time":"0","pay_time":"0","shipping_time":"0","evaluation_status":"0","evaluation_time":"0","pack_id":"0","card_id":"0","bonus_id":"0","invoice_no":"","extension_code":"0","extension_id":"0","to_buyer":"","pay_note":"","is_separate":"0","parent_id":"0","cid":"0","pid":"0","reson":null,"comment_status":"0","content":null,"month":"201810","region_id":"0","goods_image":null,"alipay":null,"shopname":"郭","_goods":[{"rec_id":"94","order_id":"72","goods_id":"571","goods_name":"新卫衣@","goods_sn":"","product_id":"0","goods_numbers":"1","number":"1.00","market_price":"147.60","goods_price":"123.00","goods_attr":"M 黑色","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"785","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/goods/20181022/aa4302c4acc4bce295fc9835dfe52be9.png","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"},{"rec_id":"95","order_id":"72","goods_id":"540","goods_name":"Lilbetter卫衣男 秋装连帽上衣","goods_sn":"","product_id":"0","goods_numbers":"3","number":"3.00","market_price":"129.60","goods_price":"108.00","goods_attr":"M 黑色","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"770","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"},{"rec_id":"96","order_id":"72","goods_id":"562","goods_name":"菠萝","goods_sn":"","product_id":"0","goods_numbers":"1","number":"1.00","market_price":"118.80","goods_price":"99.00","goods_attr":"大小","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"761","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"http://shop.dktoo.com/application/lee/uploads/goods/20180925/a98b4a9c628bdfb9929c540544be8ef3.png","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"},{"rec_id":"97","order_id":"72","goods_id":"568","goods_name":"激励激励","goods_sn":"","product_id":"0","goods_numbers":"1","number":"1.00","market_price":"120.00","goods_price":"100.00","goods_attr":"20 g","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"777","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"}]}]}],"map":1,"totalpage":1}
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
         * result : [{"mid":"94","order_sn":"2018102570924","status":"0","user_id":"4","tel":"","consignee":"田哥哥","address_name":"房管局医院","address":"浙江省杭州市余杭区","integral":"85","give_integral":"0","order_amount":"646.00","extension_code":"","extension_id":"0","is_pay":"0","pay_time":null,"pay_way":"1","add_time":"1540447167","_orders":[{"order_id":"72","myorder_id":"94","sid":"10","order_sn":"2018102570924","user_id":"4","order_status":"11","consignee":"田哥哥","address_name":"房管局医院","address":"浙江省杭州市余杭区","zipcode":"","tel":"13439998803","mobile":"13439998803","email":"","best_time":"","sign_building":"","postscript":"","shipping_id":"25","shipping_name":"自营配送","pay_id":"3","pay_name":"余额支付","how_surplus":"","pack_name":"","card_name":"","card_message":"","goods_amount":"646.00","pay_fee":"20.00","money_paid":"0.00","surplus":"0.00","integral":"85","integral_money":"0.00","give_integral":"0","bonus":"0.00","order_amount":"20.00","from_ad":"0","referer":"","add_time":"1540447167","confirm_time":"0","pay_time":"0","shipping_time":"0","evaluation_status":"0","evaluation_time":"0","pack_id":"0","card_id":"0","bonus_id":"0","invoice_no":"","extension_code":"0","extension_id":"0","to_buyer":"","pay_note":"","is_separate":"0","parent_id":"0","cid":"0","pid":"0","reson":null,"comment_status":"0","content":null,"month":"201810","region_id":"0","goods_image":null,"alipay":null,"shopname":"郭","_goods":[{"rec_id":"94","order_id":"72","goods_id":"571","goods_name":"新卫衣@","goods_sn":"","product_id":"0","goods_numbers":"1","number":"1.00","market_price":"147.60","goods_price":"123.00","goods_attr":"M 黑色","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"785","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/goods/20181022/aa4302c4acc4bce295fc9835dfe52be9.png","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"},{"rec_id":"95","order_id":"72","goods_id":"540","goods_name":"Lilbetter卫衣男 秋装连帽上衣","goods_sn":"","product_id":"0","goods_numbers":"3","number":"3.00","market_price":"129.60","goods_price":"108.00","goods_attr":"M 黑色","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"770","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"},{"rec_id":"96","order_id":"72","goods_id":"562","goods_name":"菠萝","goods_sn":"","product_id":"0","goods_numbers":"1","number":"1.00","market_price":"118.80","goods_price":"99.00","goods_attr":"大小","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"761","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"http://shop.dktoo.com/application/lee/uploads/goods/20180925/a98b4a9c628bdfb9929c540544be8ef3.png","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"},{"rec_id":"97","order_id":"72","goods_id":"568","goods_name":"激励激励","goods_sn":"","product_id":"0","goods_numbers":"1","number":"1.00","market_price":"120.00","goods_price":"100.00","goods_attr":"20 g","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"777","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"}]}]}]
         * map : 1
         * totalpage : 1
         */

        private int map;
        private int totalpage;
        private List<ResultBean> result;

        public int getMap() {
            return map;
        }

        public void setMap(int map) {
            this.map = map;
        }

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

        public static class ResultBean implements Serializable{
            /**
             * mid : 94
             * order_sn : 2018102570924
             * status : 0
             * user_id : 4
             * tel :
             * consignee : 田哥哥
             * address_name : 房管局医院
             * address : 浙江省杭州市余杭区
             * integral : 85
             * give_integral : 0
             * order_amount : 646.00
             * extension_code :
             * extension_id : 0
             * is_pay : 0
             * pay_time : null
             * pay_way : 1
             * add_time : 1540447167
             * _orders : [{"order_id":"72","myorder_id":"94","sid":"10","order_sn":"2018102570924","user_id":"4","order_status":"11","consignee":"田哥哥","address_name":"房管局医院","address":"浙江省杭州市余杭区","zipcode":"","tel":"13439998803","mobile":"13439998803","email":"","best_time":"","sign_building":"","postscript":"","shipping_id":"25","shipping_name":"自营配送","pay_id":"3","pay_name":"余额支付","how_surplus":"","pack_name":"","card_name":"","card_message":"","goods_amount":"646.00","pay_fee":"20.00","money_paid":"0.00","surplus":"0.00","integral":"85","integral_money":"0.00","give_integral":"0","bonus":"0.00","order_amount":"20.00","from_ad":"0","referer":"","add_time":"1540447167","confirm_time":"0","pay_time":"0","shipping_time":"0","evaluation_status":"0","evaluation_time":"0","pack_id":"0","card_id":"0","bonus_id":"0","invoice_no":"","extension_code":"0","extension_id":"0","to_buyer":"","pay_note":"","is_separate":"0","parent_id":"0","cid":"0","pid":"0","reson":null,"comment_status":"0","content":null,"month":"201810","region_id":"0","goods_image":null,"alipay":null,"shopname":"郭","_goods":[{"rec_id":"94","order_id":"72","goods_id":"571","goods_name":"新卫衣@","goods_sn":"","product_id":"0","goods_numbers":"1","number":"1.00","market_price":"147.60","goods_price":"123.00","goods_attr":"M 黑色","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"785","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/goods/20181022/aa4302c4acc4bce295fc9835dfe52be9.png","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"},{"rec_id":"95","order_id":"72","goods_id":"540","goods_name":"Lilbetter卫衣男 秋装连帽上衣","goods_sn":"","product_id":"0","goods_numbers":"3","number":"3.00","market_price":"129.60","goods_price":"108.00","goods_attr":"M 黑色","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"770","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"},{"rec_id":"96","order_id":"72","goods_id":"562","goods_name":"菠萝","goods_sn":"","product_id":"0","goods_numbers":"1","number":"1.00","market_price":"118.80","goods_price":"99.00","goods_attr":"大小","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"761","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"http://shop.dktoo.com/application/lee/uploads/goods/20180925/a98b4a9c628bdfb9929c540544be8ef3.png","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"},{"rec_id":"97","order_id":"72","goods_id":"568","goods_name":"激励激励","goods_sn":"","product_id":"0","goods_numbers":"1","number":"1.00","market_price":"120.00","goods_price":"100.00","goods_attr":"20 g","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"777","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"}]}]
             */

            private String mid;
            private String order_sn;
            private String status;
            private String user_id;
            private String tel;
            private String consignee;
            private String address_name;
            private String address;
            private String integral;
            private String give_integral;
            private String order_amount;
            private String extension_code;
            private String extension_id;
            private String is_pay;
            private Object pay_time;
            private String pay_way;
            private String add_time;
            private List<OrdersBean> _orders;

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public String getOrder_sn() {
                return order_sn;
            }

            public void setOrder_sn(String order_sn) {
                this.order_sn = order_sn;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getConsignee() {
                return consignee;
            }

            public void setConsignee(String consignee) {
                this.consignee = consignee;
            }

            public String getAddress_name() {
                return address_name;
            }

            public void setAddress_name(String address_name) {
                this.address_name = address_name;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getIntegral() {
                return integral;
            }

            public void setIntegral(String integral) {
                this.integral = integral;
            }

            public String getGive_integral() {
                return give_integral;
            }

            public void setGive_integral(String give_integral) {
                this.give_integral = give_integral;
            }

            public String getOrder_amount() {
                return order_amount;
            }

            public void setOrder_amount(String order_amount) {
                this.order_amount = order_amount;
            }

            public String getExtension_code() {
                return extension_code;
            }

            public void setExtension_code(String extension_code) {
                this.extension_code = extension_code;
            }

            public String getExtension_id() {
                return extension_id;
            }

            public void setExtension_id(String extension_id) {
                this.extension_id = extension_id;
            }

            public String getIs_pay() {
                return is_pay;
            }

            public void setIs_pay(String is_pay) {
                this.is_pay = is_pay;
            }

            public Object getPay_time() {
                return pay_time;
            }

            public void setPay_time(Object pay_time) {
                this.pay_time = pay_time;
            }

            public String getPay_way() {
                return pay_way;
            }

            public void setPay_way(String pay_way) {
                this.pay_way = pay_way;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public List<OrdersBean> get_orders() {
                return _orders;
            }

            public void set_orders(List<OrdersBean> _orders) {
                this._orders = _orders;
            }

            public static class OrdersBean implements Serializable{
                /**
                 * order_id : 72
                 * myorder_id : 94
                 * sid : 10
                 * order_sn : 2018102570924
                 * user_id : 4
                 * order_status : 11
                 * consignee : 田哥哥
                 * address_name : 房管局医院
                 * address : 浙江省杭州市余杭区
                 * zipcode :
                 * tel : 13439998803
                 * mobile : 13439998803
                 * email :
                 * best_time :
                 * sign_building :
                 * postscript :
                 * shipping_id : 25
                 * shipping_name : 自营配送
                 * pay_id : 3
                 * pay_name : 余额支付
                 * how_surplus :
                 * pack_name :
                 * card_name :
                 * card_message :
                 * goods_amount : 646.00
                 * pay_fee : 20.00
                 * money_paid : 0.00
                 * surplus : 0.00
                 * integral : 85
                 * integral_money : 0.00
                 * give_integral : 0
                 * bonus : 0.00
                 * order_amount : 20.00
                 * from_ad : 0
                 * referer :
                 * add_time : 1540447167
                 * confirm_time : 0
                 * pay_time : 0
                 * shipping_time : 0
                 * evaluation_status : 0
                 * evaluation_time : 0
                 * pack_id : 0
                 * card_id : 0
                 * bonus_id : 0
                 * invoice_no :
                 * extension_code : 0
                 * extension_id : 0
                 * to_buyer :
                 * pay_note :
                 * is_separate : 0
                 * parent_id : 0
                 * cid : 0
                 * pid : 0
                 * reson : null
                 * comment_status : 0
                 * content : null
                 * month : 201810
                 * region_id : 0
                 * goods_image : null
                 * alipay : null
                 * shopname : 郭
                 * _goods : [{"rec_id":"94","order_id":"72","goods_id":"571","goods_name":"新卫衣@","goods_sn":"","product_id":"0","goods_numbers":"1","number":"1.00","market_price":"147.60","goods_price":"123.00","goods_attr":"M 黑色","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"785","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/goods/20181022/aa4302c4acc4bce295fc9835dfe52be9.png","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"},{"rec_id":"95","order_id":"72","goods_id":"540","goods_name":"Lilbetter卫衣男 秋装连帽上衣","goods_sn":"","product_id":"0","goods_numbers":"3","number":"3.00","market_price":"129.60","goods_price":"108.00","goods_attr":"M 黑色","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"770","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"},{"rec_id":"96","order_id":"72","goods_id":"562","goods_name":"菠萝","goods_sn":"","product_id":"0","goods_numbers":"1","number":"1.00","market_price":"118.80","goods_price":"99.00","goods_attr":"大小","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"761","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"http://shop.dktoo.com/application/lee/uploads/goods/20180925/a98b4a9c628bdfb9929c540544be8ef3.png","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"},{"rec_id":"97","order_id":"72","goods_id":"568","goods_name":"激励激励","goods_sn":"","product_id":"0","goods_numbers":"1","number":"1.00","market_price":"120.00","goods_price":"100.00","goods_attr":"20 g","send_number":"0","is_real":"0","extension_code":"","extension_id":"0","parent_id":"0","is_gift":"0","goods_attr_id":"777","evaluation_status":"0","evaluation_time":"0","Score":"5","comment":null,"userid":"4","class":null,"images":null,"status":"0","is_show":"1","income":"0.00","sid":"10","goods_status":"0","type":"1","point":"0.00","month":"201810","rid":"0","total":"0.00","goods_image":"","reply_time":null,"reply_comment":null,"reply_status":"0","add_time":"1540447167"}]
                 */

                private String order_id;
                private String myorder_id;
                private String sid;
                private String order_sn;
                private String user_id;
                private String order_status;
                private String consignee;
                private String address_name;
                private String address;
                private String zipcode;
                private String tel;
                private String mobile;
                private String email;
                private String best_time;
                private String sign_building;
                private String postscript;
                private String shipping_id;
                private String shipping_name;
                private String pay_id;
                private String pay_name;
                private String how_surplus;
                private String pack_name;
                private String card_name;
                private String card_message;
                private String goods_amount;
                private String pay_fee;
                private String money_paid;
                private String surplus;
                private String integral;
                private String integral_money;
                private String give_integral;
                private String bonus;
                private String order_amount;
                private String from_ad;
                private String referer;
                private String add_time;
                private String confirm_time;
                private String pay_time;
                private String shipping_time;
                private String evaluation_status;
                private String evaluation_time;
                private String pack_id;
                private String card_id;
                private String bonus_id;
                private String invoice_no;
                private String extension_code;
                private String extension_id;
                private String to_buyer;
                private String pay_note;
                private String is_separate;
                private String parent_id;
                private String cid;
                private String pid;
                private Object reson;
                private String comment_status;
                private Object content;
                private String month;
                private String region_id;
                private Object goods_image;
                private Object alipay;
                private String shopname;
                private List<GoodsBean> _goods;

                public String getOrder_id() {
                    return order_id;
                }

                public void setOrder_id(String order_id) {
                    this.order_id = order_id;
                }

                public String getMyorder_id() {
                    return myorder_id;
                }

                public void setMyorder_id(String myorder_id) {
                    this.myorder_id = myorder_id;
                }

                public String getSid() {
                    return sid;
                }

                public void setSid(String sid) {
                    this.sid = sid;
                }

                public String getOrder_sn() {
                    return order_sn;
                }

                public void setOrder_sn(String order_sn) {
                    this.order_sn = order_sn;
                }

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public String getOrder_status() {
                    return order_status;
                }

                public void setOrder_status(String order_status) {
                    this.order_status = order_status;
                }

                public String getConsignee() {
                    return consignee;
                }

                public void setConsignee(String consignee) {
                    this.consignee = consignee;
                }

                public String getAddress_name() {
                    return address_name;
                }

                public void setAddress_name(String address_name) {
                    this.address_name = address_name;
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

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public String getBest_time() {
                    return best_time;
                }

                public void setBest_time(String best_time) {
                    this.best_time = best_time;
                }

                public String getSign_building() {
                    return sign_building;
                }

                public void setSign_building(String sign_building) {
                    this.sign_building = sign_building;
                }

                public String getPostscript() {
                    return postscript;
                }

                public void setPostscript(String postscript) {
                    this.postscript = postscript;
                }

                public String getShipping_id() {
                    return shipping_id;
                }

                public void setShipping_id(String shipping_id) {
                    this.shipping_id = shipping_id;
                }

                public String getShipping_name() {
                    return shipping_name;
                }

                public void setShipping_name(String shipping_name) {
                    this.shipping_name = shipping_name;
                }

                public String getPay_id() {
                    return pay_id;
                }

                public void setPay_id(String pay_id) {
                    this.pay_id = pay_id;
                }

                public String getPay_name() {
                    return pay_name;
                }

                public void setPay_name(String pay_name) {
                    this.pay_name = pay_name;
                }

                public String getHow_surplus() {
                    return how_surplus;
                }

                public void setHow_surplus(String how_surplus) {
                    this.how_surplus = how_surplus;
                }

                public String getPack_name() {
                    return pack_name;
                }

                public void setPack_name(String pack_name) {
                    this.pack_name = pack_name;
                }

                public String getCard_name() {
                    return card_name;
                }

                public void setCard_name(String card_name) {
                    this.card_name = card_name;
                }

                public String getCard_message() {
                    return card_message;
                }

                public void setCard_message(String card_message) {
                    this.card_message = card_message;
                }

                public String getGoods_amount() {
                    return goods_amount;
                }

                public void setGoods_amount(String goods_amount) {
                    this.goods_amount = goods_amount;
                }

                public String getPay_fee() {
                    return pay_fee;
                }

                public void setPay_fee(String pay_fee) {
                    this.pay_fee = pay_fee;
                }

                public String getMoney_paid() {
                    return money_paid;
                }

                public void setMoney_paid(String money_paid) {
                    this.money_paid = money_paid;
                }

                public String getSurplus() {
                    return surplus;
                }

                public void setSurplus(String surplus) {
                    this.surplus = surplus;
                }

                public String getIntegral() {
                    return integral;
                }

                public void setIntegral(String integral) {
                    this.integral = integral;
                }

                public String getIntegral_money() {
                    return integral_money;
                }

                public void setIntegral_money(String integral_money) {
                    this.integral_money = integral_money;
                }

                public String getGive_integral() {
                    return give_integral;
                }

                public void setGive_integral(String give_integral) {
                    this.give_integral = give_integral;
                }

                public String getBonus() {
                    return bonus;
                }

                public void setBonus(String bonus) {
                    this.bonus = bonus;
                }

                public String getOrder_amount() {
                    return order_amount;
                }

                public void setOrder_amount(String order_amount) {
                    this.order_amount = order_amount;
                }

                public String getFrom_ad() {
                    return from_ad;
                }

                public void setFrom_ad(String from_ad) {
                    this.from_ad = from_ad;
                }

                public String getReferer() {
                    return referer;
                }

                public void setReferer(String referer) {
                    this.referer = referer;
                }

                public String getAdd_time() {
                    return add_time;
                }

                public void setAdd_time(String add_time) {
                    this.add_time = add_time;
                }

                public String getConfirm_time() {
                    return confirm_time;
                }

                public void setConfirm_time(String confirm_time) {
                    this.confirm_time = confirm_time;
                }

                public String getPay_time() {
                    return pay_time;
                }

                public void setPay_time(String pay_time) {
                    this.pay_time = pay_time;
                }

                public String getShipping_time() {
                    return shipping_time;
                }

                public void setShipping_time(String shipping_time) {
                    this.shipping_time = shipping_time;
                }

                public String getEvaluation_status() {
                    return evaluation_status;
                }

                public void setEvaluation_status(String evaluation_status) {
                    this.evaluation_status = evaluation_status;
                }

                public String getEvaluation_time() {
                    return evaluation_time;
                }

                public void setEvaluation_time(String evaluation_time) {
                    this.evaluation_time = evaluation_time;
                }

                public String getPack_id() {
                    return pack_id;
                }

                public void setPack_id(String pack_id) {
                    this.pack_id = pack_id;
                }

                public String getCard_id() {
                    return card_id;
                }

                public void setCard_id(String card_id) {
                    this.card_id = card_id;
                }

                public String getBonus_id() {
                    return bonus_id;
                }

                public void setBonus_id(String bonus_id) {
                    this.bonus_id = bonus_id;
                }

                public String getInvoice_no() {
                    return invoice_no;
                }

                public void setInvoice_no(String invoice_no) {
                    this.invoice_no = invoice_no;
                }

                public String getExtension_code() {
                    return extension_code;
                }

                public void setExtension_code(String extension_code) {
                    this.extension_code = extension_code;
                }

                public String getExtension_id() {
                    return extension_id;
                }

                public void setExtension_id(String extension_id) {
                    this.extension_id = extension_id;
                }

                public String getTo_buyer() {
                    return to_buyer;
                }

                public void setTo_buyer(String to_buyer) {
                    this.to_buyer = to_buyer;
                }

                public String getPay_note() {
                    return pay_note;
                }

                public void setPay_note(String pay_note) {
                    this.pay_note = pay_note;
                }

                public String getIs_separate() {
                    return is_separate;
                }

                public void setIs_separate(String is_separate) {
                    this.is_separate = is_separate;
                }

                public String getParent_id() {
                    return parent_id;
                }

                public void setParent_id(String parent_id) {
                    this.parent_id = parent_id;
                }

                public String getCid() {
                    return cid;
                }

                public void setCid(String cid) {
                    this.cid = cid;
                }

                public String getPid() {
                    return pid;
                }

                public void setPid(String pid) {
                    this.pid = pid;
                }

                public Object getReson() {
                    return reson;
                }

                public void setReson(Object reson) {
                    this.reson = reson;
                }

                public String getComment_status() {
                    return comment_status;
                }

                public void setComment_status(String comment_status) {
                    this.comment_status = comment_status;
                }

                public Object getContent() {
                    return content;
                }

                public void setContent(Object content) {
                    this.content = content;
                }

                public String getMonth() {
                    return month;
                }

                public void setMonth(String month) {
                    this.month = month;
                }

                public String getRegion_id() {
                    return region_id;
                }

                public void setRegion_id(String region_id) {
                    this.region_id = region_id;
                }

                public Object getGoods_image() {
                    return goods_image;
                }

                public void setGoods_image(Object goods_image) {
                    this.goods_image = goods_image;
                }

                public Object getAlipay() {
                    return alipay;
                }

                public void setAlipay(Object alipay) {
                    this.alipay = alipay;
                }

                public String getShopname() {
                    return shopname;
                }

                public void setShopname(String shopname) {
                    this.shopname = shopname;
                }

                public List<GoodsBean> get_goods() {
                    return _goods;
                }

                public void set_goods(List<GoodsBean> _goods) {
                    this._goods = _goods;
                }

                public static class GoodsBean implements Serializable{
                    /**
                     * rec_id : 94
                     * order_id : 72
                     * goods_id : 571
                     * goods_name : 新卫衣@
                     * goods_sn :
                     * product_id : 0
                     * goods_numbers : 1
                     * number : 1.00
                     * market_price : 147.60
                     * goods_price : 123.00
                     * goods_attr : M 黑色
                     * send_number : 0
                     * is_real : 0
                     * extension_code :
                     * extension_id : 0
                     * parent_id : 0
                     * is_gift : 0
                     * goods_attr_id : 785
                     * evaluation_status : 0
                     * evaluation_time : 0
                     * Score : 5
                     * comment : null
                     * userid : 4
                     * class : null
                     * images : null
                     * status : 0
                     * is_show : 1
                     * income : 0.00
                     * sid : 10
                     * goods_status : 0
                     * type : 1
                     * point : 0.00
                     * month : 201810
                     * rid : 0
                     * total : 0.00
                     * goods_image : http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/goods/20181022/aa4302c4acc4bce295fc9835dfe52be9.png
                     * reply_time : null
                     * reply_comment : null
                     * reply_status : 0
                     * add_time : 1540447167
                     */

                    private String rec_id;
                    private String order_id;
                    private String goods_id;
                    private String goods_name;
                    private String goods_sn;
                    private String product_id;
                    private String goods_numbers;
                    private String number;
                    private String market_price;
                    private String goods_price;
                    private String goods_attr;
                    private String send_number;
                    private String is_real;
                    private String extension_code;
                    private String extension_id;
                    private String parent_id;
                    private String is_gift;
                    private String goods_attr_id;
                    private String evaluation_status;
                    private String evaluation_time;
                    private String Score;
                    private Object comment;
                    private String userid;
                    @SerializedName("class")
                    private Object classX;
                    private Object images;
                    private String status;
                    private String is_show;
                    private String income;
                    private String sid;
                    private String goods_status;
                    private String type;
                    private String point;
                    private String month;
                    private String rid;
                    private String total;
                    private String goods_image;
                    private Object reply_time;
                    private Object reply_comment;
                    private String reply_status;
                    private String add_time;

                    public String getRec_id() {
                        return rec_id;
                    }

                    public void setRec_id(String rec_id) {
                        this.rec_id = rec_id;
                    }

                    public String getOrder_id() {
                        return order_id;
                    }

                    public void setOrder_id(String order_id) {
                        this.order_id = order_id;
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

                    public String getGoods_sn() {
                        return goods_sn;
                    }

                    public void setGoods_sn(String goods_sn) {
                        this.goods_sn = goods_sn;
                    }

                    public String getProduct_id() {
                        return product_id;
                    }

                    public void setProduct_id(String product_id) {
                        this.product_id = product_id;
                    }

                    public String getGoods_numbers() {
                        return goods_numbers;
                    }

                    public void setGoods_numbers(String goods_numbers) {
                        this.goods_numbers = goods_numbers;
                    }

                    public String getNumber() {
                        return number;
                    }

                    public void setNumber(String number) {
                        this.number = number;
                    }

                    public String getMarket_price() {
                        return market_price;
                    }

                    public void setMarket_price(String market_price) {
                        this.market_price = market_price;
                    }

                    public String getGoods_price() {
                        return goods_price;
                    }

                    public void setGoods_price(String goods_price) {
                        this.goods_price = goods_price;
                    }

                    public String getGoods_attr() {
                        return goods_attr;
                    }

                    public void setGoods_attr(String goods_attr) {
                        this.goods_attr = goods_attr;
                    }

                    public String getSend_number() {
                        return send_number;
                    }

                    public void setSend_number(String send_number) {
                        this.send_number = send_number;
                    }

                    public String getIs_real() {
                        return is_real;
                    }

                    public void setIs_real(String is_real) {
                        this.is_real = is_real;
                    }

                    public String getExtension_code() {
                        return extension_code;
                    }

                    public void setExtension_code(String extension_code) {
                        this.extension_code = extension_code;
                    }

                    public String getExtension_id() {
                        return extension_id;
                    }

                    public void setExtension_id(String extension_id) {
                        this.extension_id = extension_id;
                    }

                    public String getParent_id() {
                        return parent_id;
                    }

                    public void setParent_id(String parent_id) {
                        this.parent_id = parent_id;
                    }

                    public String getIs_gift() {
                        return is_gift;
                    }

                    public void setIs_gift(String is_gift) {
                        this.is_gift = is_gift;
                    }

                    public String getGoods_attr_id() {
                        return goods_attr_id;
                    }

                    public void setGoods_attr_id(String goods_attr_id) {
                        this.goods_attr_id = goods_attr_id;
                    }

                    public String getEvaluation_status() {
                        return evaluation_status;
                    }

                    public void setEvaluation_status(String evaluation_status) {
                        this.evaluation_status = evaluation_status;
                    }

                    public String getEvaluation_time() {
                        return evaluation_time;
                    }

                    public void setEvaluation_time(String evaluation_time) {
                        this.evaluation_time = evaluation_time;
                    }

                    public String getScore() {
                        return Score;
                    }

                    public void setScore(String Score) {
                        this.Score = Score;
                    }

                    public Object getComment() {
                        return comment;
                    }

                    public void setComment(Object comment) {
                        this.comment = comment;
                    }

                    public String getUserid() {
                        return userid;
                    }

                    public void setUserid(String userid) {
                        this.userid = userid;
                    }

                    public Object getClassX() {
                        return classX;
                    }

                    public void setClassX(Object classX) {
                        this.classX = classX;
                    }

                    public Object getImages() {
                        return images;
                    }

                    public void setImages(Object images) {
                        this.images = images;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getIs_show() {
                        return is_show;
                    }

                    public void setIs_show(String is_show) {
                        this.is_show = is_show;
                    }

                    public String getIncome() {
                        return income;
                    }

                    public void setIncome(String income) {
                        this.income = income;
                    }

                    public String getSid() {
                        return sid;
                    }

                    public void setSid(String sid) {
                        this.sid = sid;
                    }

                    public String getGoods_status() {
                        return goods_status;
                    }

                    public void setGoods_status(String goods_status) {
                        this.goods_status = goods_status;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getPoint() {
                        return point;
                    }

                    public void setPoint(String point) {
                        this.point = point;
                    }

                    public String getMonth() {
                        return month;
                    }

                    public void setMonth(String month) {
                        this.month = month;
                    }

                    public String getRid() {
                        return rid;
                    }

                    public void setRid(String rid) {
                        this.rid = rid;
                    }

                    public String getTotal() {
                        return total;
                    }

                    public void setTotal(String total) {
                        this.total = total;
                    }

                    public String getGoods_image() {
                        return goods_image;
                    }

                    public void setGoods_image(String goods_image) {
                        this.goods_image = goods_image;
                    }

                    public Object getReply_time() {
                        return reply_time;
                    }

                    public void setReply_time(Object reply_time) {
                        this.reply_time = reply_time;
                    }

                    public Object getReply_comment() {
                        return reply_comment;
                    }

                    public void setReply_comment(Object reply_comment) {
                        this.reply_comment = reply_comment;
                    }

                    public String getReply_status() {
                        return reply_status;
                    }

                    public void setReply_status(String reply_status) {
                        this.reply_status = reply_status;
                    }

                    public String getAdd_time() {
                        return add_time;
                    }

                    public void setAdd_time(String add_time) {
                        this.add_time = add_time;
                    }
                }
            }
        }
    }
}
