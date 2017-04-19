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
import org.json.JSONTokener;

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
    @Size(max = 45)
    @Column(name = "d_06c")
    private String d06c;
    @Size(max = 45)
    @Column(name = "d_06d")
    private String d06d;
    @Size(max = 45)
    @Column(name = "d_06e")
    private String d06e;
    
    @Size(max = 45)
    @Column(name = "d_07a")
    private String d07a;
    @Size(max = 45)
    @Column(name = "d_07b")
    private String d07b;
    @Size(max = 45)
    @Column(name = "d_07c")
    private String d07c;
    @Size(max = 45)
    @Column(name = "d_07d")
    private String d07d;
    @Size(max = 45)
    @Column(name = "d_07e")
    private String d07e;
    @Size(max = 45)
    @Column(name = "d_07f")
    private String d07f;
    
    @Size(max = 45)
    @Column(name = "d_08")
    private String d08;
     
    @Size(max = 45)
    @Column(name = "d_09")
    private String d09;
    
    
    @Size(max = 45)
    @Column(name = "d_10")
    private String d10;
    
    @Size(max = 45)
    @Column(name = "d_11")
    private String d11;
    
    @Size(max = 45)
    @Column(name = "d_12")
    private String d12;
    
    @Size(max = 45)
    @Column(name = "d_13")
    private String d13;
    
    @Size(max = 45)
    @Column(name = "d_14")
    private String d14;

    @Size(max = 45)
    @Column(name = "d_15")
    private String d15;
    
    @Size(max = 45)
    @Column(name = "d_16")
    private String d16;
    
    @Size(max = 45)
    @Column(name = "d_17a")
    private String d17a;
    @Size(max = 45)
    @Column(name = "d_17b")
    private String d17b;
    @Size(max = 45)
    @Column(name = "d_17c")
    private String d17c;
    @Size(max = 45)
    @Column(name = "d_17d")
    private String d17d;
    @Size(max = 45)
    @Column(name = "d_17e")
    private String d17e;
    
    @Size(max = 45)
    @Column(name = "d_18")
    private String d18;
    
    @Size(max = 45)
    @Column(name = "d_19")
    private String d19;
    
    @Size(max = 45)
    @Column(name = "d_20")
    private String d20;
    

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

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getD06c() {
        return d06c;
    }

    public void setD06c(String d06c) {
        this.d06c = d06c;
    }

    public String getD06d() {
        return d06d;
    }

    public void setD06d(String d06d) {
        this.d06d = d06d;
    }

    public String getD06e() {
        return d06e;
    }

    public void setD06e(String d06e) {
        this.d06e = d06e;
    }

    public String getD07a() {
        return d07a;
    }

    public void setD07a(String d07a) {
        this.d07a = d07a;
    }

    public String getD07b() {
        return d07b;
    }

    public void setD07b(String d07b) {
        this.d07b = d07b;
    }

    public String getD07c() {
        return d07c;
    }

    public void setD07c(String d07c) {
        this.d07c = d07c;
    }

    public String getD07d() {
        return d07d;
    }

    public void setD07d(String d07d) {
        this.d07d = d07d;
    }

    public String getD07e() {
        return d07e;
    }

    public void setD07e(String d07e) {
        this.d07e = d07e;
    }

    public String getD07f() {
        return d07f;
    }

    public void setD07f(String d07f) {
        this.d07f = d07f;
    }

    public String getD08() {
        return d08;
    }

    public void setD08(String d08) {
        this.d08 = d08;
    }

    public String getD09() {
        return d09;
    }

    public void setD09(String d09) {
        this.d09 = d09;
    }

    public String getD10() {
        return d10;
    }

    public void setD10(String d10) {
        this.d10 = d10;
    }

    public String getD11() {
        return d11;
    }

    public void setD11(String d11) {
        this.d11 = d11;
    }

    public String getD12() {
        return d12;
    }

    public void setD12(String d12) {
        this.d12 = d12;
    }

    public String getD13() {
        return d13;
    }

    public void setD13(String d13) {
        this.d13 = d13;
    }

    public String getD14() {
        return d14;
    }

    public void setD14(String d14) {
        this.d14 = d14;
    }

    public String getD15() {
        return d15;
    }

    public void setD15(String d15) {
        this.d15 = d15;
    }

    public String getD16() {
        return d16;
    }

    public void setD16(String d16) {
        this.d16 = d16;
    }

    public String getD17a() {
        return d17a;
    }

    public void setD17a(String d17a) {
        this.d17a = d17a;
    }

    public String getD17b() {
        return d17b;
    }

    public void setD17b(String d17b) {
        this.d17b = d17b;
    }

    public String getD17c() {
        return d17c;
    }

    public void setD17c(String d17c) {
        this.d17c = d17c;
    }

    public String getD17d() {
        return d17d;
    }

    public void setD17d(String d17d) {
        this.d17d = d17d;
    }

    public String getD17e() {
        return d17e;
    }

    public void setD17e(String d17e) {
        this.d17e = d17e;
    }

    public String getD18() {
        return d18;
    }

    public void setD18(String d18) {
        this.d18 = d18;
    }

    public String getD19() {
        return d19;
    }

    public void setD19(String d19) {
        this.d19 = d19;
    }

    public String getD20() {
        return d20;
    }

    public void setD20(String d20) {
        this.d20 = d20;
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
