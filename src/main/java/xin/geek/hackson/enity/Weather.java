package xin.geek.hackson.enity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(WeatherPK.class)
public class Weather {
    private String openid;
    private String torole;
    private String city;
    @Id
    @Column(name = "weather", nullable = false, length = 45)
    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    private String weather;

    @Id
    @Column(name = "openid", nullable = false, length = 45)
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Id
    @Column(name = "torole", nullable = false, length = 45)
    public String getTorole() {
        return torole;
    }

    public void setTorole(String torole) {
        this.torole = torole;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(openid, weather.openid) &&
                Objects.equals(torole, weather.torole) &&
                Objects.equals(city, weather.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(openid, torole, city);
    }
}
