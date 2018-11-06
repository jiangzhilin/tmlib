package com.liuge.z02sckhd_6wqgx.entity;

/**
 * Created by jiang on 2018/10/25.
 */

public class OrderPayEntity {

    /**
     * status : success
     * msg : 获取成功
     * data : alipay_sdk=alipay-sdk-php-20161101&app_id=2017112000056987&biz_content=%7B%22out_trade_no%22%3A%222018102570924%22%2C%22subject%22%3A%22%5Cu8ba2%5Cu5355%5Cu652f%5Cu4ed8%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22total_amount%22%3A0.01%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fshop.dktoo.com%2Fz02sckhd_6wqgx%2FApipay%2Fnotifyurl&sign_type=RSA&timestamp=2018-10-25+16%3A35%3A34&version=1.0&sign=MtgBW8c2U2weTPEijxtqhswTkBdYsD7JyWi%2BJj0%2FKuYftJVm1cAVEk0ZYKQZpXeTKXD3kmIPKHozSKZft16Lo0Aqbok0ECSA0ULNH5qa%2BjJcRPmS3L77EepRrUY5DMmygBACL%2BOIAuJzeHH%2BiaSwmqKUOIJZ7gAKrst7MktjlaM%3D
     */

    private String status;
    private String msg;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
