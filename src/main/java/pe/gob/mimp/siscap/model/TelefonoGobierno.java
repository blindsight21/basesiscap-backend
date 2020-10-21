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
@Table(name = "TELEFONO_GOBIERNO")
public class TelefonoGobierno implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_TELEFONO_GOBIERNO", sequenceName = "SQ_TELEFONO_GOBIERNO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TELEFONO_GOBIERNO")
    @Column(name = "NID_TELEFONO_GOBIERNO")
    private BigDecimal nidTelefonoGobierno;

    @Column(name = "NID_TIPO_TELEFONO")
    private BigInteger nidTipoTelefono;

    @Column(name = "TXT_TELEFONO")
    private String txtTelefono;

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

    public TelefonoGobierno() {
    }

    public TelefonoGobierno(BigDecimal nidTelefonoGobierno) {
        this.nidTelefonoGobierno = nidTelefonoGobierno;
    }

    public BigDecimal getNidTelefonoGobierno() {
        return nidTelefonoGobierno;
    }

    public void setNidTelefonoGobierno(BigDecimal nidTelefonoGobierno) {
        this.nidTelefonoGobierno = nidTelefonoGobierno;
    }

    public BigInteger getNidTipoTelefono() {
        return nidTipoTelefono;
    }

    public void setNidTipoTelefono(BigInteger nidTipoTelefono) {
        this.nidTipoTelefono = nidTipoTelefono;
    }

    public String getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(String txtTelefono) {
        this.txtTelefono = txtTelefono;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidTelefonoGobierno != null ? nidTelefonoGobierno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonoGobierno)) {
            return false;
        }
        TelefonoGobierno other = (TelefonoGobierno) object;
        if ((this.nidTelefonoGobierno == null && other.nidTelefonoGobierno != null) || (this.nidTelefonoGobierno != null && !this.nidTelefonoGobierno.equals(other.nidTelefonoGobierno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.TelefonoGobierno[ nidTelefonoGobierno=" + nidTelefonoGobierno + " ]";
    }

}
