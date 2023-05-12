package com.example.unitconverter.vo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeneralMetricDefinition {

    // name e.g. Length
    private String name;

    // list of units e.g. Metres, Kilometer...
    private List<String> units;

    // map of the conversion formula
    private Set<Unit> conversionMap;
    private boolean isUsingBasicFormulaConversion;
    private String baseUnitName;

    public GeneralMetricDefinition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUnits() {
        return units;
    }

    public void setUnits(List<String> units) {
        this.units = units;
    }

    public Set<Unit> getConversionMap() {
        return conversionMap;
    }

    public void setConversionMap(Set<Unit> conversionMap) {
        this.conversionMap = conversionMap;
    }

    public boolean isUsingBasicFormulaConversion() {
        return isUsingBasicFormulaConversion;
    }

    public void setUsingBasicFormulaConversion(boolean usingBasicFormulaConversion) {
        isUsingBasicFormulaConversion = usingBasicFormulaConversion;
    }

    public String getBaseUnitName() {
        return baseUnitName;
    }

    public void setBaseUnitName(String baseUnitName) {
        this.baseUnitName = baseUnitName;
    }
}
