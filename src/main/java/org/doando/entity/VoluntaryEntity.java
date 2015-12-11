package org.doando.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author arthur
 */
@Entity
@Table(name="tb_voluntary", schema="public")
public class VoluntaryEntity implements Serializable{
    
    public static final long serialVersionUID = 0L;
    
    @Id
    @Column(name="id_voluntary", nullable = false, unique = true)
    @SequenceGenerator(name = "id_voluntary_sq", sequenceName = "sq_voluntary_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_voluntary_sq")
    private Integer id;
    
    @Column(name="voluntary_name", nullable = false ,length = 150)
    private String name;
    
    @Column(name="voluntary_sex", nullable = false, length = 50)
    private String sex;
    
    @Column(name="voluntary_email", nullable = false, length = 150)
    private String email;
    
    @Column(name="voluntary_phone", nullable = false, length = 50)
    private String phone;
    
    @Column(name="voluntary_availability", nullable = false, length = 50)
    private String availability;
    
    @Column(name="voluntary_state")
    private String state;
    
    @Column(name="voluntary_city")
    private String city;
    
    @Column(name="voluntary_interest")
    private String interest;

    public VoluntaryEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
    
}
