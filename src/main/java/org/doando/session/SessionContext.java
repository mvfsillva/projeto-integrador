package org.doando.session;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.doando.entity.OngEntity;

/**
 *
 * @author yago
 */
public class SessionContext {

    private static SessionContext instance;

    public static SessionContext getInstance() {
        if (instance == null) {
            instance = new SessionContext();
        }

        return instance;
    }

    private SessionContext() {

    }

    private ExternalContext currentExternalContext() {
        if (FacesContext.getCurrentInstance() == null) {
            throw new RuntimeException("The FacesContext cannot be called outside a HTTP request");
        } else {
            return FacesContext.getCurrentInstance().getExternalContext();
        }
    }

    public OngEntity getLoggedInOng() {
        return (OngEntity) getAttribute(OngEntity.LOGGED_IN_USER);
    }

    public void setLoggedInOng(OngEntity user) {
        setAttribute(OngEntity.LOGGED_IN_USER, user);
    }

    public void endSession() {
        currentExternalContext().invalidateSession();
    }

    public Object getAttribute(String key) {
        return currentExternalContext().getSessionMap().get(key);
    }

    public void setAttribute(String key, Object value) {
        currentExternalContext().getSessionMap().put(key, value);
    }

}
