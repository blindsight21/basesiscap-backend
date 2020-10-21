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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "PUBLICO_OBJETIVO")
public class PublicoObjetivo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "SQ_PUBLICO_OBJETIVO", sequenceName = "SQ_PUBLICO_OBJETIVO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PUBLICO_OBJETIVO")
    @NotNull
    @Column(name = "NID_PUBLICO_OBJETIVO")
    private BigDecimal nidPublicoObjetivo;
//    @Size(max = 128)
    @Column(name = "TXT_PUBLICO_OBJETIVO")
    private String txtPublicoObjetivo;
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
    @OneToMany(mappedBy = "nidPublicoObjetivo", fetch = FetchType.LAZY)
    private List<ActividadGobPubliObje> actividadGobPubliObjeList;
    @OneToMany(mappedBy = "nidPublicoObjetivo", fetch = FetchType.LAZY)
    private List<Participante> participanteList;

    

    public PublicoObjetivo() {
    }

    public PublicoObjetivo(BigDecimal nidPublicoObjetivo) {
        this.nidPublicoObjetivo = nidPublicoObjetivo;
    }

    public BigDecimal getNidPublicoObjetivo() {
        return nidPublicoObjetivo;
    }

    public void setNidPublicoObjetivo(BigDecimal nidPublicoObjetivo) {
        this.nidPublicoObjetivo = nidPublicoObjetivo;
    }

    public String getTxtPublicoObjetivo() {
        return txtPublicoObjetivo;
    }

    public void setTxtPublicoObjetivo(String txtPublicoObjetivo) {
        this.txtPublicoObjetivo = txtPublicoObjetivo;
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
    public List<ActividadGobPubliObje> getActividadGobPubliObjeList() {
        return actividadGobPubliObjeList;
    }

    public void setActividadGobPubliObjeList(List<ActividadGobPubliObje> actividadGobPubliObjeList) {
        this.actividadGobPubliObjeList = actividadGobPubliObjeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidPublicoObjetivo != null ? nidPublicoObjetivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicoObjetivo)) {
            return false;
        }
        PublicoObjetivo other = (PublicoObjetivo) object;
        if ((this.nidPublicoObjetivo == null && other.nidPublicoObjetivo != null) || (this.nidPublicoObjetivo != null && !this.nidPublicoObjetivo.equals(other.nidPublicoObjetivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.PublicoObjetivo[ nidPublicoObjetivo=" + nidPublicoObjetivo + " ]";
    }

    @XmlTransient
    public List<Participante> getParticipanteList() {
        return participanteList;
    }

    public void setParticipanteList(List<Participante> participanteList) {
        this.participanteList = participanteList;
    }

}
