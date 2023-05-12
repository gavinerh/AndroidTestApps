package com.example.utilityglobal.util;


import com.example.utilityglobal.vo.GeneralMetricDefinition;
import com.example.utilityglobal.vo.Unit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class DefaultMetricConstructor {

    public static String nameOfBaseUnit = "Metres";

    public static GeneralMetricDefinition generateLength(){
        GeneralMetricDefinition generalMetricDefinition = new GeneralMetricDefinition("Length");
        List<String> units = new ArrayList<>();
        units.add("Metres");
        units.add("Kilometres");
        units.add("Miles");
        units.add("Foot");
        units.add("Inch");
        units.add("Yard");

        Set<Unit> conversionMap = new HashSet<>();
        Unit metre = new Unit("Metres",1.0);
        conversionMap.add(metre);
        Unit kilometre = new Unit("Kilometres", 0.001);
        conversionMap.add(kilometre);
        Unit mile = new Unit("Miles",0.000621371);
        conversionMap.add(mile);
        Unit yard = new Unit("Yard",1.09361);
        conversionMap.add(yard);
        Unit foot = new Unit("Foot",3.28084);
        conversionMap.add(foot);
        Unit inch = new Unit("Inch", 39.3701);
        conversionMap.add(inch);

        generalMetricDefinition.setUsingBasicFormulaConversion(true);
        generalMetricDefinition.setUnits(units);
        generalMetricDefinition.setConversionMap(conversionMap);
        return generalMetricDefinition;
    }

    public static GeneralMetricDefinition generateTemperature(){
        GeneralMetricDefinition generalMetricDefinition = new GeneralMetricDefinition("Temperature");
        List<String> units = new ArrayList<>();
        units.add("Celsius");
        units.add("Fahrenheit");
        units.add("Kelvin");

        Set<Unit> conversionMap = new HashSet<>();
        Function<Double, Double> celsiusToFahrenheitFunc = (degree) -> {
            return (degree * 1.8) + 32;
        };
        Unit celsiusToFahrenheit = new Unit("celsiusToFahrenheit",celsiusToFahrenheitFunc);
        conversionMap.add(celsiusToFahrenheit);

        Function<Double, Double> fahrenheitToDegreeFunc = (farenheit) -> {
            return (farenheit - 32) / 1.8;
        };
        Unit fahrenheitToDegree = new Unit("fahrenheitToCelsius", fahrenheitToDegreeFunc);
        conversionMap.add(fahrenheitToDegree);

        Function<Double, Double> kelvinToCelsiusFunc = (kelvin) -> {
            return (kelvin - 273.15);
        };
        Unit kelvinToCelsius = new Unit("kelvinToCelsius", kelvinToCelsiusFunc);
        conversionMap.add(kelvinToCelsius);

        Function<Double,Double> celsiusToKelvinFunc = (celsius) -> {
            return (celsius + 273.15);
        };
        Unit celsiusToKelvin = new Unit("celsiusToKelvin",celsiusToKelvinFunc);
        conversionMap.add(celsiusToKelvin);

        generalMetricDefinition.setUsingBasicFormulaConversion(false);
        generalMetricDefinition.setConversionMap(conversionMap);
        generalMetricDefinition.setUnits(units);
        generalMetricDefinition.setBaseUnitName("celsius");
        return generalMetricDefinition;
    }


}
