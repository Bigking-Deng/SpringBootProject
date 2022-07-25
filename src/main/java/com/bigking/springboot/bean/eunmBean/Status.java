package com.bigking.springboot.bean.eunmBean;

public enum Status {
    PREPARE(-1),
    ON_SALE(0),
    SOLD(1);

    private int status_code;

    Status(int code){
        this.status_code = code;
    }

    public int getStatus_code(){
        return this.status_code;
    }
}
