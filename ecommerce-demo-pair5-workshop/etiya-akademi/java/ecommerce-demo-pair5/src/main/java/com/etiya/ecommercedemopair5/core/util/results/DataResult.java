package com.etiya.ecommercedemopair5.core.util.results;

public class DataResult<T> extends Result{

    private T data;

    public DataResult(T data, boolean success, String message) {
        super(success,message);
        this.data=data;
    }
    public DataResult(T data, boolean success) {
        super(success);
        this.data=data;        //BURAYA THIS.DATA=DATA YAZDIK
    }
    public T getData(){
        return this.data;
    }
}
