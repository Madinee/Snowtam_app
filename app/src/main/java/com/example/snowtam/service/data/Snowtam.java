package com.example.snowtam.service.data;

import android.util.Log;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Snowtam implements Serializable {

    //API DATA
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

    //Parsing arguments
    /** Contient le snowtam non traduit **/
    private String indicateurEmplacement; //A)
    private String publicationDate; //B)
    private ArrayList<Runway> runways; //C) - P)
    private String airDeTrafic; //R)
    private String prochaineObservation; //S)
    private String remarques; //T)

    /** Contient le snowtam traduit **/
    private String indicateurEmplacement_decode; //A)
    private String publicationDate_decode; //B)
    //voir dans Runway pour C) - P)
    private String airDeTrafic_decode; //R)
    private String prochaineObservation_decode; //S)
    private String remarques_decode; //T)



    //Parsing functions

    private String getSnowtamDate(String snowtam){
        String parsedSnowtam=parseA(snowtam)+parseB(snowtam)+parseR(snowtam)+parseS(snowtam)+parseT(snowtam);
        return parsedSnowtam;
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

    private ArrayList<Runway> parseRunways(String str) {
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

    private void translateA() {
        //TODO : récuperer le nom de l'aéroport avec le travail de marine. En attendant :
        indicateurEmplacement_decode = new String(indicateurEmplacement);
        Log.d("TRANSLATE", "A) : '" + indicateurEmplacement_decode + "'");
    }

    private void translateB() {
        //mmddhhmm -- 11250621
        publicationDate_decode = new String();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddhhmm");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(publicationDate);
        } catch (ParseException e) {
            Log.e("DATE", "Erreur lors du parsing de la date");
        }
        convertedDate.setYear(Calendar.getInstance().get(Calendar.YEAR)-1900);
        publicationDate_decode = convertedDate.toString();
        Log.d("TRANSLATE", "B) : '" + publicationDate_decode + "'");
    }

    private void translateR() {
        airDeTrafic_decode = new String();
        if(!airDeTrafic.isEmpty()) {
            if(airDeTrafic.contains("NO")) {
                airDeTrafic_decode = "aprons are unusable";
            }
            else {
                for (char c : airDeTrafic.toCharArray()) {
                    if('0' <= c && c <= '9') {
                        int numero = c - '0';
                        airDeTrafic_decode = "aprons are " + condition(numero);
                    }
                }
            }
        }
        Log.d("TRANSLATE", "R) : '" + airDeTrafic_decode + "'");
    }

    private String condition(int numero) {
        switch (numero) {
            case 0: return "CLEAR AND DRY";
            case 1: return "DAMP";
            case 2: return "WET";
            case 3: return "RIME";
            case 4: return "DRY SNOW";
            case 5: return "WET SNOW";
            case 6: return "SLUSH";
            case 7: return "ICE";
            case 8: return "COMPACTED";
            case 9: return "FROZEN RUTS";
            default: return "";
        }
    }

    private void translateS() {
        prochaineObservation_decode = new String();
        if(!prochaineObservation.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMddhhmm");
            Date convertedDate = new Date();
            try {
                convertedDate = dateFormat.parse(prochaineObservation);
            } catch (ParseException e) {
                Log.e("DATE", "Erreur lors du parsing de la date");
            }
            convertedDate.setYear(Calendar.getInstance().get(Calendar.YEAR)-1900);
            prochaineObservation_decode = convertedDate.toString();
        }
        Log.d("TRANSLATE", "S) : '" + prochaineObservation_decode + "'");
    }

    private void translateT() {
        remarques_decode = new String();
        if(!remarques.isEmpty()) {
            remarques_decode = remarques;
        }
        Log.d("TRANSLATE", "T) : '" + remarques_decode + "'");
    }


}
