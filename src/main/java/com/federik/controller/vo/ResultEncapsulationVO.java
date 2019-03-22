package com.federik.controller.vo;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class ResultEncapsulationVO <T>{

    private Long resultCode;

    private List<T> data;

    private String strDescribe;

    public Long getResultCode() {
        return resultCode;
    }

    public void setResultCode(Long resultCode) {
        this.resultCode = resultCode;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getStrDescribe() {
        return strDescribe;
    }

    public void setStrDescribe(String strDescribe) {
        this.strDescribe = strDescribe;
    }

    public String toString(){
        return JSON.toJSONString(this);
    }
}
