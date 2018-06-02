package xin.geek.hackson.enity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(WeatherPK.class)
public class Weather {
    private String openid;
    private String toRole;
    private String city;

    @Id
    @Column(name = "openid", nullable = false, length = 45)
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Id
    @Column(name = "toRole", nullable = false, length = 45)
    public String getToRole() {
        return toRole;
    }

    public void setToRole(String toRole) {
        this.toRole = toRole;
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
                Objects.equals(toRole, weather.toRole) &&
                Objects.equals(city, weather.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(openid, toRole, city);
    }
}
