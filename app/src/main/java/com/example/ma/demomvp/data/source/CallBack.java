package com.example.ma.demomvp.data.source;

public interface CallBack<T> {
    void getDataSuccess(T data);
    void getDataError(Exception e);
}
