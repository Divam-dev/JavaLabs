package Lab8;

import org.example.Lab8.ApiHandler.MeasurementLocation;
import org.example.Lab8.ApiHandler.WeatherApiFetcher;
import org.example.Lab8.ApiHandler.WeatherApiMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApiTest {

    @Test
    public void testWeatherApiFetcher() {
        WeatherApiFetcher apiFetcher = new WeatherApiFetcher();

        MeasurementLocation location = new MeasurementLocation(1, 50.45, 30.523, "Kyiv");
        String apiUrl = apiFetcher.getApiUrlForCity(location);

        assertNotNull(apiUrl);
        assertTrue(apiUrl.contains("latitude=" + location.getLatitude()));
        assertTrue(apiUrl.contains("longitude=" + location.getLongitude()));
        assertTrue(apiUrl.contains("start_date=" + location.getStartDate()));
        assertTrue(apiUrl.contains("end_date=" + location.getStartDate().plusYears(1)));
    }

    @Test
    public void testWeatherApiMapper() {
        WeatherApiMapper apiMapper = new WeatherApiMapper();

        String responseData = "{ \"daily\": { \"temperature_2m_mean\": [10.5, 15.2, 20.0], \"precipitation_sum\": [5.0, 0.0, 2.5], \"wind_speed_10m_max\": [30.0, 25.0, 20.0] }, \"hourly\": { \"relative_humidity_2m\": [60.0, 65.0, 70.0] } }";

        apiMapper.processWeatherData("TestCity", responseData);

        assertEquals(15.23, apiMapper.getMeanTemperature(), 0.01);
        assertEquals(65.0, apiMapper.getAverageHumidity(), 0.01);
        assertArrayEquals(new double[]{5.0, 0.0, 2.5}, apiMapper.getPrecipitationValues(), 0.01);
        assertArrayEquals(new double[]{30.0, 25.0, 20.0}, apiMapper.getWindSpeedValues(), 0.01);
    }
}
