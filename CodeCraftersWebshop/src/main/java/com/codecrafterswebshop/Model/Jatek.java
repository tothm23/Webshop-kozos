package com.codecrafterswebshop.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tothm23
 */
@Entity
@Table(name = "jatek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jatek.findAll", query = "SELECT j FROM Jatek j"),
    @NamedQuery(name = "Jatek.findById", query = "SELECT j FROM Jatek j WHERE j.id = :id"),
    @NamedQuery(name = "Jatek.findByNev", query = "SELECT j FROM Jatek j WHERE j.nev = :nev"),
    @NamedQuery(name = "Jatek.findByAr", query = "SELECT j FROM Jatek j WHERE j.ar = :ar"),
    @NamedQuery(name = "Jatek.findByKep", query = "SELECT j FROM Jatek j WHERE j.kep = :kep"),
    @NamedQuery(name = "Jatek.findByKorhatar", query = "SELECT j FROM Jatek j WHERE j.korhatar = :korhatar"),
    @NamedQuery(name = "Jatek.findByAkcio", query = "SELECT j FROM Jatek j WHERE j.akcio = :akcio"),
    @NamedQuery(name = "Jatek.findByMennyisegraktaron", query = "SELECT j FROM Jatek j WHERE j.mennyisegraktaron = :mennyisegraktaron"),
    @NamedQuery(name = "Jatek.findByKategoriaId", query = "SELECT j FROM Jatek j WHERE j.kategoriaId = :kategoriaId"),
    @NamedQuery(name = "Jatek.findByEszkozId", query = "SELECT j FROM Jatek j WHERE j.eszkozId = :eszkozId"),
    @NamedQuery(name = "Jatek.findByPlatformId", query = "SELECT j FROM Jatek j WHERE j.platformId = :platformId"),
    @NamedQuery(name = "Jatek.findByLetrehozva", query = "SELECT j FROM Jatek j WHERE j.letrehozva = :letrehozva"),
    @NamedQuery(name = "Jatek.findByFrissitve", query = "SELECT j FROM Jatek j WHERE j.frissitve = :frissitve")})
public class Jatek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nev")
    private String nev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ar")
    private int ar;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "leiras")
    private String leiras;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "kep")
    private String kep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "korhatar")
    private String korhatar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "akcio")
    private int akcio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mennyisegraktaron")
    private int mennyisegraktaron;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kategoriaId")
    private int kategoriaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eszkozId")
    private int eszkozId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "platformId")
    private int platformId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "letrehozva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date letrehozva;
    @Column(name = "frissitve")
    @Temporal(TemporalType.TIMESTAMP)
    private Date frissitve;

    public Jatek() {
    }

    public Jatek(Integer id) {
        this.id = id;
    }

    public Jatek(Integer id, String nev, int ar, String leiras, String kep, String korhatar, int akcio, int mennyisegraktaron, int kategoriaId, int eszkozId, int platformId, Date letrehozva) {
        this.id = id;
        this.nev = nev;
        this.ar = ar;
        this.leiras = leiras;
        this.kep = kep;
        this.korhatar = korhatar;
        this.akcio = akcio;
        this.mennyisegraktaron = mennyisegraktaron;
        this.kategoriaId = kategoriaId;
        this.eszkozId = eszkozId;
        this.platformId = platformId;
        this.letrehozva = letrehozva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getKep() {
        return kep;
    }

    public void setKep(String kep) {
        this.kep = kep;
    }

    public String getKorhatar() {
        return korhatar;
    }

    public void setKorhatar(String korhatar) {
        this.korhatar = korhatar;
    }

    public int getAkcio() {
        return akcio;
    }

    public void setAkcio(int akcio) {
        this.akcio = akcio;
    }

    public int getMennyisegraktaron() {
        return mennyisegraktaron;
    }

    public void setMennyisegraktaron(int mennyisegraktaron) {
        this.mennyisegraktaron = mennyisegraktaron;
    }

    public int getKategoriaId() {
        return kategoriaId;
    }

    public void setKategoriaId(int kategoriaId) {
        this.kategoriaId = kategoriaId;
    }

    public int getEszkozId() {
        return eszkozId;
    }

    public void setEszkozId(int eszkozId) {
        this.eszkozId = eszkozId;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public Date getLetrehozva() {
        return letrehozva;
    }

    public void setLetrehozva(Date letrehozva) {
        this.letrehozva = letrehozva;
    }

    public Date getFrissitve() {
        return frissitve;
    }

    public void setFrissitve(Date frissitve) {
        this.frissitve = frissitve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jatek)) {
            return false;
        }
        Jatek other = (Jatek) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.codecrafterswebshop.Model.Jatek[ id=" + id + " ]";
    }

}