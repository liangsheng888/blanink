package com.blanink.pojo;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/24.
 *
 */

public class FlowData implements Serializable {
    Map<String, String> transitions;
    Map<String, String> names;

    @Override
    public String toString() {
        return "FlowData{" +
                "transitions=" + transitions +
                ", names=" + names +
                '}';
    }


}
