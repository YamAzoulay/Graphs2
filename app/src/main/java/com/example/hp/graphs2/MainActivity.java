package com.example.hp.graphs2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {
    WebView wv;
    Intent t;
    String WebSofi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv=(WebView)findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        WebSofi="https://www.sagive.co.il/library/tools/embed-graphs/bargraph/index.php?trcount=7&data=#8c0000,#910000,#297fb7,#1c81c4%7C1,%7C4,%7C7,%7CRepeats,Weight%7Cchecked%7C";

        wv.loadUrl(WebSofi);


    }

    public void tt(View view) {
        t=new Intent(this,Sqlite.class);
        startActivity(t);
    }
}
