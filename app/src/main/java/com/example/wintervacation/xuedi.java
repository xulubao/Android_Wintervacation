package com.example.wintervacation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class xuedi extends AppCompatActivity {
    int YEAR,MONTH;
    protected Spinner spnYear = null;
    protected Spinner spnMonth = null;
    protected Spinner spnDay = null;
    protected String[] year ={"2000","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994",
            "1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011",
            "2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028",
            "2029","2030"};
    protected String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    protected String[][] day = {
            {"1天","2天","3天","4天","5天","6天","7天","8天","9天","10天","11天","12天","13天","14天","15天","16天","17天","18天","19天","20天","21天","22天","23天",
                    "24天","25天","26天","27天","28天","29天","30天","31天"},
            {"1天","2天","3天","4天","5天","6天","7天","8天","9天","10天","11天","12天","13天","14天","15天","16天","17天","18天","19天","20天","21天","22天","23天",
                    "24天","25天","26天","27天","28天","29天","30天"},
            {"1天","2天","3天","4天","5天","6天","7天","8天","9天","10天","11天","12天","13天","14天","15天","16天","17天","18天","19天","20天","21天","22天","23天",
                    "24天","25天","26天","27天","28天","29天"},
            {"1天","2天","3天","4天","5天","6天","7天","8天","9天","10天","11天","12天","13天","14天","15天","16天","17天","18天","19天","20天","21天","22天","23天",
                    "24天","25天","26天","27天","28天"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        bind();
    }

    protected void initComponent(){
        spnYear = (Spinner)findViewById(R.id.spnYear);
        spnMonth = (Spinner)findViewById(R.id.spnMonth);
        spnDay = (Spinner)findViewById(R.id.spnTime);

        SpinnerItemSelectedListener listener = new SpinnerItemSelectedListener();
        spnYear.setOnItemSelectedListener(listener);
        spnMonth.setOnItemSelectedListener(listener);
    }

    protected void bind(){
        ArrayAdapter adapter = new ArrayAdapter(xuedi.this,R.layout.support_simple_spinner_dropdown_item,year);
        spnYear.setAdapter(adapter);
        ArrayAdapter adapter1 = new ArrayAdapter(xuedi.this,R.layout.support_simple_spinner_dropdown_item,month);
        spnMonth.setAdapter(adapter1);
    }

    class SpinnerItemSelectedListener implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
            if (adapterView.getId() == spnYear.getId()) {
                ArrayAdapter adapter = new ArrayAdapter(xuedi.this,R.layout.support_simple_spinner_dropdown_item,day[0]);
                spnDay.setAdapter(adapter);
                YEAR = Integer.valueOf(year[i]);
            }
            else if (adapterView.getId() == spnMonth.getId()) {
                MONTH = Integer.valueOf(month[i]);
                Toast.makeText(xuedi.this, "您选择了" + spnYear.getSelectedItem().toString() + "年" + spnMonth.getSelectedItem().toString() + "月", Toast.LENGTH_SHORT).show();

                if ((YEAR % 4 == 0 && YEAR % 100 != 0 || YEAR % 400 == 0) && MONTH == 2) {
                    ArrayAdapter adapter = new ArrayAdapter(xuedi.this,R.layout.support_simple_spinner_dropdown_item,day[2]);
                    spnDay.setAdapter(adapter);
                    Toast.makeText(xuedi.this,"本月有29天",Toast.LENGTH_LONG).show();
                }
                else switch (MONTH) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        ArrayAdapter adapter3 = new ArrayAdapter(xuedi.this, R.layout.support_simple_spinner_dropdown_item, day[0]);
                        spnDay.setAdapter(adapter3);
                        Toast.makeText(xuedi.this, "本月有31天", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        ArrayAdapter adapter4 = new ArrayAdapter(xuedi.this, R.layout.support_simple_spinner_dropdown_item, day[3]);
                        spnDay.setAdapter(adapter4);
                        Toast.makeText(xuedi.this, "本月有28天", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        ArrayAdapter adapter2 = new ArrayAdapter(xuedi.this, R.layout.support_simple_spinner_dropdown_item, day[1]);
                        spnDay.setAdapter(adapter2);
                        Toast.makeText(xuedi.this, "本月有30天", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
}
