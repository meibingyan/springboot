package com.mby.result;




public class BizResult<T> {

    private int code;

    private T data;

    private String msg;

    public BizResult() {
    }

    public BizResult(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> BizResult success(T t){
        return new BizResult(1,t,"SUCCESS");
    }

    public static <T> BizResult fail(){
        return new BizResult(0,null,"FAIL");
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
