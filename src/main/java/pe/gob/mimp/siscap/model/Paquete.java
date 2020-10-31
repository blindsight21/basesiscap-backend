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
@Table(name = "PAQUETE")
public class Paquete implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_PAQUETE", sequenceName = "SQ_PAQUETE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PAQUETE")
    @Column(name = "NID_PAQUETE")
    private BigDecimal nidPaquete;

    @Column(name = "TXT_PAQUETE")
    private String txtPaquete;

    @Column(name = "FEC_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIni;

    @Column(name = "FEC_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin;

    @Column(name = "NID_ESTADO_PAQUETE")
    private BigInteger nidEstadoPaquete;

    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistro;

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

    public Paquete() {
    }

    public Paquete(BigDecimal nidPaquete) {
        this.nidPaquete = nidPaquete;
    }

    public BigDecimal getNidPaquete() {
        return nidPaquete;
    }

    public void setNidPaquete(BigDecimal nidPaquete) {
        this.nidPaquete = nidPaquete;
    }

    public String getTxtPaquete() {
        return txtPaquete;
    }

    public void setTxtPaquete(String txtPaquete) {
        this.txtPaquete = txtPaquete;
    }

    public Date getFecIni() {
        return fecIni;
    }

    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public BigInteger getNidEstadoPaquete() {
        return nidEstadoPaquete;
    }

    public void setNidEstadoPaquete(BigInteger nidEstadoPaquete) {
        this.nidEstadoPaquete = nidEstadoPaquete;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
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
        hash += (nidPaquete != null ? nidPaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paquete)) {
            return false;
        }
        Paquete other = (Paquete) object;
        if ((this.nidPaquete == null && other.nidPaquete != null) || (this.nidPaquete != null && !this.nidPaquete.equals(other.nidPaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.Paquete[ nidPaquete=" + nidPaquete + " ]";
    }

}
