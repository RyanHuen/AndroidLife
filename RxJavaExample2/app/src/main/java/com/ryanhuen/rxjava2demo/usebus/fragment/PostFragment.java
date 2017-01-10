
package com.ryanhuen.rxjava2demo.usebus.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaozhuo.rxjava2demo.R;
import com.ryanhuen.rxbus.RxBus;
import com.ryanhuen.rxjava2demo.usebus.event.TestEvent;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends Fragment implements View.OnClickListener {

    private android.widget.Button mPostObject;
    private android.widget.TextView mPostedContainer;

    public static PostFragment newInstance() {

        Bundle args = new Bundle();

        PostFragment fragment = new PostFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mPostObject = (Button) view.findViewById(R.id.post_object);
        mPostObject.setOnClickListener(this);
        mPostedContainer = (TextView) view.findViewById(R.id.posted_container);
    }

    private int mNumIncrease = 0;

    @Override
    public void onClick(View view) {
        RxBus.INSTANCE.postEvent(new TestEvent(mNumIncrease));
        mPostedContainer.setText(mPostedContainer.getText() + "  " + mNumIncrease);
        Toast.makeText(this.getContext(), "事件已发送", Toast.LENGTH_SHORT).show();
        mNumIncrease++;
    }
}
