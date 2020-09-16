package com.example.wintervacation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/*
 *   @创建者        徐路宝
 *   @创建描述      2020/4/3 11:17
 *   @描述         广播服务
 *
 */public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "接收到的Intent的Action为：" + intent.getAction()
                        + "\n消息内容是：" + intent.getStringExtra("msg")
                , Toast.LENGTH_SHORT).show();
    }
}
