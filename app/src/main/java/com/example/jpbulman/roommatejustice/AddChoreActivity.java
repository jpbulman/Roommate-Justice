package com.example.jpbulman.roommatejustice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ScrollView;

public class AddChoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chore);

        NumberPicker n = (NumberPicker) findViewById(R.id.numberPicker);
        n.setMaxValue(100);
    }

    public void finisher(View view){

        NumberPicker n = (NumberPicker) findViewById(R.id.numberPicker);
        int points = n.getValue();

        EditText editText = (EditText) findViewById(R.id.nameForChore);
        String name = editText.getText().toString();

        Chore c = new Chore(name,points);

        Intent i = new Intent(this,AddChoreActivity.class);
        Bundle passingChoreBundle = new Bundle();
        passingChoreBundle.putSerializable("1234",c);
        i.putExtras(passingChoreBundle);
        setResult(Activity.RESULT_OK,i);

        MainActivity.addChoreToList(c);

        finish();
    }

    public Chore getChore(){
        NumberPicker n = (NumberPicker) findViewById(R.id.numberPicker);
        int points = n.getValue();

        EditText editText = (EditText) findViewById(R.id.nameForChore);
        String name = editText.getText().toString();

        return new Chore(name,points);
    }

}
