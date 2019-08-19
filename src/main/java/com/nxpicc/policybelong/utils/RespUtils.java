package com.nxpicc.policybelong.utils;

public class RespUtils {

    //    成功有数据
    public static <T> RespBean success(T data) {
        return new RespBean(RespEnums.SUCCESS, data);
    }

    //    成功无数据
    public static <T> RespBean success() {
        return new RespBean(RespEnums.SUCCESS, null);
    }


    //    成功自定义返回msg
    public static <T> RespBean success(String msg, T data) {
        return new RespBean(RespEnums.SUCCESS.getCode(), msg, data);
    }


    //    自定义成功返回
    public static <T> RespBean success(String code, String msg, T data) {
        return new RespBean(code, msg, data);
    }


    //错误无数据,错误已在枚举中进行定义
    public static <T> RespBean error(RespEnums respEnums) {
        return new RespBean(respEnums);
    }

    //错误有数据,错误已在枚举中定义
    public static <T> RespBean error(RespEnums respEnums, T data) {
        return new RespBean(respEnums, data);
    }

    //错误无数据，错误未在枚举中定义
    public static <T> RespBean error(String code,String msg){
        return  new RespBean(code,msg);
    }

    //错误自定义
    public static <T> RespBean error(String code, String msg, T data) {
        return new RespBean<T>(code, msg, data);
    }

}

