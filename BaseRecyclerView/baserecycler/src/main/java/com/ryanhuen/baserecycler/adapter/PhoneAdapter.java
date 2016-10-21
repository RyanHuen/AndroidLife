
package com.ryanhuen.baserecycler.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ryanhuen.baserecycler.BuildConfig;
import com.ryanhuen.baserecycler.R;
import com.ryanhuen.baserecycler.holder.base.BaseViewHolder;
import com.ryanhuen.baserecycler.holder.impl.ContentLoadingHolder;
import com.ryanhuen.baserecycler.holder.impl.EmptyViewHolder;
import com.ryanhuen.baserecycler.interfaces.LayoutTypeListener;
import com.ryanhuen.baserecycler.layoutmanager.PLayoutManager;

import java.io.File;
import java.util.List;

/**
 * Created by xianeng on 16-7-4.
 */
public class PhoneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected Context mContext;
    private String TAG = "PhoneAdapter";
    public static final int mEmptyType = -1;
    public static final int mLoadingType = -2;
    private static final int mEmptyTypeCount = 1;

    private RecyclerView mRecyclerView;
    private PLayoutManager mLayoutManager;

    public List<File> mDatas;

    public PhoneAdapter(Context context, List<File> datas) {
        this.mContext = context;
        mDatas = datas;

    }

    public void customNotify() {
        notifyDataSetChanged();
    }

    public void setLayoutManager(PLayoutManager manager) {
        mLayoutManager = manager;
        mRecyclerView.setLayoutManager(manager);
        customNotify();
    }

    public LayoutTypeListener getLayoutTypeListener() {
        return mLayoutManager;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
    }

    @Override
    public int getItemCount() {
        if (isEmptyData()) {
            return mEmptyTypeCount;
        }
        return mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (getItemCount() == mEmptyTypeCount && isEmptyData()) {
            if (mDatas.isEmpty()) {
                return mLoadingType;
            } else {
                return mEmptyType;
            }
        }
        return mLayoutManager.getViewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case mEmptyType:
                return new EmptyViewHolder(
                        LayoutInflater.from(mContext).inflate(R.layout.content_empty_view,
                                parent,
                                false));
            case mLoadingType:
                return new ContentLoadingHolder(LayoutInflater.from(mContext)
                        .inflate(R.layout.content_loading_view, parent, false));
            default:
                return mLayoutManager.getViewHolder(parent);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = ((GridLayoutManager) manager);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    if (type == mEmptyType || type == mLoadingType) {
                        return gridLayoutManager.getSpanCount();
                    } else {
                        return 1;
                    }
                }
            });
        }
    }

    private boolean isEmptyData() {
        return mDatas == null || mDatas.size() == 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onBindViewHolder" + position);
        }
        if (holder instanceof BaseViewHolder) {
            ((BaseViewHolder) holder).initView(mContext,
                    mDatas.get(position));
        }

    }

}
