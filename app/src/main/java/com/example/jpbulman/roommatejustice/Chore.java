package com.example.jpbulman.roommatejustice;

import android.util.Log;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JP Bulman on 1/12/2018.
 */

public class Chore implements Serializable{

    private int timesCompleted = 0;
    private String name = "";
    private int pointValue = 0;
    private static int totalPoints = 0;
    private String timeCompleted;
    private int priorityLevel = 0;

    public Chore(String name,int pointValue,int priorityLevel){
        this.name=name;
        this.pointValue=pointValue;
        this.priorityLevel=priorityLevel;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setCompleted() {
        Log.d("SetCompleted", "SetCompleted just ran");
        Log.d("Total Points", Chore.getTotalPoints() + "");

        totalPoints += pointValue;
        timesCompleted++;

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
        this.timeCompleted = format.format(date);
    }

    public String getTitle(){
        return this.name;
    }

    public String getInfo() {
        String returnString = "      Worth: "+String.valueOf(this.pointValue);

        if (timeCompleted != null) {
            returnString += "       Completed " + timeCompleted;
        }

        return returnString;
    }

    public String toString(){
        String returnString = this.name+"      Worth: "+String.valueOf(this.pointValue);
        if (timeCompleted != null) {
            returnString += "       Completed " + timeCompleted;
        }
        return returnString;
    }

    public static int getTotalPoints() {
        return totalPoints;
    }

}
