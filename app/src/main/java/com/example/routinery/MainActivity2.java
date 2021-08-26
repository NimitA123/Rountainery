package com.example.routinery;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private TextView changeColorText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        changeColorText = findViewById(R.id.tvText2);
        ChangeColorText();
        textView = findViewById(R.id.tvText4);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,  MainActivity3.class);
                startActivity(intent);
            }
        });
    }

    private void ChangeColorText() {
        String Text = "I am Routinery";
        SpannableString ss = new SpannableString(Text);
        ForegroundColorSpan fcsYellow = new ForegroundColorSpan(Color.YELLOW);
        ss.setSpan(fcsYellow, 5, 14,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        changeColorText.setText(ss);
    }
}