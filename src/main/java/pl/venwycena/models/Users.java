/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.venwycena.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author k.skowronski
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUId", query = "SELECT u FROM Users u WHERE u.uId = :uId"),
    @NamedQuery(name = "Users.findByULogin", query = "SELECT u FROM Users u WHERE u.uLogin = :uLogin"),
    @NamedQuery(name = "Users.findByUPassword", query = "SELECT u FROM Users u WHERE u.uPassword = :uPassword"),
    @NamedQuery(name = "Users.findByUMail", query = "SELECT u FROM Users u WHERE u.uMail = :uMail")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "u_id")
    private Integer uId;
    @Size(max = 100)
    @Column(name = "u_login")
    private String uLogin;
    @Size(max = 200)
    @Column(name = "u_password")
    private String uPassword;
    @Size(max = 200)
    @Column(name = "u_mail")
    private String uMail;
    @Size(max = 200)
    @Column(name = "u_imie")
    private String uImie;
    @Size(max = 200)
    @Column(name = "u_nazwisko")
    private String uNazwisko;
     @Size(max = 200)
    @Column(name = "u_aktywny")
    private String uAktywny;

    public Users() {
    }

    public Users(Integer uId) {
        this.uId = uId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getULogin() {
        return uLogin;
    }

    public void setULogin(String uLogin) {
        this.uLogin = uLogin;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getUMail() {
        return uMail;
    }

    public void setUMail(String uMail) {
        this.uMail = uMail;
    }

    public String getuImie() {
        return uImie;
    }

    public void setuImie(String uImie) {
        this.uImie = uImie;
    }

    public String getuNazwisko() {
        return uNazwisko;
    }

    public void setuNazwisko(String uNazwisko) {
        this.uNazwisko = uNazwisko;
    }

    public String getuAktywny() {
        return uAktywny;
    }

    public void setuAktywny(String uAktywny) {
        this.uAktywny = uAktywny;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.venwycena.Users[ uId=" + uId + " ]";
    }
    
}
