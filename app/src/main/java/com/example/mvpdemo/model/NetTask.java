package com.example.mvpdemo.model;

import com.example.mvpdemo.LoadTasksCallBack;

//http://ip-api.com/json/
public interface NetTask<T> {
    void execute(T param, LoadTasksCallBack callBack);
}
