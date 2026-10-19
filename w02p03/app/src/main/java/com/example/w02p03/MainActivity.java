package com.example.w02p03;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView_wynik;
    EditText editText_x, editText_y;

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
        textView_wynik = findViewById(R.id.textView_wynik);
        editText_x = findViewById(R.id.editText_x);
        editText_y = findViewById(R.id.editText_y);
    }

    public void oblicz(View view) {
        String dana_x = editText_x.getText().toString();
        String dana_y = editText_y.getText().toString();
        if(dana_x.length()==0 || dana_y.length()==0) {  // dana_y=="" - to nie działa
            return;
        }
        Double x = Double.parseDouble(dana_x);
        Double y = Double.parseDouble(dana_y);
//        Double x = Double.parseDouble(editText_x.getText().toString());
//        Double y = Double.parseDouble(editText_y.getText().toString());
        Double wynik = x + y;
        textView_wynik.setText(wynik.toString());


    }
}