
package com.ryanhuen.baserecycler.holder.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.File;

import butterknife.ButterKnife;

/**
 * Created by xianeng on 16-7-4.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void initView(final Context context, final File fso) {

    }

}
