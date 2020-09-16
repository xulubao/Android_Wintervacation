package com.example.wintervacation;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
/*
 *   @创建者        徐路宝
 *   @创建描述      2020/3/27 10:50
 *   @描述          myservice
 */public class MyService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        Log.e("151","创建");
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Log.e("151","启动");
        return super.onStartCommand(intent,flags,startId);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.e("151","销毁");
    }
}
