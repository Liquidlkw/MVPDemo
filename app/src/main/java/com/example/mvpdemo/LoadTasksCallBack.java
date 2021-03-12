package com.example.mvpdemo;

public interface LoadTasksCallBack<T> {
    void onSuccess(T t);

    void onStart();

    void onFailed();

    void onFinish();

}
