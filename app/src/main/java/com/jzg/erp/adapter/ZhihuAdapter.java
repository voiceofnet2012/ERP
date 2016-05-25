package com.jzg.erp.adapter;

import android.content.Context;

import com.jzg.erp.R;
import com.jzg.erp.adapter.comm.CommonAdapter;
import com.jzg.erp.adapter.comm.ViewHolder;
import com.jzg.erp.bean.ZhihuItem;

import java.util.List;

/**
 * @author: voiceofnet
 * email: pengkun@jingzhengu.com
 * phone:18101032717
 * @time: 2016/5/24 10:01
 * @desc:
 */
public class ZhihuAdapter extends CommonAdapter<ZhihuItem>{
    public ZhihuAdapter(Context context, List<ZhihuItem> data, int itemLayoutId) {
        super(context, data, itemLayoutId);
    }

    @Override
    public void convert(ViewHolder helper, ZhihuItem item, int position) {
        helper.setText(R.id.tvTitle,item.getDescription());
        helper.setText(R.id.tvCategory,item.getName());
        helper.setSimpleDraweeView(R.id.sdvLeft,item.getThumbnail());
    }
}
