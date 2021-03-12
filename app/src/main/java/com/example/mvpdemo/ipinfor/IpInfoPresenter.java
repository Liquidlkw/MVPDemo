package com.example.mvpdemo.ipinfor;

import com.example.mvpdemo.model.IpInfo;
import com.example.mvpdemo.LoadTasksCallBack;
import com.example.mvpdemo.model.NetTask;

public class IpInfoPresenter implements IpInfoContract.Presenter,
        LoadTasksCallBack<IpInfo> {

    private NetTask netTask;
    private IpInfoContract.View addTaskView;

    //传入view和 model
    public IpInfoPresenter(IpInfoContract.View addTaskView, NetTask netTask) {
        this.netTask = netTask;
        this.addTaskView = addTaskView;
    }


    //此处将参数传入model 网络获取数据
    @Override
    public void getIpInfo(String ip) {
        netTask.execute(ip, this);
    }

    //以下设置View
    @Override
    public void onSuccess(IpInfo ipInfo) {
        if (addTaskView.isActive()) {
            addTaskView.setIpInfo(ipInfo);
        }
    }

    @Override
    public void onStart() {
        if (addTaskView.isActive()) {
            addTaskView.showLoading();
        }
    }

    @Override
    public void onFailed() {
        if (addTaskView.isActive()) {
            addTaskView.showError();
            addTaskView.hideLoading();
        }
    }

    @Override
    public void onFinish() {
        if (addTaskView.isActive()) {
            addTaskView.hideLoading();
        }
    }
}
