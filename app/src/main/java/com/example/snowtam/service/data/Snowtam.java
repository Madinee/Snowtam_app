package com.example.snowtam.service.data;

import android.util.Log;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class Snowtam implements Serializable {


    @SerializedName("id")
    private String id;


    public boolean isICAO() {
        return isICAO;
    }

    public String getCreated() {
        return Created;
    }

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
    }

    public String getStateCode() {
        return StateCode;
    }

    public int getCriticality() {
        return criticality;
    }

    @SerializedName("entity")
    private String entity;

    @SerializedName("status")
    private String status;

    @SerializedName("Qcode")
    private String Qcode;

    @SerializedName("Area")
    private String Area;

    @SerializedName("SubArea")
    private String SubArea;

    @SerializedName("Condition")
    private String Condition;

    @SerializedName("Subject")
    private String Subject;

    @SerializedName("Modifier")
    private String Modifier;

    @SerializedName("message")
    private String message;

    @SerializedName("startdate")
    private String startdate;

    @SerializedName("enddate")
    private String enddate;

    @SerializedName("isICAO")
    private boolean isICAO;

    @SerializedName("Created")
    private String Created;

    @SerializedName("key")
    private String key;

    @SerializedName("type")
    private String type;

    @SerializedName("StateCode")
    private String StateCode;

    @SerializedName("criticality")
    private int criticality;

    @SerializedName("all")
    private String all;//correspond à all

    @SerializedName("StateName")
    private String StateName;

    @SerializedName("location")
    private String location;

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }


    public String getId() {
        return id;
    }

    public String getAll() {
        return all;
    }

    public String getStateName() {
        return StateName;
    }

    public String getLocation(){
        return  location;
    }

    public String getEntity() {
        return entity;
    }

    public String getStatus() {
        return status;
    }

    public String getQcode() {
        return Qcode;
    }

    public String getArea() {
        return Area;
    }

    public String getSubArea() {
        return SubArea;
    }

    public String getCondition() {
        return Condition;
    }

    public String getSubject() {
        return Subject;
    }

    public String getModifier() {
        return Modifier;
    }

    public String getMessage() {
        return message;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setQcode(String qcode) {
        Qcode = qcode;
    }

    public void setArea(String area) {
        Area = area;
    }

    public void setSubArea(String subArea) {
        SubArea = subArea;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public void setModifier(String modifier) {
        Modifier = modifier;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public void setICAO(boolean ICAO) {
        isICAO = ICAO;
    }

    public void setCreated(String created) {
        Created = created;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }

    public void setCriticality(int criticality) {
        this.criticality = criticality;
    }

    public void setAll(String all) {
        this.all = all;
    }


    private String parseA(String str) {
    //Parsing SnowTam
    String a = new String();
        if(str.contains("A)")) {
        a = str.split("A\\)")[1].split("[B-T]\\)")[0]; //récupère la chaine de caractère comprise entre A) et Une lettre + ')'
        a = a.trim(); //enlève les " " et "\n" de la chaine de caractère
    }
        Log.d("A)", "'" + a + "'");
        return a;
}

    private String parseB(String str) {
        String b = new String();
        if(str.contains("B)")) {
            b = str.split("B\\)")[1].split("[C-T]\\)")[0];
            b = b.trim();
        }
        Log.d("B)", "'" + b + "'");
        return b;
    }

    /*private ArrayList<Runway> parseRunways(String str) {
        ArrayList<Runway> run = new ArrayList<Runway>();
        int count = 0, i = 0;
        while((i = str.indexOf("C)", i)) != -1) {
            count++; i++;
        }
        Log.d("NB_RUNWAY", Integer.toString(count));
        for(i = 0; i < count; i++) {
            run.add(new Runway(str, i));
        }
        return run;
    }

     */

    private String parseR(String str) {
        String r = new String();
        if(str.contains("R)")) {
            r = str.split("R\\)")[1].split("[S-T]\\)")[0];
            r = r.trim();
        }
        Log.d("R)", "'" + r + "'");
        return r;
    }

    private String parseS(String str) {
        String s = new String();
        if(str.contains("S)")) {
            s = str.split("S\\)")[1].split("T\\)")[0];
            s = s.trim();
        }
        Log.d("S)", "'" + s + "'");
        return s;
    }

    private String parseT(String str) {
        String t = new String();
        if(str.contains("T)")) {
            t = str.split("T\\)")[1].split("\\)")[0];
            t = t.trim();
        }
        Log.d("T)", "'" + t + "'");
        return t;
    }

}
