package com.jzg.erp.adapter.comm;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter基类
 * Created by Administrator on 2015/1/26.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mData = new ArrayList<>();
    protected final int mItemLayoutId;
    protected Resources mResources;

    public CommonAdapter(Context context, List<T> data, int itemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mItemLayoutId = itemLayoutId;
        this.mResources = mContext.getResources();
        if (data != null) {
            mData.addAll(data);
        }
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = getViewHolder(position, convertView, parent);
        convert(viewHolder, getItem(position), position);
        return viewHolder.getConvertView();

    }

    public abstract void convert(ViewHolder helper, T item, int position);

    private ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return ViewHolder.get(mContext, convertView, parent, mItemLayoutId, position);
    }


    public void clear() {
        if (mData != null) {
            mData.clear();
            notifyDataSetChanged();
        }
    }

    public void addDataToFirst(T data) {
        if (data != null) {
            mData.add(0, data);
            notifyDataSetChanged();
        }
    }

    public void addData(T data) {
        if (data == null) {
            return;
        }

        mData.add(data);
        notifyDataSetChanged();
    }

    public void remove(T data) {
        if (data == null) {
            return;
        }

        mData.remove(data);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        if (position >= 0 && position < getCount()) {
            mData.remove(position);
            notifyDataSetChanged();
        }
    }


    public void setDatas(List<T> data) {
        if (data == null || data.size() == 0) {
            return;
        }
        mData.addAll(data);
        notifyDataSetChanged();
    }


    public List<T> getData() {
        return mData;
    }

}
