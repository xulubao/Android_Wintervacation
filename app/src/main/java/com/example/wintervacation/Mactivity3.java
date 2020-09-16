package com.example.wintervacation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.CollapsibleActionView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class Mactivity3 extends AppCompatActivity {

    int TimeLen ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mactivity3);
        EditText editText = findViewById(R.id.edtT1);
        EditText editText2 = findViewById(R.id.edtT2);
        MyListener myListener = new MyListener();
        editText.setOnFocusChangeListener(myListener);
        editText2.setOnFocusChangeListener(myListener);


        final EditText editText3 = findViewById(R.id.editText);
        final Button btntime = findViewById(R.id.button20);
        final Chronometer chronometer = findViewById(R.id.Chronometer);
        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeLen = Integer.parseInt(editText3.getText().toString());
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                btntime.setEnabled(false);
            }
        });
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime()-  chronometer.getBase() > TimeLen*1000){
                    chronometer.stop();
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(Mactivity3.this, "时间到！", Toast.LENGTH_SHORT).show();
                    btntime.setEnabled(true);
                }
            }
        });




    }

    class MyListener implements View.OnFocusChangeListener{

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus){
                v.setBackgroundColor(Color.GRAY);
            }else {
                v.setBackgroundColor(Color.BLUE);
            }
        }
    }
}
