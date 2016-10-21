
package com.ryanhuen.baserecycler;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ryanhuen.baserecycler.adapter.PhoneAdapter;
import com.ryanhuen.baserecycler.layoutmanager.PLayoutManager;
import com.ryanhuen.baserecycler.utils.Utils;
import com.ryanhuen.permission_m.PermissionConfig;
import com.ryanhuen.permission_m.RequestPermission;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView mContentRecycler;
    LinearLayout mActivityMain;
    Button mSwitchLayout;
    private PLayoutManager mLayoutManager;
    private PhoneAdapter mContentAdpater;
    private static final int mContentGridItemWidth = MyApplication.getContext()
            .getResources().getDimensionPixelOffset(R.dimen.content_grid_item_min_width);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPermission();
        bindView();
        initLayoutManager();
    }

    private void bindView() {
        mContentRecycler = (RecyclerView) findViewById(R.id.content_recycler);
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
        mSwitchLayout = (Button) findViewById(R.id.switchLayout);
        mSwitchLayout.setOnClickListener(this);
    }

    private void initLayoutManager() {
        // TODO:根据屏幕宽度来计算多少列
        mLayoutManager = new PLayoutManager(this, 1, GridLayoutManager.VERTICAL,
                false, Config.ViewTypeDoubleLineList);
        mContentRecycler.setLayoutManager(mLayoutManager);
        mContentAdpater = new PhoneAdapter(this, initDatas());
        mContentAdpater.setRecyclerView(mContentRecycler);
        mContentRecycler.setAdapter(mContentAdpater);
        mContentAdpater.setLayoutManager(mLayoutManager);
        mContentRecycler.setAdapter(mContentAdpater);
        switchLayoutManager(new File(Config.DIR_EXTERNAL_STORAGE), Config.ViewTypeDoubleLineList);
    }

    private List<File> initDatas() {
        // TODO：列出SD卡根目录
        File file = new File(Config.DIR_EXTERNAL_STORAGE);
        return new ArrayList<>(Arrays.asList(file.listFiles()));
    }

    private void switchLayoutManager(File fso, int type) {
        if (fso != null) {
            switch (type) {
                case Config.ViewTypeSimpleList:
                    mLayoutManager.setViewType(Config.ViewTypeSimpleList);
                    mLayoutManager.setSpanCount(1);
                    break;
                case Config.ViewTypeDoubleLineList:
                    mLayoutManager.setViewType(Config.ViewTypeDoubleLineList);
                    mLayoutManager.setSpanCount(1);
                    break;
                case Config.ViewTypeGrid:
                    mLayoutManager.setViewType(Config.ViewTypeGrid);
                    mLayoutManager.setSpanCount(Utils.getScreenSize(this).x /
                            mContentGridItemWidth);
                    break;
            }
            mContentAdpater.customNotify();
        }
    }

    @Override
    public void onClick(View v) {
        if (mLayoutManager.getViewType() == Config.ViewTypeDoubleLineList) {
            switchLayoutManager(new File(Config.DIR_EXTERNAL_STORAGE), Config.ViewTypeGrid);
        } else if (mLayoutManager.getViewType() == Config.ViewTypeGrid) {
            switchLayoutManager(new File(Config.DIR_EXTERNAL_STORAGE), Config.ViewTypeSimpleList);
        } else {
            switchLayoutManager(new File(Config.DIR_EXTERNAL_STORAGE), Config.ViewTypeDoubleLineList);
        }
    }

    private void initPermission() {
        String[] permissionList = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_PHONE_STATE
        };
        PermissionConfig.addToPermissionList(permissionList);
        RequestPermission.verifyPermissions(this);
    }
}
