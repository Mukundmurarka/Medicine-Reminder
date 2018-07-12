package com.mukundmurarka.medicinereminder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    ImageView plus;
    ListView listView;
    ArrayList<String> arrayList;

    SQLiteDatabase database;
    Medicine medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus = findViewById(R.id.plus);
        listView = findViewById(R.id.list);

        arrayList = new ArrayList<>();
        Medicine medicine = new Medicine(this);
        Cursor cursor = medicine.getdata();

        medicine = new Medicine(this);

        database = medicine.getWritableDatabase();

        if (cursor.moveToFirst()) {
            do {
                String name_f = cursor.getString(cursor.getColumnIndex("Name"));
                String date_f = cursor.getString(cursor.getColumnIndex("Date"));
                String time_f = cursor.getString(cursor.getColumnIndex("Time"));

                arrayList.add(name_f + " " + date_f + " " + time_f);


            }
            while (cursor.moveToNext());
        }
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);

                String[] arr = arrayList.get(position).split(" ",3);

                String name = arr[0];

                Log.d("test", name);

                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();

                arrayAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_LONG).show();
                return true;
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);


            }
        });
    }
}
