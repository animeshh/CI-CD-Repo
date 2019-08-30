package com.unitconverter;

import java.util.HashMap;
import java.util.Set;

public class TemperatureConverter {
    private HashMap<String, Double> tempUnits;

    public TemperatureConverter() {
        tempUnits = new HashMap<String, Double>();
        tempUnits.put(VALID_TEMP.Kelvin.toString(), 32.0);
        tempUnits.put(VALID_TEMP.Celsius.toString(), 1.8);
        tempUnits.put(VALID_TEMP.Fahrenheit.toString(), 32.0);
        tempUnits.put(VALID_TEMP.Rankine.toString(), 4.0);
    }

    public Double convert(String fromUnit, String toUnit, double inputValue) {

        if (fromUnit.equals(VALID_TEMP.Celsius.toString()) && toUnit.equals(VALID_TEMP.Fahrenheit.toString()))
            return inputValue * tempUnits.get(fromUnit) + tempUnits.get(toUnit);
        if (fromUnit.equals(VALID_TEMP.Fahrenheit.toString()) && toUnit.equals(VALID_TEMP.Celsius.toString()))
            return (inputValue - tempUnits.get(fromUnit)) / tempUnits.get(fromUnit);
        //ToDO:other conversions
        return inputValue;
    }

    /*
    F = 1.8(K - 273) + 32
    K = °C + 273
    */

    public Set<String> validTempUnits() {
        return tempUnits.keySet();
    }

    enum VALID_TEMP {
        Kelvin,
        Celsius,
        Fahrenheit,
        Rankine
    }

}