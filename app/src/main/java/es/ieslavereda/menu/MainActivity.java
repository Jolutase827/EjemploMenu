package es.ieslavereda.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(view->{
            showPreferences();
        });
    }

    private void showPreferences() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        textView.setText(
                "EditTextPreference: "+ MyPreferenceManager.getInstance(this).getEditText()+
                        "\nCheck Box: "+ MyPreferenceManager.getInstance(this).getCheckBox()+"\n"+
                        "Switch: "+ MyPreferenceManager.getInstance(this).getSwitch()+"\n"+
                        "ListPreference: "+ MyPreferenceManager.getInstance(this).getStringPreferences()+"\n"+
                        "Lista fondo: "+ MyPreferenceManager.getInstance(this).getTemaFondo()
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.exit: finish();
            case R.id.settings:
                Intent i = new Intent(this, PreferenceActivity.class);
                startActivity(i);
                return true;
            default:return super.onOptionsItemSelected(item);
        }
    }
}