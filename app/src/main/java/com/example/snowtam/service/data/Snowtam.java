package com.example.snowtam.service.data;

public class Snowtam {
    private String id;
    private String all;//correspond à all
    private String StateName;
    private String location;

    public Snowtam(String stateName, String location) {
        StateName = stateName;
        this.location = location;
    }

    public Snowtam() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public void setLocation(String location) {
        this.location = location;
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

    @Override
    public String toString() {
        return "Snowtam{" +
                "StateName='" + StateName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
