package com.example.mvpdemo.ipinfor;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.IpInfo;


public class IpInfoFragment extends Fragment implements IpInfoContract.View {

    private TextView tv_country;
    private TextView tv_countryCode;
    private TextView tv_region;
    private Dialog mDialog;
    private Button button;
    private IpInfoContract.Presenter mPresenter;

    public static IpInfoFragment newInstance() {
        return new IpInfoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_ip_info, container, false);
        tv_country = root.findViewById(R.id.country);
        tv_countryCode = root.findViewById(R.id.countryCode);
        tv_region = root.findViewById(R.id.region);
        button = root.findViewById(R.id.get);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDialog = new ProgressDialog(getActivity());
        mDialog.setTitle("获取数据中");
        button.setOnClickListener(v -> {
            //传入参数进行网络获取数据
            mPresenter.getIpInfo(null);
        });

    }


    @Override
    public void setPresenter(IpInfoContract.Presenter presenter) {
        mPresenter = presenter;
    }

    //update ui
    @Override
    public void setIpInfo(IpInfo ipInfo) {
        if (ipInfo != null) {
            tv_country.setText(ipInfo.getCountry());
            tv_countryCode.setText(ipInfo.getCountryCode());
            tv_region.setText(ipInfo.getRegion());

        }
    }

    @Override
    public void showLoading() {
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }

    }

    @Override
    public void showError() {
        Toast.makeText(getActivity(), "网络出错", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}