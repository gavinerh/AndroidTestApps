package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.unitconverter.services.UnitConverterService;
import com.example.unitconverter.vo.GeneralMetricDefinition;
import com.example.unitconverter.vo.Metrics;
import com.example.unitconverter.vo.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class MainActivity extends AppCompatActivity {


    Button toUnitConverterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toUnitConverterBtn = findViewById(R.id.toUnitConverter);
        toUnitConverterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UnitConverterActivity.class);
                startActivity(intent);
            }
        });

    }



}