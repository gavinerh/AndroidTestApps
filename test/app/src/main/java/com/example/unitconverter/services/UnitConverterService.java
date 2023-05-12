package com.example.unitconverter.services;

import com.example.unitconverter.vo.GeneralMetricDefinition;
import com.example.unitconverter.vo.Metrics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnitConverterService {
    Metrics metrics;


    public UnitConverterService() {
        metrics = new Metrics();

    }

    // return list containing eg, Length, Mass, Temperature
    public List<String> getMetricNames() {
        return new ArrayList<>(metrics.getMetricMap().keySet());
    }

    // e.g. get unit names: Metre, Kilometer... when given the metricName: Length
    public List<String> getMetricDefinitionUnitNames(String metricName) {
        return metrics.getMetricMap().get(metricName).getUnits();
    }

    public GeneralMetricDefinition getGeneralMetricDefinition(String metricName) {
        return metrics.getMetricMap().get(metricName);
    }
}
