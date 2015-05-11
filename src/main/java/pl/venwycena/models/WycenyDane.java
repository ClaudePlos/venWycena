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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author k.skowronski
 */
@Entity
@Table(name = "wyceny_dane")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WycenyDane.findAll", query = "SELECT w FROM WycenyDane w"),
    @NamedQuery(name = "WycenyDane.findByDId", query = "SELECT w FROM WycenyDane w WHERE w.dId = :dId"),
    @NamedQuery(name = "WycenyDane.findByD01", query = "SELECT w FROM WycenyDane w WHERE w.d01 = :d01"),
    @NamedQuery(name = "WycenyDane.findByD02", query = "SELECT w FROM WycenyDane w WHERE w.d02 = :d02"),
    @NamedQuery(name = "WycenyDane.findByD03", query = "SELECT w FROM WycenyDane w WHERE w.d03 = :d03"),
    @NamedQuery(name = "WycenyDane.findByD04", query = "SELECT w FROM WycenyDane w WHERE w.d04 = :d04"),
    @NamedQuery(name = "WycenyDane.findByD05", query = "SELECT w FROM WycenyDane w WHERE w.d05 = :d05"),
    @NamedQuery(name = "WycenyDane.findByD06a", query = "SELECT w FROM WycenyDane w WHERE w.d06a = :d06a"),
    @NamedQuery(name = "WycenyDane.findByD06b", query = "SELECT w FROM WycenyDane w WHERE w.d06b = :d06b")})
public class WycenyDane implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "d_id")
    private Integer dId;
    @Size(max = 45)
    
    @Column(name = "d_w_id")
    private Integer dwId;
    @Size(max = 45)
    
    @Column(name = "d_01")
    private String d01;
    @Size(max = 45)
    @Column(name = "d_02")
    private String d02;
    @Size(max = 45)
    @Column(name = "d_03")
    private String d03;
    @Size(max = 45)
    @Column(name = "d_04")
    private String d04;
    @Size(max = 45)
    @Column(name = "d_05")
    private String d05;
    @Size(max = 45)
    @Column(name = "d_06a")
    private String d06a;
    @Size(max = 45)
    @Column(name = "d_06b")
    private String d06b;

    public WycenyDane() {
    }

    public WycenyDane(Integer dId) {
        this.dId = dId;
    }

    public Integer getDId() {
        return dId;
    }

    public void setDId(Integer dId) {
        this.dId = dId;
    }

    public Integer getDwId() {
        return dwId;
    }

    public void setDwId(Integer dwId) {
        this.dwId = dwId;
    }
    
  
    public String getD01() {
        return d01;
    }

    public void setD01(String d01) {
        this.d01 = d01;
    }

    public String getD02() {
        return d02;
    }

    public void setD02(String d02) {
        this.d02 = d02;
    }

    public String getD03() {
        return d03;
    }

    public void setD03(String d03) {
        this.d03 = d03;
    }

    public String getD04() {
        return d04;
    }

    public void setD04(String d04) {
        this.d04 = d04;
    }

    public String getD05() {
        return d05;
    }

    public void setD05(String d05) {
        this.d05 = d05;
    }

    public String getD06a() {
        return d06a;
    }

    public void setD06a(String d06a) {
        this.d06a = d06a;
    }

    public String getD06b() {
        return d06b;
    }

    public void setD06b(String d06b) {
        this.d06b = d06b;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dId != null ? dId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WycenyDane)) {
            return false;
        }
        WycenyDane other = (WycenyDane) object;
        if ((this.dId == null && other.dId != null) || (this.dId != null && !this.dId.equals(other.dId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.venwycena.service.WycenyDane[ dId=" + dId + " ]";
    }
    
}
