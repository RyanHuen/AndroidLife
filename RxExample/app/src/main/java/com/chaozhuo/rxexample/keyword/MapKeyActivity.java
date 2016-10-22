package com.chaozhuo.rxexample.keyword;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chaozhuo.rxexample.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class MapKeyActivity extends AppCompatActivity {


    @Bind(R.id.linearLayout)
    LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_key);
        ButterKnife.bind(this);
        Observable<Integer> observable = Observable.just(
                R.drawable.computer, R.drawable.earth, R.drawable.phone_shade);
        Subscriber<Drawable> subscriber = new Subscriber<Drawable>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Drawable drawable) {
                ImageView imageView = new ImageButton(MapKeyActivity.this);
                imageView.setImageDrawable(drawable);
                // 设置当前图像的图像（position为当前图像列表的位置）
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new Gallery.LayoutParams(163, 106));
                // 设置Gallery组件的背景风格
                mLinearLayout.addView(imageView);
            }
        };
        observable.map(new Func1<Integer, Drawable>() {
            @Override
            public Drawable call(Integer integer) {
                return MapKeyActivity.this.getResources().getDrawable(integer);
            }
        }).subscribe(subscriber);

    }
}
