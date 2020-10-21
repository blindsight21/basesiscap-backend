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
@Table(name = "ARCHIVO_ACTIVIDAD_GOB")
public class ArchivoActividadGob implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SQ_ARCHIVO_ACTIVIDAD_GOB", sequenceName = "SQ_ARCHIVO_ACTIVIDAD_GOB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ARCHIVO_ACTIVIDAD_GOB")
    @Column(name = "NID_ARCHIVO_ACTIVIDAD_GOB")
    private BigDecimal nidArchivoActividadGob;

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

    @Column(name = "TXT_RUTA")
    private String txtRuta;

    @JoinColumn(name = "NID_ACTIVIDAD_GOBIERNO", referencedColumnName = "NID_ACTIVIDAD_GOB")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActividadGob nidActividadGobierno;

    public ArchivoActividadGob() {
    }

    public ArchivoActividadGob(BigDecimal nidArchivoActividadGob) {
        this.nidArchivoActividadGob = nidArchivoActividadGob;
    }

    public ArchivoActividadGob(BigDecimal nidArchivoActividadGob, String txtRuta) {
        this.nidArchivoActividadGob = nidArchivoActividadGob;
        this.txtRuta = txtRuta;
    }

    public BigDecimal getNidArchivoActividadGob() {
        return nidArchivoActividadGob;
    }

    public void setNidArchivoActividadGob(BigDecimal nidArchivoActividadGob) {
        this.nidArchivoActividadGob = nidArchivoActividadGob;
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

    public String getTxtRuta() {
        return txtRuta;
    }

    public void setTxtRuta(String txtRuta) {
        this.txtRuta = txtRuta;
    }

    public ActividadGob getNidActividadGobierno() {
        return nidActividadGobierno;
    }

    public void setNidActividadGobierno(ActividadGob nidActividadGobierno) {
        this.nidActividadGobierno = nidActividadGobierno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidArchivoActividadGob != null ? nidArchivoActividadGob.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchivoActividadGob)) {
            return false;
        }
        ArchivoActividadGob other = (ArchivoActividadGob) object;
        if ((this.nidArchivoActividadGob == null && other.nidArchivoActividadGob != null) || (this.nidArchivoActividadGob != null && !this.nidArchivoActividadGob.equals(other.nidArchivoActividadGob))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.ArchivoActividadGob[ nidArchivoActividadGob=" + nidArchivoActividadGob + " ]";
    }

}
