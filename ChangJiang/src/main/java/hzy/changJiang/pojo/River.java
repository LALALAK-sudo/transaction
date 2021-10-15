package hzy.changJiang.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "river")
public class River implements Serializable {
    @Id
    @Column(name = "id")
    Integer id;
    @Column(name = "code")
    String code;

    @Override
    public String toString() {
        return "River{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", startLongitude=" + startLongitude +
                ", startLatitude=" + startLatitude +
                ", endLongitude=" + endLongitude +
                ", endLatitude=" + endLatitude +
                ", RiverLong=" + RiverLong +
                '}';
    }

    @Column(name = "name")
    String name;
    @Column(name = "startLongitude")
    Float startLongitude;
    @Column(name = "startLatitude")
    Float startLatitude;
    @Column(name = "endLongitude")
    Float endLongitude;
    @Column(name = "endLatitude")
    Float endLatitude;
    @Column(name = "RiverLong")
    Integer RiverLong;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(Float startLongitude) {
        this.startLongitude = startLongitude;
    }

    public Float getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(Float startLatitude) {
        this.startLatitude = startLatitude;
    }

    public Float getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(Float endLongitude) {
        this.endLongitude = endLongitude;
    }

    public Float getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(Float endLatitude) {
        this.endLatitude = endLatitude;
    }

    public int getRiverLong() {
        return RiverLong;
    }

    public void setRiverLong(int riverLong) {
        RiverLong = riverLong;
    }
}
