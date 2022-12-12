package com.etiya.ecommerscedemopair5.core.util.results;

public class SuccessResult extends Result{
    public SuccessResult(){
        super(true);
    }
    public SuccessResult(String message){
        super(true,message);
    }
}
