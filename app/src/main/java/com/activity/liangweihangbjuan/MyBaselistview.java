package com.activity.liangweihangbjuan;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MyBaselistview extends BaseAdapter{
    private  Context context;
    private  ArrayList<String> namelist;
    public MyBaselistview(Context context, ArrayList<String> namelist) {
        this.context=context;
        this.namelist=namelist;
    }

    public int getCount() {
        return namelist.size();
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
        View view = View.inflate(context, R.layout.listitem, null);
        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(namelist.get(position));
        return view;
    }
}
