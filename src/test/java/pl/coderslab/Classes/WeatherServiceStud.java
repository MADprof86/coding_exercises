package pl.coderslab.Classes;

import pl.coderslab.Classes.WeatherService;

public class WeatherServiceStud implements WeatherService {
    @Override
    public Double getCurrentTemperature(String city) {
        return switch(city){
            case "Katowice" -> 15.0;
            case "Kraków" -> 10.0;
            default -> null;
       };
    }
}
