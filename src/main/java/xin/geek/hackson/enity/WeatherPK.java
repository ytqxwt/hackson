package xin.geek.hackson.enity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class WeatherPK implements Serializable {
    private String openid;
    private String toRole;

    @Column(name = "openid", nullable = false, length = 45)
    @Id
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Column(name = "toRole", nullable = false, length = 45)
    @Id
    public String getToRole() {
        return toRole;
    }

    public void setToRole(String toRole) {
        this.toRole = toRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherPK weatherPK = (WeatherPK) o;
        return Objects.equals(openid, weatherPK.openid) &&
                Objects.equals(toRole, weatherPK.toRole);
    }

    @Override
    public int hashCode() {

        return Objects.hash(openid, toRole);
    }
}
