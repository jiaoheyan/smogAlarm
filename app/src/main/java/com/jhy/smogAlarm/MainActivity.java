package com.jhy.smogAlarm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_add,btn_delete;
    EditText et_temp,et_hum;
    ListView lv_data;
    SqliteOperator sqliteOperator;
    sb_list_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        sqliteOperator = new SqliteOperator(this);
        adapter = new sb_list_adapter(this,R.layout.data_item,sqliteOperator.queryMany());
        lv_data.setAdapter(adapter);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmogBean sb = new SmogBean();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                sb.setTime(simpleDateFormat.format(date));
                sb.setTemp(et_temp.getText().toString());
                sb.setHum(et_hum.getText().toString());
                sqliteOperator.add(sb);
                adapter.notifyDataSetChanged();
            }
        });



    }

    private void initView() {
        et_hum = findViewById(R.id.et_hum);
        et_temp = findViewById(R.id.et_temp);
        btn_add = findViewById(R.id.btn_add);
        btn_delete = findViewById(R.id.btn_delete);
        lv_data = findViewById(R.id.lv_data);
    }
}
