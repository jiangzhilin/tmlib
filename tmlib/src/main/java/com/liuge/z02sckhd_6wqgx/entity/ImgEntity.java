package com.liuge.z02sckhd_6wqgx.entity;

/**
 * Created by jiang on 2018/11/4.
 */

public class ImgEntity {

    /**
     * status : success
     * msg : 上传成功
     * data : {"id":"1128","path":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/comment/20181104/4915882f17eba09a0202962f84b6bfd6.jpg"}
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
         * id : 1128
         * path : http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/comment/20181104/4915882f17eba09a0202962f84b6bfd6.jpg
         */

        private String id;
        private String path;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
