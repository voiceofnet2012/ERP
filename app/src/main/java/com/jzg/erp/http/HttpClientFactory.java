package com.jzg.erp.http;

/**
 * @author: voiceofnet
 * email: pengkun@jingzhengu.com
 * phone:18101032717
 * @time: 2016/5/23 15:52
 * @desc:
 */
public class HttpClientFactory {
    private static  HttpWrapper sInstance;

    private HttpClientFactory() {}

    public static HttpWrapper getLoader() {
        if (sInstance == null) {
            synchronized (HttpClientFactory.class) {
                if (sInstance == null) {
                    sInstance = new AsyncHttpClientImpl();
                }
            }
        }
        return sInstance;
    }

}
