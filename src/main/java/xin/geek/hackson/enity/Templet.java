package xin.geek.hackson.enity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Templet {
    private String name;
    private String test1;
    private String test2;
    private String test3;
    private String image1;
    private String image2;
    private String image3;
    private String record1;
    private String record2;
    private String record3;
    private String from;
    private String to;

    @Id
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "test1", nullable = true, length = -1)
    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    @Basic
    @Column(name = "test2", nullable = true, length = -1)
    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

    @Basic
    @Column(name = "test3", nullable = true, length = -1)
    public String getTest3() {
        return test3;
    }

    public void setTest3(String test3) {
        this.test3 = test3;
    }

    @Basic
    @Column(name = "image1", nullable = true, length = 45)
    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    @Basic
    @Column(name = "image2", nullable = true, length = 45)
    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    @Basic
    @Column(name = "image3", nullable = true, length = 45)
    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    @Basic
    @Column(name = "record1", nullable = true, length = 45)
    public String getRecord1() {
        return record1;
    }

    public void setRecord1(String record1) {
        this.record1 = record1;
    }

    @Basic
    @Column(name = "record2", nullable = true, length = 45)
    public String getRecord2() {
        return record2;
    }

    public void setRecord2(String record2) {
        this.record2 = record2;
    }

    @Basic
    @Column(name = "record3", nullable = true, length = 45)
    public String getRecord3() {
        return record3;
    }

    public void setRecord3(String record3) {
        this.record3 = record3;
    }

    @Basic
    @Column(name = "from", nullable = true, length = 45)
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Basic
    @Column(name = "to", nullable = true, length = 45)
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Templet templet = (Templet) o;
        return
                Objects.equals(name, templet.name) &&
                        Objects.equals(test1, templet.test1) &&
                        Objects.equals(test2, templet.test2) &&
                        Objects.equals(test3, templet.test3) &&
                        Objects.equals(image1, templet.image1) &&
                        Objects.equals(image2, templet.image2) &&
                        Objects.equals(image3, templet.image3) &&
                        Objects.equals(record1, templet.record1) &&
                        Objects.equals(record2, templet.record2) &&
                        Objects.equals(record3, templet.record3) &&
                        Objects.equals(from, templet.from) &&
                        Objects.equals(to, templet.to);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, test1, test2, test3, image1, image2, image3, record1, record2, record3, from, to);
    }
}
