package com.example.wintervacation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

import androidx.appcompat.app.AppCompatActivity;



public class Main2Activity extends AppCompatActivity {

    private ZoomControls mZoomControls;
    long size = 12;
    private TextView text ;
    private AutoCompleteTextView auto;
    private static final String [] autoText = new String[]{"abc","axlb","a182"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview);

        mZoomControls = (ZoomControls)findViewById(R.id.zoomControls);
        text = (TextView)findViewById(R.id.textView);
        mZoomControls.setOnZoomInClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                size = size + 2;
                text.setTextSize(size);
            }
        });

        mZoomControls.setOnZoomOutClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                size = size - 2;
                text.setTextSize(size);
            }
        });

        auto = (AutoCompleteTextView) findViewById(R.id.auto);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,autoText);
        auto.setAdapter(adapter);


        Gallery mGallery;
        mGallery = findViewById(R.id.gallery);
        mGallery.setAdapter(new myAdapter(this));
        mGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main2Activity.this, "你点击了第"+(position+1)+"张图片", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnstart = findViewById(R.id.startserrver);
        Button btnstop = findViewById(R.id.stopserver);
        btnstart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,MyService.class);
                startService(intent);
            }
        });
        btnstop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,MyService.class);
                stopService(intent);
            }
        });
    }
}
