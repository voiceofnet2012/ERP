package com.jzg.erp.image;

/**
 * @author: voiceofnet
 * email: pengkun@jingzhengu.com
 * phone:18101032717
 * @time: 2016/5/23 15:52
 * @desc:
 */
public class ImageLoadFactory {
    private static volatile ImageWrapper sInstance;

    private ImageLoadFactory() {}

    /**
     * 获取图片加载器
     *
     * @return
     */
    public static ImageWrapper getLoader() {
        if (sInstance == null) {
            synchronized (ImageLoadFactory.class) {
                if (sInstance == null) {
                    sInstance = new FrescoImpl();
                }
            }
        }
        return sInstance;
    }

}
