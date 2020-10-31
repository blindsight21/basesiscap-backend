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
@Table(name = "DIRECCION_GOBIERNO")
public class DireccionGobierno implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_DIRECCION_GOBIERNO", sequenceName = "SQ_DIRECCION_GOBIERNO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DIRECCION_GOBIERNO")
    @Column(name = "NID_DIRECCION_GOBIERNO")
    private BigDecimal nidDireccionGobierno;

    @Column(name = "NID_DISTRITO")
    private BigInteger nidDistrito;

    @Column(name = "NUM_LATITUD")
    private BigInteger numLatitud;

    @Column(name = "NUM_LONGITUD")
    private BigInteger numLongitud;

    @Column(name = "NID_VIA")
    private BigInteger nidVia;

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

    @JoinColumn(name = "NID_GOBIERNO", referencedColumnName = "NID_GOBIERNO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Gobierno nidGobierno;

    public DireccionGobierno() {
    }

    public DireccionGobierno(BigDecimal nidDireccionGobierno) {
        this.nidDireccionGobierno = nidDireccionGobierno;
    }

    public BigDecimal getNidDireccionGobierno() {
        return nidDireccionGobierno;
    }

    public void setNidDireccionGobierno(BigDecimal nidDireccionGobierno) {
        this.nidDireccionGobierno = nidDireccionGobierno;
    }

    public BigInteger getNidDistrito() {
        return nidDistrito;
    }

    public void setNidDistrito(BigInteger nidDistrito) {
        this.nidDistrito = nidDistrito;
    }

    public BigInteger getNumLatitud() {
        return numLatitud;
    }

    public void setNumLatitud(BigInteger numLatitud) {
        this.numLatitud = numLatitud;
    }

    public BigInteger getNumLongitud() {
        return numLongitud;
    }

    public void setNumLongitud(BigInteger numLongitud) {
        this.numLongitud = numLongitud;
    }

    public BigInteger getNidVia() {
        return nidVia;
    }

    public void setNidVia(BigInteger nidVia) {
        this.nidVia = nidVia;
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

    public Gobierno getNidGobierno() {
        return nidGobierno;
    }

    public void setNidGobierno(Gobierno nidGobierno) {
        this.nidGobierno = nidGobierno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidDireccionGobierno != null ? nidDireccionGobierno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionGobierno)) {
            return false;
        }
        DireccionGobierno other = (DireccionGobierno) object;
        if ((this.nidDireccionGobierno == null && other.nidDireccionGobierno != null) || (this.nidDireccionGobierno != null && !this.nidDireccionGobierno.equals(other.nidDireccionGobierno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.DireccionGobierno[ nidDireccionGobierno=" + nidDireccionGobierno + " ]";
    }

}
