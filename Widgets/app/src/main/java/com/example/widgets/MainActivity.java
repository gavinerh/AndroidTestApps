package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button pressMeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.editText1);
        String input_text = editText.getText().toString();
        pressMeButton = findViewById(R.id.pressMeButton);

        pressMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Button is pressed");
                Toast.makeText(MainActivity.this,"Button is clicked", Toast.LENGTH_LONG).show();
            }
        });
    }
}