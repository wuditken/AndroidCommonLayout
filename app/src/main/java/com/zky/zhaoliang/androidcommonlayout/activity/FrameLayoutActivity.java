package com.zky.zhaoliang.androidcommonlayout.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zky.zhaoliang.androidcommonlayout.R;

/**
 * 帧布局(霓虹灯效果)
 */
public class FrameLayoutActivity extends AppCompatActivity {

    private static final int UPDATE_UI = 1; // 更新ui的标志
    private static final long DELAY_MILLIS = 40; // 更新ui延时40毫秒
    private TextView[] textViews = new TextView[7]; // 显示7中颜色的控件
    private int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.GRAY, Color.BLACK, Color.WHITE}; // 7中颜色
    private int[] ids = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7}; // 控件的ids
    private int currentColor; // 当前颜色,默认是0

    Handler mHandler = new Handler() {  // 更新ui的handler
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_UI:
                    /*
                    循环更新颜色
                     */
                    for (int i = 0; i < textViews.length; i++) {
                        textViews[i].setBackgroundColor(colors[(currentColor + i) % 7]);
                    }
                    currentColor++;
                    break;
            }
            mHandler.sendEmptyMessageDelayed(UPDATE_UI, DELAY_MILLIS);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        findView();

        mHandler.sendEmptyMessageDelayed(UPDATE_UI, DELAY_MILLIS);
    }

    /**
     * 查找控件
     */
    private void findView() {
        for (int i = 0; i < textViews.length; i++) {
            textViews[i] = (TextView) findViewById(ids[i]);
        }
    }
}
