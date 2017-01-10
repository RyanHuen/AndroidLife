
package com.ryanhuen.rxjava2demo.usebus;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.chaozhuo.rxjava2demo.R;
import com.ryanhuen.rxjava2demo.usebus.fragment.HandleFragment;
import com.ryanhuen.rxjava2demo.usebus.fragment.PostFragment;

public class UseBusActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_bus);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.poster, PostFragment.newInstance());
        transaction.add(R.id.handler, HandleFragment.newInstance());
        transaction.commit();
    }
}
