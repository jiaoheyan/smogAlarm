package com.jhy.smogAlarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class sb_list_adapter extends ArrayAdapter<SmogBean> {
    private int resourceId;
    public sb_list_adapter(Context context, int textViewResourceId, List<SmogBean> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        SmogBean sb=getItem(position);           //获取当前项的实例

        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        TextView lv_time=view.findViewById(R.id.item_tv_time);//设置显示的内容
        TextView lv_temp=view.findViewById(R.id.item_tv_temp);
        TextView lv_hum = view.findViewById(R.id.item_tv_hum);
        lv_time.setText(sb.getTime());
        lv_temp.setText(sb.getTemp());
        lv_hum.setText(sb.getHum());
        return view;
    }
}
