package xin.geek.hackson.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.geek.hackson.enity.User;
import xin.geek.hackson.enity.Weather;
import xin.geek.hackson.enity.WeatherPK;

public interface WeatherRepos extends JpaRepository<Weather, WeatherPK> {
}
