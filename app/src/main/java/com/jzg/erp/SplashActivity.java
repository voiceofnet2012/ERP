package com.jzg.erp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jzg.erp.adapter.ZhihuAdapter;
import com.jzg.erp.bean.ZhihuItem;
import com.jzg.erp.http.HttpClientFactory;
import com.jzg.erp.http.StringResponseHandler;
import com.jzg.erp.utils.LogUtil;
import com.jzg.erp.view.ButtonTestActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static final String TAG = "SplashActivity";
    @Bind(R.id.lv)
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        lv.setOnItemClickListener(this);

        HttpClientFactory.getLoader().get("http://news-at.zhihu.com/api/4/themes", null, new StringResponseHandler(String.class) {
            @Override
            public void onSucess(String result) {
                JSONObject jo = JSON.parseObject(result);
                String others = jo.getString("others");
                List<ZhihuItem> items = JSON.parseArray(others, ZhihuItem.class);
                LogUtil.e(TAG, "items.size=" + items.size());
                if (items != null && items.size() > 0) {
                    ZhihuAdapter adapter = new ZhihuAdapter(SplashActivity.this, items, R.layout.item_zhihu);
                    lv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailed(String msg) {

            }

            @Override
            public void onEmpty() {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(new Intent(this,ButtonTestActivity.class));
    }
}
