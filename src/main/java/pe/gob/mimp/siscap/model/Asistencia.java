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
@Table(name = "ASISTENCIA")
public class Asistencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SQ_ASISTENCIA", sequenceName = "SQ_ASISTENCIA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ASISTENCIA")
    @Column(name = "NID_ASISTENCIA")
    private BigDecimal nidAsistencia;

    @Column(name = "FEC_ASISTENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAsistencia;

    @Column(name = "NID_ACTIVIDAD_GOB")
    private BigInteger nidActividadGob;

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

    @JoinColumn(name = "NID_PARTICIPANTE", referencedColumnName = "NID_PARTICIPANTE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Participante nidParticipante;

    public Asistencia() {
    }

    public Asistencia(BigDecimal nidAsistencia) {
        this.nidAsistencia = nidAsistencia;
    }

    public BigDecimal getNidAsistencia() {
        return nidAsistencia;
    }

    public void setNidAsistencia(BigDecimal nidAsistencia) {
        this.nidAsistencia = nidAsistencia;
    }

    public Date getFecAsistencia() {
        return fecAsistencia;
    }

    public void setFecAsistencia(Date fecAsistencia) {
        this.fecAsistencia = fecAsistencia;
    }

    public BigInteger getNidActividadGob() {
        return nidActividadGob;
    }

    public void setNidActividadGob(BigInteger nidActividadGob) {
        this.nidActividadGob = nidActividadGob;
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

    public Participante getNidParticipante() {
        return nidParticipante;
    }

    public void setNidParticipante(Participante nidParticipante) {
        this.nidParticipante = nidParticipante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidAsistencia != null ? nidAsistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.nidAsistencia == null && other.nidAsistencia != null) || (this.nidAsistencia != null && !this.nidAsistencia.equals(other.nidAsistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.Asistencia[ nidAsistencia=" + nidAsistencia + " ]";
    }

}
