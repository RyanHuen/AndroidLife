
package com.ryanhuen.baserecycler.holder.impl;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by xianeng on 16-8-8.
 */
public class EmptyViewHolder extends RecyclerView.ViewHolder {
    public EmptyViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
