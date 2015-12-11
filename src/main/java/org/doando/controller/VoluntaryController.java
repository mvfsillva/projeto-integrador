package org.doando.controller;

import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.doando.appService.VoluntaryApplicationService;
import org.doando.entity.VoluntaryEntity;

/**
 *
 * @author arthur
 */

@ManagedBean(name = "voluntaryController")
@ViewScoped
public class VoluntaryController {
    
    private VoluntaryApplicationService voluntaryAppService;
    private VoluntaryEntity voluntary;
    private List<VoluntaryEntity> voluntaries;

    public VoluntaryController() {
        this.voluntaryAppService = new VoluntaryApplicationService();
        this.voluntary = new VoluntaryEntity();
    }

    public VoluntaryEntity getVoluntary() {
        return voluntary;
    }

    public void setVoluntary(VoluntaryEntity voluntary) {
        this.voluntary = voluntary;
    }

    public List<VoluntaryEntity> getVoluntaries() {
        if(voluntaries == null){
            this.voluntaries = voluntaryAppService.find();
        }
        return voluntaries;
    }

    public void setVoluntaries(List<VoluntaryEntity> voluntaries) {
        this.voluntaries = voluntaries;
    }
    
    public void clear (){
        this.voluntary = null;
    }
    
    public String save() {
        voluntaryAppService.save(voluntary);
        clear ();
        return "/voluntary/voluntary.xhtml?faces-redirect=true";
    }
    
    public String delete (String name){
        VoluntaryEntity v = voluntaryAppService.find(name);
        voluntaryAppService.delete(v);
        return "/voluntary/voluntary.xhtml?faces-redirect=true";
    }
    
}
