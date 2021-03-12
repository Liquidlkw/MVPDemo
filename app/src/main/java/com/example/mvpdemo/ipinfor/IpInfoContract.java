package com.example.mvpdemo.ipinfor;

import com.example.mvpdemo.model.IpInfo;
import com.example.mvpdemo.BaseView;

/**
 * 定义一个契约接口IpInfoContract
 * 契约接口主要用来存放相同业务的Presenter和View的接口
 * 便于查找和维护
 */
public interface IpInfoContract {

    //定义了网络获取数据的接口
    interface Presenter{
        void getIpInfo(String ip);
    }

    //定义了与界面交互的方法
    //BaseView接口的目的就是给View绑定Presenter，接着实现Presenter接口
    interface View extends BaseView<Presenter> {
        //update ui
        void setIpInfo(IpInfo ipInfo);
        void showLoading();
        void hideLoading();
        void showError();
        //用于判断Fragment是否添加到了Activity中
        boolean isActive();
    }
}
