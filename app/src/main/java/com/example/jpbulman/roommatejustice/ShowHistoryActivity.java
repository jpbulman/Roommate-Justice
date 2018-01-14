package com.example.jpbulman.roommatejustice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_history);
        HistoryList history = (HistoryList) getIntent().getExtras().getSerializable(MainActivity.HISTORY_KEY);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,history.getListOfComplete());
        ListView historyview = findViewById(R.id.historyview);
        historyview.setAdapter(arrayAdapter);
    }


}
