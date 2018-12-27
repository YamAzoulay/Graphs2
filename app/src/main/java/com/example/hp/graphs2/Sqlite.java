package com.example.hp.graphs2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Sqlite extends AppCompatActivity implements AdapterView.OnItemClickListener {

    SQLiteDatabase db;
    HelperDB hlp;
    Button button;
    EditText ed;
    String st;
    int i;
    ContentValues cv;
    ListView lv;
    ArrayAdapter adp;
    ArrayList<String> tbl = new ArrayList<>();
    Button button4;
    Button button2;
    Cursor c;
    Intent t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        button = (Button) findViewById(R.id.button);
        button4 = (Button) findViewById(R.id.button4);
        button2 = (Button) findViewById(R.id.button2);
        ed = (EditText) findViewById(R.id.ed);
        lv = (ListView) findViewById(R.id.lv);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);


        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.close();

    }


    public void next(View view) {
        //׳”׳•׳¡׳₪׳× ׳ ׳×׳•׳ ׳™׳ ׳׳˜׳‘׳׳” data
        st = ed.getText().toString();
        i = Integer.parseInt(st);
        cv = new ContentValues();
        cv.put(Data.COUNT, i);

        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.insert(Data.TABLE_DATA, null, cv);
        db.close();

        //׳”׳¦׳’׳× ׳ ׳×׳•׳ ׳™׳ ׳׳”׳˜׳‘׳׳” data ׳‘׳¨׳©׳™׳׳”
        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();

        tbl = new ArrayList<>();
        c = db.query(Data.TABLE_DATA, null, null, null, null, null, null);
        int col1 = c.getColumnIndex("_id");
        int col2 = c.getColumnIndex("Count");
        int col3 = c.getColumnIndex("Date");
        int col4 = c.getColumnIndex("Week");
        c.moveToFirst();

        while (!c.isAfterLast()) {
            int Count = c.getInt(col2);
            String Date = c.getString(col3);
            int Week = c.getInt(col4);
            String temp = Count + "," + Date + "," + Week;
            tbl.add(temp);
            c.moveToNext();

        }
        c.close();

        adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tbl);
        lv.setAdapter(adp);

        db.close();


    }

    //׳׳©׳׳•׳ ׳׳× ׳׳׳‘׳¨׳˜ ׳׳™׳ ׳׳§׳‘׳׳™׳ ׳ ׳×׳•׳•׳ ׳™׳ ׳׳”׳˜׳‘׳׳”
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int selectedFromList = lv.getSelectedItemPosition();

        Toast.makeText(this, "׳”׳׳¡׳₪׳¨ ׳©׳‘׳—׳¨׳× ׳”׳•׳" + selectedFromList, Toast.LENGTH_SHORT).show();


    }

    //׳₪׳¢׳•׳׳” ׳׳׳—׳™׳§׳× ׳ ׳×׳•׳ ׳™׳ ׳׳”׳˜׳‘׳׳”
    public void delete(View view) {
        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();


        db.delete(Data.TABLE_DATA, "COUNT=?", new String[]{"555"});
        tbl = new ArrayList<>();
        c = db.query(Data.TABLE_DATA, null, null, null, null, null, null);
        int col1 = c.getColumnIndex("_id");
        int col2 = c.getColumnIndex("Count");
        int col3 = c.getColumnIndex("Date");
        int col4 = c.getColumnIndex("Week");
        c.moveToFirst();

        while (!c.isAfterLast()) {
            int Count = c.getInt(col2);
            String Date = c.getString(col3);
            int Week = c.getInt(col4);
            String temp = Count + "," + Date + "," + Week;
            tbl.add(temp);
            c.moveToNext();

        }
        c.close();

        adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tbl);
        lv.setAdapter(adp);


        db.close();


    }

    public void blue(View view) {
        t=new Intent(this,Blue.class);
        startActivity(t);

    }
}

