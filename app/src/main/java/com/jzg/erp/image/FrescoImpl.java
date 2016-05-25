package com.jzg.erp.image;

import android.net.Uri;
import android.widget.ImageView;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jzg.erp.utils.UIUtils;

/**
 * @author: voiceofnet
 * email: pengkun@jingzhengu.com
 * phone:18101032717
 * @time: 2016/5/23 14:08
 * @desc:
 */
public class FrescoImpl implements  ImageWrapper{

/*
    XML属性	意义
    fadeDuration	淡入淡出动画持续时间(单位：毫秒ms)
    actualImageScaleType	实际图像的缩放类型
    placeholderImage	占位图
    placeholderImageScaleType	占位图的缩放类型
    progressBarImage	进度图
    progressBarImageScaleType	进度图的缩放类型
    progressBarAutoRotateInterval	进度图自动旋转间隔时间(单位：毫秒ms)
    failureImage	失败图
    failureImageScaleType	失败图的缩放类型
    retryImage	重试图
    retryImageScaleType	重试图的缩放类型
    backgroundImage	背景图
    overlayImage	叠加图
    pressedStateOverlayImage	按压状态下所显示的叠加图
    roundAsCircle	设置为圆形图
    roundedCornerRadius	圆角半径
    roundTopLeft	左上角是否为圆角
    roundTopRight	右上角是否为圆角
    roundBottomLeft	左下角是否为圆角
    roundBottomRight	右下角是否为圆角
    roundingBorderWidth	圆形或者圆角图边框的宽度
    roundingBorderColor	圆形或者圆角图边框的颜色
    roundWithOverlayColor	圆形或者圆角图底下的叠加颜色(只能设置颜色)
    viewAspectRatio	控件纵横比

    远程图片	http://, https://	HttpURLConnection 或者参考 使用其他网络加载方案
    本地文件	file://	FileInputStream
    Content provider	content://	ContentResolver
    asset目录下的资源	asset://	AssetManager
    res目录下的资源	res://	Resources.openRawResource
    res 示例:

    Uri uri = Uri.parse("res://包名(实际可以是任何字符串甚至留空)/" + R.drawable.ic_launcher);*/


    @Override
    public void loadImageFromUrl(ImageView imageView, String url, DisplayOption option) {
        SimpleDraweeView iv = (SimpleDraweeView)imageView;
        if(url.startsWith("/")){
            url = "file://"+url;
        }
        if(option!=null){
            GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(UIUtils.getResources())
                    .setPlaceholderImage(UIUtils.getDrawable(option.loadingResId))
                    .setFailureImage(UIUtils.getDrawable(option.loadFailedResId))
                    .build();
            iv.setHierarchy(hierarchy);
        }

        iv.setImageURI(Uri.parse(url));
    }

    @Override
    public void loadImageFromUrl(ImageView imageView, String url) {
        SimpleDraweeView iv = (SimpleDraweeView)imageView;
        if(url.startsWith("/")){
            url = "file://"+url;
        }
        iv.setImageURI(Uri.parse(url));
    }
}

















