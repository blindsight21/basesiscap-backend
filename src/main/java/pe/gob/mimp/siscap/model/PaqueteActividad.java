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
@Table(name = "PAQUETE_ACTIVIDAD")
public class PaqueteActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_PAQUETE_ACTIVIDAD", sequenceName = "SQ_PAQUETE_ACTIVIDAD", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PAQUETE_ACTIVIDAD")
    @Column(name = "NID_PAQUETE_ACTIVIDAD")
    private BigDecimal nidPaqueteActividad;

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

    @JoinColumn(name = "NID_PAQUETE", referencedColumnName = "NID_PAQUETE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Paquete nidPaquete;

    @JoinColumn(name = "NID_ACTIVIDAD_GOB", referencedColumnName = "NID_ACTIVIDAD_GOB")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActividadGob nidActividadGob;

    public PaqueteActividad() {
    }

    public PaqueteActividad(BigDecimal nidPaqueteActividad) {
        this.nidPaqueteActividad = nidPaqueteActividad;
    }

    public BigDecimal getNidPaqueteActividad() {
        return nidPaqueteActividad;
    }

    public void setNidPaqueteActividad(BigDecimal nidPaqueteActividad) {
        this.nidPaqueteActividad = nidPaqueteActividad;
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

    public Paquete getNidPaquete() {
        return nidPaquete;
    }

    public void setNidPaquete(Paquete nidPaquete) {
        this.nidPaquete = nidPaquete;
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
        hash += (nidPaqueteActividad != null ? nidPaqueteActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaqueteActividad)) {
            return false;
        }
        PaqueteActividad other = (PaqueteActividad) object;
        if ((this.nidPaqueteActividad == null && other.nidPaqueteActividad != null) || (this.nidPaqueteActividad != null && !this.nidPaqueteActividad.equals(other.nidPaqueteActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.PaqueteActividad[ nidPaqueteActividad=" + nidPaqueteActividad + " ]";
    }

}
