package com.jzg.erp.http;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author: voiceofnet
 * email: pengkun@jingzhengu.com
 * phone:18101032717
 * @time: 2016/5/23 17:10
 * @desc:
 */
public abstract class ListResponseHandler<T> implements HttpWrapper.OnResponseHandler {
    public Class<T> clazz;
    public ListResponseHandler(Class<T> clazz){
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
                List<T> list = JSON.parseArray(data, clazz);
                onSucess(list);
            }
        }else{
            String msg = jsonObject.getString(HttpWrapper.OnResponseHandler.MSG);
            onFailed(msg);
        }
    }

    public  abstract void onSucess(List<T> result);
}
