package org.doando.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author arthur.hage
 */
@Entity
@Table(name = "tb_event", schema = "public")
public class EventsEntity implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1369634611898263707L;

	@Id
    @Column(name = "id_event", nullable = false, unique = true)
    @SequenceGenerator(name = "id_event_sq", sequenceName = "sq_event_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_event_sq")
    private Integer id;
    
    @Column(name="event_name", nullable = false)
    private String name;
        
    @Column(name = "event_locality", nullable = false)
    private String locality;
    
    @Column(name = "event_description")
    private String description;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "event_date", nullable = false, length = 10)
    private Date date;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="ong_id", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    private OngEntity ong;

    public EventsEntity() {
    }

    public EventsEntity(String name, String locality, String description, Date date) {
        this.name = name;
        this.locality = locality;
        this.description = description;
        this.date = date;
    }

    public EventsEntity(String name, String locality, String description, Date date, OngEntity ong) {
        this.name = name;
        this.locality = locality;
        this.description = description;
        this.date = date;
        this.ong = ong;
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
    
    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OngEntity getOng() {
        return ong;
    }

    public void setOng(OngEntity ong) {
        this.ong = ong;
    }
    
}
