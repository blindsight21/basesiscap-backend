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
@Table(name = "TELEFONO_PERSONA_SISCAP")

public class TelefonoPersonaSiscap implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_TELEFONO_PERSONA_SISCAP", sequenceName = "SQ_TELEFONO_PERSONA_SISCAP", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TELEFONO_PERSONA_SISCAP")
    @Column(name = "NID_TELEFONO_PERSONA_SISCAP")
    private BigDecimal nidTelefonoPersonaSiscap;

    @Column(name = "TXT_TELEFONO_PERSONA_SISCAP")
    private String txtTelefonoPersonaSiscap;

    @Column(name = "NID_TIPO_TELEFONO")
    private BigInteger nidTipoTelefono;

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

    @Column(name = "TXT_ANEXO")
    private String txtAnexo;

    @JoinColumn(name = "NID_PERSONA_SISCAP", referencedColumnName = "NID_PERSONA_SISCAP")
    @ManyToOne(fetch = FetchType.LAZY)
    private PersonaSiscap nidPersonaSiscap;

    public TelefonoPersonaSiscap() {
    }

    public TelefonoPersonaSiscap(BigDecimal nidTelefonoPersonaSiscap) {
        this.nidTelefonoPersonaSiscap = nidTelefonoPersonaSiscap;
    }

    public BigDecimal getNidTelefonoPersonaSiscap() {
        return nidTelefonoPersonaSiscap;
    }

    public void setNidTelefonoPersonaSiscap(BigDecimal nidTelefonoPersonaSiscap) {
        this.nidTelefonoPersonaSiscap = nidTelefonoPersonaSiscap;
    }

    public String getTxtTelefonoPersonaSiscap() {
        return txtTelefonoPersonaSiscap;
    }

    public void setTxtTelefonoPersonaSiscap(String txtTelefonoPersonaSiscap) {
        this.txtTelefonoPersonaSiscap = txtTelefonoPersonaSiscap;
    }

    public BigInteger getNidTipoTelefono() {
        return nidTipoTelefono;
    }

    public void setNidTipoTelefono(BigInteger nidTipoTelefono) {
        this.nidTipoTelefono = nidTipoTelefono;
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

    public String getTxtAnexo() {
        return txtAnexo;
    }

    public void setTxtAnexo(String txtAnexo) {
        this.txtAnexo = txtAnexo;
    }

    public PersonaSiscap getNidPersonaSiscap() {
        return nidPersonaSiscap;
    }

    public void setNidPersonaSiscap(PersonaSiscap nidPersonaSiscap) {
        this.nidPersonaSiscap = nidPersonaSiscap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidTelefonoPersonaSiscap != null ? nidTelefonoPersonaSiscap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonoPersonaSiscap)) {
            return false;
        }
        TelefonoPersonaSiscap other = (TelefonoPersonaSiscap) object;
        if ((this.nidTelefonoPersonaSiscap == null && other.nidTelefonoPersonaSiscap != null) || (this.nidTelefonoPersonaSiscap != null && !this.nidTelefonoPersonaSiscap.equals(other.nidTelefonoPersonaSiscap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.TelefonoPersonaSiscap[ nidTelefonoPersonaSiscap=" + nidTelefonoPersonaSiscap + " ]";
    }

}
