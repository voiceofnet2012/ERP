package com.jzg.erp.http;

import android.text.TextUtils;

/**
 * @author: voiceofnet
 * email: pengkun@jingzhengu.com
 * phone:18101032717
 * @time: 2016/5/23 17:10
 * @desc:
 */
public abstract class StringResponseHandler implements HttpWrapper.OnResponseHandler {
    public Class clazz;
    public StringResponseHandler(Class clazz){
        this.clazz = clazz;
    }

    @Override
    public void process(String json) {
        if(TextUtils.isEmpty(json)){
            onEmpty();
        }else{
            onSucess(json);
        }
    }

    public  abstract void onSucess(String result);
}
