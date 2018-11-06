package com.liuge.z02sckhd_6wqgx.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/9/18.
 */

public class GoodsDetailsEntity {

    /**
     * status : success
     * msg : 获取成功
     * data : {"goods_id":"540","goods_sn":"125485","goods_name":"Lilbetter卫衣男 秋装连帽上衣","goods_number":"247","description":"<p>\r\n\t不发红包股份顾给他个v也还好吧\r\n<\/p>\r\n<p align=\"center\">\r\n\t<img src=\"/application/lee/uploads/image/20180912/20180912061448_93511.jpg\" alt=\"\" /> \r\n<\/p>","cate_id":"158","brand":"","spec_qty":"1","spec_name_1":"颜色","spec_name_2":"","goods_weight":"1.000","status":"1","add_time":"1536736739","goods_type":"42","last_update":"1536736739","default_spec":"732","default_image":"application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","is_best":"0","is_new":"0","is_hot":"0","is_promote":"0","market_price":"129.60","price":"108.00","cost_price":"0.00","promote_price":"0.00","promote_start_date":"0","promote_end_date":"0","click_count":"0","is_shipping":"0","sort":"50","give_integral":"-1","rank_integral":"-1","integral":"50","is_check":"1","seo_keys":"时尚,纯棉,直筒,常规,长袖,翻领,大众,Array,123","seo_desc":"","from":"0","sid":"10","is_del":"0","views":"97","collects":"0","carts":"2","orders":"8","sales":"0","comments":"0","_images":[{"id":"1759","gid":"540","url":"application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","thumb":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","sort":"1","fid":"958"}],"_specs":[{"spec_id":"732","goods_id":"540","spec_1":"L","spec_2":"","color_rgb":"","price":"108.00","stock":"43","sku":"125485"},{"spec_id":"733","goods_id":"540","spec_1":"M","spec_2":"","color_rgb":"","price":"110.00","stock":"199","sku":"585386"}],"attr":[{"aid":"19","value":"123","attr_name":"品牌"}],"phone":"13183872174","pay_fee":null}
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
         * goods_id : 540
         * goods_sn : 125485
         * goods_name : Lilbetter卫衣男 秋装连帽上衣
         * goods_number : 247
         * description : <p>
         不发红包股份顾给他个v也还好吧
         </p>
         <p align="center">
         <img src="/application/lee/uploads/image/20180912/20180912061448_93511.jpg" alt="" />
         </p>
         * cate_id : 158
         * brand :
         * spec_qty : 1
         * spec_name_1 : 颜色
         * spec_name_2 :
         * goods_weight : 1.000
         * status : 1
         * add_time : 1536736739
         * goods_type : 42
         * last_update : 1536736739
         * default_spec : 732
         * default_image : application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg
         * is_best : 0
         * is_new : 0
         * is_hot : 0
         * is_promote : 0
         * market_price : 129.60
         * price : 108.00
         * cost_price : 0.00
         * promote_price : 0.00
         * promote_start_date : 0
         * promote_end_date : 0
         * click_count : 0
         * is_shipping : 0
         * sort : 50
         * give_integral : -1
         * rank_integral : -1
         * integral : 50
         * is_check : 1
         * seo_keys : 时尚,纯棉,直筒,常规,长袖,翻领,大众,Array,123
         * seo_desc :
         * from : 0
         * sid : 10
         * is_del : 0
         * views : 97
         * collects : 0
         * carts : 2
         * orders : 8
         * sales : 0
         * comments : 0
         * _images : [{"id":"1759","gid":"540","url":"application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","thumb":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg","sort":"1","fid":"958"}]
         * _specs : [{"spec_id":"732","goods_id":"540","spec_1":"L","spec_2":"","color_rgb":"","price":"108.00","stock":"43","sku":"125485"},{"spec_id":"733","goods_id":"540","spec_1":"M","spec_2":"","color_rgb":"","price":"110.00","stock":"199","sku":"585386"}]
         * attr : [{"aid":"19","value":"123","attr_name":"品牌"}]
         * phone : 13183872174
         * pay_fee : null
         */

        private String goods_id;
        private String goods_sn;
        private String goods_name;
        private String goods_number;
        private String description;
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
        private String phone;
        private Object pay_fee;
        private List<ImagesBean> _images;
        private List<SpecsBean> _specs;
        private List<AttrBean> attr;

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getPay_fee() {
            return pay_fee;
        }

        public void setPay_fee(Object pay_fee) {
            this.pay_fee = pay_fee;
        }

        public List<ImagesBean> get_images() {
            return _images;
        }

        public void set_images(List<ImagesBean> _images) {
            this._images = _images;
        }

        public List<SpecsBean> get_specs() {
            return _specs;
        }

        public void set_specs(List<SpecsBean> _specs) {
            this._specs = _specs;
        }

        public List<AttrBean> getAttr() {
            return attr;
        }

        public void setAttr(List<AttrBean> attr) {
            this.attr = attr;
        }

        public static class ImagesBean {
            /**
             * id : 1759
             * gid : 540
             * url : application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg
             * thumb : http://shop.dktoo.com/application/lee/uploads/lee/20180912/80607de91b145f55de41ade365f6556d.jpg
             * sort : 1
             * fid : 958
             */

            private String id;
            private String gid;
            private String url;
            private String thumb;
            private String sort;
            private String fid;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getGid() {
                return gid;
            }

            public void setGid(String gid) {
                this.gid = gid;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
                this.fid = fid;
            }
        }

        public static class SpecsBean {
            /**
             * spec_id : 732
             * goods_id : 540
             * spec_1 : L
             * spec_2 :
             * color_rgb :
             * price : 108.00
             * stock : 43
             * sku : 125485
             */

            private String spec_id;
            private String goods_id;
            private String spec_1;
            private String spec_2;
            private String color_rgb;
            private String price;
            private String stock;
            private String sku;

            public String getSpec_id() {
                return spec_id;
            }

            public void setSpec_id(String spec_id) {
                this.spec_id = spec_id;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getSpec_1() {
                return spec_1;
            }

            public void setSpec_1(String spec_1) {
                this.spec_1 = spec_1;
            }

            public String getSpec_2() {
                return spec_2;
            }

            public void setSpec_2(String spec_2) {
                this.spec_2 = spec_2;
            }

            public String getColor_rgb() {
                return color_rgb;
            }

            public void setColor_rgb(String color_rgb) {
                this.color_rgb = color_rgb;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getStock() {
                return stock;
            }

            public void setStock(String stock) {
                this.stock = stock;
            }

            public String getSku() {
                return sku;
            }

            public void setSku(String sku) {
                this.sku = sku;
            }
        }

        public static class AttrBean {
            /**
             * aid : 19
             * value : 123
             * attr_name : 品牌
             */

            private String aid;
            private String value;
            private String attr_name;

            public String getAid() {
                return aid;
            }

            public void setAid(String aid) {
                this.aid = aid;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getAttr_name() {
                return attr_name;
            }

            public void setAttr_name(String attr_name) {
                this.attr_name = attr_name;
            }
        }
    }
}
