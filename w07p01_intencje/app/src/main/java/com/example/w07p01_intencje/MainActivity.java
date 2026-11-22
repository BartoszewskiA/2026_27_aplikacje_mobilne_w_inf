package com.example.w07p01_intencje;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_otworz_druga_aktywnosc;
    Button btn_otworz_druga_aktywnosc_przez_dane;
    EditText editText_dane;


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
        btn_otworz_druga_aktywnosc = findViewById(R.id.a_1btn_01);
        btn_otworz_druga_aktywnosc_przez_dane = findViewById(R.id.a_1btn_02);
        editText_dane = findViewById(R.id.a1_editText_01);
        btn_otworz_druga_aktywnosc.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
        btn_otworz_druga_aktywnosc_przez_dane.setOnClickListener(view -> przeslij_dane());
    }

    private void przeslij_dane() {
        String dane = editText_dane.getText().toString();
        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
        intent.putExtra("dane", dane);
        intent.putExtra("dodatkowe_dane", 3.14);
        startActivity(intent);
    }
}