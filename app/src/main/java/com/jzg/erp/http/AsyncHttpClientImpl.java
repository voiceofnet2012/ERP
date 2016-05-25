package com.jzg.erp.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * @author: voiceofnet
 * email: pengkun@jingzhengu.com
 * phone:18101032717
 * @time: 2016/5/23 16:32
 * @desc:
 */
public class AsyncHttpClientImpl implements HttpWrapper {
    AsyncHttpClient client;
    public AsyncHttpClientImpl() {
        client = new AsyncHttpClient();
    }

    @Override
    public void get(String url, Map<String, String> params, final OnResponseHandler listener) {
        RequestParams p = new RequestParams(params);
        client.get(BASE_HOST + url, p, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String json, Throwable throwable) {
                listener.onFailed(json);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String json) {
                listener.process(json);
            }
        });
    }

    @Override
    public void post(String url, Map<String, String> params, final OnResponseHandler listener) {
        RequestParams p = new RequestParams(params);
        client.get(BASE_HOST + url, p, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String json, Throwable throwable) {
                listener.onFailed(json);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String json) {
                listener.process(json);
            }
        });
    }
}
