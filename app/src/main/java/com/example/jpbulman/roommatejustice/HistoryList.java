package com.example.jpbulman.roommatejustice;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Hesrah on 1/13/18.
 */

public class HistoryList implements Serializable {
    private ArrayList<Chore> listOfComplete = new ArrayList<Chore>();

    public void addHistory(Chore aChore) {
        this.listOfComplete.add(aChore);
    }
    public ArrayList<Chore> getListOfComplete(){
        return this.listOfComplete;
    }
}
