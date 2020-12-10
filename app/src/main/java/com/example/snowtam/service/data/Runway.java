package com.example.snowtam.service.data;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Runway {

    /** Contient le snowtam non traduit **/
    private String ident; //C)
    private String longDeblayee; //D)
    private String largDeblayee; //E)
    private String condition; //F)
    private String epaisseur; //G)
    private String coefFrottement; //H)
    private String congereCritique; //J)
    private String feux; //K)
    private String dimensionsDeblayementAVenir; //L)
    private String heureFinDelayement; //M)
    private String etatTaxiways; //N)
    private String bancsNeige; //P)

    /** Contient le snowtam traduit **/
    private String ident_decode; //C)
    private String longDeblayee_decode; //D)
    private String largDeblayee_decode; //E)
    private String condition_decode; //F)
    private String epaisseur_decode; //G)
    private String coefFrottement_decode; //H)
    private String congereCritique_decode; //J)
    private String feux_decode; //K)
    private String dimensionsDeblayementAVenir_decode; //L)
    private String heureFinDelayement_decode; //M)
    private String etatTaxiways_decode; //N)
    private String bancsNeige_decode; //P)

    private String runway;
    private String runwayTranslated;


    public Runway(String runwayStrings, int numero) {
        String runwayString;
        runwayString = findRunway(runwayStrings, numero);
        parseRunway(runwayString);
        translateRunway();
        runway = toString();
    }

    public String toString() {
        String ret = new String();
        ret = "C) " + ident;
        if(!longDeblayee.isEmpty())
            ret += " D) " + longDeblayee;
        if(!largDeblayee.isEmpty())
            ret += " E) " + largDeblayee;
        if(!condition.isEmpty())
            ret += " F) " + condition;
        if(!epaisseur.isEmpty())
            ret += " G) " + epaisseur;
        if(!coefFrottement.isEmpty())
            ret += " H) " + coefFrottement;
        if(!congereCritique.isEmpty())
            ret += " J) " + congereCritique;
        if(!feux.isEmpty())
            ret += " K) " + feux;
        if(!dimensionsDeblayementAVenir.isEmpty())
            ret += " L) " + dimensionsDeblayementAVenir;
        if(!heureFinDelayement.isEmpty())
            ret += " M) " + heureFinDelayement;
        if(!etatTaxiways.isEmpty())
            ret += " N) " + etatTaxiways;
        if(!bancsNeige.isEmpty())
            ret += " P) " + bancsNeige;
        return ret;
    }


    private void translateRunway() {
        translateC();
        translateD();
        translateE();
        translateF();
        translateG();
        translateH();
        translateJ();
        translateK();
        translateL();
        translateM();
        translateN();
        translateP();

        runwayTranslated = new String();
        runwayTranslated = ident_decode + "\n\n";
        if(!longDeblayee_decode.isEmpty())
            runwayTranslated += longDeblayee_decode + "\n\n";
        if(!largDeblayee_decode.isEmpty())
            runwayTranslated += largDeblayee_decode + "\n\n";
        if(!condition_decode.isEmpty())
            runwayTranslated += condition_decode + "\n\n";
        if(!epaisseur_decode.isEmpty())
            runwayTranslated += epaisseur_decode + "\n\n";
        if(!coefFrottement_decode.isEmpty())
            runwayTranslated += coefFrottement_decode + "\n\n";
        if(!congereCritique_decode.isEmpty())
            runwayTranslated += congereCritique_decode + "\n\n";
        if(!feux_decode.isEmpty())
            runwayTranslated += feux_decode + "\n\n";
        if(!dimensionsDeblayementAVenir_decode.isEmpty())
            runwayTranslated += dimensionsDeblayementAVenir_decode + "\n\n";
        if(!heureFinDelayement_decode.isEmpty())
            runwayTranslated += heureFinDelayement_decode + "\n\n";
        if(!etatTaxiways_decode.isEmpty())
            runwayTranslated += etatTaxiways_decode + "\n\n";
        if(!bancsNeige_decode.isEmpty())
            runwayTranslated += bancsNeige_decode;

        Log.d("RUNWAY", "'" + runwayTranslated + "'");
    }

    private void translateC() {
        ident_decode = new String();
        if(!ident.isEmpty()) {
            if(ident.compareTo("88") == 0)
                ident_decode = "ALL RUNWAYS";
            else {
                if(ident.contains("L")) {
                    ident_decode = ident.substring(0, ident.indexOf("L")) + " LEFT";
                } else if(ident.contains("R")) {
                    ident_decode = ident.substring(0, ident.indexOf("R")) + " RIGHT";
                } else {
                    if(Integer.parseInt(ident) < 50) {
                        ident_decode = ident + " LEFT";
                    } else {
                        ident_decode = ident + " RIGHT";
                    }
                }
            }
        }
        Log.d("TRANSLATE", "C) : '" + ident_decode + "'");
    }

    private void translateD() {
        longDeblayee_decode = new String();
        if(!longDeblayee.isEmpty()) {
            longDeblayee_decode = "CLEARED RUNWAY LENGTH " + longDeblayee + "M";
        }
        Log.d("TRANSLATE", "D) : '" + longDeblayee_decode + "'");
    }

    private void translateE() {
        largDeblayee_decode = new String();
        if(!largDeblayee.isEmpty()) {
            largDeblayee_decode = "CLEARED RUNWAY WIDTH " + largDeblayee + "M";
        }
        Log.d("TRANSLATE", "E) : '" + largDeblayee_decode + "'");
    }

    private void translateF() {
        condition_decode = new String();
        if(!condition.isEmpty()) { //1/1/1
            condition_decode = "Threshold: " + condition(condition.substring(0,1)) + " / " +
                    "Mid runway: " + condition(condition.substring(2,3)) + " / " +
                    "Roll out: " + condition(condition.substring(4));
        }
        Log.d("TRANSLATE", "F) : '" + condition_decode + "'");
    }

    private String condition(String numero) {
        switch (numero) {
            case "0": return "CLEAR AND DRY";
            case "1": return "DAMP";
            case "2": return "WET";
            case "3": return "RIME";
            case "4": return "DRY SNOW";
            case "5": return "WET SNOW";
            case "6": return "SLUSH";
            case "7": return "ICE";
            case "8": return "COMPACTED";
            case "9": return "FROZEN RUTS";
            default: return "";
        }
    }

    private void translateG() {
        epaisseur_decode = new String();
        if(!epaisseur.isEmpty()) {
            epaisseur_decode = "MEAN DEPTH Threashold: ";
            String a[] = epaisseur.split("/");
            if(a[0].compareToIgnoreCase("XX") == 0) {
                epaisseur_decode += "Not Significant";
            } else {
                epaisseur_decode += a[0] + "mm";
            }
            epaisseur_decode += " / Mid runway: ";
            if(a[1].compareToIgnoreCase("XX") == 0) {
                epaisseur_decode += "Not Significant";
            } else {
                epaisseur_decode += a[1] + "mm";
            }
            epaisseur_decode += " / Roll out: ";
            if(a[2].compareToIgnoreCase("XX") == 0) {
                epaisseur_decode += "Not Significant";
            } else {
                epaisseur_decode += a[0] + "mm";
            }
        }
        Log.d("TRANSLATE", "G) : '" + epaisseur_decode + "'");
    }

    private void translateH() {
        coefFrottement_decode = new String();
        if(!coefFrottement.isEmpty()) {
            coefFrottement_decode = "BRAKING ACTION Threshold: ";
            if(coefFrottement.length() > 5) {
                String a[] = coefFrottement.split("/");
                String b[] = a[2].split(" ");
                coefFrottement_decode += coefFrott(a[0], true) + " / Mid runway " +
                        coefFrott(a[1], true) + " / Roll out: " +
                        coefFrott(b[0], true) + ". Instrument: " +
                        instrument(b[1]);
            } else {
                String a[] = coefFrottement.split("/");
                coefFrottement_decode += coefFrott(a[0], false) + " / Mid runway " +
                        coefFrott(a[1], false) + " / Roll out: " +
                        coefFrott(a[2], false);
            }
        }
        Log.d("TRANSLATE", "H) : '" + coefFrottement_decode + "'");
    }

    private String coefFrott(String coef, boolean calcul) {
        String ret = new String();
        if(coef.compareToIgnoreCase("XX") == 0) {
            ret = "XX";
        } else {
            int c = Integer.parseInt(coef);
            if(c == 9)
                ret = "No reliable friction measurement";
            else if (calcul) {
                if(c >= 40)
                    ret = "GOOD";
                else if(c >= 36)
                    ret = "MEDIUM TO GOOD";
                else if(c >= 30)
                    ret = "MEDIUM";
                else if(c >= 26)
                    ret = "MEDIUM TO POOR";
                else if(c <= 25)
                    ret = "POOR";
            } else {
                switch (c) {
                    case 5: ret = "GOOD";
                        break;
                    case 4: ret = "MEDIUM TO GOOD";
                        break;
                    case 3: ret = "MEDIUM";
                        break;
                    case 2: ret = "MEDIUM TO POOR";
                        break;
                    case 1: ret = "POOR";
                        break;
                    default: ret = "No reliable friction measurement";
                        break;
                }

            }
        }
        return ret;
    }

    private String instrument(String INSTR) {
        switch (INSTR) {
            case "BRD": return "Brakemeter-Dynometer";
            case "GRT": return "Grip tester";
            case "MUM": return "Mu-meter";
            case "RFT": return "Runway friction tester";
            case "SFH": return "Surface friction tester (high-pressure tire)";
            case "SFL": return "Surface friction tester (low-pressure tire)";
            case "SKH": return "Skiddometer (high-pressure tire)";
            case "SKL": return "Skiddometer (low-pressure tire)";
            case "TAP": return "Tapeley meter";
            default: return "";
        }
    }

    private void translateJ() {
        congereCritique_decode = new String();
        if(!congereCritique.isEmpty()) {
            congereCritique_decode = "CRITICAL SNOWBANK ";
            String a[] = congereCritique.split("/");
            congereCritique_decode += a[0] + "cm / ";
            if(a[1].contains("LR")) {
                congereCritique_decode += a[1].substring(0, a[1].indexOf("LR")) + "m LEFT AND RIGHT of Runway";
            } else if(a[1].contains("L")) {
                congereCritique_decode += a[1].substring(0, a[1].indexOf("L")) + "m LEFT of Runway";
            } else if(a[1].contains("R")) {
                congereCritique_decode += a[1].substring(0, a[1].indexOf("R")) + "m RIGHT of Runway";
            }
        }
        Log.d("TRANSLATE", "J) : '" + congereCritique_decode + "'");
    }

    private void translateK() {
        feux_decode = new String();
        if(!feux.isEmpty()) {
            feux_decode = "Lights obscured: ";
            if(feux.contains("LR")) {
                feux_decode += "LEFT AND RIGHT";
            } else if(feux.contains("L")) {
                feux_decode += "LEFT";
            } else if(feux.contains("R")) {
                feux_decode += "RIGHT";
            }
            feux_decode += " of Runway";
        }
        Log.d("TRANSLATE", "K) : '" + feux_decode + "'");
    }

    private void translateL() {
        dimensionsDeblayementAVenir_decode = new String();
        if(!dimensionsDeblayementAVenir.isEmpty()) {
            dimensionsDeblayementAVenir_decode = "FURTHER CLEARANCE ";
            if(dimensionsDeblayementAVenir.compareToIgnoreCase("TOTAL") == 0) {
                dimensionsDeblayementAVenir += "TOTAL";
            } else {
                String a[] = dimensionsDeblayementAVenir.split("/");
                dimensionsDeblayementAVenir_decode += a[0] + "m / " + a[1] + "m";
            }
        }
        Log.d("TRANSLATE", "L) : '" + dimensionsDeblayementAVenir_decode + "'");

    }

    private void translateM() {
        heureFinDelayement_decode = new String();
        if(!heureFinDelayement.isEmpty()) {
            if(heureFinDelayement.contains("NO")) {
                heureFinDelayement_decode = "No anticipated time of completion";
            } else {
                heureFinDelayement_decode = "Anticipated time of completion " + heureFinDelayement + " UTC";
            }
        }
        Log.d("TRANSLATE", "M) : '" + heureFinDelayement_decode + "'");
    }

    private void translateN() {
        etatTaxiways_decode = new String();
        if(!etatTaxiways.isEmpty()) {
            if(etatTaxiways.compareToIgnoreCase("NO") == 0)
                etatTaxiways_decode = "No taxiways";
            else {
                etatTaxiways_decode = "Taxiways : "; //+ liste des taxis
                String a[] = etatTaxiways.split("\\s");
                for (String str : a) {
                    etatTaxiways_decode += str + " ";
                }
                etatTaxiways_decode = etatTaxiways_decode.substring(0, etatTaxiways_decode.length() - 3); //retire le /X à la fin
                etatTaxiways_decode += " : " + condition(etatTaxiways.split("/")[1]);
            }
        }
        Log.d("TRANSLATE", "N) : '" + etatTaxiways_decode + "'");
    }

    private void translateP() {
        bancsNeige_decode = new String();
        if(!bancsNeige.isEmpty()) {
            bancsNeige_decode = "SNOWBANKS: YES SPACE " + bancsNeige.substring(3) + "m";
        }
        Log.d("TRANSLATE", "P) : '" + bancsNeige_decode + "'");

    }

    private String findRunway(String runwayStrings, int n) {
        String result = new String();
        int count = 0, i = 0, j = 0;

        while((i = runwayStrings.indexOf("C)", i)) != -1 && count < n) {
            count++; i++;
        } //On récupère l'indice de début du Nième runway (dans la chaine de caractères)
        if((j = runwayStrings.indexOf("C)", i+1)) != -1) //Si ce runway n'est pas le dernier
            result = runwayStrings.substring(i, j); //On récupères les infos du runway jusqu'au prochain (pour pas mélanger les infos)
        else
            result = runwayStrings.substring(i); //Sinon on racupère jusqu'à la fin
        result = result.trim() + " Z)"; //ajout d'un marqueur de fin, au cas où il n'y en ait pas
        Log.d("RUNWAY", "Runway " + n + " : '" + result + "'");
        return result;
    }

    private void parseRunway(String str) {
        ident = parseC(str);
        longDeblayee = parseD(str);
        largDeblayee = parseE(str);
        condition = parseF(str);
        epaisseur = parseG(str);
        coefFrottement = parseH(str);
        congereCritique = parseJ(str);
        feux = parseK(str);
        dimensionsDeblayementAVenir = parseL(str);
        heureFinDelayement = parseM(str);
        etatTaxiways = parseN(str);
        bancsNeige = parseP(str);
    }

    private String parseC(String str) {
        String c = new String();
        if(str.contains("C)")) {
            c = str.split("C\\)")[1].split("[C-Z]\\)")[0];
            c = c.trim();
        }
        Log.d("C)", "'" + c + "'");
        return c;
    }

    private String parseD(String str) {
        String d = new String();
        if(str.contains("D)")) {
            d = str.split("D\\)")[1].split("[C-Z]\\)")[0];
            d = d.trim();
        }
        Log.d("D)", "'" + d + "'");
        return d;
    }

    private String parseE(String str) {
        String e = new String();
        if(str.contains("E)")) {
            e = str.split("E\\)")[1].split("[C-Z]\\)")[0];
            e = e.trim();
        }
        Log.d("E)", "'" + e + "'");
        return e;
    }

    private String parseF(String str) {
        String f = new String();
        if(str.contains("F)")) {
            f = str.split("F\\)")[1].split("[C-Z]\\)")[0];
            f = f.trim();
        }
        Log.d("F)", "'" + f + "'");
        return f;
    }

    private String parseG(String str) {
        String g = new String();
        if(str.contains("G)")) {
            g = str.split("G\\)")[1].split("[C-Z]\\)")[0];
            g = g.trim();
        }
        Log.d("G)", "'" + g + "'");
        return g;
    }

    private String parseH(String str) {
        String h = new String();
        if(str.contains("H)")) {
            h = str.split("H\\)")[1].split("[C-Z]\\)")[0];
            h = h.trim();
        }
        Log.d("H)", "'" + h + "'");
        return h;
    }

    private String parseJ(String str) {
        String j = new String();
        if(str.contains("J)")) {
            j = str.split("J\\)")[1].split("[C-Z]\\)")[0];
            j = j.trim();
        }
        Log.d("J)", "'" + j + "'");
        return j;
    }

    private String parseK(String str) {
        String k = new String();
        if(str.contains("K)")) {
            k = str.split("K\\)")[1].split("[C-Z]\\)")[0];
            k = k.trim();
        }
        Log.d("K)", "'" + k + "'");
        return k;
    }

    private String parseL(String str) {
        String l = new String();
        if(str.contains("L)")) {
            l = str.split("L\\)")[1].split("[C-Z]\\)")[0];
            l = l.trim();
        }
        Log.d("L)", "'" + l + "'");
        return l;
    }

    private String parseM(String str) {
        String m = new String();
        if(str.contains("M)")) {
            m = str.split("M\\)")[1].split("[C-Z]\\)")[0];
            m = m.trim();
        }
        Log.d("M)", "'" + m + "'");
        return m;
    }

    private String parseN(String str) {
        String n = new String();
        if(str.contains("N)")) {
            n = str.split("N\\)")[1].split("[C-Z]\\)")[0];
            n = n.trim();
        }
        Log.d("N)", "'" + n + "'");
        return n;
    }

    private String parseP(String str) {
        String p = new String();
        if(str.contains("P)")) {
            p = str.split("P\\)")[1].split("[C-Z]\\)")[0];
            p = p.trim();
        }
        Log.d("P)", "'" + p + "'");
        return p;
    }


    public String translated() {
        return runwayTranslated;
    }

}
