
package com.ryanhuen.rxjava2demo.usebus.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chaozhuo.rxjava2demo.R;
import com.ryanhuen.rxbus.RxBus;
import com.ryanhuen.rxjava2demo.usebus.event.TestEvent;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class HandleFragment extends Fragment {


    private android.widget.TextView mObjectReceive;

    public static HandleFragment newInstance() {

        Bundle args = new Bundle();

        HandleFragment fragment = new HandleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSubscribe();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_handle, container, false);
        initView(view);
        return view;
    }


    private void initSubscribe() {
        RxBus.INSTANCE.tObservable(TestEvent.class)
                .subscribeWith(new Observer<TestEvent>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onNext(TestEvent testEvent) {

                        mObjectReceive.setText(mObjectReceive.getText() + "  " + testEvent.number);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        mObjectReceive = (TextView) view.findViewById(R.id.object_receive);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mDisposable.clear();
    }
}
