/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "VW_ACTIVIDAD_CALENDARIO")
public class VwActividadCalendario implements Serializable {
    @Basic(optional = false)
    @NotNull

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_ACTIVIDAD_GOB")
    private BigInteger nidActividadGob;
    @Column(name = "TXT_TEMA")
    private String txtTema;
    @Column(name = "NID_AREA")
    private BigInteger nidArea;
    @Column(name = "TXT_AREA")
    private String txtArea;
    @Column(name = "TXT_SIGLA")
    private String txtSigla;
    @Column(name = "TXT_NOMBRES")
    private String txtNombres;
    @Column(name = "FEC_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicio;
    @Column(name = "FEC_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin;
    @Column(name = "NID_GOBIERNO")
    private BigInteger nidGobierno;
    @Column(name = "TXT_GOBIERNO")
    private String txtGobierno;
    @Column(name = "NID_ESTADO_ACTIVIDAD_GOB")
    private BigInteger nidEstadoActividadGob;
    @Column(name = "TXT_ESTADO_ACTIVIDAD_GOB")
    private String txtEstadoActividadGob;

    public VwActividadCalendario() {
    }

    public String getTxtTema() {
        return txtTema;
    }

    public void setTxtTema(String txtTema) {
        this.txtTema = txtTema;
    }

    public BigInteger getNidArea() {
        return nidArea;
    }

    public void setNidArea(BigInteger nidArea) {
        this.nidArea = nidArea;
    }

    public String getTxtArea() {
        return txtArea;
    }

    public void setTxtArea(String txtArea) {
        this.txtArea = txtArea;
    }

    public String getTxtSigla() {
        return txtSigla;
    }

    public void setTxtSigla(String txtSigla) {
        this.txtSigla = txtSigla;
    }
    
    public String getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(String txtNombres) {
        this.txtNombres = txtNombres;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public BigInteger getNidGobierno() {
        return nidGobierno;
    }

    public void setNidGobierno(BigInteger nidGobierno) {
        this.nidGobierno = nidGobierno;
    }

    public String getTxtGobierno() {
        return txtGobierno;
    }

    public void setTxtGobierno(String txtGobierno) {
        this.txtGobierno = txtGobierno;
    }
    
    public String getTxtEstadoActividadGob() {
        return txtEstadoActividadGob;
    }

    public void setTxtEstadoActividadGob(String txtEstadoActividadGob) {
        this.txtEstadoActividadGob = txtEstadoActividadGob;
    }

    public BigInteger getNidActividadGob() {
        return nidActividadGob;
    }

    public void setNidActividadGob(BigInteger nidActividadGob) {
        this.nidActividadGob = nidActividadGob;
    }

    public BigInteger getNidEstadoActividadGob() {
        return nidEstadoActividadGob;
    }

    public void setNidEstadoActividadGob(BigInteger nidEstadoActividadGob) {
        this.nidEstadoActividadGob = nidEstadoActividadGob;
    }

}
