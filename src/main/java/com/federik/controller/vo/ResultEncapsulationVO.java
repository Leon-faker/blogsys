package com.federik.controller.vo;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class ResultEncapsulationVO <T>{

    private Long resultCode;

    private T data;

    private String strDescribe;

    public Long getResultCode() {
        return resultCode;
    }

    public static <T> ResultEncapsulationVO<T> success(String str){
        return (new ResultEncapsulationVO<>()).setResultCode(SystemEnum.ResultEnum.success.getResultCode()).setStrDescribe(str);
    }

    public static <T> ResultEncapsulationVO<T> fail(String str){
        return (new ResultEncapsulationVO<>()).setResultCode(SystemEnum.ResultEnum.fail.getResultCode()).setStrDescribe(str);
    }

    public ResultEncapsulationVO setResultCode(Long resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultEncapsulationVO setData(T data) {
        this.data = data;
        return this;
    }

    public String getStrDescribe() {
        return strDescribe;
    }

    public ResultEncapsulationVO setStrDescribe(String strDescribe) {
        this.strDescribe = strDescribe;
        return this;
    }

    public String toString(){
        return JSON.toJSONString(this);
    }
}
