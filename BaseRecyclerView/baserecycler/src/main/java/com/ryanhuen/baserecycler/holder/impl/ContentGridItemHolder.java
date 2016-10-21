
package com.ryanhuen.baserecycler.holder.impl;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ryanhuen.baserecycler.R;
import com.ryanhuen.baserecycler.holder.base.BaseViewHolder;

import java.io.File;

import butterknife.Bind;

/**
 * Created by xianeng on 16-7-11.
 */
public class ContentGridItemHolder extends BaseViewHolder {

    private static String TAG = "ContentGridItemHolder";
    @Bind(R.id.icon_img)
    ImageView mIconImg;
    @Bind(R.id.icon_img_root)
    LinearLayout mIconImgRoot;
    @Bind(R.id.name_text)
    TextView mNameText;

    public ContentGridItemHolder(View view) {
        super(view);
    }

    @Override
    public void initView(Context context, File fso) {
        if (fso.isDirectory()) {
            mIconImg.setImageResource(R.drawable.folder_large);
        } else {
            mIconImg.setImageResource(R.drawable.file);
        }
        mNameText.setText(fso.getName());

    }
}
