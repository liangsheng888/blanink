package com.blanink.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/26.
 */

public class Attributes implements Serializable {
    public String id;

    @Override
    public String toString() {
        return "Attributes{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
