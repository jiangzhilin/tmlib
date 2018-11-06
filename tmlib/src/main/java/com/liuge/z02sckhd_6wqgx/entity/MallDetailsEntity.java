package com.liuge.z02sckhd_6wqgx.entity;

import java.util.List;

/**
 * Created by jiang on 2018/10/28.
 */

public class MallDetailsEntity {


    /**
     * status : success
     * msg : 获取成功
     * data : {"seller":{"id":"10","shopname":"郭","banner":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/seller/20181019/892c978fabc128461b68fd1922d15f9e.png","logo":"http://shop.dktoo.com/application/lee/uploads/lee/20180927/f736590094161fb35bfd1040790dc772.jpeg"},"category":[{"id":"151","pid":"0","name":"女装","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/4f14a2af447f030edb4954131d4a4bf9.png"},{"id":"150","pid":"0","name":"食品","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/8023281aa0d48f7a2e4d9a41ff7d3204.png"},{"id":"149","pid":"0","name":"鞋帽","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/bdd77876575068e719e79a55122b3674.png"},{"id":"147","pid":"0","name":"百货","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/0b2a6ab68cc627880f3141f47e3f2d82.png"},{"id":"146","pid":"0","name":"童装","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/77a5fd154c9c1b10e72cc1b903ceca64.png"},{"id":"144","pid":"0","name":"美妆","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/0db290cc4180b617e69a0e2ee574cf07.png"},{"id":"164","pid":"0","name":"家电","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/633369412488d639b209ae565f8f5c68.png"},{"id":"165","pid":"0","name":"文具","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/75744022d3fbdd832c17a8bf28a54b69.png"}],"isbest":[{"goods_id":"552","goods_sn":"123463","goods_name":"口红","goods_number":"98","cate_id":"144","brand":"","spec_qty":"1","spec_name_1":"颜色","spec_name_2":"","goods_weight":"1.000","status":"1","add_time":"1539664178","goods_type":"0","last_update":"1539664178","default_spec":"747","default_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/e50c6bb4ad548d9eede82fed0017aeff.jpg","is_best":"1","is_new":"0","is_hot":"0","is_promote":"0","market_price":"23.88","price":"19.90","cost_price":"0.00","promote_price":"0.00","promote_start_date":"0","promote_end_date":"0","click_count":"0","is_shipping":"0","sort":"50","give_integral":"6","rank_integral":"-1","integral":"10","is_check":"1","seo_keys":"","seo_desc":"","from":"0","sid":"10","is_del":"0","views":"0","collects":"2","carts":"20","orders":"2","sales":"0","comments":"1","pay_number":2},{"goods_id":"539","goods_sn":"002","goods_name":"ONLY2018秋季新款毛边高腰九分牛仔裤","goods_number":"595","cate_id":"159","brand":"","spec_qty":"1","spec_name_1":"颜色","spec_name_2":"","goods_weight":"1.000","status":"1","add_time":"1539920583","goods_type":"42","last_update":"1539920583","default_spec":"731","default_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/73b0ec746b6c43b452e4a40eb7c79ff6.jpg","is_best":"1","is_new":"0","is_hot":"0","is_promote":"0","market_price":"117.60","price":"98.00","cost_price":"0.00","promote_price":"0.00","promote_start_date":"0","promote_end_date":"0","click_count":"0","is_shipping":"0","sort":"50","give_integral":"111","rank_integral":"-1","integral":"2","is_check":"1","seo_keys":"百搭,纯棉,微喇,超短,长袖,常规,立领,大众","seo_desc":"","from":"0","sid":"10","is_del":"0","views":"47","collects":"3","carts":"13","orders":"7","sales":"0","comments":"1","pay_number":7}]}
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
         * seller : {"id":"10","shopname":"郭","banner":"http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/seller/20181019/892c978fabc128461b68fd1922d15f9e.png","logo":"http://shop.dktoo.com/application/lee/uploads/lee/20180927/f736590094161fb35bfd1040790dc772.jpeg"}
         * category : [{"id":"151","pid":"0","name":"女装","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/4f14a2af447f030edb4954131d4a4bf9.png"},{"id":"150","pid":"0","name":"食品","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/8023281aa0d48f7a2e4d9a41ff7d3204.png"},{"id":"149","pid":"0","name":"鞋帽","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/bdd77876575068e719e79a55122b3674.png"},{"id":"147","pid":"0","name":"百货","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/0b2a6ab68cc627880f3141f47e3f2d82.png"},{"id":"146","pid":"0","name":"童装","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/77a5fd154c9c1b10e72cc1b903ceca64.png"},{"id":"144","pid":"0","name":"美妆","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/0db290cc4180b617e69a0e2ee574cf07.png"},{"id":"164","pid":"0","name":"家电","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/633369412488d639b209ae565f8f5c68.png"},{"id":"165","pid":"0","name":"文具","image":"http://shop.dktoo.com/application/lee/uploads/lee/20180903/75744022d3fbdd832c17a8bf28a54b69.png"}]
         * isbest : [{"goods_id":"552","goods_sn":"123463","goods_name":"口红","goods_number":"98","cate_id":"144","brand":"","spec_qty":"1","spec_name_1":"颜色","spec_name_2":"","goods_weight":"1.000","status":"1","add_time":"1539664178","goods_type":"0","last_update":"1539664178","default_spec":"747","default_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/e50c6bb4ad548d9eede82fed0017aeff.jpg","is_best":"1","is_new":"0","is_hot":"0","is_promote":"0","market_price":"23.88","price":"19.90","cost_price":"0.00","promote_price":"0.00","promote_start_date":"0","promote_end_date":"0","click_count":"0","is_shipping":"0","sort":"50","give_integral":"6","rank_integral":"-1","integral":"10","is_check":"1","seo_keys":"","seo_desc":"","from":"0","sid":"10","is_del":"0","views":"0","collects":"2","carts":"20","orders":"2","sales":"0","comments":"1","pay_number":2},{"goods_id":"539","goods_sn":"002","goods_name":"ONLY2018秋季新款毛边高腰九分牛仔裤","goods_number":"595","cate_id":"159","brand":"","spec_qty":"1","spec_name_1":"颜色","spec_name_2":"","goods_weight":"1.000","status":"1","add_time":"1539920583","goods_type":"42","last_update":"1539920583","default_spec":"731","default_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/73b0ec746b6c43b452e4a40eb7c79ff6.jpg","is_best":"1","is_new":"0","is_hot":"0","is_promote":"0","market_price":"117.60","price":"98.00","cost_price":"0.00","promote_price":"0.00","promote_start_date":"0","promote_end_date":"0","click_count":"0","is_shipping":"0","sort":"50","give_integral":"111","rank_integral":"-1","integral":"2","is_check":"1","seo_keys":"百搭,纯棉,微喇,超短,长袖,常规,立领,大众","seo_desc":"","from":"0","sid":"10","is_del":"0","views":"47","collects":"3","carts":"13","orders":"7","sales":"0","comments":"1","pay_number":7}]
         */

