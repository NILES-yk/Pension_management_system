package com.cqupt.utils;

import lombok.Data;


@Data
public class ResultVo<T>{
    private boolean flag;
    private String message;
    private T data;

    //成功添加消息
    public static ResultVo success(String message){
        ResultVo resultVo = new ResultVo();
        resultVo.setMessage(message);
        resultVo.setFlag(true);
        return resultVo;
    }

    //成功添加数据
    public static <T> ResultVo success(T data){
        ResultVo resultVo = new ResultVo();
        resultVo.setData(data);
        resultVo.setFlag(true);
        return resultVo;
    }

    //成功添加消息和数据
    public static <T> ResultVo success(T data,String message){
        ResultVo resultVo = new ResultVo();
        resultVo.setMessage(message);
        resultVo.setData(data);
        resultVo.setFlag(true);
        return resultVo;
    }

    //添加消息失败
    public static ResultVo fail(String message){
        ResultVo resultVo = new ResultVo();
        resultVo.setMessage(message);
        resultVo.setFlag(false);
        return resultVo;
    }

    //添加数据失败
    public static <T> ResultVo fail(T data){
        ResultVo resultVo = new ResultVo();
        resultVo.setData(data);
        resultVo.setFlag(false);
        return resultVo;
    }

    //添加消息和数据失败
    public static <T> ResultVo fail(T data,String message){
        ResultVo resultVo = new ResultVo();
        resultVo.setMessage(message);
        resultVo.setData(data);
        resultVo.setFlag(false);
        return resultVo;
    }

    //出现异常
    public static <T> ResultVo error(Exception e){
        ResultVo resultVo = new ResultVo();
        resultVo.setMessage("系统发送了异常"+e.getMessage());
        resultVo.setFlag(false);
        return resultVo;
    }

}
