package pl.springboot2.karoljanik.weatherapihibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherApiHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApiHibernateApplication.class, args);
    }

}
