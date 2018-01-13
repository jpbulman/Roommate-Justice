package com.example.jpbulman.roommatejustice;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by JP Bulman on 1/12/2018.
 */

public class Chore implements Serializable{

    private int timesCompleted = 0;
    private String name = "";
    private int pointValue = 0;
    private static int totalPoints = 0;

    public Chore(String name,int pointValue){
        this.name=name;
        this.pointValue=pointValue;
    }

    public void setCompleted() {
        Log.d("SetCompleted", "SetCompleted just ran");
        Log.d("Total Points", Chore.getTotalPoints() + "");

        totalPoints += pointValue;
        timesCompleted++;
    }

    public String getTitle(){
        return this.name;
    }

    public String toString(){
        return this.name+" "+String.valueOf(this.pointValue);
    }

    public static int getTotalPoints() {
        return totalPoints;
    }

}
