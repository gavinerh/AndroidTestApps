package com.example.unitconverter.vo;

import com.example.unitconverter.util.DefaultMetricConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metrics {

    Map<String,GeneralMetricDefinition> metricMap;

    public Metrics() {
        metricMap = new HashMap();
        metricMap.put("Length",DefaultMetricConstructor.generateLength());
        metricMap.put("Temperature",DefaultMetricConstructor.generateTemperature());
//        metricList.add(new GeneralMetricDefinition("Mass"));
//        metricList.add(new GeneralMetricDefinition("Speed"));
//        metricList.add(new GeneralMetricDefinition("Time"));
    }

    public Map<String,GeneralMetricDefinition> getMetricMap(){
        return metricMap;
    }

    public void addNewMetric(GeneralMetricDefinition metric) {
        metricMap.put(metric.getName(),metric);
    }
}
