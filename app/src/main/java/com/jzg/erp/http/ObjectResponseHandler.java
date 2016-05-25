package com.jzg.erp.http;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: voiceofnet
 * email: pengkun@jingzhengu.com
 * phone:18101032717
 * @time: 2016/5/23 17:10
 * @desc:
 */
public abstract class ObjectResponseHandler<T> implements HttpWrapper.OnResponseHandler {
    public Class<T> clazz;
    public ObjectResponseHandler(Class<T> clazz){
        this.clazz = clazz;
    }

    @Override
    public void process(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        int status = jsonObject.getIntValue(HttpWrapper.OnResponseHandler.STATUS);
        if(status== HttpWrapper.OnResponseHandler.OK){
            String data = jsonObject.getString(HttpWrapper.OnResponseHandler.DATA);
            if(TextUtils.isEmpty(data)){
                onEmpty();
            }else{
                T t = JSON.parseObject(data, clazz);
                onSucess(t);
            }
        }else{
            String msg = jsonObject.getString(HttpWrapper.OnResponseHandler.MSG);
            onFailed(msg);
        }
    }

    public  abstract void onSucess(T result);
}
