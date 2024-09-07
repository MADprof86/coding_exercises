package pl.coderslab.Classes;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class WeatherClientTest {
    @Mock
    private WeatherService weatherService;

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
      @Test
    void testGetWeatherReport_ReturnsProperMessageMockit(){

        when(weatherService.getCurrentTemperature("Warszawa")).thenReturn(15.0);
        WeatherClient weatherClient = new WeatherClient(weatherService);

        String resultMesage = weatherClient.getWeatherReport("Warszawa");
        assertEquals("Temperatura w Warszawa wynosi: 15.0°C",resultMesage);


      }
}