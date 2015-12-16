package org.doando.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 *
 * @author arthur.hage
 */

@Entity
@Table(name = "tb_necessity", schema = "public")
public class NecessityEntity implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6255015039723910221L;

	@Id
    @Column(name = "id_necessity", nullable = false, unique = true)
    @SequenceGenerator(name = "id_necessity_sq", sequenceName = "sq_necessity_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_necessity_sq")
    private Integer id;
    
    @Column(name = "necessity_description", nullable = false)
    private String description;
    
    @Column(name = "necessity_title", nullable = false)
    private String title;
    
    @Column(name = "necessity_priority", nullable = false)
    private String priority;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "necessity_date", nullable = false, length = 10)
    private Date date;
    
    @Column(name = "necessity_ongName")
    private String ongName;
    
    @Column(name = "necessity_emailOng")
    private String emailOng;

    public NecessityEntity() {
    }

    public NecessityEntity(String description, String title, String priority, Date date) {
        this.description = description;
        this.title = title;
        this.priority = priority;
        this.date = date;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOngName() {
        return ongName;
    }

    public void setOngName(String ongName) {
        this.ongName = ongName;
    }

    public String getEmailOng() {
        return emailOng;
    }

    public void setEmailOng(String emailOng) {
        this.emailOng = emailOng;
    }
    
}
