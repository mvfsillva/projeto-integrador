package org.doando.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.doando.appService.NecessityApplicationService;
import org.doando.entity.NecessityEntity;
import org.doando.session.SessionContext;

/**
 *
 * @author arthur
 */

@ManagedBean(name="necessityController")
@SessionScoped
public class NecessityController implements Serializable{
    
    public static final long serialVersionUID = 0L;
    
    private String ong;
    private String email;
    private NecessityEntity necessity;
    private List<NecessityEntity> necessities;
    private boolean loggedIn;
    private NecessityApplicationService necessityAppService;

    public NecessityController() {
        this.necessity = new NecessityEntity();
        this.necessityAppService = new NecessityApplicationService();
        this.loggedIn = false;
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
        if(loggedIn){
            necessity.setOngName(ong);
            necessity.setEmailOng(email);
            necessityAppService.update(necessity);
        }else{
            necessity.setOngName(ong);
            necessity.setEmailOng(email);
            necessityAppService.save(necessity);
        }
        init();
        clear();
        return "/donation/donation.xhtml?faces-redirect=true";
    }
    
    public String teste(NecessityEntity entity) throws IOException{
        this.necessity = necessityAppService.find(entity.getOngName());
        if (this.necessity != null) {
            this.loggedIn = true;
            this.necessity.getTitle();
            this.necessity.getPriority();
            this.necessity.getDescription();
            this.necessity.getDate();
        }
        return "/donation/config.donation.xhtml?faces-redirect=true";
    }
    
    public void init(){
        this.necessities = necessityAppService.find();
    }
    
    public String delete(NecessityEntity e) {
        NecessityEntity necessityToDelete = necessityAppService.find(e.getOngName());
        necessityAppService.delete(necessityToDelete);
        return "/donation/donation.xhtml?faces-redirect=true";
    }
    
}
