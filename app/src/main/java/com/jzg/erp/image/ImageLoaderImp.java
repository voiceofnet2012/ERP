package com.jzg.erp.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.jzg.erp.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * @author: voiceofnet
 * email: pengkun@jingzhengu.com
 * phone:18101032717
 * @time: 2016/5/23 11:30
 * @desc: UniversalImageLoader 的抽象实现类;
 */
public class ImageLoaderImp implements ImageWrapper{
    private DisplayImageOptions options;

    public ImageLoaderImp(Context context,DisplayOption opt) {
        initImageLoader(context);
        options = initDisplayOptions(opt);
    }

    private void initImageLoader(Context context){
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs();
        ImageLoader.getInstance().init(config.build());
    }

    public DisplayImageOptions initDisplayOptions(DisplayOption option){
        int loadingResId = R.mipmap.ic_launcher;
        int loadFailedResId = R.mipmap.ic_launcher;
        if (option != null) {
            loadingResId = option.loadingResId;
            loadFailedResId = option.loadFailedResId;
        }
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(loadingResId)
                .showImageForEmptyUri(loadFailedResId)
                .showImageOnFail(loadFailedResId)
                .cacheInMemory(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565).build();
        return options;
    }

    /***
     *
     * @param imageView
     * @param url 图片url:<br />
     *            "http://site.com/image.png"  from Web<br />
     *            "/mnt/sdcard/image.png"  from SD card<br />
     *            "assets://image.png"  from assets<br />
     * @param option
     */
    @Override
    public void loadImageFromUrl(ImageView imageView, String url, DisplayOption option) {
        if(url.startsWith("/")){
            url = "file://"+url;
        }
        DisplayImageOptions opt = initDisplayOptions(option);
        ImageLoader.getInstance().displayImage(url,imageView,opt);
    }

    @Override
    public void loadImageFromUrl(ImageView imageView, String url) {
        if(url.startsWith("/")){
            url = "file://"+url;
        }
        ImageLoader.getInstance().displayImage(url,imageView,options);
    }
}
