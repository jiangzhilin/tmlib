package com.liuge.z02sckhd_6wqgx.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/9/19.
 */

public class MiaoshaEntity {

    /**
     * status : success
     * msg : 获取成功
     * data : {"store":{"act_id":"88","act_type":"4","goods_id":"554","goods_name":"运动鞋","start_time":"2018-08-07 00:00:00","end_time":"2018-09-30 00:00:00","is_finished":"0","ext_info":null,"total":"9999","number":"9","price":"1.90","spec_id":"749","spec_name":"","num":"0","pid":"1","markups":"0.00","maxprice":"0.00","sid":"10","type":"4"},"buylog":[{"user_id":"3","member_name":"157****6882","goods_numbers":"1","goods_price":"1.90","add_time":"1536905567","total":1.9}],"onum":1,"goods":{"goods_id":"554","goods_sn":"123456","goods_name":"运动鞋","goods_number":"199","description":"<p>\r\n\t小孩运动鞋\r\n<\/p>\r\n<p align=\"center\">\r\n\t<img src=\"/application/lee/uploads/image/20180912/20180912074123_25526.jpg\" alt=\"\" /> \r\n<\/p>","cate_id":"146","brand":"","spec_qty":"1","spec_name_1":"颜色","spec_name_2":"","goods_weight":"1.000","status":"1","add_time":"1536738122","goods_type":"0","last_update":"1536738122","default_spec":"750","default_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/06a440634b57677a12e24c2ac693078f.jpg","is_best":"0","is_new":"0","is_hot":"0","is_promote":"0","market_price":"239.99","price":"199.99","cost_price":"0.00","promote_price":"0.00","promote_start_date":"0","promote_end_date":"0","click_count":"0","is_shipping":"0","sort":"50","give_integral":"-1","rank_integral":"-1","integral":"80","is_check":"1","seo_keys":"","seo_desc":"","from":"0","sid":"10","is_del":"0","_specs_all":[{"spec_id":"750","goods_id":"554","spec_1":"红色","spec_2":"","color_rgb":"","price":"199.99","stock":"96","sku":"123456"},{"spec_id":"749","goods_id":"554","spec_1":"白色","spec_2":"","color_rgb":"","price":"199.99","stock":"100","sku":"123456"}],"_images":[{"id":"1760","gid":"554","url":"application/lee/uploads/lee/20180912/06a440634b57677a12e24c2ac693078f.jpg","thumb":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/06a440634b57677a12e24c2ac693078f.jpg","sort":"1","fid":"959"}],"_statistics":{"goods_id":"554","views":"19","collects":"0","carts":"1","orders":"3","sales":"0","comments":"0"},"cate_name":"童装","attr":null},"phone":"13183872174","pay_fee":null}
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
         * store : {"act_id":"88","act_type":"4","goods_id":"554","goods_name":"运动鞋","start_time":"2018-08-07 00:00:00","end_time":"2018-09-30 00:00:00","is_finished":"0","ext_info":null,"total":"9999","number":"9","price":"1.90","spec_id":"749","spec_name":"","num":"0","pid":"1","markups":"0.00","maxprice":"0.00","sid":"10","type":"4"}
         * buylog : [{"user_id":"3","member_name":"157****6882","goods_numbers":"1","goods_price":"1.90","add_time":"1536905567","total":1.9}]
         * onum : 1
         * goods : {"goods_id":"554","goods_sn":"123456","goods_name":"运动鞋","goods_number":"199","description":"<p>\r\n\t小孩运动鞋\r\n<\/p>\r\n<p align=\"center\">\r\n\t<img src=\"/application/lee/uploads/image/20180912/20180912074123_25526.jpg\" alt=\"\" /> \r\n<\/p>","cate_id":"146","brand":"","spec_qty":"1","spec_name_1":"颜色","spec_name_2":"","goods_weight":"1.000","status":"1","add_time":"1536738122","goods_type":"0","last_update":"1536738122","default_spec":"750","default_image":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/06a440634b57677a12e24c2ac693078f.jpg","is_best":"0","is_new":"0","is_hot":"0","is_promote":"0","market_price":"239.99","price":"199.99","cost_price":"0.00","promote_price":"0.00","promote_start_date":"0","promote_end_date":"0","click_count":"0","is_shipping":"0","sort":"50","give_integral":"-1","rank_integral":"-1","integral":"80","is_check":"1","seo_keys":"","seo_desc":"","from":"0","sid":"10","is_del":"0","_specs_all":[{"spec_id":"750","goods_id":"554","spec_1":"红色","spec_2":"","color_rgb":"","price":"199.99","stock":"96","sku":"123456"},{"spec_id":"749","goods_id":"554","spec_1":"白色","spec_2":"","color_rgb":"","price":"199.99","stock":"100","sku":"123456"}],"_images":[{"id":"1760","gid":"554","url":"application/lee/uploads/lee/20180912/06a440634b57677a12e24c2ac693078f.jpg","thumb":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/06a440634b57677a12e24c2ac693078f.jpg","sort":"1","fid":"959"}],"_statistics":{"goods_id":"554","views":"19","collects":"0","carts":"1","orders":"3","sales":"0","comments":"0"},"cate_name":"童装","attr":null}
         * phone : 13183872174
         * pay_fee : null
         */