        private SellerBean seller;
        private List<CategoryBean> category;
        private List<IsbestBean> isbest;

        public SellerBean getSeller() {
            return seller;
        }

        public void setSeller(SellerBean seller) {
            this.seller = seller;
        }

        public List<CategoryBean> getCategory() {
            return category;
        }

        public void setCategory(List<CategoryBean> category) {
            this.category = category;
        }

        public List<IsbestBean> getIsbest() {
            return isbest;
        }

        public void setIsbest(List<IsbestBean> isbest) {
            this.isbest = isbest;
        }

        public static class SellerBean {
            /**
             * id : 10
             * shopname : 郭
             * banner : http://shop.dktoo.com/application/z02sckhd_6wqgx/uploads/seller/20181019/892c978fabc128461b68fd1922d15f9e.png
             * logo : http://shop.dktoo.com/application/lee/uploads/lee/20180927/f736590094161fb35bfd1040790dc772.jpeg
             */

            private String id;
            private String shopname;
            private String banner;
            private String logo;

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
        }

        public static class CategoryBean {
            /**
             * id : 151
             * pid : 0
             * name : 女装
             * image : http://shop.dktoo.com/application/lee/uploads/lee/20180903/4f14a2af447f030edb4954131d4a4bf9.png
             */

            private String id;
            private String pid;
            private String name;
            private String image;

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

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }

