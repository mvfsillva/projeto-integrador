package org.doando.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.doando.appService.IApplicationService;
import org.doando.appService.OngApplicationService;
import org.doando.entity.OngEntity;
import org.doando.session.SessionContext;

/**
 *
 * @author yago
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1543771079988155504L;
	
	private OngEntity user;
    private OngApplicationService ongAppService;
    
    private String externalTextForLoggedInUser;
    
    public LoginController() {
        this.user = new OngEntity();
        this.ongAppService = new OngApplicationService();
        initLoggedInOng();
    }
    
    private void initLoggedInOng() {
    	OngEntity loggedEntity = getLoggedInOng();
        if(loggedEntity == null) {
        	externalTextForLoggedInUser = "Login";
        } else {
        	externalTextForLoggedInUser = loggedEntity.getName();
        }
    }
    
    public OngEntity getLoggedInOng() {
        return SessionContext.getInstance().getLoggedInOng();
    }

    private IApplicationService<OngEntity, Integer> getOngApplicationService() {
        return ongAppService;
    }
    
    public String doLogin() {
        try {
            OngEntity userLoginResult = ((OngApplicationService) getOngApplicationService()).tryToLogin(user.getEmail(), user.getPassword());
            if (userLoginResult == null) {
                invalidateSession();
                return "/security/login.xhtml?faces-redirect=true";
            }
            setSessionContextAttribute(userLoginResult);
            initLoggedInOng();
            return "/index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            invalidateSession();
            e.printStackTrace();
            return "/security/login.xhtml?faces-redirect=true";
        }
    }

	private void setSessionContextAttribute(OngEntity userLoginResult) {
		SessionContext.getInstance().setAttribute(OngEntity.LOGGED_IN_USER, userLoginResult);
	}

	private void invalidateSession() {
		FacesContext.getCurrentInstance().validationFailed();
	}

    
    public String doLogout() {
        SessionContext.getInstance().endSession();
        return "/security/login.xhtml?faces-redirect=true";
    }

//    public void solicitarNovaSenha() {
//        try {
//            getOngBO().gerarNovaSenha(login, email);
//        } catch (BOException e) {
//            FacesContext.getCurrentInstance().validationFailed();
//        }
//    }

    public OngEntity getOng() {
        return user;
    }

    public void setOng(OngEntity user) {
        this.user = user;
    }

	public String getExternalTextForLoggedInUser() {
		return externalTextForLoggedInUser;
	}

	public void setExternalTextForLoggedInUser(String externalTextForLoggedInUser) {
		this.externalTextForLoggedInUser = externalTextForLoggedInUser;
	}

}
