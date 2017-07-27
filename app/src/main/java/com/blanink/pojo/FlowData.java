package com.blanink.pojo;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/24.
 *
 */

public class FlowData implements Serializable {
    public  Map<String, String> transitions;
    public Map<String, String> names;
    public Map<String,FlowPosition> positions;

    @Override
    public String toString() {
        return "FlowData{" +
                "transitions=" + transitions +
                ", names=" + names +
                ", positions=" + positions +
                '}';
    }

    public Map<String, String> getTransitions() {
        return transitions;
    }

    public void setTransitions(Map<String, String> transitions) {
        this.transitions = transitions;
    }

    public Map<String, String> getNames() {
        return names;
    }

    public void setNames(Map<String, String> names) {
        this.names = names;
    }

    public Map<String, FlowPosition> getPositions() {
        return positions;
    }

    public void setPositions(Map<String, FlowPosition> positions) {
        this.positions = positions;
    }

    public static class FlowPosition implements Serializable {
        public Double top;
        public Double left;

        @Override
        public String toString() {
            return "FlowPosition{" +
                    "top=" + top +
                    ", left=" + left +
                    '}';
        }

        public Double getTop() {
            return top;
        }

        public void setTop(Double top) {
            this.top = top;
        }

        public Double getLeft() {
            return left;
        }

        public void setLeft(Double left) {
            this.left = left;
        }
    }}


