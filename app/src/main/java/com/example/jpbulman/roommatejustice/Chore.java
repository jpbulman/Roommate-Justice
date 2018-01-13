package com.example.jpbulman.roommatejustice;

import java.io.Serializable;

/**
 * Created by JP Bulman on 1/12/2018.
 */

public class Chore implements Serializable{

    private boolean isCompleted;
    private String name;
    private int pointValue;

    public Chore(String name,int pointValue){
        this.name=name;
        this.pointValue=pointValue;
    }

    public String toString(){
        return this.name+String.valueOf(this.pointValue);
    }

}
