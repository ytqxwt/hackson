package xin.geek.hackson.enity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class User {
    private String openid;
    private String name;
    private Date birthday;
    private String role;
    private String familyId;
    private String city;

    public User() {
    }

    public User(String openid, String role, String familyId) {
        this.openid = openid;
        this.role = role;
        this.familyId = familyId;
    }

    @Id
    @Column(name = "openid", nullable = false, length = 45)
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "role", nullable = true, length = 45)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "family_id", nullable = true, length = 45)
    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
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
        User user = (User) o;
        return Objects.equals(openid, user.openid) &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(role, user.role) &&
                Objects.equals(familyId, user.familyId) &&
                Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(openid, name, birthday, role, familyId, city);
    }
}
