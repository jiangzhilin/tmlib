package com.liuge.z02sckhd_6wqgx.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/9/27.
 */

public class AddressEntity {

    /**
     * status : success
     * msg : 获取成功
     * data : [{"address_id":"99","address_name":"可口可乐了","user_id":"4","consignee":"撒是达到","email":"","region_id":"0","address":"浙江省杭州市滨江区","zipcode":"","tel":"18482180351","mobile":"18482180351","sign_building":"","point_lng":null,"point_lat":null,"is_default":"1","best_time":""}]
     */

    private String status;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * address_id : 99
         * address_name : 可口可乐了
         * user_id : 4
         * consignee : 撒是达到
         * email :
         * region_id : 0
         * address : 浙江省杭州市滨江区
         * zipcode :
         * tel : 18482180351
         * mobile : 18482180351
         * sign_building :
         * point_lng : null
         * point_lat : null
         * is_default : 1
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
