package es.ieslavereda.menu;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import androidx.annotation.Nullable;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

public class PreferenciasFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.preferencias,rootKey);
        ListPreference themePreference = getPreferenceManager().findPreference("temafondo");
        themePreference.setOnPreferenceChangeListener((p,v)->{
            ThemeSetUp.applyTheme(ThemeSetUp.Mode.valueOf((String)v));
            return true;
        });
    }
}
