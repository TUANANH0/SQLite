package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DataBase dataBase;
    ListView lvCongViec;
    ArrayList<CongViec> arrayCongViec;
    CongViecAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCongViec = (ListView) findViewById(R.id.listviewCongViec);
        arrayCongViec = new ArrayList<>();
        adapter = new CongViecAdapter(this, R.layout.dong_cong_viec, arrayCongViec);
        lvCongViec.setAdapter(adapter);
        dataBase = new DataBase(this, "GhiChu.sqlite", null,1);

        dataBase.QueryData("Create table if not exists CongViec(id Integer Primary key Autoincrement," +
                "TenCV nvarchar(200))");

        dataBase.QueryData("Insert into CongViec values(null, 'Project Androi')");

        Cursor dataCongviec = dataBase.GetData("Select * From CongViec");
        while(dataCongviec.moveToNext()){
            String ten = dataCongviec.getString(1);
           // Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
            int id = dataCongviec.getInt(0);
            arrayCongViec.add(new CongViec(id,ten));
        }
        adapter.notifyDataSetChanged();
    }
}