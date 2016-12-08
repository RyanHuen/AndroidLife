
package com.ryanhuen.rxbusdownload;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ryanhuen.rxbusdownload.event.ProgressUpdateEvent;
import com.ryanhuen.rxbusdownload.rx.RxBus;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class AppDialogActivity extends Activity {

    @Bind(R.id.image_in_layout_item)
    ImageView mImageInLayoutItem;
    @Bind(R.id.title_in_layout_item)
    TextView mTitleInLayoutItem;
    @Bind(R.id.progress_in_layout_item)
    ProgressBar mProgressInLayoutItem;
    @Bind(R.id.activity_app_dialog)
    RelativeLayout mActivityAppDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_dialog);
        ButterKnife.bind(this);
        subscribeProgressUpdate();
    }

    private Subscription mSubscription;

    private void subscribeProgressUpdate() {
        mSubscription = RxBus.getInstance()
                .toObservable(ProgressUpdateEvent.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ProgressUpdateEvent>() {
                    @Override
                    public void call(ProgressUpdateEvent progressUpdateEvent) {
                        mProgressInLayoutItem.setProgress(progressUpdateEvent.getProgress());
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
