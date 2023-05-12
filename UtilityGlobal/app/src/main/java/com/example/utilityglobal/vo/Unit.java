package com.example.utilityglobal.vo;

import java.util.function.Function;

public class Unit {
    private String name;
    private Double formulaWithRespectToBaseUnit;
    private Function function;


    public Unit(String name, Double formulaWithRespectToBaseUnit) {
        this.name = name;
        this.formulaWithRespectToBaseUnit = formulaWithRespectToBaseUnit;
        function = null;
    }

    public Unit(String name, Function func) {
        this.name = name;
        this.function = func;
        formulaWithRespectToBaseUnit = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFormulaWithRespectToBaseUnit() {
        return formulaWithRespectToBaseUnit;
    }

    public void setFormulaWithRespectToBaseUnit(Double formulaWithRespectToBaseUnit) {
        this.formulaWithRespectToBaseUnit = formulaWithRespectToBaseUnit;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }


}
