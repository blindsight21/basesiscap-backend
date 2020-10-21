/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "GOBIERNO")

public class Gobierno implements Serializable {

    @OneToMany(mappedBy = "nidGobierno", fetch = FetchType.LAZY)
    private List<ActividadGob> actividadGobList;

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SQ_GOBIERNO", sequenceName = "SQ_GOBIERNO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GOBIERNO")
    @Column(name = "NID_GOBIERNO")
    private BigDecimal nidGobierno;

    @Column(name = "TXT_GOBIERNO")
    private String txtGobierno;

    @JoinColumn(name = "NID_TIPO_GOBIERNO", referencedColumnName = "NID_TIPO_GOBIERNO")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoGobierno nidTipoGobierno;

    @Column(name = "NID_DISTRITO")
    private BigInteger nidDistrito;

    @Column(name = "TXT_WEB")
    private String txtWeb;

    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;

    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;

    @Column(name = "TXT_PC")
    private String txtPc;

    @Column(name = "TXT_IP")
    private String txtIp;

    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;

    @Transient
    private BigDecimal nidDepartamento;

    @Transient
    private BigDecimal nidProvincia;

    public Gobierno() {
    }

    public Gobierno(BigDecimal nidGobierno) {
        this.nidGobierno = nidGobierno;
    }

    public BigDecimal getNidGobierno() {
        return nidGobierno;
    }

    public void setNidGobierno(BigDecimal nidGobierno) {
        this.nidGobierno = nidGobierno;
    }

    public String getTxtGobierno() {
        return txtGobierno;
    }

    public void setTxtGobierno(String txtGobierno) {
        this.txtGobierno = txtGobierno;
    }

    public String getTxtWeb() {
        return txtWeb;
    }

    public void setTxtWeb(String txtWeb) {
        this.txtWeb = txtWeb;
    }

    public BigInteger getFlgActivo() {
        return flgActivo;
    }

    public void setFlgActivo(BigInteger flgActivo) {
        this.flgActivo = flgActivo;
    }

    public BigInteger getNidUsuario() {
        return nidUsuario;
    }

    public void setNidUsuario(BigInteger nidUsuario) {
        this.nidUsuario = nidUsuario;
    }

    public String getTxtPc() {
        return txtPc;
    }

    public void setTxtPc(String txtPc) {
        this.txtPc = txtPc;
    }

    public String getTxtIp() {
        return txtIp;
    }

    public void setTxtIp(String txtIp) {
        this.txtIp = txtIp;
    }

    public Date getFecEdicion() {
        return fecEdicion;
    }

    public void setFecEdicion(Date fecEdicion) {
        this.fecEdicion = fecEdicion;
    }

    public BigInteger getNidDistrito() {
        return nidDistrito;
    }

    public void setNidDistrito(BigInteger nidDistrito) {
        this.nidDistrito = nidDistrito;
    }

    public TipoGobierno getNidTipoGobierno() {
        return nidTipoGobierno;
    }

    public void setNidTipoGobierno(TipoGobierno nidTipoGobierno) {
        this.nidTipoGobierno = nidTipoGobierno;
    }

    public BigDecimal getNidDepartamento() {
        return nidDepartamento;
    }

    public void setNidDepartamento(BigDecimal nidDepartamento) {
        this.nidDepartamento = nidDepartamento;
    }

    public BigDecimal getNidProvincia() {
        return nidProvincia;
    }

    public void setNidProvincia(BigDecimal nidProvincia) {
        this.nidProvincia = nidProvincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidGobierno != null ? nidGobierno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gobierno)) {
            return false;
        }
        Gobierno other = (Gobierno) object;
        if ((this.nidGobierno == null && other.nidGobierno != null) || (this.nidGobierno != null && !this.nidGobierno.equals(other.nidGobierno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.Gobierno[ nidGobierno=" + nidGobierno + " ]";
    }

    @XmlTransient
    public List<ActividadGob> getActividadGobList() {
        return actividadGobList;
    }

    public void setActividadGobList(List<ActividadGob> actividadGobList) {
        this.actividadGobList = actividadGobList;
    }

}
