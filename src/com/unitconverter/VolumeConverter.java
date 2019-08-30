package com.unitconverter;

import java.util.HashMap;
import java.util.Set;

public class VolumeConverter {
    private HashMap<String, Double> volUnits;

    public VolumeConverter() {
        volUnits = new HashMap<String, Double>();
        volUnits.put(VALID_VOLUME.liters.toString(), 1.0);
        volUnits.put(VALID_VOLUME.gallons.toString(), 3.7854);
        volUnits.put(VALID_VOLUME.cups.toString(), 4.0);
        volUnits.put(VALID_VOLUME.tablespoons.toString(), 67.62);
    }

    public Double convert(String fromUnit, String toUnit, Double inputValue) {

        return inputValue * volUnits.get(fromUnit) / volUnits.get(toUnit);
    }

    public Set<String> validVolUnits() {
        return volUnits.keySet();
    }

    enum VALID_VOLUME {
        liters,
        gallons,
        cups,
        tablespoons
    }
}