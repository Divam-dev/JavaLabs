package org.example.Lab8.ApiHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

public class WeatherApiFetcher {

    public String getApiUrlForCity(MeasurementLocation location) {
        LocalDate endDate = location.getStartDate().plusYears(1);

        return "https://archive-api.open-meteo.com/v1/archive?latitude=" + location.getLatitude() +
                "&longitude=" + location.getLongitude() +
                "&start_date=" + location.getStartDate() + "&end_date=" + endDate +
                "&hourly=relative_humidity_2m&daily=temperature_2m_mean,precipitation_sum,wind_speed_10m_max&timeformat=unixtime";
    }

    public String performHttpRequest(String apiUrl) throws Exception {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            return response.toString();
        } catch (Exception e) {
            System.err.println("Error performing HTTP request:");
            System.err.println("URL: " + apiUrl);
            System.err.println("Error message: " + e.getMessage());
            throw e;
        }
    }
}