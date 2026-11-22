package com.example.w03p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button  btn_01;
    TextView textView_01;
    int licznik =0;
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
        btn_01 = findViewById(R.id.btn_01);
        textView_01 = findViewById(R.id.textView_01);
        btn_01.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view) {
            licznik++;
                textView_01.setText("Kliknięto przycisk ("+ licznik +")");
            }});
        btn_01.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                textView_01.setText("Przytrzymano przycisk");
                return false;
            }
        });
    }
}