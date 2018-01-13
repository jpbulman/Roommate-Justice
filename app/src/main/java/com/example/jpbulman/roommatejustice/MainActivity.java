package com.example.jpbulman.roommatejustice;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Chore> listOfChores = new ArrayList<Chore>();
    static final int addChoreCode = 1;

    private ArrayAdapter a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listOfChores);
        ListView l = findViewById(R.id.listViewChoreHolder);
        l.setAdapter(a);
    }

//    public void sendMessage(View view){
//        //Sends a message on a new screen
//        Intent intent = new Intent(this,DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE,message);
//        startActivity(intent);
//    }

    public void addChore(View view){
        Intent intent = new Intent(this,AddChoreActivity.class);
        startActivityForResult(intent,addChoreCode);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==addChoreCode){
            if(resultCode==RESULT_OK){
                //Button b = findViewById(R.id.addChore);
                try {
                    Bundle bringingChores = data.getExtras();
                    Chore c = (Chore)bringingChores.getSerializable("1234");
                    listOfChores.add(c);
                    Chore[] arrayOfChores  = listOfChores.toArray(new Chore[listOfChores.size()]);
                    ListView l = findViewById(R.id.listViewChoreHolder);
                    l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            view.setBackgroundColor(Color.GREEN);
                        }
                    });
                    a.notifyDataSetChanged();
                }
                catch (Exception e){
                    Log.d("H","",e);}
            }
        }
    }

}
