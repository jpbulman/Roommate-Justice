package com.example.jpbulman.roommatejustice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.ScrollView;

public class AddChoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chore);
        Intent intent = getIntent();
    }

    public void finisher(View view){
        NumberPicker n = (NumberPicker) findViewById(R.id.numberPicker);
        int points = n.getValue();

        Plain

        //Chore c = new Chore();
        finish();
    }

}
