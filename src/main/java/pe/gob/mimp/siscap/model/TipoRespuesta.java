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
@Table(name = "TIPO_RESPUESTA")

public class TipoRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_TIPO_RESPUESTA", sequenceName = "SQ_TIPO_RESPUESTA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_RESPUESTA")
    @Column(name = "NID_TIPO_RESPUESTA")
    private BigDecimal nidTipoRespuesta;

    @Column(name = "TXT_TIPO_RESPUESTA")
    private String txtTipoRespuesta;

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

    @Column(name = "NOTA_MIN")
    private BigInteger notaMin;

    public TipoRespuesta() {
    }

    public TipoRespuesta(BigDecimal nidTipoRespuesta) {
        this.nidTipoRespuesta = nidTipoRespuesta;
    }

    public BigDecimal getNidTipoRespuesta() {
        return nidTipoRespuesta;
    }

    public void setNidTipoRespuesta(BigDecimal nidTipoRespuesta) {
        this.nidTipoRespuesta = nidTipoRespuesta;
    }

    public String getTxtTipoRespuesta() {
        return txtTipoRespuesta;
    }

    public void setTxtTipoRespuesta(String txtTipoRespuesta) {
        this.txtTipoRespuesta = txtTipoRespuesta;
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

    public BigInteger getNotaMin() {
        return notaMin;
    }

    public void setNotaMin(BigInteger notaMin) {
        this.notaMin = notaMin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidTipoRespuesta != null ? nidTipoRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRespuesta)) {
            return false;
        }
        TipoRespuesta other = (TipoRespuesta) object;
        if ((this.nidTipoRespuesta == null && other.nidTipoRespuesta != null) || (this.nidTipoRespuesta != null && !this.nidTipoRespuesta.equals(other.nidTipoRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.TipoRespuesta[ nidTipoRespuesta=" + nidTipoRespuesta + " ]";
    }

}
