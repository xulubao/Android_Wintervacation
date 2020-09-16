package com.example.wintervacation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Broadcast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        Button btnbroadcast = findViewById(R.id.btnbroadcast);
        btnbroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("org.crazyit.action.CRAZY_BROADCAST");
                intent.putExtra("msg","广播服务！");
                sendBroadcast(intent);
            }
        });
        FileOutputStream outputStream= null;
        try {
            outputStream = openFileOutput("xlb.txt",MODE_APPEND);
            outputStream.write("Hello Word 星期五".getBytes());
            outputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream!=null)
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream fileInputStream = null;
        try {
             fileInputStream = openFileInput("xlb.txt");
             byte[] buffer = new byte[fileInputStream.available()];
             fileInputStream.read(buffer);
            Toast.makeText(this, new String(buffer), Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
