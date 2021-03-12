package com.example.mvpdemo;

//BaseView接口的目的就是给View绑定Presenter，接着实现Presenter接口
public interface BaseView<T> {
    void setPresenter(T presenter);
}
