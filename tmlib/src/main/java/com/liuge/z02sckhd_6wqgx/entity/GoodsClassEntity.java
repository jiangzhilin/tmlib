package com.liuge.z02sckhd_6wqgx.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/9/18.
 */

public class GoodsClassEntity {

    /**
     * status : success
     * msg : 获取成功
     * data : [{"id":"151","pid":"0","name":"女装","keywords":"","desc":"","sort":"8","status":"1","filter_attr":"","nav":"0","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/4f14a2af447f030edb4954131d4a4bf9.png","grade":"0","sid":"1"},{"id":"150","pid":"0","name":"食品","keywords":"","desc":"","sort":"2","status":"1","filter_attr":"","nav":"0","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/8023281aa0d48f7a2e4d9a41ff7d3204.png","grade":"0","sid":"1"},{"id":"149","pid":"0","name":"鞋帽","keywords":"","desc":"","sort":"6","status":"1","filter_attr":"","nav":"0","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/bdd77876575068e719e79a55122b3674.png","grade":"0","sid":"1"},{"id":"147","pid":"0","name":"百货","keywords":"","desc":"","sort":"1","status":"1","filter_attr":"","nav":"0","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/0b2a6ab68cc627880f3141f47e3f2d82.png","grade":"0","sid":"1"},{"id":"146","pid":"0","name":"童装","keywords":"","desc":"","sort":"5","status":"1","filter_attr":"","nav":"0","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/77a5fd154c9c1b10e72cc1b903ceca64.png","grade":"0","sid":"1"},{"id":"144","pid":"0","name":"美妆","keywords":"","desc":"","sort":"3","status":"1","filter_attr":"","nav":"0","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/0db290cc4180b617e69a0e2ee574cf07.png","grade":"0","sid":"1"},{"id":"164","pid":"0","name":"家电","keywords":null,"desc":null,"sort":"50","status":"1","filter_attr":null,"nav":"0","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/633369412488d639b209ae565f8f5c68.png","grade":"0","sid":"1"},{"id":"165","pid":"0","name":"文具","keywords":null,"desc":null,"sort":"50","status":"1","filter_attr":null,"nav":"0","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/75744022d3fbdd832c17a8bf28a54b69.png","grade":"0","sid":"1"}]
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

    public static class DataBean {
        /**
         * id : 151
         * pid : 0
         * name : 女装
         * keywords :
         * desc :
         * sort : 8
         * status : 1
         * filter_attr :
         * nav : 0
         * image : http://shop.dktoo.com/application/lee/uploads/lee/20180903/4f14a2af447f030edb4954131d4a4bf9.png
         * grade : 0
         * sid : 1
         */

        private String id;
        private String pid;
        private String name;
        private String keywords;
        private String desc;
        private String sort;
        private String status;
        private String filter_attr;
        private String nav;
        private String image;
        private String grade;
        private String sid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFilter_attr() {
            return filter_attr;
        }

        public void setFilter_attr(String filter_attr) {
            this.filter_attr = filter_attr;
        }

        public String getNav() {
            return nav;
        }

        public void setNav(String nav) {
            this.nav = nav;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }
    }
}
