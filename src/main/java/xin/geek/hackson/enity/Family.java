package xin.geek.hackson.enity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Family {
    private String id;
    private String name;
    private String count;

    public Family() {
    }

    public Family(String name, String count) {
        this.name = name;
        this.count = count;
    }

    @Id
    @Column(name = "id", nullable = false, length = 45)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "count", nullable = true, length = 45)
    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return id == family.id &&
                Objects.equals(name, family.name) &&
                Objects.equals(count, family.count);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, count);
    }
}
