package com.nacho.schoolidolpoints5;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.nacho.schoolidolpoints5.GlobalFunctions.*;

/**
 * Created by nacho on 24/04/2015.
 */
public class TokenEvent {
    static int eventGoal, currentPoints, eventMode, pointsGained, nSongs;
    static File eventFile, configFile;
    static final String EVENT_EXT = ".evn";
    static int tokensGained, price, nonEventMode, currentTokens;
    static int[] configValues;
    //static Context context;

    /*protected TokenEvent(String name, int typeEv, int goal, String date, Context context) {
        super(name, typeEv, goal, date);
        String s = eventType + " " + eventMode + " " + nonEventMode + " " + currentTokens + " " + currentPoints + " " + eventGoal + "\n" + date;

        String s1 = context.getFilesDir().toString() + "/" + eventName + EVENT_EXT;
        Toast.makeText(context, "creamos en: " + s1, Toast.LENGTH_SHORT).show();
        eventFile = new File(context.getFilesDir().toString() + "/" + eventName + EVENT_EXT);
        writeToFile(s, eventFile);
        //writeToFile(eventName, "current_event.txt");
        pushString("current_event_file", eventFile.toString(), context);
        if(configValues == null) {
            loadConfig(context);
        }
    }*/

    /*protected TokenEvent(File file, String name, int evm, int noevm, int tokens, int points, int goal, String date, Context context) {
        super(name, 0, goal, date);
        eventFile = file;
        currentTokens = tokens;
        currentPoints = points;
        eventMode = evm;
        nonEventMode = noevm;
    }*/

    public static void loadEvent(Context context) {
        try {
            if(eventFile == null) {
                File file = new File(context.getFilesDir().toString() + "/" + context.getString(R.string.eventFile) + EVENT_EXT);
                eventFile = file;
                if(!file.exists()) {
                    String s = eventMode + " " + nonEventMode + " " + currentTokens + " " + currentPoints + " " + eventGoal;
                    writeToFile(s, eventFile);
                    File f = new File(context.getFilesDir().toString() + "/" + "SchoolIdol_Values.txt");
                    if(f.exists()) {
                        configFile = new File(context.getFilesDir().toString() + "/" + R.string.eventConfigFile);
                        copyLineFile(f, configFile);
                    }
                }
            }
            FileInputStream fIn = new FileInputStream(eventFile);
            if ( fIn != null ) {
                BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(fIn));
                String s = bufferedReader.readLine();
                //Toast.makeText(context, "valores recuperados: " + s, Toast.LENGTH_SHORT).show();
                String[] ss = s.split(" ");
                eventMode = Integer.parseInt(ss[0]);
                nonEventMode = Integer.parseInt(ss[1]);
                currentTokens = Integer.parseInt(ss[2]);
                currentPoints = Integer.parseInt(ss[3]);
                eventGoal = Integer.parseInt(ss[4]);

                if(configValues == null) {
                    loadConfig(context);
                }
                bufferedReader.close();
                fIn.close();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
    }

    protected static void loadConfig(Context context) {
        if(configFile == null) {
            configFile = new File(context.getFilesDir().toString() + "/" + R.string.eventConfigFile);
        }
        String s = readLineValuesWithDefault(configFile, "5 15 65 10 30 120 16 45 200 27 75 280");
        String[] ss = s.split(" ");
        configValues = new int[12];
        for (int i = 0; i < 12; i++) {
            configValues[i] = Integer.parseInt(ss[i]);
        }
    }

    public static void readEventValues(Context context) {
        /*if(configValues == null) {
            loadConfig(context);
        }*/
        try {
            FileInputStream fIn = new FileInputStream(eventFile);
            if ( fIn != null ) {
                BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(fIn));
                String s = bufferedReader.readLine();
                //Toast.makeText(context, "valores recuperados: " + s, Toast.LENGTH_SHORT).show();
                String[] ss = s.split(" ");
                eventMode = Integer.parseInt(ss[0]);
                //eventType + " " + eventMode + " " + nonEventMode + " " + currentTokens + " " + currentPoints + " " + eventGoal + " " + date;
                nonEventMode = Integer.parseInt(ss[1]);
                currentTokens = Integer.parseInt(ss[2]);
                currentPoints = Integer.parseInt(ss[3]);
                eventGoal = Integer.parseInt(ss[4]);
                bufferedReader.close();
                fIn.close();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
    }

    public static void calculateSongs() {
        double falta = eventGoal - currentPoints;
        double k = Math.ceil((falta - (falta * price - currentTokens * pointsGained) / (price + pointsGained)) / pointsGained);

        //double r = Math.ceil((falta - k * pointsGained) / tokensGained);
        double r2 = Math.ceil((k * price - currentTokens) / tokensGained);
        //Toast.makeText(context, "k value: " + k, Toast.LENGTH_SHORT).show();
        //Toast.makeText(context, "r value: " + r, Toast.LENGTH_SHORT).show();
        //double res = Math.ceil((double) ((eventGoal - currentPoints) * price - currentTokens * pointsGained) / (tokensGained * (pointsGained + price)));
        if(r2 > 0.0) {
            nSongs = (int) r2;
        }
        else {
            nSongs = 0;
        }
    }

    public static void saveEvent() {
        String s = eventMode + " " + nonEventMode + " " + currentTokens + " " + currentPoints + " " + eventGoal;
        writeToFile(s, eventFile);
    }

    public static void updateValues(int position, Context context) {
        eventMode = position;
        price = configValues[3*position+1];
        pointsGained = configValues[3*position+2];
        calculateSongs();
    }

    public static void updateNEValues(int position, Context context){
        nonEventMode = position;
        tokensGained = configValues[3*position];
        calculateSongs();
    }

    public static void updateCfg(){
        tokensGained = configValues[3*nonEventMode];
        price = configValues[3*eventMode+1];
        pointsGained = configValues[3*eventMode+2];
    }

}
