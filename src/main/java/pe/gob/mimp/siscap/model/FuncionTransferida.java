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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "FUNCION_TRANSFERIDA")
public class FuncionTransferida implements Serializable {
    @OneToMany(mappedBy = "nidFuncionTransferida", fetch = FetchType.LAZY)
    private List<ActividadGob> actividadGobList;

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SQ_FUNCION_TRANSFERIDA", sequenceName = "SQ_FUNCION_TRANSFERIDA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FUNCION_TRANSFERIDA")
    @Column(name = "NID_FUNCION_TRANSFERIDA")
    private BigDecimal nidFuncionTransferida;

    @Column(name = "TXT_FUNCION_TRANSFERIDA")
    private String txtFuncionTransferida;

    @Column(name = "TXT_FUNCION_TRANFERIDA_DES")
    private String txtFuncionTranferidaDes;

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

    @JoinColumn(name = "NID_TIPO_FUNCION", referencedColumnName = "NID_TIPO_FUNCION")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoFuncion nidTipoFuncion;

    public FuncionTransferida() {
    }

    public FuncionTransferida(BigDecimal nidFuncionTransferida) {
        this.nidFuncionTransferida = nidFuncionTransferida;
    }

    public FuncionTransferida(BigDecimal nidFuncionTransferida, String txtFuncionTransferida) {
        this.nidFuncionTransferida = nidFuncionTransferida;
        this.txtFuncionTransferida = txtFuncionTransferida;
    }

    public BigDecimal getNidFuncionTransferida() {
        return nidFuncionTransferida;
    }

    public void setNidFuncionTransferida(BigDecimal nidFuncionTransferida) {
        this.nidFuncionTransferida = nidFuncionTransferida;
    }

    public String getTxtFuncionTransferida() {
        return txtFuncionTransferida;
    }

    public void setTxtFuncionTransferida(String txtFuncionTransferida) {
        this.txtFuncionTransferida = txtFuncionTransferida;
    }

    public String getTxtFuncionTranferidaDes() {
        return txtFuncionTranferidaDes;
    }

    public void setTxtFuncionTranferidaDes(String txtFuncionTranferidaDes) {
        this.txtFuncionTranferidaDes = txtFuncionTranferidaDes;
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

    public TipoFuncion getNidTipoFuncion() {
        return nidTipoFuncion;
    }

    public void setNidTipoFuncion(TipoFuncion nidTipoFuncion) {
        this.nidTipoFuncion = nidTipoFuncion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidFuncionTransferida != null ? nidFuncionTransferida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionTransferida)) {
            return false;
        }
        FuncionTransferida other = (FuncionTransferida) object;
        if ((this.nidFuncionTransferida == null && other.nidFuncionTransferida != null) || (this.nidFuncionTransferida != null && !this.nidFuncionTransferida.equals(other.nidFuncionTransferida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.FuncionTransferida[ nidFuncionTransferida=" + nidFuncionTransferida + " ]";
    }

    @XmlTransient
    public List<ActividadGob> getActividadGobList() {
        return actividadGobList;
    }

    public void setActividadGobList(List<ActividadGob> actividadGobList) {
        this.actividadGobList = actividadGobList;
    }

}
