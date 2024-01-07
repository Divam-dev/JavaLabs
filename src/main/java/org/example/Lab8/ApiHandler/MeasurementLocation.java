package org.example.Lab8.ApiHandler;

import java.time.LocalDate;

public class MeasurementLocation {
    private static final LocalDate START_DATE = LocalDate.of(2021, 1, 1);

    private final int id;
    private final double latitude;
    private final double longitude;
    private final String city;

    private double meanTemperature;
    private double averageHumidity;

    public MeasurementLocation(int id, double latitude, double longitude, String city) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getStartDate() {
        return START_DATE;
    }

    public double getMeanTemperature() {
        return meanTemperature;
    }

    public void setMeanTemperature(double meanTemperature) {
        this.meanTemperature = meanTemperature;
    }

    public double getAverageHumidity() {
        return averageHumidity;
    }

    public void setAverageHumidity(double averageHumidity) {
        this.averageHumidity = averageHumidity;
    }

}