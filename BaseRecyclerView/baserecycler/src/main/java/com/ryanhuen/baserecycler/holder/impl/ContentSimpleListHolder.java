
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
public class ContentSimpleListHolder extends BaseViewHolder {

    @Bind(R.id.icon)
    ImageView mIcon;
    @Bind(R.id.file_name_container)
    LinearLayout mFileNameContainer;
    @Bind(R.id.file_item_layout)
    LinearLayout mFileItemLayout;
    @Bind(R.id.name_text)
    TextView mNameText;

    public ContentSimpleListHolder(View view) {
        super(view);
    }

    @Override
    public void initView(Context context, File fso) {
        if (fso.isDirectory()) {
            mIcon.setImageResource(R.drawable.folder_large);
        } else {
            mIcon.setImageResource(R.drawable.file);
        }
        mNameText.setText(fso.getName());
    }
}
