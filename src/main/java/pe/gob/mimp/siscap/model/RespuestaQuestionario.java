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
@Table(name = "RESPUESTA_QUESTIONARIO")
public class RespuestaQuestionario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_RESPUESTA_QUESTIONARIO", sequenceName = "SQ_RESPUESTA_QUESTIONARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RESPUESTA_QUESTIONARIO")
    @Column(name = "NID_RESPUESTA_QUESTIONARIO")
    private BigDecimal nidRespuestaQuestionario;

    @Column(name = "TXT_RESPUESTA")
    private String txtRespuesta;

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

    @Column(name = "NUM_NOTA")
    private BigInteger numNota;

    @Column(name = "NUM_ORDEN")
    private BigInteger numOrden;

    @JoinColumn(name = "NID_QUESTIONARIO", referencedColumnName = "NID_QUESTIONARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Questionario nidQuestionario;

    public RespuestaQuestionario() {
    }

    public RespuestaQuestionario(BigDecimal nidRespuestaQuestionario) {
        this.nidRespuestaQuestionario = nidRespuestaQuestionario;
    }

    public BigDecimal getNidRespuestaQuestionario() {
        return nidRespuestaQuestionario;
    }

    public void setNidRespuestaQuestionario(BigDecimal nidRespuestaQuestionario) {
        this.nidRespuestaQuestionario = nidRespuestaQuestionario;
    }

    public String getTxtRespuesta() {
        return txtRespuesta;
    }

    public void setTxtRespuesta(String txtRespuesta) {
        this.txtRespuesta = txtRespuesta;
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

    public BigInteger getNumNota() {
        return numNota;
    }

    public void setNumNota(BigInteger numNota) {
        this.numNota = numNota;
    }

    public BigInteger getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(BigInteger numOrden) {
        this.numOrden = numOrden;
    }

    public Questionario getNidQuestionario() {
        return nidQuestionario;
    }

    public void setNidQuestionario(Questionario nidQuestionario) {
        this.nidQuestionario = nidQuestionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidRespuestaQuestionario != null ? nidRespuestaQuestionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespuestaQuestionario)) {
            return false;
        }
        RespuestaQuestionario other = (RespuestaQuestionario) object;
        if ((this.nidRespuestaQuestionario == null && other.nidRespuestaQuestionario != null) || (this.nidRespuestaQuestionario != null && !this.nidRespuestaQuestionario.equals(other.nidRespuestaQuestionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.RespuestaQuestionario[ nidRespuestaQuestionario=" + nidRespuestaQuestionario + " ]";
    }

}
