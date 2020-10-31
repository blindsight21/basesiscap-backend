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
import javax.validation.constraints.NotNull;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "TIPO_EVALUACION")

public class TipoEvaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_TIPO_EVALUACION", sequenceName = "SQ_TIPO_EVALUACION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_EVALUACION")
    @NotNull
    @Column(name = "NID_TIPO_EVALUACION")
    private BigDecimal nidTipoEvaluacion;

    @Column(name = "TXT_TIPO_EVALUACION")
    private String txtTipoEvaluacion;

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

    public TipoEvaluacion() {
    }

    public TipoEvaluacion(BigDecimal nidTipoEvaluacion) {
        this.nidTipoEvaluacion = nidTipoEvaluacion;
    }

    public BigDecimal getNidTipoEvaluacion() {
        return nidTipoEvaluacion;
    }

    public void setNidTipoEvaluacion(BigDecimal nidTipoEvaluacion) {
        this.nidTipoEvaluacion = nidTipoEvaluacion;
    }

    public String getTxtTipoEvaluacion() {
        return txtTipoEvaluacion;
    }

    public void setTxtTipoEvaluacion(String txtTipoEvaluacion) {
        this.txtTipoEvaluacion = txtTipoEvaluacion;
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
        hash += (nidTipoEvaluacion != null ? nidTipoEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvaluacion)) {
            return false;
        }
        TipoEvaluacion other = (TipoEvaluacion) object;
        if ((this.nidTipoEvaluacion == null && other.nidTipoEvaluacion != null) || (this.nidTipoEvaluacion != null && !this.nidTipoEvaluacion.equals(other.nidTipoEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.TipoEvaluacion[ nidTipoEvaluacion=" + nidTipoEvaluacion + " ]";
    }

}
