package com.baunvb.duoihinhbatchu;

/**
 * Created by Baunvb on 12/6/2016.
 */

public class Question {
    private int id;
    private String name;

    public Question(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
