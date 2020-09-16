package com.example.wintervacation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginVolly extends AppCompatActivity {
    private Button btnlongin;
    private EditText uname;
    private EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_volly);
        initComper();
    }

    public void initComper() {
        btnlongin = findViewById(R.id.btnlogin);
        uname = (EditText) findViewById(R.id.edtuname);
        pwd = (EditText) findViewById(R.id.edtpwd);
    }

    public void login(View v) {
        String url = "http://10.0.2.2/xx/login2.php";

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener() {
            @Override
            public void onResponse(Object arg0) {
                if (arg0.toString().equals("1")) {
                    Intent intent = new Intent(LoginVolly.this, Volly.class);
                    Toast.makeText(LoginVolly.this, "登陆成功！欢迎：" + uname.getText().toString(), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginVolly.this, "登陆失败，账号或密码错误！！！", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("uname", uname.getText().toString());
                map.put("pwd", pwd.getText().toString());
                return map;
            }
        };
        Volley.newRequestQueue(LoginVolly.this).add(request);
    }
}
