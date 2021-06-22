package pl.springboot2.karoljanik.weatherapihibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.springboot2.karoljanik.weatherapihibernate.model.Weather;

@Repository
public interface WeatherRepo extends JpaRepository<Weather, Long> {

}
