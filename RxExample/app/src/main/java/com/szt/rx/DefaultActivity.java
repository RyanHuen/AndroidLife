package com.szt.rx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.chaozhuo.rxexample.R;
import com.szt.rx.base.BaseUseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DefaultActivity extends AppCompatActivity {

    @Bind(R.id.base_use)
    Button mBaseUse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.base_use)
    public void onClick() {
        this.startActivity(new Intent(this, BaseUseActivity.class));
    }
}
