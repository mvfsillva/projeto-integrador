    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.controller;

import com.ads.projetoIntegrador.business.IBusinessManager;
import com.ads.projetoIntegrador.business.UserBusiness;
import com.ads.projetoIntegrador.entity.UserEntity;
import com.ads.projetoIntegrador.session.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author yago
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {

    private UserEntity user;
    private UserBusiness bo;
    
    public LoginController() {
        this.user = new UserEntity();
    }
    
    public UserEntity getLoggedInUser() {
        return SessionContext.getInstance().getLoggedInUser();
    }

    private IBusinessManager<UserEntity, Integer> getUserBusiness() {
        if(bo == null) {
            bo = new UserBusiness();
        }
        return bo;
    }
    
    public String doLogin() {
        try {
            UserEntity userLoginResult = ((UserBusiness) getUserBusiness())
                    .tryUserLogin(user.getUsername(), user.getPassword());
            if (userLoginResult == null) {
                FacesContext.getCurrentInstance().validationFailed();
                return "";
            }
            SessionContext.getInstance().setAttribute(UserEntity.LOGGED_IN_USER, userLoginResult);
            return "/index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().validationFailed();
            e.printStackTrace();
            return "";
        }
    }

    public String doLogout() {
        SessionContext.getInstance().endSession();
        return "/security/login.xhtml?faces-redirect=true";
    }

//    public void solicitarNovaSenha() {
//        try {
//            getUserBO().gerarNovaSenha(login, email);
//        } catch (BOException e) {
//            FacesContext.getCurrentInstance().validationFailed();
//        }
//    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
