package com.example.mvpdemo.ipinfor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.IpInfoTask;

public class MainActivity extends AppCompatActivity {

    private IpInfoFragment ipInfoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ipInfoFragment==null) {
            ipInfoFragment = IpInfoFragment.newInstance();
        }
        FragmentManager manager= getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container,ipInfoFragment);
        transaction.commit();

        IpInfoTask ipInfoTask = IpInfoTask.getInstance();
        IpInfoPresenter ipInfoPresenter = new IpInfoPresenter(ipInfoFragment,ipInfoTask);
        ipInfoFragment.setPresenter(ipInfoPresenter);

    }
}