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
    
    private NecessityEntity necessity;
    private List<NecessityEntity> necessities;
    private NecessityApplicationService necessityAppService;

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
    
    public String save (){
        //ong = SessionContext.getInstance().getLoggedInUser();
        //TODO currentOng.getNecessities().add(necessity);
        return "";
    }
    
}