        private StoreBean store;
        private int onum;
        private GoodsBean goods;
        private String phone;
        private Object pay_fee;
        private List<BuylogBean> buylog;

        public StoreBean getStore() {
            return store;
        }

        public void setStore(StoreBean store) {
            this.store = store;
        }

        public int getOnum() {
            return onum;
        }

        public void setOnum(int onum) {
            this.onum = onum;
        }

        public GoodsBean getGoods() {
            return goods;
        }

        public void setGoods(GoodsBean goods) {
            this.goods = goods;
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

        public List<BuylogBean> getBuylog() {
            return buylog;
        }

        public void setBuylog(List<BuylogBean> buylog) {
            this.buylog = buylog;
        }

        public static class StoreBean {
            /**
             * act_id : 88
             * act_type : 4
             * goods_id : 554
             * goods_name : 运动鞋
             * start_time : 2018-08-07 00:00:00
             * end_time : 2018-09-30 00:00:00
             * is_finished : 0
             * ext_info : null
             * total : 9999
             * number : 9
             * price : 1.90
             * spec_id : 749
             * spec_name :
             * num : 0
             * pid : 1
             * markups : 0.00
             * maxprice : 0.00
             * sid : 10
             * type : 4
             */

            private String act_id;
            private String act_type;
            private String goods_id;
            private String goods_name;
            private String start_time;
            private String end_time;
            private String is_finished;
            private Object ext_info;
            private String total;
            private String number;
            private String price;
            private String spec_id;
            private String spec_name;
            private String num;
            private String pid;
            private String markups;
            private String maxprice;
            private String sid;
            private String type;

            public String getAct_id() {
                return act_id;
            }

            public void setAct_id(String act_id) {
                this.act_id = act_id;
            }

            public String getAct_type() {
                return act_type;
            }

            public void setAct_type(String act_type) {
                this.act_type = act_type;
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

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getIs_finished() {
                return is_finished;
            }

            public void setIs_finished(String is_finished) {
                this.is_finished = is_finished;
            }

            public Object getExt_info() {
                return ext_info;
            }

            public void setExt_info(Object ext_info) {
                this.ext_info = ext_info;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getSpec_id() {
                return spec_id;
            }

            public void setSpec_id(String spec_id) {
                this.spec_id = spec_id;
            }

            public String getSpec_name() {
                return spec_name;
            }

            public void setSpec_name(String spec_name) {
                this.spec_name = spec_name;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getMarkups() {
                return markups;
            }

            public void setMarkups(String markups) {
                this.markups = markups;
            }

            public String getMaxprice() {
                return maxprice;
            }

            public void setMaxprice(String maxprice) {
                this.maxprice = maxprice;
            }

            public String getSid() {
                return sid;
            }

            public void setSid(String sid) {
                this.sid = sid;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class GoodsBean {
            /**
             * goods_id : 554
             * goods_sn : 123456
             * goods_name : 运动鞋
             * goods_number : 199
             * description : <p>
             小孩运动鞋
             </p>
             <p align="center">
             <img src="/application/lee/uploads/image/20180912/20180912074123_25526.jpg" alt="" />
             </p>
             * cate_id : 146
             * brand :
             * spec_qty : 1
             * spec_name_1 : 颜色
             * spec_name_2 :
             * goods_weight : 1.000
             * status : 1
             * add_time : 1536738122
             * goods_type : 0
             * last_update : 1536738122
             * default_spec : 750
             * default_image : http://shop.dktoo.com/application/lee/uploads/lee/20180912/06a440634b57677a12e24c2ac693078f.jpg
             * is_best : 0
             * is_new : 0
             * is_hot : 0
             * is_promote : 0
             * market_price : 239.99
             * price : 199.99
             * cost_price : 0.00
             * promote_price : 0.00
             * promote_start_date : 0
             * promote_end_date : 0
             * click_count : 0
             * is_shipping : 0
             * sort : 50
             * give_integral : -1
             * rank_integral : -1
             * integral : 80
             * is_check : 1
             * seo_keys :
             * seo_desc :
             * from : 0
             * sid : 10
             * is_del : 0
             * _specs_all : [{"spec_id":"750","goods_id":"554","spec_1":"红色","spec_2":"","color_rgb":"","price":"199.99","stock":"96","sku":"123456"},{"spec_id":"749","goods_id":"554","spec_1":"白色","spec_2":"","color_rgb":"","price":"199.99","stock":"100","sku":"123456"}]
             * _images : [{"id":"1760","gid":"554","url":"application/lee/uploads/lee/20180912/06a440634b57677a12e24c2ac693078f.jpg","thumb":"http://shop.dktoo.com/application/lee/uploads/lee/20180912/06a440634b57677a12e24c2ac693078f.jpg","sort":"1","fid":"959"}]
             * _statistics : {"goods_id":"554","views":"19","collects":"0","carts":"1","orders":"3","sales":"0","comments":"0"}
             * cate_name : 童装
             * attr : null
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
            private StatisticsBean _statistics;
            private String cate_name;
            private Object attr;
            private List<SpecsAllBean> _specs_all;
            private List<ImagesBean> _images;

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

            public StatisticsBean get_statistics() {
                return _statistics;
            }

            public void set_statistics(StatisticsBean _statistics) {
                this._statistics = _statistics;
            }

            public String getCate_name() {
                return cate_name;
            }

            public void setCate_name(String cate_name) {
                this.cate_name = cate_name;
            }

            public Object getAttr() {
                return attr;
            }

            public void setAttr(Object attr) {
                this.attr = attr;
            }

            public List<SpecsAllBean> get_specs_all() {
                return _specs_all;
            }

            public void set_specs_all(List<SpecsAllBean> _specs_all) {
                this._specs_all = _specs_all;
            }

            public List<ImagesBean> get_images() {
                return _images;
            }

            public void set_images(List<ImagesBean> _images) {
                this._images = _images;
            }

            public static class StatisticsBean {
                /**
                 * goods_id : 554
                 * views : 19
                 * collects : 0
                 * carts : 1
                 * orders : 3
                 * sales : 0
                 * comments : 0
                 */

                private String goods_id;
                private String views;
                private String collects;
                private String carts;
                private String orders;
                private String sales;
                private String comments;

                public String getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(String goods_id) {
                    this.goods_id = goods_id;
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
            }

            public static class SpecsAllBean {
                /**
                 * spec_id : 750
                 * goods_id : 554
                 * spec_1 : 红色
                 * spec_2 :
                 * color_rgb :
                 * price : 199.99
                 * stock : 96
                 * sku : 123456
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

            public static class ImagesBean {
                /**
                 * id : 1760
                 * gid : 554
                 * url : application/lee/uploads/lee/20180912/06a440634b57677a12e24c2ac693078f.jpg
                 * thumb : http://shop.dktoo.com/application/lee/uploads/lee/20180912/06a440634b57677a12e24c2ac693078f.jpg
                 * sort : 1
                 * fid : 959
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
        }

        public static class BuylogBean {
            /**
             * user_id : 3
             * member_name : 157****6882
             * goods_numbers : 1
             * goods_price : 1.90
             * add_time : 1536905567
             * total : 1.9
             */

            private String user_id;
            private String member_name;
            private String goods_numbers;
            private String goods_price;
            private String add_time;
            private double total;

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getMember_name() {
                return member_name;
            }

            public void setMember_name(String member_name) {
                this.member_name = member_name;
            }

            public String getGoods_numbers() {
                return goods_numbers;
            }

            public void setGoods_numbers(String goods_numbers) {
                this.goods_numbers = goods_numbers;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public double getTotal() {
                return total;
            }

            public void setTotal(double total) {
                this.total = total;
            }
        }
    }
}
