package com.example.jpbulman.roommatejustice;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class JPAdapter extends ArrayAdapter<Chore> {
    Context context;
    ArrayList<Chore> listOfChores;
    public JPAdapter(Context context, ArrayList<Chore> listOfChores){
        super(context, 0, listOfChores);
        this.listOfChores = listOfChores;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Chore currChore = listOfChores.get(position);
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        TextView name = (TextView) listItem.findViewById(R.id.textView_name);
        name.setText(currChore.getTitle());
        TextView info = (TextView) listItem.findViewById(R.id.textView_info);
        info.setText(currChore.getInfo());

        switch (currChore.getPriorityLevel()) {
            case 0:
                listItem.setBackgroundColor(Color.WHITE);
                break;
            case 1:
                listItem.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                listItem.setBackgroundColor(Color.YELLOW);
                break;
            case 3:
                listItem.setBackgroundColor(Color.RED);
                break;
        }

        return listItem;
    }
}
