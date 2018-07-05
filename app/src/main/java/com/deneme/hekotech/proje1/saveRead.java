package com.deneme.hekotech.proje1;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * Created by hekotech on 8.12.2017.
 */

public class saveRead {
    Context here;

    String[] bos = new String[4];
    String[][] test = new String[35][4];


    public saveRead(Context c){
        here=c;




}




public int getCalisma(){

        SharedPreferences mSettings = here.getSharedPreferences("poms", Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSettings.edit();
        GsonBuilder gsonb = new GsonBuilder();
        Gson mGson = gsonb.create();
        String i = mSettings.getString("calis", "");

        String u;

        u = mGson.fromJson(i, String.class);
        if(u==null){
            return 25;
        }else{
            return Integer.parseInt(u);
        }

    }

    public int getDinlenme(){
        SharedPreferences mSettings = here.getSharedPreferences("poms", Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSettings.edit();
        GsonBuilder gsonb = new GsonBuilder();
        Gson mGson = gsonb.create();
        String i = mSettings.getString("dinlen", "");

        String u;

        u = mGson.fromJson(i, String.class);


        if(u==null){
            return 5;
        }else{
            Log.d("", "getDinlenme: "+u);
            Log.d("", "getDinlenme: "+String.valueOf(Integer.parseInt(u)));
            return Integer.parseInt(u);
        }


    }

    public void savedata(String p, Object o){

        SharedPreferences mSettings = here.getSharedPreferences("poms", Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSettings.edit();
        GsonBuilder gsonb = new GsonBuilder();
        Gson mGson = gsonb.create();
        try {
            String writeValue = mGson.toJson(o);
            mEditor.putString(p, writeValue);

            if(p=="pom"){
                Log.d("", "savedata: pom geldi" );
            }
            Log.d("", "savedata: "+writeValue + "place: " + p);
            mEditor.apply();

        }
        catch(Exception e)
        {


        }

    }


    public String[][] readPom(){
        String [][] bos = new String[35][4];
        SharedPreferences mSettings = here.getSharedPreferences("poms", Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSettings.edit();
        GsonBuilder gsonb = new GsonBuilder();
        Gson mGson = gsonb.create();

        String loadValue = mSettings.getString("pom", "");
        Log.d("", "gelen pomu oku: "+loadValue);
        if(loadValue==""){
            return bos;
        }
        else{
            //populatePomodor c = mGson.fromJson(loadValue, populatePomodor.class);
            return mGson.fromJson(loadValue, String[][].class);
        }

    }



    public boolean isFirst(){
        SharedPreferences mSettings = here.getSharedPreferences("poms", Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSettings.edit();
        GsonBuilder gsonb = new GsonBuilder();
        Gson mGson = gsonb.create();
        String loadValue = mSettings.getString("isfirst", "");
        Log.d("", "isFirst: "+loadValue);
        if(loadValue==""){
            return true;
        }
        else{


            return false;
        }

    }
    public boolean isFirst2(){
        SharedPreferences mSettings = here.getSharedPreferences("poms", Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSettings.edit();
        GsonBuilder gsonb = new GsonBuilder();
        Gson mGson = gsonb.create();
        String loadValue = mSettings.getString("isfirst2", "");
        Log.d("", "isFirst: "+loadValue);
        if(loadValue==""){
            return true;
        }
        else{


            return false;
        }

    }

    public ArrayList<String> getBildirim() {
        ArrayList<String> bildirim = new ArrayList<>();
        SharedPreferences mSettings = here.getSharedPreferences("poms", Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSettings.edit();
        GsonBuilder gsonb = new GsonBuilder();
        Gson mGson = gsonb.create();

        String loadValue = mSettings.getString("bildirim", "");
        Log.d("", "bildirim: "+loadValue);
        if(loadValue==""){
            return bildirim;
        }
        else{

            bildirim = mGson.fromJson(loadValue, ArrayList.class);
            return bildirim;
        }


    }


}
