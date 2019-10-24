package com.lll.gitlearning.base;

/**
 * 
 *
 * @author runningDigua
 * @date 2019/10/21
 */
public class BaseResponse<T> {

    private int code;

    private String message;

    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
