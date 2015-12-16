package org.doando.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.doando.appService.EventsApplicationService;
import org.doando.appService.OngApplicationService;
import org.doando.entity.EventsEntity;
import org.doando.entity.OngEntity;
import org.doando.session.SessionContext;

/**
 *
 * @author arthur
 */
@ManagedBean(name="eventsController")
@ViewScoped
public class EventsController implements Serializable{
    
    public static final long serialVersionUID = 0L;
    
    private OngEntity ong;
    private EventsEntity event;
    private List<EventsEntity> events;
    private EventsApplicationService eventsAppService;
    private OngApplicationService ongAppService;

    public EventsController() {
        this.event = new EventsEntity();
        this.eventsAppService = new EventsApplicationService();
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
        ong = SessionContext.getInstance().getLoggedInOng();
        ong.getEvents().add(event);
        ongAppService.save(ong);
        clear();
        return "/event/event.xhtml?faces-redirect=true";
    }
    
}
