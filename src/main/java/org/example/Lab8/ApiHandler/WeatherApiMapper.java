package org.example.Lab8.ApiHandler;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.Lab8.WeatherCalculations;

import java.util.Arrays;

public class WeatherApiMapper {

    private double meanTemperature;
    private double averageHumidity;
    double[] temperatureValues;
    double[] precipitationValues;
    double[] windSpeedValues;
    double[] dailyAverageHumidityArray;

    public void processWeatherData(String city, String responseData) {
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(responseData, JsonObject.class);

        JsonArray precipitationArray = jsonResponse.getAsJsonObject("daily").getAsJsonArray("precipitation_sum");
        precipitationValues = gson.fromJson(precipitationArray, double[].class);

        JsonArray windSpeedArray = jsonResponse.getAsJsonObject("daily").getAsJsonArray("wind_speed_10m_max");
        windSpeedValues = gson.fromJson(windSpeedArray, double[].class);

        JsonArray hourlyHumidityArray = jsonResponse.getAsJsonObject("hourly").getAsJsonArray("relative_humidity_2m");
        double[] hourlyHumidityValues = gson.fromJson(hourlyHumidityArray, double[].class);

        dailyAverageHumidityArray = WeatherCalculations.calculateDailyAverageHumidity(hourlyHumidityValues);


        averageHumidity = WeatherCalculations.calculateAverageHumidity(hourlyHumidityValues);


        JsonArray temperatureArray = jsonResponse.getAsJsonObject("daily").getAsJsonArray("temperature_2m_mean");
        temperatureValues = gson.fromJson(temperatureArray, double[].class);

        meanTemperature = WeatherCalculations.calculateMeanTemperature(temperatureValues);


    }

    public double getMeanTemperature() {
        return meanTemperature;
    }

    public double getAverageHumidity() {
        return averageHumidity;
    }

    public double[] getTemperatureValues() {
        return temperatureValues;
    }

    public double[] getWindSpeedValues() {
        return windSpeedValues;
    }

    public double[] getPrecipitationValues() {
        return precipitationValues;
    }

    public double[] getDailyAverageHumidityArray() {
        return dailyAverageHumidityArray;
    }
}
