package org.doando.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.doando.appService.NecessityApplicationService;
import org.doando.entity.NecessityEntity;
import org.doando.session.SessionContext;

/**
 *
 * @author arthur
 */

@ManagedBean(name="necessityController")
@ViewScoped
public class NecessityController implements Serializable{
    
    public static final long serialVersionUID = 0L;
    
    private String ong;
    private String email;
    private NecessityEntity necessity;
    private List<NecessityEntity> necessities;
    private NecessityApplicationService necessityAppService;

    public NecessityController() {
        this.necessity = new NecessityEntity();
        this.necessityAppService = new NecessityApplicationService();
        init();
    }
    
    public NecessityEntity getNecessity() {
        return necessity;
    }

    public void setNecessity(NecessityEntity necessity) {
        this.necessity = necessity;
    }

    public List<NecessityEntity> getNecessities() {
        return necessities;
    }

    public void setNecessities(List<NecessityEntity> necessities) {
        this.necessities = necessities;
    }
    
    public void clear(){
        this.necessity = new NecessityEntity();
    }
    
    public String save (){
        ong = SessionContext.getInstance().getLoggedInOng().getName();
        email = SessionContext.getInstance().getLoggedInOng().getEmail();
        necessity.setOngName(ong);
        necessity.setEmailOng(email);
        necessityAppService.save(necessity);
        init();
        clear();
        return "/donation/donation.xhtml?faces-redirect=true";
    }
    
    public void init(){
        this.necessities = necessityAppService.find();
    }
    
    public String cancel(){
        return "/donation/donation.xhtml?faces-redirect=true";
    }
    
}
