package com.example.snowtam.service.data;

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
}
