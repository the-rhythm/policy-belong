package com.nxpicc.policybelong.exceptions;
import com.nxpicc.policybelong.utils.RespEnums;
import lombok.Data;
import java.io.Serializable;

@Data
public class CustomException extends RuntimeException implements Serializable {
    //自定义异常处理类,用于抛出自定义异常
    private String code;
    private String msg;

    public CustomException(RespEnums enums){
        super();
        this.code=enums.getCode();
        this.msg=enums.getMsg();
    }
    public CustomException(){
        super();
    }
}
