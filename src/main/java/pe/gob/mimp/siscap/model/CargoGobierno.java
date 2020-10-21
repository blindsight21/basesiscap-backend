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
@Table(name = "CARGO_GOBIERNO")
public class CargoGobierno implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_CARGO_GOBIERNO", sequenceName = "SQ_CARGO_GOBIERNO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CARGO_GOBIERNO")
    @Column(name = "NID_CARGO_GOBIERNO")
    private BigDecimal nidCargoGobierno;

    @Column(name = "TXT_CARGO_GOBIERNO")
    private String txtCargoGobierno;

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

    public CargoGobierno() {
    }

    public CargoGobierno(BigDecimal nidCargoGobierno) {
        this.nidCargoGobierno = nidCargoGobierno;
    }

    public BigDecimal getNidCargoGobierno() {
        return nidCargoGobierno;
    }

    public void setNidCargoGobierno(BigDecimal nidCargoGobierno) {
        this.nidCargoGobierno = nidCargoGobierno;
    }

    public String getTxtCargoGobierno() {
        return txtCargoGobierno;
    }

    public void setTxtCargoGobierno(String txtCargoGobierno) {
        this.txtCargoGobierno = txtCargoGobierno;
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
        hash += (nidCargoGobierno != null ? nidCargoGobierno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoGobierno)) {
            return false;
        }
        CargoGobierno other = (CargoGobierno) object;
        if ((this.nidCargoGobierno == null && other.nidCargoGobierno != null) || (this.nidCargoGobierno != null && !this.nidCargoGobierno.equals(other.nidCargoGobierno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.CargoGobierno[ nidCargoGobierno=" + nidCargoGobierno + " ]";
    }

}
