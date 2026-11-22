package com.example.w05p02;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView_01;
    RadioGroup radioGroup_1;

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
        radioGroup_1 = findViewById(R.id.radioGroup_1);
        radioGroup_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {
                zmien_jezyk(i);
            }
        });
    }

    private void zmien_jezyk(int i) {
        if (i == R.id.radioButton_1) {
//            textView_01.setText(R.string.powitanie_pl);
            String s = getResources().getString(R.string.powitanie_pl);
            textView_01.setText(s);
        } else { textView_01.setText(R.string.powitanie_en); }
    }
}