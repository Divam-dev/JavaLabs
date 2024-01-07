package Lab8;

import org.example.Lab8.WeatherCalculations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherCalculationsTest {
    @Test
    void testCalculateDailyAverageHumidity() {
        double[] hourlyHumidityValues = {50, 60, 70, 80, 90, 100, 40, 30, 20, 10, 0, 0};
        double[] expected = {};

        double[] result = WeatherCalculations.calculateDailyAverageHumidity(hourlyHumidityValues);

        assertArrayEquals(expected, result, 0.001);
    }

    @Test
    void testCalculateMeanTemperature() {
        double[] temperatureValues = {20.0, 25.0, 30.0, 35.0, 40.0};
        double expected = 30.0;

        double result = WeatherCalculations.calculateMeanTemperature(temperatureValues);

        assertEquals(expected, result, 0.001);
    }

    @Test
    void testCalculateAverageHumidity() {
        double[] humidityValues = {50.0, 60.0, 70.0, 80.0, 90.0};
        double expected = 70.0;

        double result = WeatherCalculations.calculateAverageHumidity(humidityValues);

        assertEquals(expected, result, 0.001);
    }

    @Test
    void testHasTemperatureIncreased() {
        double[] temperatureValues = {20.0, 25.0, 30.0, 35.0, 40.0};
        double threshold = 5.0;
        int consecutiveDays = 3;

        assertTrue(WeatherCalculations.hasTemperatureIncreased(temperatureValues, threshold, consecutiveDays));
    }


    @Test
    void testHasConsecutiveDaysWithPrecipitation() {
        double[] precipitationValues = {0.0, 0.0, 0.0, 0.0, 0.0};
        int consecutiveDays = 3;

        assertFalse(WeatherCalculations.hasConsecutiveDaysWithPrecipitation(precipitationValues, consecutiveDays));
    }
}
