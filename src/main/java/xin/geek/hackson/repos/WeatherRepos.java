package xin.geek.hackson.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xin.geek.hackson.enity.User;
import xin.geek.hackson.enity.Weather;
import xin.geek.hackson.enity.WeatherPK;

import java.util.List;

public interface WeatherRepos extends JpaRepository<Weather, WeatherPK> {


    @Query(value = "select * from weather where openid in " +
            "(select  family_id from user where user.city is not null and family_id=?1)"
            , nativeQuery = true)
    List<Weather> getWeatherByFamilyIdAndCityIsNotNull(String FamilyId);
}
