package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
import com.example.unitconverter.vo.Unit;

import java.util.List;
import java.util.function.Function;

public class UnitConverterActivity extends AppCompatActivity {

    UnitConverterService unitConverterService;
    Spinner metricSpinner;
    Spinner unitSpinner1;
    Spinner unitSpinner2;
    EditText editText1;
    EditText editText2;
    ImageView arrowImage;
    Button convertButton;
    ArrayAdapter unitSpinnerAdapter;
    int editTextCurrentlyInFocus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_converter);

        unitConverterService = new UnitConverterService();

        initialiseMetricSpinner();

        arrowImage = findViewById(R.id.arrow);

        // if editText1 changes, editText2 will change accordingly
        initialiseEditText();

        initialiseConvertButton();
    }

    private void initialiseConvertButton() {
        convertButton = findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextCurrentlyInFocus == 1) {
                    convertOperation(editText1,unitSpinner1,editText2,unitSpinner2);
                } else if (editTextCurrentlyInFocus == 2) {
                    convertOperation(editText2,unitSpinner2,editText1,unitSpinner1);
                }
            }
        });
    }

    private void convertOperation(EditText editTextInFocus, Spinner spinnerInFocus, EditText editTextToPopulate, Spinner spinnerOnReceivingEnd){
        String editTextValue = editTextInFocus.getText().toString();
        if(editTextValue.trim().equals("")) {
            Toast.makeText(UnitConverterActivity.this, "Enter a value to continue", Toast.LENGTH_SHORT).show();
            return;
        }
        // get value of spinner in focus
        String spinnerFocussedVal = spinnerInFocus.getSelectedItem().toString();
        String receivingSpinnerVal = spinnerOnReceivingEnd.getSelectedItem().toString();

        double finalValue = 0.0;
        // get the metric definition that contains the different units
        GeneralMetricDefinition generalMetricDefinition = unitConverterService.getGeneralMetricDefinition(metricSpinner.getSelectedItem().toString());
        if(generalMetricDefinition.isUsingBasicFormulaConversion()){
            double divideValue = 0.0;
            double multiplyValue = 0.0;
            for(Unit unit : generalMetricDefinition.getConversionMap()) {
                if(Double.compare(divideValue, 0.0) != 0 && Double.compare(multiplyValue,0.0) != 0){
                    break;
                }
                if(unit.getName().equals(spinnerFocussedVal)) {
                    // extract the divide value
                    divideValue = unit.getFormulaWithRespectToBaseUnit();
                }
                if(unit.getName().equals(receivingSpinnerVal)) {
                    // extract the multiply value
                    multiplyValue = unit.getFormulaWithRespectToBaseUnit();
                }
            }
            double focussedEditTextVal = Double.parseDouble(editTextValue);
            finalValue = focussedEditTextVal / divideValue * multiplyValue;
        } else {
            // using func to resolve
            if(spinnerFocussedVal.toLowerCase().equals(generalMetricDefinition.getBaseUnitName())){
                // already at base unit
                finalValue = Double.parseDouble(editTextValue);
            } else {
                // need to convert to base unit
                String nameOfFuncToConvertToBase = spinnerFocussedVal.toLowerCase() + "to" + generalMetricDefinition.getBaseUnitName().toLowerCase();
                for(Unit unit : generalMetricDefinition.getConversionMap()) {
                    String unitNameLowercase = unit.getName().toLowerCase();
                    if(nameOfFuncToConvertToBase.equals(unitNameLowercase)) {
                        Function<Double,Double> func = unit.getFunction();
                        finalValue = func.apply(Double.parseDouble(editTextValue));
                    }
                }
            }
            String nameOfFuncToConvertToFinalUnit = generalMetricDefinition.getBaseUnitName().toLowerCase() + "to" + receivingSpinnerVal.toLowerCase();
            for(Unit unit : generalMetricDefinition.getConversionMap()) {
                if(unit.getName().toLowerCase().equals(nameOfFuncToConvertToFinalUnit)) {
                    finalValue = (Double) unit.getFunction().apply(finalValue);
                    break;
                }
            }
        }
        editTextToPopulate.setText(String.valueOf(finalValue));
    }

    private void initialiseEditText() {
        editText1 = findViewById(R.id.valueEntry1);
        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                arrowImage.setRotation(0f);
                editTextCurrentlyInFocus = 1;
            }
        });

        editText2 = findViewById(R.id.valueEntry2);
        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                arrowImage.setRotation(180f);
                editTextCurrentlyInFocus = 2;
            }
        });
    }

    private void initialiseUnitSpinners() {
        unitSpinner1 = findViewById(R.id.unit1);
        unitSpinner2 = findViewById(R.id.unit2);
        unitSpinner1.setAdapter(unitSpinnerAdapter);
        unitSpinner1.setSelection(0);
        unitSpinner2.setAdapter(unitSpinnerAdapter);
        unitSpinner2.setSelection(1);
        unitSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initialiseMetricSpinner(){
        metricSpinner = findViewById(R.id.chooseMetric);
        List<String> metricNames = unitConverterService.getMetricNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,metricNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metricSpinner.setAdapter(adapter);
        metricSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String metric = parent.getItemAtPosition(position).toString();
                List<String> unitList = unitConverterService.getMetricDefinitionUnitNames(metric);
                Toast.makeText(UnitConverterActivity.this, "Selected " + metric, Toast.LENGTH_SHORT).show();

                // need to set the arrayAdapter for the 2 spinners
                ArrayAdapter<String> adapterForUnitSpinners = new ArrayAdapter<>(UnitConverterActivity.this, android.R.layout.simple_spinner_dropdown_item,unitList);
                adapterForUnitSpinners.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                unitSpinnerAdapter = adapterForUnitSpinners;
                initialiseUnitSpinners();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}