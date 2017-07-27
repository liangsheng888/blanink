package com.blanink.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/31.
 */
public class OrderProd implements Serializable {
    public String id;
    public String prod_name;
    public String prod_price;
    public String prod_number;
    public String delivery_time;
    public String innerDelivery_time;
    public String companyBPriority;
    public String productDescription;
    public String prodSn;

    public OrderProd(String id, String prod_name, String prod_price, String prod_number, String delivery_time, String innerDelivery_time, String companyBPriority, String productDescription, String prodSn) {
        this.id = id;
        this.prod_name = prod_name;
        this.prod_price = prod_price;
        this.prod_number = prod_number;
        this.delivery_time = delivery_time;
        this.innerDelivery_time = innerDelivery_time;
        this.companyBPriority = companyBPriority;
        this.productDescription = productDescription;
        this.prodSn = prodSn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_price() {
        return prod_price;
    }

    public void setProd_price(String prod_price) {
        this.prod_price = prod_price;
    }

    public String getProd_number() {
        return prod_number;
    }

    public void setProd_number(String prod_number) {
        this.prod_number = prod_number;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public String getInnerDelivery_time() {
        return innerDelivery_time;
    }

    public void setInnerDelivery_time(String innerDelivery_time) {
        this.innerDelivery_time = innerDelivery_time;
    }

    public String getCompanyBPriority() {
        return companyBPriority;
    }

    public void setCompanyBPriority(String companyBPriority) {
        this.companyBPriority = companyBPriority;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProdSn() {
        return prodSn;
    }

    public void setProdSn(String prodSn) {
        this.prodSn = prodSn;
    }
}
