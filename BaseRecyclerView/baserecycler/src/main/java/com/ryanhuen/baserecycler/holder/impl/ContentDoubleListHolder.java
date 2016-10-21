
package com.ryanhuen.baserecycler.holder.impl;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ryanhuen.baserecycler.R;
import com.ryanhuen.baserecycler.holder.base.BaseViewHolder;

import java.io.File;

import butterknife.Bind;

/**
 * Created by xianeng on 16-7-5.
 */
public class ContentDoubleListHolder extends BaseViewHolder {
    private static String TAG = "ContentDoubleListHolder";
    @Bind(R.id.icon_img)
    ImageView mIconImg;
    @Bind(R.id.name_text)
    TextView mNameText;
    @Bind(R.id.time_text)
    TextView mTimeText;
    @Bind(R.id.size_text)
    TextView mSizeText;

    public ContentDoubleListHolder(View view) {
        super(view);
    }

    @Override
    public void initView(Context context, File fso) {
        if (fso.isDirectory()) {
            mIconImg.setImageResource(R.drawable.folder_large);
        } else {
            mIconImg.setImageResource(R.drawable.file);
            mSizeText.setText(String.valueOf(fso.length()));
        }
        mNameText.setText(fso.getName());
        mTimeText.setText(String.valueOf(fso.lastModified()));
    }

}
