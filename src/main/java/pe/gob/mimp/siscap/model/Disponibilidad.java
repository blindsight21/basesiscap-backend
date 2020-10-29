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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "DISPONIBILIDAD")
public class Disponibilidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SQ_DISPONIBILIDAD", sequenceName = "SQ_DISPONIBILIDAD", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DISPONIBILIDAD")
    @Column(name = "NID_DISPONIBILIDAD")
    private BigDecimal nidDisponibilidad;

    @Column(name = "NID_FUNCIONALIDAD")
    private BigInteger nidFuncionalidad;

    @Column(name = "FLG_DISPONIBILIDAD")
    private BigDecimal flgDisponibilidad;

    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;

    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;

    @Column(name = "TXT_PC")
    private String txtPc;

    @Column(name = "TXT_IP")
    private String txtIp;

    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistro;

    public Disponibilidad() {
    }

    public Disponibilidad(BigDecimal nidDisponibilidad) {
        this.nidDisponibilidad = nidDisponibilidad;
    }

    public BigDecimal getNidDisponibilidad() {
        return nidDisponibilidad;
    }

    public void setNidDisponibilidad(BigDecimal nidDisponibilidad) {
        this.nidDisponibilidad = nidDisponibilidad;
    }

    public BigInteger getNidFuncionalidad() {
        return nidFuncionalidad;
    }

    public void setNidFuncionalidad(BigInteger nidFuncionalidad) {
        this.nidFuncionalidad = nidFuncionalidad;
    }

    public BigDecimal getFlgDisponibilidad() {
        return flgDisponibilidad;
    }

    public void setFlgDisponibilidad(BigDecimal flgDisponibilidad) {
        this.flgDisponibilidad = flgDisponibilidad;
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

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidDisponibilidad != null ? nidDisponibilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disponibilidad)) {
            return false;
        }
        Disponibilidad other = (Disponibilidad) object;
        if ((this.nidDisponibilidad == null && other.nidDisponibilidad != null) || (this.nidDisponibilidad != null && !this.nidDisponibilidad.equals(other.nidDisponibilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.Disponibilidad[ nidDisponibilidad=" + nidDisponibilidad + " ]";
    }

}
