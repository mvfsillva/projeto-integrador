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
    
    private boolean loggedIn;
    
    private String externalTextForLoggedInUser;
    private String externalLinkForLoggedInUser;
    private String displayText;
    
    public LoginController() {
        this.ongAppService = new OngApplicationService();
        initLoggedInOng();
    }
    
    private void initLoggedInOng() {
    	this.user = getLoggedInOng();
        if(this.user == null) {
        	loggedIn = false;
        	displayText = "block";
        	externalTextForLoggedInUser = "Login";
        	externalLinkForLoggedInUser = "/security/login.xhtml?faces-redirect=true";
            this.user = new OngEntity();
        } else {
        	loggedIn = true;
        	displayText = "none";
        	externalTextForLoggedInUser = this.user.getName();
        	externalLinkForLoggedInUser = "/ong/config.ong.xhtml?faces-redirect=true";
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

	public String getExternalLinkForLoggedInUser() {
		return externalLinkForLoggedInUser;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.loggedIn = isLoggedIn;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

}
