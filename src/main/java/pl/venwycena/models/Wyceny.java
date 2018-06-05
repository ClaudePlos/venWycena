/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.venwycena.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author k.skowronski
 */
@Entity
@Table(name = "wyceny")
public class Wyceny implements Serializable {
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "w_id")
    private Integer wId;
    
    @Column(name = "w_user_id")
    private Integer wUserId;
    @Column(name = "w_data_wyceny")
    @Temporal(TemporalType.DATE)
    private Date wDataWyceny;
    @Column(name = "w_data_obowiazywania")
    @Temporal(TemporalType.DATE)
    private Date wDataObowiazywania;
    @Size(max = 200)
    @Column(name = "w_nazwa")
    private String wNazwa;
    
    @Transient
    private String mailKtoZamawia;

    public Wyceny() {
    }

    public Wyceny(Integer wId) {
        this.wId = wId;
    }

    public Integer getWId() {
        return wId;
    }

    public void setWId(Integer wId) {
        this.wId = wId;
    }

    public Integer getWUserId() {
        return wUserId;
    }

    public void setWUserId(Integer wUserId) {
        this.wUserId = wUserId;
    }

    public Date getWDataWyceny() {
        return wDataWyceny;
    }

    public void setWDataWyceny(Date wDataWyceny) {
        this.wDataWyceny = wDataWyceny;
    }

    public Date getWDataObowiazywania() {
        return wDataObowiazywania;
    }

    public void setWDataObowiazywania(Date wDataObowiazywania) {
        this.wDataObowiazywania = wDataObowiazywania;
    }

    public String getWNazwa() {
        return wNazwa;
    }

    public void setWNazwa(String wNazwa) {
        this.wNazwa = wNazwa;
    }

    public String getMailKtoZamawia() {
        return mailKtoZamawia;
    }

    public void setMailKtoZamawia(String mailKtoZamawia) {
        this.mailKtoZamawia = mailKtoZamawia;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wId != null ? wId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wyceny)) {
            return false;
        }
        Wyceny other = (Wyceny) object;
        if ((this.wId == null && other.wId != null) || (this.wId != null && !this.wId.equals(other.wId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.venwycena.models.Wyceny[ wId=" + wId + " ]";
    }
    
}
