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
@Table(name = "FICHA_DETALLE")

public class FichaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_FICHA_DETALLE", sequenceName = "SQ_FICHA_DETALLE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FICHA_DETALLE")
    @Column(name = "NID_FICHA_DETALLE")
    private BigDecimal nidFichaDetalle;

    @Column(name = "NID_QUESTIONARIO")
    private BigInteger nidQuestionario;

    @Column(name = "TXT_FICHA_DETALLE")
    private String txtFichaDetalle;

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

    @JoinColumn(name = "NID_TIPO_RESPUESTA", referencedColumnName = "NID_TIPO_RESPUESTA")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoRespuesta nidTipoRespuesta;

    @JoinColumn(name = "NID_FICHA", referencedColumnName = "NID_FICHA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ficha nidFicha;

    public FichaDetalle() {
    }

    public FichaDetalle(BigDecimal nidFichaDetalle) {
        this.nidFichaDetalle = nidFichaDetalle;
    }

    public BigDecimal getNidFichaDetalle() {
        return nidFichaDetalle;
    }

    public void setNidFichaDetalle(BigDecimal nidFichaDetalle) {
        this.nidFichaDetalle = nidFichaDetalle;
    }

    public BigInteger getNidQuestionario() {
        return nidQuestionario;
    }

    public void setNidQuestionario(BigInteger nidQuestionario) {
        this.nidQuestionario = nidQuestionario;
    }

    public String getTxtFichaDetalle() {
        return txtFichaDetalle;
    }

    public void setTxtFichaDetalle(String txtFichaDetalle) {
        this.txtFichaDetalle = txtFichaDetalle;
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

    public TipoRespuesta getNidTipoRespuesta() {
        return nidTipoRespuesta;
    }

    public void setNidTipoRespuesta(TipoRespuesta nidTipoRespuesta) {
        this.nidTipoRespuesta = nidTipoRespuesta;
    }

    public Ficha getNidFicha() {
        return nidFicha;
    }

    public void setNidFicha(Ficha nidFicha) {
        this.nidFicha = nidFicha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidFichaDetalle != null ? nidFichaDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaDetalle)) {
            return false;
        }
        FichaDetalle other = (FichaDetalle) object;
        if ((this.nidFichaDetalle == null && other.nidFichaDetalle != null) || (this.nidFichaDetalle != null && !this.nidFichaDetalle.equals(other.nidFichaDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.FichaDetalle[ nidFichaDetalle=" + nidFichaDetalle + " ]";
    }

}
