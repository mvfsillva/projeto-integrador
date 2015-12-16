package org.doando.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.doando.appService.EventsApplicationService;
import org.doando.entity.EventsEntity;
import org.doando.session.SessionContext;

/**
 *
 * @author arthur
 */
@ManagedBean(name="eventsController")
@ViewScoped
public class EventsController implements Serializable{
    
    public static final long serialVersionUID = 0L;
    
    private String ong;
    private String email;
    private EventsEntity event;
    private List<EventsEntity> events;
    private EventsApplicationService eventsAppService;

    public EventsController() {
        this.event = new EventsEntity();
        this.eventsAppService = new EventsApplicationService();
        init();
    }

    public EventsEntity getEvent() {
        return event;
    }

    public void setEvent(EventsEntity event) {
        this.event = event;
    }

    public List<EventsEntity> getEvents() {
        return events;
    }

    public void setEvents(List<EventsEntity> events) {
        this.events = events;
    }
    
    public void clear(){
        this.event = new EventsEntity();
    }
    
    public String save(){
        ong = SessionContext.getInstance().getLoggedInOng().getName();
        email =  SessionContext.getInstance().getLoggedInOng().getEmail();
        event.setOngName(ong);
        event.setEmailOng(email);
        eventsAppService.save(event);
        init();
        clear();
        return "/event/event.xhtml?faces-redirect=true";
    }
    
    public void init (){
        this.events = eventsAppService.find();
    }
    
    public String teste(EventsEntity entity) throws IOException{
        this.event = eventsAppService.find(entity.getName());
        if (this.event != null) {
            this.event.getName();
            this.event.getDescription();
            this.event.getLocality();
            this.event.getDate();
        }
        return "/event/config.event.xhtml?faces-redirect=true";
    }
    
    public String delete(EventsEntity e) {
        EventsEntity eventToDelete = eventsAppService.find(e.getName());
        eventsAppService.delete(eventToDelete);
        return "/event/event.xhtml?faces-redirect=true";
    }
      
    public String cancel(){
        return "/event/event.xhtml?faces-redirect=true";
    }
    
}
