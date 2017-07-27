package com.blanink.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/26.
 * 产品属性
 */

public class OrderProductSpecifications implements Serializable {
    private Attributes attribute;		// 产品属性编号
    private String attributeValue;		// 产品属性值
    public String attributeSearchType;//文本框type

    public String getAttributeSearchType() {
        return attributeSearchType;
    }

    public void setAttributeSearchType(String attributeSearchType) {
        this.attributeSearchType = attributeSearchType;
    }

    @Override
    public String toString() {
        return "OrderProductSpecifications{" +
                "attribute=" + attribute +
                ", attributeValue='" + attributeValue + '\'' +
                ", attributeSearchType='" + attributeSearchType + '\'' +
                '}';
    }

    public Attributes getAttribute() {
        return attribute;
    }

    public void setAttribute(Attributes attribute) {
        this.attribute = attribute;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
