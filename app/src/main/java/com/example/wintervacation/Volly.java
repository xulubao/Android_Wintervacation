package com.example.wintervacation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Volly extends AppCompatActivity {
    //   Url     Urlstream   httpclient   Asychttpclient   okhttp       volley (   Thread  +  Handler)
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volly);
        Button btngain = findViewById(R.id.btngain);
        lv = findViewById(R.id.lv);
    }


    public void yy(View v) {
        // 127.0.0.1
        String url = "http://10.0.2.2/xx/2.php";
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            JSONArray stu = object.getJSONArray("students");
                            List<Student> list = new ArrayList<Student>();
                            for (int i=0;i<stu.length();i++){
                                JSONObject object1 = stu.getJSONObject(i);
                                list.add(new Student(object1.getString("name"),object1.getInt("age")));
                            }
                            sort(list);
                            lv.setAdapter(new MyAdapter(Volly.this, list));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
    void sort(List<Student> list){
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAge()>o2.getAge())return -1;
                else return 1;
            }
        });
    }

    class MyAdapter extends BaseAdapter {
        Context context;
        List<Student> arr;

        public MyAdapter(Context context, List<Student> arr) {
            this.context = context;
            this.arr = arr;
        }

        @Override
        public int getCount() {
            return arr.size();
        }

        @Override
        public Object getItem(int position) {
            return arr.size();
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(context).inflate(R.layout.item, null);
            TextView t1 = view.findViewById(R.id.textView3);
            TextView t2 = view.findViewById(R.id.textView4);

                Student stu = arr.get(position);
                t1.setText(stu.getName());
                t2.setText(stu.getAge()+"");

            return view;
        }
    }
    class  Student{
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }
}
