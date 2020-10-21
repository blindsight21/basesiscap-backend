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
import javax.persistence.Transient;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "ACTIVIDAD_GOB_RESULTADO")
public class ActividadGobResultado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SQ_ACTIVIDAD_GOB_RESULTADO", sequenceName = "SQ_ACTIVIDAD_GOB_RESULTADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACTIVIDAD_GOB_RESULTADO")
    @Column(name = "NID_ACTIVIDAD_GOB_RESULTADO")
    private BigDecimal nidActividadGobResultado;

    @Column(name = "TXT_ACTIVIDAD_GOB_RESULTADO")
    private String txtActividadGobResultado;

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

    @JoinColumn(name = "NID_NIVEL_EVALUACION", referencedColumnName = "NID_NIVEL_EVALUACION")
    @ManyToOne(fetch = FetchType.LAZY)
    private NivelEvaluacion nidNivelEvaluacion;

    @JoinColumn(name = "NID_ACTIVIDAD_GOB", referencedColumnName = "NID_ACTIVIDAD_GOB")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActividadGob nidActividadGob;

    @Transient
    private BigDecimal nidTipoEvaluacion;

    public ActividadGobResultado() {
    }

    public ActividadGobResultado(BigDecimal nidActividadGobResultado) {
        this.nidActividadGobResultado = nidActividadGobResultado;
    }

    public BigDecimal getNidActividadGobResultado() {
        return nidActividadGobResultado;
    }

    public void setNidActividadGobResultado(BigDecimal nidActividadGobResultado) {
        this.nidActividadGobResultado = nidActividadGobResultado;
    }

    public String getTxtActividadGobResultado() {
        return txtActividadGobResultado;
    }

    public void setTxtActividadGobResultado(String txtActividadGobResultado) {
        this.txtActividadGobResultado = txtActividadGobResultado;
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

    public NivelEvaluacion getNidNivelEvaluacion() {
        return nidNivelEvaluacion;
    }

    public void setNidNivelEvaluacion(NivelEvaluacion nidNivelEvaluacion) {
        this.nidNivelEvaluacion = nidNivelEvaluacion;
    }

    public ActividadGob getNidActividadGob() {
        return nidActividadGob;
    }

    public void setNidActividadGob(ActividadGob nidActividadGob) {
        this.nidActividadGob = nidActividadGob;
    }

    public BigDecimal getNidTipoEvaluacion() {
        return nidTipoEvaluacion;
    }

    public void setNidTipoEvaluacion(BigDecimal nidTipoEvaluacion) {
        this.nidTipoEvaluacion = nidTipoEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidActividadGobResultado != null ? nidActividadGobResultado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadGobResultado)) {
            return false;
        }
        ActividadGobResultado other = (ActividadGobResultado) object;
        if ((this.nidActividadGobResultado == null && other.nidActividadGobResultado != null) || (this.nidActividadGobResultado != null && !this.nidActividadGobResultado.equals(other.nidActividadGobResultado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.ActividadGobResultado[ nidActividadGobResultado=" + nidActividadGobResultado + " ]";
    }

}
