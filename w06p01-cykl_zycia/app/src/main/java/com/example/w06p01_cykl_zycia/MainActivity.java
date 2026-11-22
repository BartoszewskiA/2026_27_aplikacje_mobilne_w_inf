package com.example.w06p01_cykl_zycia;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView_01;
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
    }

    @Override
    protected void onStart() {
        super.onStart();
        String s = textView_01.getText().toString();
        s+= "\nonStart";
        textView_01.setText(s);
    }
    @Override
    protected void onResume() {
        super.onResume();
        String s = textView_01.getText().toString();
        s+= "\nonResume";
        textView_01.setText(s);
    }
    @Override
    protected void onPause() {
        super.onPause();
        String s = textView_01.getText().toString();
        s+= "\nonPause";
        textView_01.setText(s);
    }

    @Override
    protected void onStop() {
        super.onStop();
        String s = textView_01.getText().toString();
        s+= "\nonStop";
        textView_01.setText(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String s = textView_01.getText().toString();
        s+= "\nonDestroy";
        textView_01.setText(s);
    }


}