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
@Table(name = "FICHA")

public class Ficha implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_FICHA", sequenceName = "SQ_FICHA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FICHA")
    @Column(name = "NID_FICHA")
    private BigDecimal nidFicha;

    @Column(name = "NID_TIPO_RESPUESTA")
    private BigInteger nidTipoRespuesta;

    @Column(name = "TXT_FICHA")
    private String txtFicha;

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

    @Column(name = "NOTA_MIN")
    private BigInteger notaMin;

    @JoinColumn(name = "NID_GOBIERNO", referencedColumnName = "NID_GOBIERNO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Gobierno nidGobierno;

    public Ficha() {
    }

    public Ficha(BigDecimal nidFicha) {
        this.nidFicha = nidFicha;
    }

    public BigDecimal getNidFicha() {
        return nidFicha;
    }

    public void setNidFicha(BigDecimal nidFicha) {
        this.nidFicha = nidFicha;
    }

    public BigInteger getNidTipoRespuesta() {
        return nidTipoRespuesta;
    }

    public void setNidTipoRespuesta(BigInteger nidTipoRespuesta) {
        this.nidTipoRespuesta = nidTipoRespuesta;
    }

    public String getTxtFicha() {
        return txtFicha;
    }

    public void setTxtFicha(String txtFicha) {
        this.txtFicha = txtFicha;
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

    public BigInteger getNotaMin() {
        return notaMin;
    }

    public void setNotaMin(BigInteger notaMin) {
        this.notaMin = notaMin;
    }

    public Gobierno getNidGobierno() {
        return nidGobierno;
    }

    public void setNidGobierno(Gobierno nidGobierno) {
        this.nidGobierno = nidGobierno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidFicha != null ? nidFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.nidFicha == null && other.nidFicha != null) || (this.nidFicha != null && !this.nidFicha.equals(other.nidFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.Ficha[ nidFicha=" + nidFicha + " ]";
    }

}
