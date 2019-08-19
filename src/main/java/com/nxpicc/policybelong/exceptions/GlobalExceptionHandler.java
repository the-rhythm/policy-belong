package com.nxpicc.policybelong.exceptions;
import com.nxpicc.policybelong.utils.RespBean;
import com.nxpicc.policybelong.utils.RespEnums;
import com.nxpicc.policybelong.utils.RespUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.BindingException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.SQLException;

@Slf4j
@RestControllerAdvice(annotations = {RestController.class,Controller.class})
public class GlobalExceptionHandler {

    /**
     * 请求参数类型错误异常的捕获
     * @param e
     * @return
     */
    @ExceptionHandler(value={BindException.class, ConstraintViolationException.class, MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public RespBean badRequest(BindException e){
        log.error("发生参数异常:",e.toString());
        return RespUtils.error(RespEnums.BAD_REQUEST);
    }

    /**
     * 404错误异常的捕获
     * @param e
     * @return
     */
    @ExceptionHandler(value={NoHandlerFoundException.class})
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    @ResponseBody
    public RespBean badRequestNotFound(BindException e){
        log.error("404错误",e.toString());
        return new RespBean(RespEnums.NOT_FOUND);
    }

    /**
     * mybatis未绑定异常
     * @param e
     * @return
     */
    @ExceptionHandler(BindingException.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RespBean mybatis(Exception e){
        log.error("mybatis错误",e.getMessage());
        return new RespBean(RespEnums.BOUND_STATEMENT_NOT_FOUNT);
    }

    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public RespBean runtimeExceptionHandler(RuntimeException e) {
        log.error("运行时异常",e.toString());
        return new RespBean(RespEnums.INTERNAL_SERVER_ERROR);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public RespBean nullPointerExceptionHandler(NullPointerException e) {
        log.error("空指针异常",e);
        return new RespBean(RespEnums.INTERNAL_SERVER_ERROR);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public RespBean iOExceptionHandler(IOException ex) {
        log.error("IO异常",ex);
        return new RespBean(RespEnums.INTERNAL_SERVER_ERROR);
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public RespBean classCastExceptionHandler(ClassCastException ex) {
        log.error("类型转换异常",ex);
        return new RespBean(RespEnums.INTERNAL_SERVER_ERROR);
    }
    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public RespBean indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        log.error("数组越界异常",ex);
        return new RespBean(RespEnums.INTERNAL_SERVER_ERROR);
    }
    //栈溢出异常
    @ExceptionHandler({StackOverflowError.class})
    @ResponseBody
    public RespBean requestStackOverflow(StackOverflowError ex) {
        log.error("栈溢出异常",ex);
        return new RespBean(RespEnums.INTERNAL_SERVER_ERROR);
    }
    /**
     * 自定义异常的捕获
     * 自定义抛出异常。统一的在这里捕获返回JSON格式的友好提示。
     * @return
     */
    @ExceptionHandler(value={CustomException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public RespBean sendError(CustomException e){
        log.error("自定义异常",e.getMsg());
        return RespUtils.error(e.getCode(),e.getMsg());
    }

    /**
     * 数据库操作出现异常
     * @param e
     * @return
     */
    @ExceptionHandler(value={SQLException.class,DataAccessException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public RespBean systemError(Exception e){
        log.error("数据库操作异常 {}",e.getMessage());
        return new RespBean(RespEnums.DATABASE_ERROR);
    }

    /**
     * 网络连接失败！
     * @param e
     * @return
     */
    @ExceptionHandler(value={ConnectException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public RespBean connect(Exception e){
        log.error("网络异常",e.getMessage());
        return new RespBean(RespEnums.CONNECTION_ERROR);
    }

    /**
     * 请求方法不支持！
     * @param e
     * @return
     */
    @ExceptionHandler(value =HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED)
    public RespBean notAllowed(Exception e){
        log.error("请求方法不支持",e.getMessage());
        return new RespBean(RespEnums.METHOD_NOT_ALLOWED);
    }

    /**
     * 处理其他未知异常！ 如果以上异常都未捕获时会触发
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public RespBean unknown(Exception e){
        log.error("发生未知异常",e);
        return  new RespBean(RespEnums.INTERNAL_SERVER_ERROR);
    }
}

