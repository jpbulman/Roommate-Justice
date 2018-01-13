package com.example.jpbulman.roommatejustice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Chore> listOfChores = new ArrayList<Chore>();
    static final int addChoreCode = 1;

    public static void addChoreToList(Chore c){
        listOfChores.add(c);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                    LinearLayout l = findViewById(R.id.LOTlayout);
                    TextView t = new TextView(this);
                    t.setText(c.toString());
                    l.addView(t);
                }
                catch (Exception e){
                    Log.d("H","",e);}
            }
        }
    }

}
