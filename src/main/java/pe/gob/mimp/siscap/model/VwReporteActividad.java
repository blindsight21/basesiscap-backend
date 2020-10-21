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
@Table(name = "VW_REPORTE_ACTIVIDAD")
public class VwReporteActividad implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_ACTIVIDAD_GOB")
    private BigInteger nidActividadGob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_TIPO_OBJETIVO")
    private BigInteger nidTipoObjetivo;
    @Column(name = "TXT_TIPO_OBJETIVO")
    private String txtTipoObjetivo;
    @Column(name = "TXT_OBJETIVO")
    private String txtObjetivo;
    @Column(name = "NID_ESTADO_ACTIVIDAD_GOB")
    private BigInteger nidEstadoActividadGob;
    @Column(name = "TXT_ESTADO_ACTIVIDAD_GOB")
    private String txtEstadoActividadGob;
    @Column(name = "PUBLICO_OBJETIVO")
    private String publicoObjetivo;
    @Column(name = "TXT_TEMA")
    private String txtTema;
    @Column(name = "NID_GOBIERNO")
    private BigInteger nidGobierno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_TIPO_MODALIDAD")
    private BigInteger nidTipoModalidad;
    @Column(name = "TXT_TIPO_MODALIDAD")
    private String txtTipoModalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_MODALIDAD_ACTIVIDAD")
    private BigInteger nidModalidadActividad;
    @Column(name = "TXT_MODALIDAD_ACTIVIDAD")
    private String txtModalidadActividad;
    @Column(name = "FEC_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicio;
    @Column(name = "FEC_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin;
    @Column(name = "NUM_TRIMESTRE")
    private BigInteger numTrimestre;
    @Column(name = "TXT_TRIMESTRE")
    private String txtTrimestre;
    @Column(name = "NUM_ANIO")
    private BigInteger numAnio;
    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;
    @Column(name = "NID_AREA")
    private BigInteger nidArea;
    @Column(name = "NUM_CONTADOR_FEMENINO")
    private BigInteger numContadorFemenino;
    @Column(name = "NUM_CONTADOR_MASCULINO")
    private BigInteger numContadorMasculino;
    @Column(name = "NUM_CONTADOR_TOTAL")
    private BigInteger numContadorTotal;
    @Column(name = "TXT_GOBIERNO")
    private String txtGobierno;
    @Column(name = "NID_DEPARTAMENTO")
    private BigInteger nidDepartamento;
    @Column(name = "TXT_SIGLA")
    private String txtSigla;
    @Column(name = "TXT_AREA")
    private String txtArea;
    @Column(name = "TXT_JUSTIFICACION_REPROGRAMADO")
    private String txtJustificacionReprogramado;
    @Column(name = "TXT_JUSTIFICACION_ANULADO")
    private String txtJustificacionAnulado;
    @Column(name = "RESULTADO_TIPO_NIVEL")
    private String resultadoTipoNivel;
    @Column(name = "RESULTADO_DESCRIPCION")
    private String resultadoDescripcion;

    public VwReporteActividad() {
    }

    public BigInteger getNidActividadGob() {
        return nidActividadGob;
    }

    public void setNidActividadGob(BigInteger nidActividadGob) {
        this.nidActividadGob = nidActividadGob;
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

    public String getTxtObjetivo() {
        return txtObjetivo;
    }

    public void setTxtObjetivo(String txtObjetivo) {
        this.txtObjetivo = txtObjetivo;
    }

    public BigInteger getNidEstadoActividadGob() {
        return nidEstadoActividadGob;
    }

    public void setNidEstadoActividadGob(BigInteger nidEstadoActividadGob) {
        this.nidEstadoActividadGob = nidEstadoActividadGob;
    }

    public String getTxtEstadoActividadGob() {
        return txtEstadoActividadGob;
    }

    public void setTxtEstadoActividadGob(String txtEstadoActividadGob) {
        this.txtEstadoActividadGob = txtEstadoActividadGob;
    }

    public String getPublicoObjetivo() {
        return publicoObjetivo;
    }

    public void setPublicoObjetivo(String publicoObjetivo) {
        this.publicoObjetivo = publicoObjetivo;
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

    public BigInteger getNumTrimestre() {
        return numTrimestre;
    }

    public void setNumTrimestre(BigInteger numTrimestre) {
        this.numTrimestre = numTrimestre;
    }

    public String getTxtTrimestre() {
        return txtTrimestre;
    }

    public void setTxtTrimestre(String txtTrimestre) {
        this.txtTrimestre = txtTrimestre;
    }

    public BigInteger getNumAnio() {
        return numAnio;
    }

    public void setNumAnio(BigInteger numAnio) {
        this.numAnio = numAnio;
    }

    public BigInteger getNidUsuario() {
        return nidUsuario;
    }

    public void setNidUsuario(BigInteger nidUsuario) {
        this.nidUsuario = nidUsuario;
    }

    public BigInteger getNidArea() {
        return nidArea;
    }

    public void setNidArea(BigInteger nidArea) {
        this.nidArea = nidArea;
    }

    public BigInteger getNumContadorFemenino() {
        return numContadorFemenino;
    }

    public void setNumContadorFemenino(BigInteger numContadorFemenino) {
        this.numContadorFemenino = numContadorFemenino;
    }

    public BigInteger getNumContadorMasculino() {
        return numContadorMasculino;
    }

    public void setNumContadorMasculino(BigInteger numContadorMasculino) {
        this.numContadorMasculino = numContadorMasculino;
    }

    public BigInteger getNumContadorTotal() {
        return numContadorTotal;
    }

    public void setNumContadorTotal(BigInteger numContadorTotal) {
        this.numContadorTotal = numContadorTotal;
    }

    public String getTxtGobierno() {
        return txtGobierno;
    }

    public void setTxtGobierno(String txtGobierno) {
        this.txtGobierno = txtGobierno;
    }
    
    public BigInteger getNidDepartamento() {
        return nidDepartamento;
    }

    public void setNidDepartamento(BigInteger nidDepartamento) {
        this.nidDepartamento = nidDepartamento;
    }

    public String getTxtSigla() {
        return txtSigla;
    }

    public void setTxtSigla(String txtSigla) {
        this.txtSigla = txtSigla;
    }

    public String getTxtArea() {
        return txtArea;
    }

    public void setTxtArea(String txtArea) {
        this.txtArea = txtArea;
    }

    public String getTxtJustificacionReprogramado() {
        return txtJustificacionReprogramado;
    }

    public void setTxtJustificacionReprogramado(String txtJustificacionReprogramado) {
        this.txtJustificacionReprogramado = txtJustificacionReprogramado;
    }

    public String getTxtJustificacionAnulado() {
        return txtJustificacionAnulado;
    }

    public void setTxtJustificacionAnulado(String txtJustificacionAnulado) {
        this.txtJustificacionAnulado = txtJustificacionAnulado;
    }

    public String getResultadoTipoNivel() {
        return resultadoTipoNivel;
    }

    public void setResultadoTipoNivel(String resultadoTipoNivel) {
        this.resultadoTipoNivel = resultadoTipoNivel;
    }

    public String getResultadoDescripcion() {
        return resultadoDescripcion;
    }

    public void setResultadoDescripcion(String resultadoDescripcion) {
        this.resultadoDescripcion = resultadoDescripcion;
    }

}
