package org.example.Lab8;

import java.util.*;
import java.util.stream.IntStream;

public class WeatherCalculations {

    public static double[] calculateDailyAverageHumidity(double[] hourlyHumidityValues) {
        int numHoursPerDay = 24;
        int numDays = hourlyHumidityValues.length / numHoursPerDay;

        return IntStream.range(0, numDays)
                .mapToDouble(i -> {
                    int startIndex = i * numHoursPerDay;
                    int endIndex = (i + 1) * numHoursPerDay;
                    return Arrays.stream(hourlyHumidityValues, startIndex, endIndex).average().orElse(0);
                })
                .map(value -> round(value, 2))
                .toArray();
    }

    public static double calculateMeanTemperature(double[] temperatureValues) {
        double meanTemperature = Arrays.stream(temperatureValues).average().orElse(0);
        return round(meanTemperature, 2);
    }

    public static double calculateAverageHumidity(double[] humidityValues) {
        return Arrays.stream(humidityValues).average().orElse(0);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static boolean hasTemperatureIncreased(double[] temperatureValues, double threshold, int consecutiveDays) {
        for (int i = 0; i <= temperatureValues.length - consecutiveDays; i++) {
            double initialTemperature = temperatureValues[i];
            boolean increased = true;
            for (int j = 1; j < consecutiveDays; j++) {
                if (temperatureValues[i + j] - initialTemperature < threshold) {
                    increased = false;
                    break;
                }
            }
            if (increased) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasConsecutiveDaysWithPrecipitation(double[] precipitationValues, int consecutiveDays) {
        for (int i = 0; i <= precipitationValues.length - consecutiveDays; i++) {
            boolean hasPrecipitation = true;
            for (int j = 0; j < consecutiveDays; j++) {
                if (precipitationValues[i + j] <= 0) {
                    hasPrecipitation = false;
                    break;
                }
            }
            if (hasPrecipitation) {
                return true;
            }
        }
        return false;
    }

    public static String findMonthWithHighestAverage(Map<String, Double> totals, Map<String, Integer> counts) {
        return totals.entrySet().stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue() / counts.get(entry.getKey())))
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public static double calculateAverage(Map<String, Double> totals, Map<String, Integer> counts, String month) {
        double total = totals.getOrDefault(month, 0.0);
        int count = counts.getOrDefault(month, 1);
        return total / count;
    }
}