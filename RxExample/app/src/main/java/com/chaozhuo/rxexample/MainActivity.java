
package com.chaozhuo.rxexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.chaozhuo.rxexample.base.BaseImplActivity;
import com.chaozhuo.rxexample.base.JustFromActivity;
import com.chaozhuo.rxexample.base.UnComDefiActivity;
import com.chaozhuo.rxexample.keyword.flatmap.FlatMapKeyActivity;
import com.chaozhuo.rxexample.keyword.MapKeyActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.base_impl)
    Button mBaseImpl;
    @Bind(R.id.just_from)
    Button mJustFrom;
    @Bind(R.id.unComplete_definition)
    Button mUnCompleteDefinition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({
            R.id.base_impl, R.id.just_from, R.id.unComplete_definition, R.id.map_key
            , R.id.flat_map_key
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.base_impl:
                this.startActivity(new Intent(this, BaseImplActivity.class));

                break;
            case R.id.just_from:
                this.startActivity(new Intent(this, JustFromActivity.class));

                break;
            case R.id.unComplete_definition:
                this.startActivity(new Intent(this, UnComDefiActivity.class));
                break;
            case R.id.map_key:
                this.startActivity(new Intent(this, MapKeyActivity.class));
                break;
            case R.id.flat_map_key:
                this.startActivity(new Intent(this, FlatMapKeyActivity.class));
                break;
        }
    }
}
