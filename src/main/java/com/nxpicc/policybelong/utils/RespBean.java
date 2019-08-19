package com.nxpicc.policybelong.utils;

import lombok.Data;
import java.io.Serializable;

@Data
public class RespBean<T> implements Serializable {
    private String code;
    private String msg;
    private  T  data;

    public RespBean(){}
    public RespBean(String code,String msg,T data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }
    public RespBean(T data){
        this.data=data;
    };
    public RespBean(String code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public RespBean(RespEnums respEnums,T data){
        this.code=respEnums.getCode();
        this.msg=respEnums.getMsg();
        this.data=data;
    }
    public RespBean(RespEnums respEnums){
        this.code=respEnums.getCode();
        this.msg=respEnums.getMsg();
    }
}