        public static class IsbestBean {
            /**
             * goods_id : 552
             * goods_sn : 123463
             * goods_name : 口红
             * goods_number : 98
             * cate_id : 144
             * brand :
             * spec_qty : 1
             * spec_name_1 : 颜色
             * spec_name_2 :
             * goods_weight : 1.000
             * status : 1
             * add_time : 1539664178
             * goods_type : 0
             * last_update : 1539664178
             * default_spec : 747
             * default_image : http://shop.dktoo.com/application/lee/uploads/lee/20180912/e50c6bb4ad548d9eede82fed0017aeff.jpg
             * is_best : 1
             * is_new : 0
             * is_hot : 0
             * is_promote : 0
             * market_price : 23.88
             * price : 19.90
             * cost_price : 0.00
             * promote_price : 0.00
             * promote_start_date : 0
             * promote_end_date : 0
             * click_count : 0
             * is_shipping : 0
             * sort : 50
             * give_integral : 6
             * rank_integral : -1
             * integral : 10
             * is_check : 1
             * seo_keys :
             * seo_desc :
             * from : 0
             * sid : 10
             * is_del : 0
             * views : 0
             * collects : 2
             * carts : 20
             * orders : 2
             * sales : 0
             * comments : 1
             * pay_number : 2
             */

            private String goods_id;
            private String goods_sn;
            private String goods_name;
            private String goods_number;
            private String cate_id;
            private String brand;
            private String spec_qty;
            private String spec_name_1;
            private String spec_name_2;
            private String goods_weight;
            private String status;
            private String add_time;
            private String goods_type;
            private String last_update;
            private String default_spec;
            private String default_image;
            private String is_best;
            private String is_new;
            private String is_hot;
            private String is_promote;
            private String market_price;
            private String price;
            private String cost_price;
            private String promote_price;
            private String promote_start_date;
            private String promote_end_date;
            private String click_count;
            private String is_shipping;
            private String sort;
            private String give_integral;
            private String rank_integral;
            private String integral;
            private String is_check;
            private String seo_keys;
            private String seo_desc;
            private String from;
            private String sid;
            private String is_del;
            private String views;
            private String collects;
            private String carts;
            private String orders;
            private String sales;
            private String comments;
            private int pay_number;

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_number() {
                return goods_number;
            }

            public void setGoods_number(String goods_number) {
                this.goods_number = goods_number;
            }

            public String getCate_id() {
                return cate_id;
            }

            public void setCate_id(String cate_id) {
                this.cate_id = cate_id;
            }

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }

            public String getSpec_qty() {
                return spec_qty;
            }

            public void setSpec_qty(String spec_qty) {
                this.spec_qty = spec_qty;
            }

            public String getSpec_name_1() {
                return spec_name_1;
            }

            public void setSpec_name_1(String spec_name_1) {
                this.spec_name_1 = spec_name_1;
            }

            public String getSpec_name_2() {
                return spec_name_2;
            }

            public void setSpec_name_2(String spec_name_2) {
                this.spec_name_2 = spec_name_2;
            }

            public String getGoods_weight() {
                return goods_weight;
            }

