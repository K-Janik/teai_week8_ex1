package pl.springboot2.karoljanik.weatherapihibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.springboot2.karoljanik.weatherapihibernate.model.ConsolidatedWeather;
import pl.springboot2.karoljanik.weatherapihibernate.model.Weather;
import pl.springboot2.karoljanik.weatherapihibernate.model.WeatherURL;
import pl.springboot2.karoljanik.weatherapihibernate.repo.WeatherRepo;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WeatherService {

    WeatherRepo weatherRepo;

    @Autowired
    public WeatherService(WeatherRepo weatherRepo) {
        this.weatherRepo = weatherRepo;
    }

    public BigDecimal getTemp() {
        RestTemplate restTemplate = new RestTemplate();
        WeatherURL weatherURL = restTemplate.getForObject("https://www.metaweather.com/api/location/523920", WeatherURL.class);
        BigDecimal consolidatedWeathers = weatherURL.getConsolidatedWeather().get(0).getTheTemp();
        return consolidatedWeathers;
    }

    @Scheduled(fixedDelay = 1000)
    public void init() {
        Weather temp = new Weather(getTemp());
        weatherRepo.save(temp);
    }
}
