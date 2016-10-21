
package com.ryanhuen.baserecycler.holder.impl;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by xianeng on 16-8-15.
 */
public class ContentLoadingHolder extends RecyclerView.ViewHolder {
    public ContentLoadingHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
