package com.cqupt.handler;

import com.cqupt.utils.ResultVo;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import java.security.SignatureException;

@ControllerAdvice
public class GlobalExceptionHandler {
    //定义异常处理的方法 统一返回异常

    //SignatureException token非法的异常
    @ExceptionHandler(SignatureException.class)
    @ResponseBody //json格式转换为java对象
    public ResultVo SignatureExceptionHandler(SignatureException e){
        return ResultVo.fail("token非法异常","token_error");
    }

    //MalformedJwtException token解析异常
    @ExceptionHandler(MalformedJwtException.class)
    @ResponseBody
    public ResultVo MalformedJwtExceptionHandler(MalformedJwtException e){
        return ResultVo.fail("token解析异常","token_error");
    }

    //ExpiredJwtException token过期异常
    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseBody
    public ResultVo ExpiredJwtExceptionHandler(ExpiredJwtException e){
        return ResultVo.fail("token过期异常","token_error");
    }

    //统一处理其他异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVo ExceptionHandler(Exception e){
        if(e.getMessage().contains("token")){
            return ResultVo.fail(e.getMessage(),"token_error");
        }
        return ResultVo.fail(e.getMessage());
    }

}
