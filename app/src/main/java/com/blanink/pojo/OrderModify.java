package com.blanink.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/3.
 */
public class OrderModify implements Serializable {
    public String id;
    public String aCompany_id;
    public String aOrderNumber;

    public String remarks;

    public String delieverTime;

    public String person_id;

    public String person_name;

    public OrderModify(String id, String aCompany_id, String aOrderNumber, String remarks, String delieverTime, String person_id, String person_name) {
        this.id = id;
        this.aCompany_id = aCompany_id;
        this.aOrderNumber = aOrderNumber;
        this.remarks = remarks;
        this.delieverTime = delieverTime;
        this.person_id = person_id;
        this.person_name = person_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getaCompany_id() {
        return aCompany_id;
    }

    public void setaCompany_id(String aCompany_id) {
        this.aCompany_id = aCompany_id;
    }

    public String getaOrderNumber() {
        return aOrderNumber;
    }

    public void setaOrderNumber(String aOrderNumber) {
        this.aOrderNumber = aOrderNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelieverTime() {
        return delieverTime;
    }

    public void setDelieverTime(String delieverTime) {
        this.delieverTime = delieverTime;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }
}
