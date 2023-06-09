package es.ieslavereda.menu;

import android.os.Build;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompatSideChannelService;

public class ThemeSetUp {
    private ThemeSetUp(){

    }
    public enum Mode{
        DEFAULT,LIGHT,DARK
    }
    public static void applyTheme(Mode mode){
        switch (mode){
            case LIGHT:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case DARK:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case DEFAULT:
                if (Build.VERSION.SDK_INT<Build.VERSION_CODES.Q)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
                else
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        }
    }
}
