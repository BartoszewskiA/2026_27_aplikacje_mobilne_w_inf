package com.example.w03p02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_01, btn_02, btn_03;
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
        znajdz_kontrolki();
//        dodaj_sluchacze();
//        dodaj_zbiorczego_sluchacza();
         dodaj_sluchacze_lambda();
         dodaj_sluchacz_suwaka();

    }

    private void dodaj_sluchacz_suwaka() {
        seekBar_01.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView_01.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Początek suwania", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Koniec suwania", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void dodaj_sluchacze_lambda() {
        btn_01.setOnClickListener(view -> textView_01.setText("kliknięto przycisk 1"));
        btn_02.setOnClickListener(view -> textView_01.setText("kliknięto przycisk 2"));
        btn_03.setOnClickListener(view -> textView_01.setText("kliknięto przycisk 3"));
    }

    private void dodaj_zbiorczego_sluchacza() {
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if(id == R.id.btn_01)
                {
                    textView_01.setText("kliknięto przycisk 1");
                }
                else if(id == R.id.btn_02)
                {
                    textView_01.setText("kliknięto przycisk 2");
                }
                else if(id == R.id.btn_03)
                {
                    textView_01.setText("kliknięto przycisk 3");
                }
//                textView_01.setText("kliknięto jakiś przycisk: "+view.getId());
            }
        };
        btn_01.setOnClickListener(sluchacz);
        btn_02.setOnClickListener(sluchacz);
        btn_03.setOnClickListener(sluchacz);
    }

    private void dodaj_sluchacze() {
        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_01.setText("Przycisk 1");
            }
        });
        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_01.setText("Przycisk 2");
            }
        });
        btn_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_01.setText("Przycisk 3");
            }
        });
    }

    private void znajdz_kontrolki() {
        btn_01 = findViewById(R.id.btn_01);
        btn_02 = findViewById(R.id.btn_02);
        btn_03 = findViewById(R.id.btn_03);
        textView_01 = findViewById(R.id.textView_01);
        seekBar_01 = findViewById(R.id.seekBar_01);
    }
        // void nazwa(parametry)
//        {
//            ciało funkcji;
//        }

    //    (parametry) -> { ciało funkcji }
    //    void nazwa(int x) { cout << x;}
    //    (x) -> { cout << x;}
//          x -> cout << x;

}