package com.jzg.erp.http;

import java.util.Map;

/**
 * @author: voiceofnet
 * email: pengkun@jingzhengu.com
 * phone:18101032717
 * @time: 2016/5/23 16:26
 * @desc:
 */
public interface HttpWrapper {
    public static final String BASE_HOST="";

    void get(String url, Map<String,String> params,OnResponseHandler listener);
    void post(String url, Map<String,String> params,OnResponseHandler listener);

    public static interface OnResponseHandler {
        public static final String MSG="msg";
        public static final String STATUS="status";
        public static final String DATA="data";
        public static final int OK=0;
        public abstract void process(String json);
        public abstract void onFailed(String msg);
        public abstract void onEmpty();
    }
}
