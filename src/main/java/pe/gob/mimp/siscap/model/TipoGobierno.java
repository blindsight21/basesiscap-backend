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
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "TIPO_GOBIERNO")
public class TipoGobierno implements Serializable {
    @OneToMany(mappedBy = "nidTipoGobierno", fetch = FetchType.LAZY)
    private List<Gobierno> gobiernoList;

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SQ_TIPO_GOBIERNO", sequenceName = "SQ_TIPO_GOBIERNO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_GOBIERNO")
    @Column(name = "NID_TIPO_GOBIERNO")
    private BigDecimal nidTipoGobierno;

    @Column(name = "TXT_TIPO_GOBIERNO")
    private String txtTipoGobierno;

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

    public TipoGobierno() {
    }

    public TipoGobierno(BigDecimal nidTipoGobierno) {
        this.nidTipoGobierno = nidTipoGobierno;
    }

    public BigDecimal getNidTipoGobierno() {
        return nidTipoGobierno;
    }

    public void setNidTipoGobierno(BigDecimal nidTipoGobierno) {
        this.nidTipoGobierno = nidTipoGobierno;
    }

    public String getTxtTipoGobierno() {
        return txtTipoGobierno;
    }

    public void setTxtTipoGobierno(String txtTipoGobierno) {
        this.txtTipoGobierno = txtTipoGobierno;
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
        hash += (nidTipoGobierno != null ? nidTipoGobierno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoGobierno)) {
            return false;
        }
        TipoGobierno other = (TipoGobierno) object;
        if ((this.nidTipoGobierno == null && other.nidTipoGobierno != null) || (this.nidTipoGobierno != null && !this.nidTipoGobierno.equals(other.nidTipoGobierno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.TipoGobierno[ nidTipoGobierno=" + nidTipoGobierno + " ]";
    }

    @XmlTransient
    public List<Gobierno> getGobiernoList() {
        return gobiernoList;
    }

    public void setGobiernoList(List<Gobierno> gobiernoList) {
        this.gobiernoList = gobiernoList;
    }

}
