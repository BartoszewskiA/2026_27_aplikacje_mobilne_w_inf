package com.example.w07p02;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_dzwon;
    ImageButton btn_internet;
    ImageButton btn_mapa;

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
        btn_dzwon = findViewById(R.id.btn_dzwon);
        btn_internet = findViewById(R.id.btn_internet);
        btn_mapa = findViewById(R.id.btn_mapa);
        btn_dzwon.setOnClickListener(v -> dzwon());
        btn_internet.setOnClickListener(v -> internet());
        btn_mapa.setOnClickListener(v -> mapa());
    }

    private void mapa() {
        Uri uri = Uri.parse("geo:0,0?q=Warszawa");
        Intent intencja = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intencja);
    }

    private void internet() {
        Uri uri = Uri.parse("https://bartoszewskia.github.io/uthrad/");
        Intent intencja = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intencja);
    }

    private void dzwon() {
        Intent intencja = new Intent(Intent.ACTION_DIAL);
        String numer = "tel:123456789";
        intencja.setData(Uri.parse(numer));
        startActivity(intencja);
    }
}