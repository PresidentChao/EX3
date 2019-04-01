package com.example.lenovo.ex3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import android.widget.Button;
import android.widget.Toast;


public class SimpleAdapterActivity extends AppCompatActivity {
    private  String[] list=new String[]{"Lion","Tiger"," Monkey","Dog","Cat","Elephant"};
    private ListView mListview;
    private SimpleAdapter mAdpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        mListview = (ListView)this.findViewById(R.id.lv);

        /**

         * 参数1 上下文

         * 参数2 当前listview加载的每一个列表项对应的布局文件

         * 参数3 数据源

         */

        final String[] list = ItemData.getmDataList();

        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();

        data = ItemData.getDataLIst("item_tv","iv");

        /**

         * SimpleAdapter的五个参数：

         * Context:上下文

         * data：数据源（List<Map<String,?>>data）一个有Map组成的集合

         *       每一个Map都会对应ListView列表中的一行

         *       每一个Map(键-值对)中的键必须包含所有在from参数中所指定的键

         *resource: ListView中每一项的布局文件ID

         *from：Map中的键名

         *to：绑定item.xml文件中的view控件ID，与from，Map的键形成对应

         */
        mAdpater = new SimpleAdapter

                (SimpleAdapterActivity.this,data,R.layout.list_item,new String[]{"item_tv","iv"},new int[]{R.id.item_tv,R.id.iv});

        mListview.setAdapter(mAdpater);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast =Toast.makeText(SimpleAdapterActivity.this,list[position],Toast.LENGTH_SHORT);
                Display display = getWindowManager().getDefaultDisplay();
                // 获取屏幕高度
                int height = display.getHeight();
                toast.setGravity(Gravity.BOTTOM, 0, height/4);
                toast.show();
            }
        });
    }
}



