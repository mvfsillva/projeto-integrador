package org.doando.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.doando.appService.VoluntaryApplicationService;
import org.doando.entity.AddressEntity;
import org.doando.entity.VoluntaryEntity;
import org.doando.utils.PostalCodeService;

/**
 *
 * @author arthur
 */
@ManagedBean(name = "voluntaryController")
@ViewScoped
public class VoluntaryController implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4873829598259678832L;

    private String cep;
    private VoluntaryApplicationService voluntaryAppService;
    private VoluntaryEntity voluntary;
    private PostalCodeService postalCodeService;
    private List<VoluntaryEntity> voluntaries;
    private AddressEntity address;

    public VoluntaryController() {
        this.voluntary = new VoluntaryEntity();
        this.postalCodeService = new PostalCodeService();
        this.voluntaryAppService = new VoluntaryApplicationService();
        init();
    }

    private void init() {
        this.voluntaries = voluntaryAppService.find();
    }

    public VoluntaryEntity getVoluntary() {
        return voluntary;
    }

    public void setVoluntary(VoluntaryEntity voluntary) {
        this.voluntary = voluntary;
    }

    public List<VoluntaryEntity> getVoluntaries() {
        return voluntaries;
    }

    public void setVoluntaries(List<VoluntaryEntity> voluntaries) {
        this.voluntaries = voluntaries;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public void clear() {
        this.voluntary = null;
    }

    public String save() {
        voluntary.setCity(address.getCity());
        voluntary.setState(address.getState());
        voluntaryAppService.save(voluntary);
        clear();
        return "/voluntary/voluntary.xhtml?faces-redirect=true";
    }

    public String delete(VoluntaryEntity v) {
        voluntaryAppService.delete(v);
        return "/voluntary/voluntary.xhtml?faces-redirect=true";
    }

    public String findCep() throws Exception {
        postalCodeService.find(cep);
        this.setAddress(postalCodeService.getAddress());
        return "";
    }
}
