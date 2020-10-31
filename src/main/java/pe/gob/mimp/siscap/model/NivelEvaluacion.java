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
@Table(name = "NIVEL_EVALUACION")
public class NivelEvaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_NIVEL_EVALUACION", sequenceName = "SQ_NIVEL_EVALUACION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_NIVEL_EVALUACION")
    @Column(name = "NID_NIVEL_EVALUACION")
    private BigDecimal nidNivelEvaluacion;

    @Column(name = "TXT_NIVEL_EVALUACION")
    private String txtNivelEvaluacion;

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

    @JoinColumn(name = "NID_TIPO_EVALUACION", referencedColumnName = "NID_TIPO_EVALUACION")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoEvaluacion nidTipoEvaluacion;

    public NivelEvaluacion() {
    }

    public NivelEvaluacion(BigDecimal nidNivelEvaluacion) {
        this.nidNivelEvaluacion = nidNivelEvaluacion;
    }

    public BigDecimal getNidNivelEvaluacion() {
        return nidNivelEvaluacion;
    }

    public void setNidNivelEvaluacion(BigDecimal nidNivelEvaluacion) {
        this.nidNivelEvaluacion = nidNivelEvaluacion;
    }

    public String getTxtNivelEvaluacion() {
        return txtNivelEvaluacion;
    }

    public void setTxtNivelEvaluacion(String txtNivelEvaluacion) {
        this.txtNivelEvaluacion = txtNivelEvaluacion;
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

    public TipoEvaluacion getNidTipoEvaluacion() {
        return nidTipoEvaluacion;
    }

    public void setNidTipoEvaluacion(TipoEvaluacion nidTipoEvaluacion) {
        this.nidTipoEvaluacion = nidTipoEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidNivelEvaluacion != null ? nidNivelEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelEvaluacion)) {
            return false;
        }
        NivelEvaluacion other = (NivelEvaluacion) object;
        if ((this.nidNivelEvaluacion == null && other.nidNivelEvaluacion != null) || (this.nidNivelEvaluacion != null && !this.nidNivelEvaluacion.equals(other.nidNivelEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.NivelEvaluacion[ nidNivelEvaluacion=" + nidNivelEvaluacion + " ]";
    }

}
