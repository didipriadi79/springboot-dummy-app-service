package com.priadi.dummyapp.domain;

public class BaseResponse<T> {
    private String message = "success";
    private int code = 200;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setGeneralError(String message, int code){
        this.message = message;
        this.code = code;
    }
}
