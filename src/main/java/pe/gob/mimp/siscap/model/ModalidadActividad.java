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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "MODALIDAD_ACTIVIDAD")
public class ModalidadActividad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SQ_MODALIDAD_ACTIVIDAD", sequenceName = "SQ_MODALIDAD_ACTIVIDAD", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MODALIDAD_ACTIVIDAD")
    @NotNull
    @Column(name = "NID_MODALIDAD_ACTIVIDAD")
    private BigDecimal nidModalidadActividad;
//    @Size(max = 128)
    @Column(name = "TXT_MODALIDAD_ACTIVIDAD")
    private String txtModalidadActividad;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;
//    @Size(max = 50)
    @Column(name = "TXT_PC")
    private String txtPc;
//    @Size(max = 20)
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;
    @OneToMany(mappedBy = "nidModalidadActividad", fetch = FetchType.LAZY)
    private List<ActividadGob> actividadGobList;

    public ModalidadActividad() {
    }

    public ModalidadActividad(BigDecimal nidModalidadActividad) {
        this.nidModalidadActividad = nidModalidadActividad;
    }

    public BigDecimal getNidModalidadActividad() {
        return nidModalidadActividad;
    }

    public void setNidModalidadActividad(BigDecimal nidModalidadActividad) {
        this.nidModalidadActividad = nidModalidadActividad;
    }

    public String getTxtModalidadActividad() {
        return txtModalidadActividad;
    }

    public void setTxtModalidadActividad(String txtModalidadActividad) {
        this.txtModalidadActividad = txtModalidadActividad;
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

    @XmlTransient
    public List<ActividadGob> getActividadGobList() {
        return actividadGobList;
    }

    public void setActividadGobList(List<ActividadGob> actividadGobList) {
        this.actividadGobList = actividadGobList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidModalidadActividad != null ? nidModalidadActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModalidadActividad)) {
            return false;
        }
        ModalidadActividad other = (ModalidadActividad) object;
        if ((this.nidModalidadActividad == null && other.nidModalidadActividad != null) || (this.nidModalidadActividad != null && !this.nidModalidadActividad.equals(other.nidModalidadActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.ModalidadActividad[ nidModalidadActividad=" + nidModalidadActividad + " ]";
    }

}
