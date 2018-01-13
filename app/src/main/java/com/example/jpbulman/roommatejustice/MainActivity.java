package com.example.jpbulman.roommatejustice;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Chore> listOfChores = new ArrayList<Chore>();
    static final int addChoreCode = 1;
    public static String historykey = "com.example.jpbulman.roommatejustice.historykey";
    private HistoryList history = new HistoryList();
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listOfChores);
        ListView l = findViewById(R.id.listViewChoreHolder);
        l.setAdapter(arrayAdapter);
        updateTotalPointsDisplay();
    }
//    public void sendMessage(View view){
//        //Sends arrayAdapter message on arrayAdapter new screen
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

    public void showHistory(View view) {
        Intent intent = new Intent(this,ShowHistoryActivity.class);
        Bundle bundle= new Bundle();
        bundle.putSerializable(historykey, history);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    private void chorePopUp(final Chore c){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setMessage(R.string.task_doer_message).setTitle(c.getTitle());
        builder.setTitle(c.getTitle());
        //builder.show();

        String[] listOfNames = {"Complete Task","Remove Task"};
        final ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        builder.setSingleChoiceItems(listOfNames, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                result.set(0, i);
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Nothing happens when they cancel
            }
        });
        builder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int resultInt = result.get(0).intValue();
                if (resultInt == -1) {
                    return;
                } else if (resultInt == 0) {
                    c.setCompleted();
                    history.addHistory(c);
                    updateTotalPointsDisplay();
                } else if (resultInt == 1) {
                    arrayAdapter.remove(c);
                }
            }
        });
        //builder.setNeutralButton();
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==addChoreCode){
            if(resultCode==RESULT_OK){
                //Button b = findViewById(R.id.addChore);
                try {
                    Bundle bringingChores = data.getExtras();
                    final Chore c = (Chore)bringingChores.getSerializable("1234");
                    listOfChores.add(c);
                    Chore[] arrayOfChores  = listOfChores.toArray(new Chore[listOfChores.size()]);
                    ListView l = findViewById(R.id.listViewChoreHolder);
                    l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            //view.setBackgroundColor(Color.GREEN);
                            chorePopUp(listOfChores.get(i));
                        }
                    });
                    arrayAdapter.notifyDataSetChanged();
                }
                catch (Exception e){
                    Log.d("H","",e);}
            }
        }
    }

    private void updateTotalPointsDisplay() {

        TextView tpd = (TextView)findViewById(R.id.totalPointsDisplay);
        String toSet = getResources().getString(R.string.total_points) + " " + String.valueOf(Chore.getTotalPoints());
        tpd.setText(toSet);


        //tpd.gettex(R.string.total_points + Chore.getTotalPoints());
    }

}
