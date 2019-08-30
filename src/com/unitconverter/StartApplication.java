package com.unitconverter;

import java.util.Scanner;
import java.util.Set;

import static java.lang.Math.floor;

class StartApplication {

    private static String inputVal = null;
    private static String inputUnit = null;
    private static String targetUnit = null;
    private static String studentResp = null;
    private static VolumeConverter volConverter;
    private static TemperatureConverter tempConverter;
    private static Double result = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            userInput(scanner);
            System.out.println(validateInput());
        }
    }

    private static void userInput(Scanner scanner) {
        System.out.println("Input Numerical Value: ");
        inputVal = scanner.next();

        System.out.println("Input unit of Measure: ");
        inputUnit = scanner.next();

        System.out.println("Target unit of Measure: ");
        targetUnit = scanner.next();

        System.out.println("Student Response: ");
        studentResp = scanner.next();
    }

    private static String validateInput() {
        if (processInputData()) {
            if (round(result).equals(round(Double.valueOf(studentResp))))
                return Constants.OUTPUT_CORRECT;
            else
                return Constants.OUTPUT_INCORRECT;
        }
        return Constants.OUTPUT_INVALID;
    }

    private static boolean processInputData() {
        if (inputVal == null || inputUnit == null || targetUnit == null)
            return false;
        tempConverter = new TemperatureConverter();
        volConverter = new VolumeConverter();
        Set<String> tempUnits = tempConverter.validTempUnits();
        Set<String> volUnits = volConverter.validVolUnits();
        try {
            if (volUnits.contains(inputUnit) && volUnits.contains(targetUnit)) {
                result = volConverter.convert(inputUnit, targetUnit, Double.valueOf(inputVal));
                return true;
            }
            if (tempUnits.contains(inputUnit) && tempUnits.contains(targetUnit)) {
                result = tempConverter.convert(inputUnit, targetUnit, Double.valueOf(inputVal));
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    private static Double round(Double val) {
        return 0.1 * floor(val * 10);
    }
}