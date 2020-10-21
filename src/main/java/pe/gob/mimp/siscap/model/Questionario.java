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
@Table(name = "QUESTIONARIO")
public class Questionario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_QUESTIONARIO", sequenceName = "SQ_QUESTIONARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_QUESTIONARIO")
    @Column(name = "NID_QUESTIONARIO")
    private BigDecimal nidQuestionario;

    @Column(name = "TXT_QUESTIONARIO")
    private String txtQuestionario;

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

    @Column(name = "NUM_ORDEN")
    private BigInteger numOrden;

    public Questionario() {
    }

    public Questionario(BigDecimal nidQuestionario) {
        this.nidQuestionario = nidQuestionario;
    }

    public BigDecimal getNidQuestionario() {
        return nidQuestionario;
    }

    public void setNidQuestionario(BigDecimal nidQuestionario) {
        this.nidQuestionario = nidQuestionario;
    }

    public String getTxtQuestionario() {
        return txtQuestionario;
    }

    public void setTxtQuestionario(String txtQuestionario) {
        this.txtQuestionario = txtQuestionario;
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

    public BigInteger getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(BigInteger numOrden) {
        this.numOrden = numOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidQuestionario != null ? nidQuestionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionario)) {
            return false;
        }
        Questionario other = (Questionario) object;
        if ((this.nidQuestionario == null && other.nidQuestionario != null) || (this.nidQuestionario != null && !this.nidQuestionario.equals(other.nidQuestionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.Questionario[ nidQuestionario=" + nidQuestionario + " ]";
    }

}
