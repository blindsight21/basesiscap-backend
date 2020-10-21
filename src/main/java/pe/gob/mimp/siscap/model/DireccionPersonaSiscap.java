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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "DIRECCION_PERSONA_SISCAP")
public class DireccionPersonaSiscap implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Mx(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_DIRECCION_PERSONA_SISCAP", sequenceName = "SQ_DIRECCION_PERSONA_SISCAP", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DIRECCION_PERSONA_SISCAP")
    @Column(name = "NID_DIRECCION_PERSONA_SISCAP")
    private BigDecimal nidDireccionPersonaSiscap;

    @Column(name = "NID_VIA")
    private BigInteger nidVia;

    @Column(name = "NID_DISTRITO")
    private BigInteger nidDistrito;

    @Column(name = "NID_LUGAR")
    private BigInteger nidLugar;

    @Column(name = "TXT_LUGAR")
    private String txtLugar;

    @Column(name = "TXT_DIRECCION")
    private String txtDireccion;

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

    @JoinColumn(name = "NID_PERSONA_SISCAP", referencedColumnName = "NID_PERSONA_SISCAP")
    @ManyToOne(fetch = FetchType.LAZY)
    private PersonaSiscap nidPersonaSiscap;

    public DireccionPersonaSiscap() {
    }

    public DireccionPersonaSiscap(BigDecimal nidDireccionPersonaSiscap) {
        this.nidDireccionPersonaSiscap = nidDireccionPersonaSiscap;
    }

    public DireccionPersonaSiscap(BigDecimal nidDireccionPersonaSiscap, BigInteger nidDistrito) {
        this.nidDireccionPersonaSiscap = nidDireccionPersonaSiscap;
        this.nidDistrito = nidDistrito;
    }

    public BigDecimal getNidDireccionPersonaSiscap() {
        return nidDireccionPersonaSiscap;
    }

    public void setNidDireccionPersonaSiscap(BigDecimal nidDireccionPersonaSiscap) {
        this.nidDireccionPersonaSiscap = nidDireccionPersonaSiscap;
    }

    public BigInteger getNidVia() {
        return nidVia;
    }

    public void setNidVia(BigInteger nidVia) {
        this.nidVia = nidVia;
    }

    public BigInteger getNidDistrito() {
        return nidDistrito;
    }

    public void setNidDistrito(BigInteger nidDistrito) {
        this.nidDistrito = nidDistrito;
    }

    public BigInteger getNidLugar() {
        return nidLugar;
    }

    public void setNidLugar(BigInteger nidLugar) {
        this.nidLugar = nidLugar;
    }

    public String getTxtLugar() {
        return txtLugar;
    }

    public void setTxtLugar(String txtLugar) {
        this.txtLugar = txtLugar;
    }

    public String getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(String txtDireccion) {
        this.txtDireccion = txtDireccion;
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

    public PersonaSiscap getNidPersonaSiscap() {
        return nidPersonaSiscap;
    }

    public void setNidPersonaSiscap(PersonaSiscap nidPersonaSiscap) {
        this.nidPersonaSiscap = nidPersonaSiscap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidDireccionPersonaSiscap != null ? nidDireccionPersonaSiscap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionPersonaSiscap)) {
            return false;
        }
        DireccionPersonaSiscap other = (DireccionPersonaSiscap) object;
        if ((this.nidDireccionPersonaSiscap == null && other.nidDireccionPersonaSiscap != null) || (this.nidDireccionPersonaSiscap != null && !this.nidDireccionPersonaSiscap.equals(other.nidDireccionPersonaSiscap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.DireccionPersonaSiscap[ nidDireccionPersonaSiscap=" + nidDireccionPersonaSiscap + " ]";
    }

}
