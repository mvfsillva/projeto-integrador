package org.doando.session;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.doando.entity.UserEntity;

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

    public UserEntity getLoggedInUser() {
        return (UserEntity) getAttribute("loggedInUser");
    }

    public void setLoggedInUser(UserEntity user) {
        setAttribute("loggedInUser", user);
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