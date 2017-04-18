package com.activity.liangweihangbjuan;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by U on 2017/2/28.
 */
public class MyBasegrid extends BaseAdapter {
    private Context content;
    private ArrayList<String> arraylist;
    public MyBasegrid(Context content, ArrayList<String> arraylist) {
        this.content=content;
        this.arraylist=arraylist;
    }


    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(content, R.layout.itemgrid, null);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        x.image().bind(image,arraylist.get(position));
        return view;
    }
}