            public void setGoods_weight(String goods_weight) {
                this.goods_weight = goods_weight;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getGoods_type() {
                return goods_type;
            }

            public void setGoods_type(String goods_type) {
                this.goods_type = goods_type;
            }

            public String getLast_update() {
                return last_update;
            }

            public void setLast_update(String last_update) {
                this.last_update = last_update;
            }

            public String getDefault_spec() {
                return default_spec;
            }

            public void setDefault_spec(String default_spec) {
                this.default_spec = default_spec;
            }

            public String getDefault_image() {
                return default_image;
            }

            public void setDefault_image(String default_image) {
                this.default_image = default_image;
            }

            public String getIs_best() {
                return is_best;
            }

            public void setIs_best(String is_best) {
                this.is_best = is_best;
            }

            public String getIs_new() {
                return is_new;
            }

            public void setIs_new(String is_new) {
                this.is_new = is_new;
            }

            public String getIs_hot() {
                return is_hot;
            }

            public void setIs_hot(String is_hot) {
                this.is_hot = is_hot;
            }

            public String getIs_promote() {
                return is_promote;
            }

            public void setIs_promote(String is_promote) {
                this.is_promote = is_promote;
            }

            public String getMarket_price() {
                return market_price;
            }

            public void setMarket_price(String market_price) {
                this.market_price = market_price;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getCost_price() {
                return cost_price;
            }

            public void setCost_price(String cost_price) {
                this.cost_price = cost_price;
            }

            public String getPromote_price() {
                return promote_price;
            }

            public void setPromote_price(String promote_price) {
                this.promote_price = promote_price;
            }

            public String getPromote_start_date() {
                return promote_start_date;
            }

            public void setPromote_start_date(String promote_start_date) {
                this.promote_start_date = promote_start_date;
            }

            public String getPromote_end_date() {
                return promote_end_date;
            }

            public void setPromote_end_date(String promote_end_date) {
                this.promote_end_date = promote_end_date;
            }

            public String getClick_count() {
                return click_count;
            }

            public void setClick_count(String click_count) {
                this.click_count = click_count;
            }

            public String getIs_shipping() {
                return is_shipping;
            }

            public void setIs_shipping(String is_shipping) {
                this.is_shipping = is_shipping;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getGive_integral() {
                return give_integral;
            }

            public void setGive_integral(String give_integral) {
                this.give_integral = give_integral;
            }

            public String getRank_integral() {
                return rank_integral;
            }

            public void setRank_integral(String rank_integral) {
                this.rank_integral = rank_integral;
            }

            public String getIntegral() {
                return integral;
            }

            public void setIntegral(String integral) {
                this.integral = integral;
            }

            public String getIs_check() {
                return is_check;
            }

            public void setIs_check(String is_check) {
                this.is_check = is_check;
            }

            public String getSeo_keys() {
                return seo_keys;
            }

            public void setSeo_keys(String seo_keys) {
                this.seo_keys = seo_keys;
            }

            public String getSeo_desc() {
                return seo_desc;
            }

            public void setSeo_desc(String seo_desc) {
                this.seo_desc = seo_desc;
            }

            public String getFrom() {
                return from;
            }

            public void setFrom(String from) {
                this.from = from;
            }

            public String getSid() {
                return sid;
            }

            public void setSid(String sid) {
                this.sid = sid;
            }

            public String getIs_del() {
                return is_del;
            }

            public void setIs_del(String is_del) {
                this.is_del = is_del;
            }

            public String getViews() {
                return views;
            }

            public void setViews(String views) {
                this.views = views;
            }

            public String getCollects() {
                return collects;
            }

            public void setCollects(String collects) {
                this.collects = collects;
            }

            public String getCarts() {
                return carts;
            }

            public void setCarts(String carts) {
                this.carts = carts;
            }

            public String getOrders() {
                return orders;
            }

            public void setOrders(String orders) {
                this.orders = orders;
            }

            public String getSales() {
                return sales;
            }

            public void setSales(String sales) {
                this.sales = sales;
            }

            public String getComments() {
                return comments;
            }

            public void setComments(String comments) {
                this.comments = comments;
            }

            public int getPay_number() {
                return pay_number;
            }

            public void setPay_number(int pay_number) {
                this.pay_number = pay_number;
            }
        }
    }
}
