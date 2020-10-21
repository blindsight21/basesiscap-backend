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
@Table(name = "ACTIVIDAD_GOB_PUBLI_PROC")
public class ActividadGobPubliProc implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "SQ_ACTIVIDAD_GOB_PUBLI_PROC", sequenceName = "SQ_ACTIVIDAD_GOB_PUBLI_PROC", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACTIVIDAD_GOB_PUBLI_PROC")
    @Column(name = "NID_ACTIVIDAD_GOB_PROC_GOB")
    private BigDecimal nidActividadGobProcGob;
    
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
    
    @JoinColumn(name = "NID_ACTIVIDAD_GOBIERNO", referencedColumnName = "NID_ACTIVIDAD_GOB")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActividadGob nidActividadGob;

    public ActividadGobPubliProc() {
    }

    public ActividadGobPubliProc(BigDecimal nidActividadGobProcGob) {
        this.nidActividadGobProcGob = nidActividadGobProcGob;
    }

    public BigDecimal getNidActividadGobProcGob() {
        return nidActividadGobProcGob;
    }

    public void setNidActividadGobProcGob(BigDecimal nidActividadGobProcGob) {
        this.nidActividadGobProcGob = nidActividadGobProcGob;
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

    public ActividadGob getNidActividadGob() {
        return nidActividadGob;
    }

    public void setNidActividadGob(ActividadGob nidActividadGob) {
        this.nidActividadGob = nidActividadGob;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidActividadGobProcGob != null ? nidActividadGobProcGob.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadGobPubliProc)) {
            return false;
        }
        ActividadGobPubliProc other = (ActividadGobPubliProc) object;
        if ((this.nidActividadGobProcGob == null && other.nidActividadGobProcGob != null) || (this.nidActividadGobProcGob != null && !this.nidActividadGobProcGob.equals(other.nidActividadGobProcGob))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.ActividadGobPubliProc[ nidActividadGobProcGob=" + nidActividadGobProcGob + " ]";
    }

}
