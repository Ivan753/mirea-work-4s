package com.example.lab2;

import org.json.JSONArray;

public class DataHolder {

    private static volatile DataHolder instance;
    private JSONArray data;

    public static DataHolder getInstance() {
        DataHolder localInstance = instance;

        if (localInstance == null) {
            instance = localInstance = new DataHolder();
        }

        return localInstance;
    }

    public void setData(JSONArray data){
        this.data = data;
    }

    public JSONArray getData(){
        return this.data;
    }

}
