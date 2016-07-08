package com.zky.zhaoliang.androidcommonlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zky.zhaoliang.androidcommonlayout.activity.AbsoluteLayoutActivity;
import com.zky.zhaoliang.androidcommonlayout.activity.FrameLayoutActivity;
import com.zky.zhaoliang.androidcommonlayout.activity.LinearLayoutOneActivity;
import com.zky.zhaoliang.androidcommonlayout.activity.LinearLayoutTwoActivity;
import com.zky.zhaoliang.androidcommonlayout.activity.RelativeLayoutOneActivity;
import com.zky.zhaoliang.androidcommonlayout.activity.RelativeLayoutTwoActivity;
import com.zky.zhaoliang.androidcommonlayout.activity.TableLayoutActivity;

/**
 * Android 中常用布局
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

        initData();

        setOnItemClickListener();
    }

    /**
     * 设置列表项点击事件
     */
    private void setOnItemClickListener() {
        listView.setOnItemClickListener(this);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{
                "LinearLayoutOne",
                "LinearLayoutTwo",
                "RelativeLayoutOne",
                "RelativeLayoutTwo",
                "FrameLayout",
                "TableLayout",
                "AbsoluteLayout"
        }));
    }

    /**
     * 查找控件
     */
    private void findView() {
        listView = (ListView) findViewById(R.id.listview);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, LinearLayoutOneActivity.class);
                break;
            case 1:
                intent = new Intent(this, LinearLayoutTwoActivity.class);
                break;
            case 2:
                intent = new Intent(this, RelativeLayoutOneActivity.class);
                break;
            case 3:
                intent = new Intent(this, RelativeLayoutTwoActivity.class);
                break;
            case 4:
                intent = new Intent(this, FrameLayoutActivity.class);
                break;
            case 5:
                intent = new Intent(this, TableLayoutActivity.class);
                break;
            case 6:
                intent = new Intent(this, AbsoluteLayoutActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }
}
