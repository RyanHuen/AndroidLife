
package com.ryanhuen.rxjava2demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.chaozhuo.rxjava2demo.R;
import com.ryanhuen.rxjava2demo.base.BaseImplActivity;
import com.ryanhuen.rxjava2demo.base.DisposeInProcessActivity;
import com.ryanhuen.rxjava2demo.base.JustEmitterActivity;
import com.ryanhuen.rxjava2demo.base.LineHandleActivity;
import com.ryanhuen.rxjava2demo.flowable.BaseFlowableActivity;
import com.ryanhuen.rxjava2demo.flowable.UnlimitPostActivity;
import com.ryanhuen.rxjava2demo.operators.ConcatMapOperatorActivity;
import com.ryanhuen.rxjava2demo.operators.FlatMapOperatorActivity;
import com.ryanhuen.rxjava2demo.operators.MapOperatorActivity;
import com.ryanhuen.rxjava2demo.operators.ZipOperatorActivity;
import com.ryanhuen.rxjava2demo.thread_control.ChangeThreadActivity;
import com.ryanhuen.rxjava2demo.thread_control.DefaultThreadActivity;
import com.ryanhuen.rxjava2demo.thread_control.MultiThreadChangeActivity;
import com.ryanhuen.rxjava2demo.usebus.UseBusActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBaseImpl;// 基本实现
    private Button lineHandle;// 链式调用
    private Button disposeInProcess;
    private Button mJustEmitter;
    private Button mDefaultThread;
    private Button mChangeThread;
    private Button mMultiThreadChange;
    private Button mMapOperator;
    private Button mFlatMapOperator;
    private Button mConcatMapOperator;
    private Button mZipOperator;
    private Button mUnlimitPostOperator;
    private Button mBaseFlowable;
    private Button mUseBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBaseImpl = (Button) findViewById(R.id.base_impl);
        mBaseImpl.setOnClickListener(this);
        lineHandle = (Button) findViewById(R.id.line_handle);
        lineHandle.setOnClickListener(this);
        disposeInProcess = (Button) findViewById(R.id.dispose_in_process);
        disposeInProcess.setOnClickListener(this);
        mJustEmitter = (Button) findViewById(R.id.just_emitter);
        mJustEmitter.setOnClickListener(this);
        mDefaultThread = (Button) findViewById(R.id.default_thread);
        mDefaultThread.setOnClickListener(this);
        mChangeThread = (Button) findViewById(R.id.change_thread);
        mChangeThread.setOnClickListener(this);
        mMultiThreadChange = (Button) findViewById(R.id.multi_thread_change);
        mMultiThreadChange.setOnClickListener(this);
        mMapOperator = (Button) findViewById(R.id.map_operator);
        mMapOperator.setOnClickListener(this);
        mFlatMapOperator = (Button) findViewById(R.id.flat_map_operator);
        mFlatMapOperator.setOnClickListener(this);
        mConcatMapOperator = (Button) findViewById(R.id.concat_map_operator);
        mConcatMapOperator.setOnClickListener(this);
        mZipOperator = (Button) findViewById(R.id.zip_operator);
        mZipOperator.setOnClickListener(this);
        mUnlimitPostOperator = (Button) findViewById(R.id.unlimit_post_operator);
        mUnlimitPostOperator.setOnClickListener(this);
        mBaseFlowable = (Button) findViewById(R.id.base_flowable);
        mBaseFlowable.setOnClickListener(this);
        mUseBus = (Button) findViewById(R.id.use_bus);
        mUseBus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            /** 基本实现 */
            case R.id.base_impl:
                startActivity(new Intent(this, BaseImplActivity.class));
                break;
            /** 链式调用的实现 */
            case R.id.line_handle:
                startActivity(new Intent(this, LineHandleActivity.class));
                break;
            /** 中途切断上下游订阅 */
            case R.id.dispose_in_process:
                startActivity(new Intent(this, DisposeInProcessActivity.class));
                break;
            /** 使用just方式发射事件 */
            case R.id.just_emitter:
                startActivity(new Intent(this, JustEmitterActivity.class));
                break;
            /** 不指定线程（默认线程） */
            case R.id.default_thread:
                startActivity(new Intent(this, DefaultThreadActivity.class));
                break;
            /** 切换线程的基本使用 */
            case R.id.change_thread:
                startActivity(new Intent(this, ChangeThreadActivity.class));
                break;
            /** 多次切换线程 */
            case R.id.multi_thread_change:
                startActivity(new Intent(this, MultiThreadChangeActivity.class));
                break;
            /** map操作符 */
            case R.id.map_operator:
                startActivity(new Intent(this, MapOperatorActivity.class));
                break;
            /** flatMap操作符 (事件无序) */
            case R.id.flat_map_operator:
                startActivity(new Intent(this, FlatMapOperatorActivity.class));
                break;
            /** concatMap操作符(事件有序) */
            case R.id.concat_map_operator:
                startActivity(new Intent(this, ConcatMapOperatorActivity.class));
                break;
            /** zip操作符(两个上游事件的合并) */
            case R.id.zip_operator:
                startActivity(new Intent(this, ZipOperatorActivity.class));
                break;
            /** 不适用BackPressure的无限事件发送情况,注意查看内存使用情况 */
            case R.id.unlimit_post_operator:
                startActivity(new Intent(this, UnlimitPostActivity.class));
                break;
            /** Flowable的基本使用 */
            case R.id.base_flowable:
                startActivity(new Intent(this, BaseFlowableActivity.class));
                break;
            /** 使用RxBus */
            case R.id.use_bus:
                startActivity(new Intent(this, UseBusActivity.class));
                break;
        }

    }
}
