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
@Table(name = "ESTADO_ACTIVIDAD_GOB")
public class EstadoActividadGob implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SQ_ESTADO_ACTIVIDAD_GOB", sequenceName = "SQ_ESTADO_ACTIVIDAD_GOB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTADO_ACTIVIDAD_GOB")
    @Column(name = "NID_ESTADO_ACTIVIDAD_GOB")
    private BigDecimal nidEstadoActividadGob;

    @Column(name = "TXT_ESTADO_ACTIVIDAD_GOB")
    private String txtEstadoActividadGob;

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

    public EstadoActividadGob() {
    }

    public EstadoActividadGob(BigDecimal nidEstadoActividadGob) {
        this.nidEstadoActividadGob = nidEstadoActividadGob;
    }

    public BigDecimal getNidEstadoActividadGob() {
        return nidEstadoActividadGob;
    }

    public void setNidEstadoActividadGob(BigDecimal nidEstadoActividadGob) {
        this.nidEstadoActividadGob = nidEstadoActividadGob;
    }

    public String getTxtEstadoActividadGob() {
        return txtEstadoActividadGob;
    }

    public void setTxtEstadoActividadGob(String txtEstadoActividadGob) {
        this.txtEstadoActividadGob = txtEstadoActividadGob;
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
        hash += (nidEstadoActividadGob != null ? nidEstadoActividadGob.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoActividadGob)) {
            return false;
        }
        EstadoActividadGob other = (EstadoActividadGob) object;
        if ((this.nidEstadoActividadGob == null && other.nidEstadoActividadGob != null) || (this.nidEstadoActividadGob != null && !this.nidEstadoActividadGob.equals(other.nidEstadoActividadGob))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.EstadoActividadGob[ nidEstadoActividadGob=" + nidEstadoActividadGob + " ]";
    }

}
