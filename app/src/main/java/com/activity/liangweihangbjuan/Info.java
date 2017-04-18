package com.activity.liangweihangbjuan;

import android.app.Application;

import org.xutils.x;

/**
 * Created by U on 2017/2/28.
 */

public class Info extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        x.Ext.setDebug(false); //输出debug日志，开启会影响性能
    }
}
