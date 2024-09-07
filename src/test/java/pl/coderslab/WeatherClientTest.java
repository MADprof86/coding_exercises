package pl.coderslab;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WeatherClientTest {

    WeatherServiceStud weatherServiceStud = new WeatherServiceStud();
    WeatherClient weatherClient = new WeatherClient(weatherServiceStud);
    @Test
    void testGetWeatherReport_ReturnsProperString() {
        String katowice = weatherClient.getWeatherReport("Katowice");
        assertEquals("Temperatura w Katowice wynosi: 15.0°C",katowice);
    }
    @Test
    void testGetWeatherReport_ReturnsDefaultMessage(){
        String defaultMessage = weatherClient.getWeatherReport("Warszawa");
        assertEquals("Brak odczytu temperatury dla miasta Warszawa",
                defaultMessage);
    }
    @Test
    void testGetWeatherReport_ReturnsProperMessageMock(){
        //given
        WeatherService mock = mock(WeatherService.class);

        when(mock.getCurrentTemperature("Warszawa")).thenReturn(15.0);

        WeatherClient weatherClient = new WeatherClient(mock);
        //when, than
        assertEquals("Temperatura w Warszawa wynosi: 15.0°C",weatherClient.getWeatherReport("Warszawa"));
      }
}