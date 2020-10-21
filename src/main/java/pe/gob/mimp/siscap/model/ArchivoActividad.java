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
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "ARCHIVO_ACTIVIDAD")

public class ArchivoActividad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_ARCHIVO_ACTIVIDAD", sequenceName = "SQ_ARCHIVO_ACTIVIDAD", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ARCHIVO_ACTIVIDAD")
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_ARCHIVO_ACTIVIDAD")
    private BigDecimal nidArchivoActividad;
    @Column(name = "TXT_ARCHIVO")
    private String txtArchivo;
    @Column(name = "TXT_URL")
    private String txtUrl;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "TXT_PC")
    private String txtPc;
    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;
    @JoinColumn(name = "NID_ACTIVIDAD_GOB", referencedColumnName = "NID_ACTIVIDAD_GOB")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActividadGob nidActividadGob;
    
    public ArchivoActividad() {
    }

    public ArchivoActividad(BigDecimal nidArchivoActividad) {
        this.nidArchivoActividad = nidArchivoActividad;
    }

    public BigDecimal getNidArchivoActividad() {
        return nidArchivoActividad;
    }

    public void setNidArchivoActividad(BigDecimal nidArchivoActividad) {
        this.nidArchivoActividad = nidArchivoActividad;
    }

    public String getTxtArchivo() {
        return txtArchivo;
    }

    public void setTxtArchivo(String txtArchivo) {
        this.txtArchivo = txtArchivo;
    }

    public String getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(String txtUrl) {
        this.txtUrl = txtUrl;
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

    public String getTxtIp() {
        return txtIp;
    }

    public void setTxtIp(String txtIp) {
        this.txtIp = txtIp;
    }

    public String getTxtPc() {
        return txtPc;
    }

    public void setTxtPc(String txtPc) {
        this.txtPc = txtPc;
    }

    public Date getFecEdicion() {
        return fecEdicion;
    }

    public void setFecEdicion(Date fecEdicion) {
        this.fecEdicion = fecEdicion;
    }
    
    public ActividadGob getNidActividadGob() {
        return nidActividadGob;
    }

    public void setNidActividadGob(ActividadGob nidActividadGob) {
        this.nidActividadGob = nidActividadGob;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidArchivoActividad != null ? nidArchivoActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchivoActividad)) {
            return false;
        }
        ArchivoActividad other = (ArchivoActividad) object;
        if ((this.nidArchivoActividad == null && other.nidArchivoActividad != null) || (this.nidArchivoActividad != null && !this.nidArchivoActividad.equals(other.nidArchivoActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.ArchivoActividad[ nidArchivoActividad=" + nidArchivoActividad + " ]";
    }
}
