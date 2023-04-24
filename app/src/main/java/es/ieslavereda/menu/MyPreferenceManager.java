package es.ieslavereda.menu;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

public class MyPreferenceManager {
    private static MyPreferenceManager instance;
    private SharedPreferences preferences;
    private MyPreferenceManager(){

    }

    public static MyPreferenceManager getInstance(Context context){
        if (instance == null){
            instance = new MyPreferenceManager();
        }
        instance.inicializa(context);
        return instance;
    }
    private void inicializa(Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getEditText(){
        return preferences.getString("editTextPreferenceKey","Default value");
    }

    public boolean getCheckBox(){
        return preferences.getBoolean("check_box_preference_1", false);
    }

    public boolean getSwitch(){
        return preferences.getBoolean("switchPreferenceKey",false);
    }

    public String getStringPreferences(){
        return preferences.getString("list_preference","standar");
    }
    public String getTemaFondo(){
        return preferences.getString("temafondo","default");
    }
}
