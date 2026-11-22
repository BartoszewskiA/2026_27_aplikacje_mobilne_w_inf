package com.example.w04p01;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView_01;
    SeekBar seekBar_01;
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
        textView_01 = findViewById(R.id.textView_01);
        seekBar_01 = findViewById(R.id.seekBar_01);
        dodajSluchaczaDoSeekBar();
    }

    private void dodajSluchaczaDoSeekBar() {
        seekBar_01.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                textView_01.setText(String.valueOf(i));
                  textView_01.setText(String.valueOf(seekBar_01.getProgress()));
//                Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(MainActivity.this, "Rozpoczęto suwanie", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(MainActivity.this, "Zakończono suwanie", Toast.LENGTH_SHORT).show();
            }
        });

    }
}