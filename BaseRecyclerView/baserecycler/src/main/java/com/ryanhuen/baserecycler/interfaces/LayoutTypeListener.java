
package com.ryanhuen.baserecycler.interfaces;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by xianeng on 16-7-14.
 */
public interface LayoutTypeListener {
    int getViewType();

    void setViewType(int showType);

    RecyclerView.ViewHolder getViewHolder(ViewGroup parent);
}
