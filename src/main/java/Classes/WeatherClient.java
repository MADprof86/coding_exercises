package Classes;

public class WeatherClient {
    private WeatherService weatherService;

    public WeatherClient(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public String getWeatherReport(String city) {
        Double temperature = weatherService.getCurrentTemperature(city);

        if(temperature == null){
            return "Brak odczytu temperatury dla miasta " + city;
        }
        return "Temperatura w " + city + " wynosi: " + temperature + "°C";
    }
}

