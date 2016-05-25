package com.jzg.erp.image;

import android.widget.ImageView;

/**
 * @author: voiceofnet
 * email: pengkun@jingzhengu.com
 * phone:18101032717
 * @time: 2016/5/23 11:13
 * @desc:
 */
public interface ImageWrapper {
    /***
     * 加载网络图片
     * @param imageView
     * @param url 图片url
     * @param option
     */
    void loadImageFromUrl(ImageView imageView,String url,DisplayOption option);

    void loadImageFromUrl(ImageView imageView,String url);


    public static class DisplayOption{
        public int loadingResId;
        public int loadFailedResId;
    }
}
