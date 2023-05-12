package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    Button toSecondActivityBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        toSecondActivityBtn = findViewById(R.id.switchActivityBtn1);

        toSecondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // explicit intent
                Intent intent = new Intent(getApplicationContext(),Activity2.class);
                intent.putExtra("id", "passing info to activity2");
                startActivity(intent);
            }
        });
    }
}