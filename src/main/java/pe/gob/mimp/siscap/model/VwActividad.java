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
import javax.validation.constraints.Size;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "VW_ACTIVIDAD")
public class VwActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_ACTIVIDAD_GOB")
    private BigInteger nidActividadGob;
//    @Size(max = 2048)
    @Column(name = "TXT_OBJETIVO")
    private String txtObjetivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_TIPO_OBJETIVO")
    private BigInteger nidTipoObjetivo;
//    @Size(max = 512)
    @Column(name = "TXT_TIPO_OBJETIVO")
    private String txtTipoObjetivo;
//    @Size(max = 2048)
    @Column(name = "TXT_TEMA")
    private String txtTema;
    @Column(name = "NID_GOBIERNO")
    private BigInteger nidGobierno;
    @Column(name = "NID_ESTADO_ACTIVIDAD_GOB")
    private BigInteger nidEstadoActividadGob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_TIPO_MODALIDAD")
    private BigInteger nidTipoModalidad;
//    @Size(max = 512)
    @Column(name = "TXT_TIPO_MODALIDAD")
    private String txtTipoModalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_MODALIDAD_ACTIVIDAD")
    private BigInteger nidModalidadActividad;
//    @Size(max = 128)
    @Column(name = "TXT_MODALIDAD_ACTIVIDAD")
    private String txtModalidadActividad;
    @Column(name = "FEC_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicio;
    @Column(name = "FEC_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin;
    @Column(name = "NUM_ANIO")
    private BigInteger numAnio;
    @Column(name = "NUM_TRIMESTRE")
    private BigInteger numTrimestre;
    @Column(name = "NID_AREA")
    private BigInteger nidArea;
    @Column(name = "NID_DEPARTAMENTO")
    private BigInteger nidDepartamento;

    public VwActividad() {
    }

    public BigInteger getNidActividadGob() {
        return nidActividadGob;
    }

    public void setNidActividadGob(BigInteger nidActividadGob) {
        this.nidActividadGob = nidActividadGob;
    }

    public String getTxtObjetivo() {
        return txtObjetivo;
    }

    public void setTxtObjetivo(String txtObjetivo) {
        this.txtObjetivo = txtObjetivo;
    }

    public BigInteger getNidTipoObjetivo() {
        return nidTipoObjetivo;
    }

    public void setNidTipoObjetivo(BigInteger nidTipoObjetivo) {
        this.nidTipoObjetivo = nidTipoObjetivo;
    }

    public String getTxtTipoObjetivo() {
        return txtTipoObjetivo;
    }

    public void setTxtTipoObjetivo(String txtTipoObjetivo) {
        this.txtTipoObjetivo = txtTipoObjetivo;
    }

    public String getTxtTema() {
        return txtTema;
    }

    public void setTxtTema(String txtTema) {
        this.txtTema = txtTema;
    }

    public BigInteger getNidGobierno() {
        return nidGobierno;
    }

    public void setNidGobierno(BigInteger nidGobierno) {
        this.nidGobierno = nidGobierno;
    }

    public BigInteger getNidEstadoActividadGob() {
        return nidEstadoActividadGob;
    }

    public void setNidEstadoActividadGob(BigInteger nidEstadoActividadGob) {
        this.nidEstadoActividadGob = nidEstadoActividadGob;
    }

    public BigInteger getNidTipoModalidad() {
        return nidTipoModalidad;
    }

    public void setNidTipoModalidad(BigInteger nidTipoModalidad) {
        this.nidTipoModalidad = nidTipoModalidad;
    }

    public String getTxtTipoModalidad() {
        return txtTipoModalidad;
    }

    public void setTxtTipoModalidad(String txtTipoModalidad) {
        this.txtTipoModalidad = txtTipoModalidad;
    }

    public BigInteger getNidModalidadActividad() {
        return nidModalidadActividad;
    }

    public void setNidModalidadActividad(BigInteger nidModalidadActividad) {
        this.nidModalidadActividad = nidModalidadActividad;
    }

    public String getTxtModalidadActividad() {
        return txtModalidadActividad;
    }

    public void setTxtModalidadActividad(String txtModalidadActividad) {
        this.txtModalidadActividad = txtModalidadActividad;
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

    public BigInteger getNumAnio() {
        return numAnio;
    }

    public void setNumAnio(BigInteger numAnio) {
        this.numAnio = numAnio;
    }

    public BigInteger getNumTrimestre() {
        return numTrimestre;
    }

    public void setNumTrimestre(BigInteger numTrimestre) {
        this.numTrimestre = numTrimestre;
    }

    public BigInteger getNidArea() {
        return nidArea;
    }

    public void setNidArea(BigInteger nidArea) {
        this.nidArea = nidArea;
    }

    public BigInteger getNidDepartamento() {
        return nidDepartamento;
    }

    public void setNidDepartamento(BigInteger nidDepartamento) {
        this.nidDepartamento = nidDepartamento;
    }

}
