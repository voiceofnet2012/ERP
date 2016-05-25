package com.jzg.erp.adapter.comm;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class ViewHolder {


    private final SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;

    private ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        // setTag
        mConvertView.setTag(this);
    }

    /**
     * 拿到一个ViewHolder对象
     *
     * @param context
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId,
                                 int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder) convertView.getTag();
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param resId
     * @return
     */
    public ViewHolder setText(int viewId, int resId) {
        TextView view = getView(viewId);
        view.setText(resId);
        return this;
    }


    /**
     * 为TextView设置字体颜色
     */
    public ViewHolder setTextColor(int viewId, int colorId) {
        TextView view = getView(viewId);
        view.setTextColor(colorId);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param bm
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }


    /**
     * 为view或者layout设置图片
     *
     * @param viewId
     * @param imgIds
     * @return
     */
    public ViewHolder setViewBackground(int viewId, int imgIds) {
        getView(viewId).setBackgroundResource(imgIds);
        return this;
    }


    /**
     * 为view或者layout设置背景颜色
     *
     * @param viewId
     * @param color
     * @return
     */
    public ViewHolder setViewBackgroundColor(int viewId, int color) {
        getView(viewId).setBackgroundColor(color);
        return this;
    }


    public ViewHolder setSimpleDraweeView(int viewId, Uri uri) {
        SimpleDraweeView imageView = getView(viewId);
        imageView.setImageURI(uri);
        return this;
    }

    public ViewHolder setSimpleDraweeView(int viewId, String uri) {
        if(TextUtils.isEmpty(uri)){
            return this;
        }

        SimpleDraweeView imageView = getView(viewId);
        imageView.setImageURI(Uri.parse(uri));
        return this;
    }

    /**
     * 设置 view 隐藏与显示
     *
     * @param viewId
     * @param visible
     */
    public void setViewVisable(int viewId, int visible) {
        View view = getView(viewId);
        if (view != null) {
            view.setVisibility(visible);
        }
    }

    public int getPosition() {
        return mPosition;
    }
}
