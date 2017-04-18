package com.activity.liangweihangbjuan;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private ListView listView;
    private List<Bean.RsBean.ChildrenBeanX> imgApp;
    private ArrayList<String> arraylist=new ArrayList<>();
    private ArrayList<String> namelist=new ArrayList<>();
    private int mI = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        gridView = (GridView) findViewById(R.id.gridview);
        SetData();
    }
    private void SetData() {
        RequestParams params = new RequestParams("https://mock.eolinker.com/success/4q69ckcRaBdxhdHySqp2Mnxdju5Z8Yr4");
        x.http().get(params, new Callback.CommonCallback<String>() {

            private MyBasegrid myBasegrid;
            private MyBaselistview myBaselistview;
            private List<Bean.RsBean> list;
            public void onSuccess(String result) {
                //解析result
                Gson gson = new Gson();
                Bean bean = gson.fromJson(result, Bean.class);
                //获取出name的集合
                List<Bean.RsBean> rs = bean.getRs();
                for(Bean.RsBean a : rs){
                    String name = a.getDirName();
                    namelist.add(name);
                }
                //所有图片的集合
                List<Bean.RsBean.ChildrenBeanX> children1 = rs.get(mI).getChildren();
                //取出对应的图片
                for (Bean.RsBean.ChildrenBeanX.ChildrenBean image:children1.get(0).getChildren() ) {
                    String imgApp = image.getImgApp();
                    arraylist.add(imgApp);
                }
                myBaselistview = new MyBaselistview(MainActivity.this, namelist);
                listView.setAdapter(myBaselistview);
                myBasegrid = new MyBasegrid(MainActivity.this, arraylist);
                gridView.setAdapter(myBasegrid);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        mI=position;
                        arraylist.clear();
                        namelist.clear();
                        SetData();
                        myBasegrid.notifyDataSetChanged();
                        myBaselistview.notifyDataSetChanged();
                    }
                });
            }
            //请求异常后的回调方法
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            //主动调用取消请求的回调方法
            public void onCancelled(CancelledException cex) {
            }

            public void onFinished() {
            }
        });
    }


}
