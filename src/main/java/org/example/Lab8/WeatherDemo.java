package org.example.Lab8;

import org.example.Lab8.ApiHandler.MeasurementLocation;
import org.example.Lab8.ApiHandler.WeatherApiFetcher;
import org.example.Lab8.ApiHandler.WeatherApiMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class WeatherDemo {

    private static final List<MeasurementLocation> locations = List.of(
            new MeasurementLocation(1, 50.45, 30.523, "Kyiv"),
            new MeasurementLocation(2, 49.9935, 36.2304, "Kharkiv"),
            new MeasurementLocation(3, 51.5074, -0.1278, "London"),
            new MeasurementLocation(4, 40.7128, -74.0060, "New York"),
            new MeasurementLocation(5, 35.6762, 139.6503, "Tokyo"),
            new MeasurementLocation(6, 52.5200, 13.4050, "Berlin"),
            new MeasurementLocation(7, 52.2297, 21.0122, "Warsaw"),
            new MeasurementLocation(8, -35.2820, 149.1287, "Canberra"),
            new MeasurementLocation(9, 39.9042, 116.4074, "Beijing"),
            new MeasurementLocation(10, 45.4, -75.68, "Ottawa"),
            new MeasurementLocation(11, 48.8566, 2.3522, "Paris"),
            new MeasurementLocation(12, 46.4825, 30.7233, "Odesa"),
            new MeasurementLocation(13, 6.5244, 3.3792, "Lagos"),
            new MeasurementLocation(14, 41.9028, 12.4964, "Rome"),
            new MeasurementLocation(16, 55.6761, 12.5683, "Copenhagen"),
            new MeasurementLocation(17, 59.3293, 18.0686, "Stockholm"),
            new MeasurementLocation(18, 59.9139, 10.7522, "Oslo"),
            new MeasurementLocation(19, 52.3702, 4.8952, "Amsterdam")
    );

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        List<String> citiesWithTemperatureIncrease = new ArrayList<>();
        List<String> citiesWithConsecutiveDaysPrecipitation = new ArrayList<>();

        Map<String, Double> monthlyTemperatureTotals = new HashMap<>();
        Map<String, Integer> monthlyTemperatureCounts = new HashMap<>();

        Map<String, Double> monthlyHumidityTotals = new HashMap<>();
        Map<String, Integer> monthlyHumidityCounts = new HashMap<>();

        Map<String, Double> monthlyPrecipitationTotals = new HashMap<>();
        Map<String, Integer> monthlyPrecipitationCounts = new HashMap<>();

        Map<String, Double> monthlyWindSpeedTotals = new HashMap<>();
        Map<String, Integer> monthlyWindSpeedCounts = new HashMap<>();

        for (MeasurementLocation location : locations) {
            try {
                WeatherApiFetcher apiFetcher = new WeatherApiFetcher();
                String apiUrl = apiFetcher.getApiUrlForCity(location);
                String responseData = apiFetcher.performHttpRequest(apiUrl);

                WeatherApiMapper apiMapper = new WeatherApiMapper();
                apiMapper.processWeatherData(location.getCity(), responseData);

                double meanTemperature = apiMapper.getMeanTemperature();
                double averageHumidity = apiMapper.getAverageHumidity();

                location.setMeanTemperature(meanTemperature);
                location.setAverageHumidity(averageHumidity);

                double[] temperatureValues = apiMapper.getTemperatureValues();
                if (WeatherCalculations.hasTemperatureIncreased(temperatureValues, 5, 5)) {
                    citiesWithTemperatureIncrease.add(location.getCity());
                }

                double[] windSpeedValues = apiMapper.getWindSpeedValues();

                double[] precipitationValues = apiMapper.getPrecipitationValues();
                if (WeatherCalculations.hasConsecutiveDaysWithPrecipitation(precipitationValues, 7)) {
                    citiesWithConsecutiveDaysPrecipitation.add(location.getCity());
                }


                for (int i = 0; i < temperatureValues.length; i++) {
                    LocalDate date = location.getStartDate().plusDays(i);
                    String monthKey = date.format(DateTimeFormatter.ofPattern("MMM"));

                    monthlyTemperatureTotals.merge(monthKey, temperatureValues[i], Double::sum);
                    monthlyTemperatureCounts.merge(monthKey, 1, Integer::sum);
                }


                double[] humidityValues = apiMapper.getDailyAverageHumidityArray();
                for (int i = 0; i < humidityValues.length; i++) {
                    LocalDate date = location.getStartDate().plusDays(i);
                    String monthKey = date.format(DateTimeFormatter.ofPattern("MMM"));

                    monthlyHumidityTotals.merge(monthKey, humidityValues[i], Double::sum);
                    monthlyHumidityCounts.merge(monthKey, 1, Integer::sum);
                }

                location.setMeanTemperature(meanTemperature);
                location.setAverageHumidity(averageHumidity);

                for (int i = 0; i < precipitationValues.length; i++) {
                    LocalDate date = location.getStartDate().plusDays(i);
                    String monthKey = date.format(DateTimeFormatter.ofPattern("MMM"));

                    monthlyPrecipitationTotals.merge(monthKey, precipitationValues[i], Double::sum);
                    monthlyPrecipitationCounts.merge(monthKey, 1, Integer::sum);
                }


                for (int i = 0; i < windSpeedValues.length; i++) {
                    LocalDate date = location.getStartDate().plusDays(i);
                    String monthKey = date.format(DateTimeFormatter.ofPattern("MMM"));

                    monthlyWindSpeedTotals.merge(monthKey, windSpeedValues[i], Double::sum);
                    monthlyWindSpeedCounts.merge(monthKey, 1, Integer::sum);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List<MeasurementLocation> hottestStations = locations.stream()
                .sorted(Comparator.comparingDouble(location -> -location.getMeanTemperature()))
                .limit(10)
                .toList();

        List<MeasurementLocation> coldestStations = locations.stream()
                .sorted(Comparator.comparingDouble(MeasurementLocation::getMeanTemperature))
                .limit(10)
                .collect(Collectors.toList());

        List<MeasurementLocation> mostHumidStations = locations.stream()
                .sorted(Comparator.comparingDouble(MeasurementLocation::getAverageHumidity).reversed())
                .limit(10)
                .collect(Collectors.toList());


        Histogram.generateHistogram("Top 10 Hottest Stations:", generateTopStationsData(hottestStations));
        Histogram.generateHistogram("Top 10 Coldest Stations:", generateTopStationsData(coldestStations));
        Histogram.generateHistogram("Top 10 Most Humid Stations:", generateHumidStationsData(mostHumidStations));
        Histogram.generateHistogram("Average Global Temperature for Each Month:", monthlyTemperatureTotals);
        Histogram.generateHistogram("Average Global Humidity for Each Month:", monthlyHumidityTotals);
        Histogram.generateHistogram("Average Global Precipitation for Each Month:", monthlyPrecipitationTotals);


        if (!citiesWithTemperatureIncrease.isEmpty()) {
            System.out.println("\nTemperature increased by at least 5°C over 5 consecutive days in: " +
                    String.join(", ", citiesWithTemperatureIncrease) + ".");
        }

        if (!citiesWithConsecutiveDaysPrecipitation.isEmpty()) {
            System.out.println("\nPrecipitation was recorded for 7 consecutive days in: " +
                    String.join(", ", citiesWithConsecutiveDaysPrecipitation) + ".");
        }


        System.out.println("\nMonth with the Highest Average Wind Speed:");

        String monthWithHighestWindSpeed = WeatherCalculations.findMonthWithHighestAverage(monthlyWindSpeedTotals, monthlyWindSpeedCounts);
        double highestAverageWindSpeed = WeatherCalculations.calculateAverage(monthlyWindSpeedTotals, monthlyWindSpeedCounts, monthWithHighestWindSpeed);

        System.out.printf("%s  %.2f km/h%n", monthWithHighestWindSpeed, highestAverageWindSpeed);
    }

    private static Map<String, Double> generateTopStationsData(List<MeasurementLocation> stations) {
        return stations.stream()
                .collect(Collectors.toMap(MeasurementLocation::getCity, MeasurementLocation::getMeanTemperature));
    }

    private static Map<String, Double> generateHumidStationsData(List<MeasurementLocation> stations) {
        return stations.stream()
                .collect(Collectors.toMap(MeasurementLocation::getCity, MeasurementLocation::getAverageHumidity));
    }
}