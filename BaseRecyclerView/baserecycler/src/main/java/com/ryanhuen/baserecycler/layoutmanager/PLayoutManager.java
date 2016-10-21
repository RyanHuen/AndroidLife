
package com.ryanhuen.baserecycler.layoutmanager;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ryanhuen.baserecycler.Config;
import com.ryanhuen.baserecycler.R;
import com.ryanhuen.baserecycler.holder.impl.ContentDoubleListHolder;
import com.ryanhuen.baserecycler.holder.impl.ContentGridItemHolder;
import com.ryanhuen.baserecycler.holder.impl.ContentSimpleListHolder;
import com.ryanhuen.baserecycler.interfaces.LayoutTypeListener;

/**
 * Created by xianeng on 16-7-17.
 */
public class PLayoutManager extends GridLayoutManager implements LayoutTypeListener {
    private int mViewShowType;
    private Context mContext;

    public PLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public PLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public PLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    public PLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout,
            int viewtype) {
        this(context, spanCount, orientation, reverseLayout);
        mContext = context;
        mViewShowType = viewtype;
    }

    @Override
    public int getViewType() {
        return mViewShowType;
    }

    @Override
    public void setViewType(int showType) {
        mViewShowType = showType;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(ViewGroup parent) {
        switch (mViewShowType) {
            case Config.ViewTypeGrid:
                return new ContentGridItemHolder(LayoutInflater.from(mContext)
                        .inflate(R.layout.phone_content_grid_item, parent, false));
            case Config.ViewTypeSimpleList:
                return new ContentSimpleListHolder(LayoutInflater.from(mContext)
                        .inflate(R.layout.content_simple_list_item, parent, false));
            case Config.ViewTypeDoubleLineList:
                return new ContentDoubleListHolder(LayoutInflater.from(mContext)
                        .inflate(R.layout.phone_content_doubleline, parent, false));
            default:
                return null;
        }
    }
}
