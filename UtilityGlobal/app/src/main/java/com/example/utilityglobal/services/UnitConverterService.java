package com.example.utilityglobal.services;


import com.example.utilityglobal.vo.GeneralMetricDefinition;
import com.example.utilityglobal.vo.Metrics;

import java.util.ArrayList;
import java.util.List;

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
