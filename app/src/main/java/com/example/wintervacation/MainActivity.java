package com.example.wintervacation;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends TabActivity {

    TabHost tabHost ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yy);

        tabHost = getTabHost();
        tabHost.addTab(
                tabHost.newTabSpec("tab1")
                .setIndicator("蓝色")
                .setContent(R.id.x1)
        );

        tabHost.addTab(
                tabHost.newTabSpec("tab2")
                        .setIndicator("红色")
                        .setContent(R.id.x2)
        );
        tabHost.addTab(
                tabHost.newTabSpec("tab3")
                        .setIndicator("徐路宝")
                        .setContent(R.id.x3)
        );
        
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equals("tab1")){
                    Toast.makeText(MainActivity.this, "点击了蓝色标签！", Toast.LENGTH_SHORT).show();
                }
                if (tabId.equals("tab2")){
                    Toast.makeText(MainActivity.this, "点击了红色标签！", Toast.LENGTH_SHORT).show();
                }
                if (tabId.equals("tab3")){
                    Toast.makeText(MainActivity.this, "徐路宝！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
