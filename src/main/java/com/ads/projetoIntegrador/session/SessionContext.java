/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.session;

import com.ads.projetoIntegrador.dto.UserDTO;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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

    public UserDTO getLoggedInUser() {
        return (UserDTO) getAttribute("loggedInUser");
    }

    public void setLoggedInUser(UserDTO user) {
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
