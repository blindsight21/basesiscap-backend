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
@Table(name = "PERSONA_SISCAP_USUARIO")
public class PersonaSiscapUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_PERSONA_SISCAP_USUARIO", sequenceName = "SQ_PERSONA_SISCAP_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERSONA_SISCAP_USUARIO")
    @Column(name = "NID_PERSONA_SISCAP_USUARIO")
    private BigDecimal nidPersonaSiscapUsuario;

    @Column(name = "NID_USUARIO2")
    private BigInteger nidUsuario2;

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

    @JoinColumn(name = "NID_PERSONA_SISCAP", referencedColumnName = "NID_PERSONA_SISCAP")
    @ManyToOne(fetch = FetchType.LAZY)
    private PersonaSiscap nidPersonaSiscap;

    public PersonaSiscapUsuario() {
    }

    public PersonaSiscapUsuario(BigDecimal nidPersonaSiscapUsuario) {
        this.nidPersonaSiscapUsuario = nidPersonaSiscapUsuario;
    }

    public BigDecimal getNidPersonaSiscapUsuario() {
        return nidPersonaSiscapUsuario;
    }

    public void setNidPersonaSiscapUsuario(BigDecimal nidPersonaSiscapUsuario) {
        this.nidPersonaSiscapUsuario = nidPersonaSiscapUsuario;
    }

    public BigInteger getNidUsuario2() {
        return nidUsuario2;
    }

    public void setNidUsuario2(BigInteger nidUsuario2) {
        this.nidUsuario2 = nidUsuario2;
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

    public PersonaSiscap getNidPersonaSiscap() {
        return nidPersonaSiscap;
    }

    public void setNidPersonaSiscap(PersonaSiscap nidPersonaSiscap) {
        this.nidPersonaSiscap = nidPersonaSiscap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidPersonaSiscapUsuario != null ? nidPersonaSiscapUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaSiscapUsuario)) {
            return false;
        }
        PersonaSiscapUsuario other = (PersonaSiscapUsuario) object;
        if ((this.nidPersonaSiscapUsuario == null && other.nidPersonaSiscapUsuario != null) || (this.nidPersonaSiscapUsuario != null && !this.nidPersonaSiscapUsuario.equals(other.nidPersonaSiscapUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.PersonaSiscapUsuario[ nidPersonaSiscapUsuario=" + nidPersonaSiscapUsuario + " ]";
    }

}
