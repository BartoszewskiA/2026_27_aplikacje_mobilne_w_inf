package com.example.w06p02_sharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText editText;
TextView textView;
Button btnZapisz, btnOdczytaj, btnKasuj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editText = findViewById(R.id.editText_01);
        textView = findViewById(R.id.textView_01);
        btnZapisz = findViewById(R.id.btn_zapisz);
        btnOdczytaj = findViewById(R.id.btn_odczytaj);
        btnKasuj = findViewById(R.id.btn_kasuj);
        btnZapisz.setOnClickListener(view -> zapisz_notatke());
        btnOdczytaj.setOnClickListener(view -> odczytaj_notatke());
        btnKasuj.setOnClickListener(view -> kasuj_notatke());

    }

    private void kasuj_notatke() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("notatki", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //editor.remove("notatka");
        editor.clear();
        editor.commit();

    }


    private void odczytaj_notatke() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("notatki", MODE_PRIVATE);
        String notatka = sharedPreferences.getString("notatka", "Brak zapisanych notatek");
        textView.setText(notatka);
}

private void zapisz_notatke() {
        String notatka = editText.getText().toString();
    SharedPreferences sharedPreferences = this.getSharedPreferences("notatki", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("notatka", notatka);
    editor.commit();
    }

}