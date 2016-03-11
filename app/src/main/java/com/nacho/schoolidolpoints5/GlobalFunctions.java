package com.nacho.schoolidolpoints5;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by nacho on 20/03/2015.
 */
public class GlobalFunctions {
    private static final String PARENT_DIR = "..";
    private static String TAG = "TKT";

    public static boolean isExternalStorage(File file) {
        String route = file.toString();
        String[] folders = route.split("/");
        for(int i = 0; i < folders.length; i ++) {
            if(folders[i].equals("sdcard")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExternalStorage(String route) {
        String[] folders = route.split("/");
        for(int i = 0; i < folders.length; i ++) {
            if(folders[i].equals("sdcard")) {
                return true;
            }
        }
        return false;
    }

    /**
     * This function as it is is only meant to write files in the private directory of the application (by the moment)
     * @param text
     * @param file
     */
    public static void writeToFile(String text, File file) {
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter myOutWriter =
                    new OutputStreamWriter(fOut);
            myOutWriter.write(text);
            myOutWriter.close();
            fOut.close();
/*            Toast.makeText(getBaseContext(),
                    "Done writing SD 'mysdfile.txt'",
                    Toast.LENGTH_SHORT).show();*/
        }
        catch (Exception e) {
            /*Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_SHORT).show();*/
        }
    }

    public static String readFromFile(File file) {
        // write on SD card file data in the text box
        StringBuilder aBuffer = new StringBuilder();
        try {
            FileInputStream fIn = new FileInputStream(file);
            BufferedReader myReader = new BufferedReader(
                    new InputStreamReader(fIn));
            String aDataRow = "";
            while ((aDataRow = myReader.readLine()) != null) {
                aBuffer.append(aDataRow);
                aBuffer.append("\n");
            }
            myReader.close();
            fIn.close();

        }
        catch (Exception e) {

        }
        return aBuffer.toString();
    }

    /**
     * Returns a line from a file, and if the file does not exists, then returns the default text given
     * @param file The file from which we want to read the line
     * @param defaultText The text we want the function to return in case of the file not exists
     * @return
     */
    public static String readLineValuesWithDefault(File file, String defaultText) {
        String ret = "";

        try {
            FileInputStream fIn = new FileInputStream(file);

            if ( fIn != null ) {
                BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(fIn));
                ret = bufferedReader.readLine();
                bufferedReader.close();
                fIn.close();
            }
        }
        catch (FileNotFoundException e) {
            //Log.e("login activity", "File not found: " + e.toString());
            writeToFile(defaultText, file);
            ret = defaultText;
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        finally {
            if(!ret.matches("(\\d+ ?)+")) {
                writeToFile(defaultText, file);
                ret = defaultText;
            }
        }
        return ret;
    }

    /**
     * Returns a line from a file, and if the file does not exists, then returns the default text given
     * @param fileFrom The source file
     * @param fileTo The file where we want to copy the text
     */
    public static void copyLineFile(File fileFrom, File fileTo) {
        String ret = "";

        try {
            FileInputStream fIn = new FileInputStream(fileFrom);

            if ( fIn != null ) {
                BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(fIn));
                ret = bufferedReader.readLine();
                bufferedReader.close();
                fIn.close();
            }
            writeToFile(ret, fileTo);
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
    }

    public static String pullString(String key, Context context) {
        // ARCHIVO DE CLAVES: ACCEDER
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        // LEER

        return sharedPref.getString(key, "");
    }

    public static void pushString (String key, String value, Context context) {
        // ARCHIVO DE CLAVES: ACCEDER

        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        // EDITAR
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static boolean pullBoolean(String key, Context context) {
        // ARCHIVO DE CLAVES: ACCEDER

        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        // LEER

        return sharedPref.getBoolean(key, false);
    }

    public static void pushBoolean (String key, Boolean value, Context context) {
        // ARCHIVO DE CLAVES: ACCEDER

        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        // EDITAR
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, value);
        editor.commit();

    }

    public static int pullInt(String key, Context context) {
        // ARCHIVO DE CLAVES: ACCEDER

        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        // LEER

        return sharedPref.getInt(key, 0);
    }

    public static void pushInt (String key, int value, Context context) {
        // ARCHIVO DE CLAVES: ACCEDER

        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        // EDITAR
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.commit();

    }

}
