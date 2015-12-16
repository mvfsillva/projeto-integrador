package org.doando.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.doando.appService.NecessityApplicationService;
import org.doando.appService.OngApplicationService;
import org.doando.entity.NecessityEntity;
import org.doando.entity.OngEntity;
import org.doando.session.SessionContext;

/**
 *
 * @author arthur
 */

@ManagedBean(name="necessityController")
@ViewScoped
public class NecessityController implements Serializable{
    
    public static final long serialVersionUID = 0L;
    
    private OngEntity ong;
    private NecessityEntity necessity;
    private List<NecessityEntity> necessities;
    private NecessityApplicationService necessityAppService;
    private OngApplicationService ongAppService;

    public NecessityController() {
        this.necessity = new NecessityEntity();
        this.necessityAppService = new NecessityApplicationService();
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
        ong = SessionContext.getInstance().getLoggedInOng();
        ong.getNecessities().add(necessity);
        ongAppService.save(ong);
        clear();
        return "/donation/donation.xhtml?faces-redirect=true";
    }
    
    
}
