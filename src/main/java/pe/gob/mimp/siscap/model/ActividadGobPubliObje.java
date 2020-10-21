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
@Table(name = "ACTIVIDAD_GOB_PUBLI_OBJE")
public class ActividadGobPubliObje implements Serializable {
    private static final long serialVersionUID = 1L;    
    
    @Id
    @SequenceGenerator(name = "SQ_ACTIVIDAD_GOB_PUBLI_OBJE", sequenceName = "SQ_ACTIVIDAD_GOB_PUBLI_OBJE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACTIVIDAD_GOB_PUBLI_OBJE")
    @Column(name = "NID_ACTIVIDAD_GOB_PUBLI_OBJE")
    private BigDecimal nidActividadGobPubliObje;
    
    @Column(name = "NUM_CONTADOR_MARCULINO")
    private BigInteger numContadorMarculino;
    
    @Column(name = "NUM_CONTADOR_FEMENINO")
    private BigInteger numContadorFemenino;
    
    @Column(name = "NUM_CONTADOR_TOTAL")
    private BigInteger numContadorTotal;
    
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
    
    @JoinColumn(name = "NID_PUBLICO_OBJETIVO", referencedColumnName = "NID_PUBLICO_OBJETIVO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PublicoObjetivo nidPublicoObjetivo;
    
    @JoinColumn(name = "NID_ACTIVIDAD_GOB", referencedColumnName = "NID_ACTIVIDAD_GOB")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActividadGob nidActividadGob;

    public ActividadGobPubliObje() {
    }

    public ActividadGobPubliObje(BigDecimal nidActividadGobPubliObje) {
        this.nidActividadGobPubliObje = nidActividadGobPubliObje;
    }

    public BigDecimal getNidActividadGobPubliObje() {
        return nidActividadGobPubliObje;
    }

    public void setNidActividadGobPubliObje(BigDecimal nidActividadGobPubliObje) {
        this.nidActividadGobPubliObje = nidActividadGobPubliObje;
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

    public BigInteger getNumContadorMarculino() {
        return numContadorMarculino;
    }

    public void setNumContadorMarculino(BigInteger numContadorMarculino) {
        this.numContadorMarculino = numContadorMarculino;
    }

    public BigInteger getNumContadorFemenino() {
        return numContadorFemenino;
    }

    public void setNumContadorFemenino(BigInteger numContadorFemenino) {
        this.numContadorFemenino = numContadorFemenino;
    }

    public BigInteger getNumContadorTotal() {
        return numContadorTotal;
    }

    public void setNumContadorTotal(BigInteger numContadorTotal) {
        this.numContadorTotal = numContadorTotal;
    }

    public PublicoObjetivo getNidPublicoObjetivo() {
        return nidPublicoObjetivo;
    }

    public void setNidPublicoObjetivo(PublicoObjetivo nidPublicoObjetivo) {
        this.nidPublicoObjetivo = nidPublicoObjetivo;
    }

    public ActividadGob getNidActividadGob() {
        return nidActividadGob;
    }

    public void setNidActividadGob(ActividadGob nidActividadGob) {
        this.nidActividadGob = nidActividadGob;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidActividadGobPubliObje != null ? nidActividadGobPubliObje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadGobPubliObje)) {
            return false;
        }
        ActividadGobPubliObje other = (ActividadGobPubliObje) object;
        if ((this.nidActividadGobPubliObje == null && other.nidActividadGobPubliObje != null) || (this.nidActividadGobPubliObje != null && !this.nidActividadGobPubliObje.equals(other.nidActividadGobPubliObje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.ActividadGobPubliObje[ nidActividadGobPubliObje=" + nidActividadGobPubliObje + " ]";
    }
    
}
