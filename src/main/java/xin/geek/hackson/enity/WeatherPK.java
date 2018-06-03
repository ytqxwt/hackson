package xin.geek.hackson.enity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class WeatherPK implements Serializable {
    private String openid;
    private String torole;

    @Column(name = "openid", nullable = false, length = 45)
    @Id
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Column(name = "torole", nullable = false, length = 45)
    @Id
    public String getTorole() {
        return torole;
    }

    public void setTorole(String torole) {
        this.torole = torole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherPK weatherPK = (WeatherPK) o;
        return Objects.equals(openid, weatherPK.openid) &&
                Objects.equals(torole, weatherPK.torole);
    }

    @Override
    public int hashCode() {

        return Objects.hash(openid, torole);
    }
}
