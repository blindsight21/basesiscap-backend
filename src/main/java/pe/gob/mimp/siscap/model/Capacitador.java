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
@Table(name = "CAPACITADOR")
public class Capacitador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SQ_CAPACITADOR", sequenceName = "SQ_CAPACITADOR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CAPACITADOR")
    @Column(name = "NID_CAPACITADOR")
    private BigDecimal nidCapacitador;

    @Column(name = "FEC_CAPACITACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCapacitacion;

    @Column(name = "TXT_OBSERVACION")
    private String txtObservacion;

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

    @JoinColumn(name = "NID_ACTIVIDAD_GOB", referencedColumnName = "NID_ACTIVIDAD_GOB")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActividadGob nidActividadGob;

    public Capacitador() {
    }

    public Capacitador(BigDecimal nidCapacitador) {
        this.nidCapacitador = nidCapacitador;
    }

    public BigDecimal getNidCapacitador() {
        return nidCapacitador;
    }

    public void setNidCapacitador(BigDecimal nidCapacitador) {
        this.nidCapacitador = nidCapacitador;
    }

    public Date getFecCapacitacion() {
        return fecCapacitacion;
    }

    public void setFecCapacitacion(Date fecCapacitacion) {
        this.fecCapacitacion = fecCapacitacion;
    }

    public String getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(String txtObservacion) {
        this.txtObservacion = txtObservacion;
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

    public ActividadGob getNidActividadGob() {
        return nidActividadGob;
    }

    public void setNidActividadGob(ActividadGob nidActividadGob) {
        this.nidActividadGob = nidActividadGob;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidCapacitador != null ? nidCapacitador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacitador)) {
            return false;
        }
        Capacitador other = (Capacitador) object;
        if ((this.nidCapacitador == null && other.nidCapacitador != null) || (this.nidCapacitador != null && !this.nidCapacitador.equals(other.nidCapacitador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.Capacitador[ nidCapacitador=" + nidCapacitador + " ]";
    }

}
