package hzy.changJiang.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "outFall")
public class OutFall implements Serializable {
    @Id
    Integer id;
    @Column(name = "code")
    String code;
    @Column(name =  "name")
    String name;
    @Column(name = "longitude")
    String longitude;
    @Column(name = "latitude")
    String latitude;
    @Column(name =  "numbers")
    Integer numbers;
    @Column(name =  "isIntake")
    Integer isIntake;

    public OutFall() {
    }

    @Column(name = "river_id")
    Integer riverId;


//    public OutFall(OutFall outFall) {
//        id = outFall.getId();
//        code = outFall.getCode();
//        name = outFall.getName();
//        longitude = outFall.getLongitude();
//        latitude = outFall.getLatitude();
//        numbers = outFall.getNumbers();
//        isIntake = outFall.getIsIntake();
//        riverId = outFall.getRiverId();
//    }

    @Override
    public String toString() {
        return "OutFall{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", numbers=" + numbers +
                ", isIntake=" + isIntake +
                ", riverId='" + riverId + '\'' +
                '}';
    }

    public Integer getRiverId() {
        return riverId;
    }

    public void setRiverId(Integer riverId) {
        this.riverId = riverId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    public Integer getIsIntake() {
        return isIntake;
    }

    public void setIsIntake(Integer isIntake) {
        this.isIntake = isIntake;
    }
}
