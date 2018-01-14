package com.example.jpbulman.roommatejustice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ScrollView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddChoreActivity extends AppCompatActivity {

    private boolean editing = false;
    private Chore editingChore;
    private int chorePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chore);

        NumberPicker n = (NumberPicker) findViewById(R.id.numberPicker);
        n.setMaxValue(100);

        Spinner s = (Spinner) findViewById(R.id.spinner);

        ArrayList<String> aryStr = new ArrayList<String>(4);
        aryStr.add(getString(R.string.no_priority));
        aryStr.add(getString(R.string.low_priority));
        aryStr.add(getString(R.string.moderate_priority));
        aryStr.add(getString(R.string.high_priority));

        ArrayAdapter<String> a = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                aryStr);

        s.setAdapter(a);

        Bundle bundle = getIntent().getExtras();
        try {
            chorePosition = bundle.getInt(MainActivity.INDEX_EDIT_CHORE_KEY);
            editingChore = (Chore) bundle.getSerializable(MainActivity.CHORE_EDIT_CHORE_KEY);
            n.setValue(editingChore.getWorth());
            s.setSelection(editingChore.getPriorityLevel());
            EditText editText = (EditText) findViewById(R.id.nameForChore);
            editText.setText(editingChore.getTitle());
        } catch (Exception e) {


        }
    }

    public void finisher(View view){

        NumberPicker n = (NumberPicker) findViewById(R.id.numberPicker);
        int points = n.getValue();

        EditText editText = (EditText) findViewById(R.id.nameForChore);
        String name = editText.getText().toString();

        Spinner s = (Spinner)findViewById(R.id.spinner);
        int positionInSpinner = s.getSelectedItemPosition();

        Chore c = new Chore(name,points,positionInSpinner);

        Intent i = new Intent(this,AddChoreActivity.class);
        Bundle passingChoreBundle = new Bundle();
        passingChoreBundle.putSerializable("1234",c);
        i.putExtras(passingChoreBundle);
        setResult(Activity.RESULT_OK,i);

        //MainActivity.addChoreToList(c);

        finish();
    }

    public Chore getChore(){
        NumberPicker n = (NumberPicker) findViewById(R.id.numberPicker);
        int points = n.getValue();

        EditText editText = (EditText) findViewById(R.id.nameForChore);
        String name = editText.getText().toString();

        return new Chore(name,points,0);
    }

}
