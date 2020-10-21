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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "PROGRAMACION_FECHA")

public class ProgramacionFecha implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_PROGRAMACION_FECHA", sequenceName = "SQ_PROGRAMACION_FECHA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROGRAMACION_FECHA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_PROGRAMACION_FECHA")
    private BigDecimal nidProgramacionFecha;
    @Column(name = "TXT_ANIO")
    private String txtAnio;
    @Column(name = "NUM_TRIMESTRE")
    private BigInteger numTrimestre;
    @Column(name = "FEC_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicio;
    @Column(name = "FEC_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin;
    @Column(name = "NID_TIPO_ACTIVIDAD")
    private BigInteger nidTipoActividad;
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

    public ProgramacionFecha() {
    }

    public ProgramacionFecha(BigDecimal nidProgramacionFecha) {
        this.nidProgramacionFecha = nidProgramacionFecha;
    }

    public BigDecimal getNidProgramacionFecha() {
        return nidProgramacionFecha;
    }

    public void setNidProgramacionFecha(BigDecimal nidProgramacionFecha) {
        this.nidProgramacionFecha = nidProgramacionFecha;
    }

    public String getTxtAnio() {
        return txtAnio;
    }

    public void setTxtAnio(String txtAnio) {
        this.txtAnio = txtAnio;
    }

    public BigInteger getNumTrimestre() {
        return numTrimestre;
    }

    public void setNumTrimestre(BigInteger numTrimestre) {
        this.numTrimestre = numTrimestre;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public BigInteger getNidTipoActividad() {
        return nidTipoActividad;
    }

    public void setNidTipoActividad(BigInteger nidTipoActividad) {
        this.nidTipoActividad = nidTipoActividad;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidProgramacionFecha != null ? nidProgramacionFecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramacionFecha)) {
            return false;
        }
        ProgramacionFecha other = (ProgramacionFecha) object;
        if ((this.nidProgramacionFecha == null && other.nidProgramacionFecha != null) || (this.nidProgramacionFecha != null && !this.nidProgramacionFecha.equals(other.nidProgramacionFecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.ProgramacionFecha[ nidProgFecha=" + nidProgramacionFecha + " ]";
    }
    
}
