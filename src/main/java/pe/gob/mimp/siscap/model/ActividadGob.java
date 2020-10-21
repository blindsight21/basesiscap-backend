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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "ACTIVIDAD_GOB")
public class ActividadGob implements Serializable {
    @OneToMany(mappedBy = "nidActividadGob", fetch = FetchType.LAZY)
    private List<Participante> participanteList;
    @OneToMany(mappedBy = "nidActividadGob", fetch = FetchType.LAZY)
    private List<ArchivoActividad> archivoActividadList;

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SQ_ACTIVIDAD_GOB", sequenceName = "SQ_ACTIVIDAD_GOB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACTIVIDAD_GOB")
    @Column(name = "NID_ACTIVIDAD_GOB")
    private BigDecimal nidActividadGob;

    @Column(name = "TXT_OBJETIVO")
    private String txtObjetivo;

    @Column(name = "TXT_TEMA")
    private String txtTema;

    @Column(name = "FEC_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicio;

    @Column(name = "FEC_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin;

    @Column(name = "FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;

    @Column(name = "NUM_ANIO")
    private BigInteger numAnio;

    @Column(name = "NUM_TRIMESTRE")
    private BigInteger numTrimestre;

    @Column(name = "TXT_OBSERVACION_ELIMINADO")
    private String txtObservacionEliminado;

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

    @Column(name = "NID_AREA")
    private BigInteger nidArea;

    @Column(name = "NID_DEPARTAMENTO")
    private BigInteger nidDepartamento;

    @Column(name = "TXT_RESPONSABLE_APEPAT")
    private String txtResponsableApepat;

    @Column(name = "TXT_RESPONSABLE_APEMAT")
    private String txtResponsableApemat;

    @Column(name = "TXT_RESPONSABLE_NOMBRE")
    private String txtResponsableNombre;

    @Column(name = "TXT_RESPONSABLE_TELEF")
    private String txtResponsableTelef;

    @Column(name = "TXT_RESPONSABLE_CORREO")
    private String txtResponsableCorreo;
    
    @Column(name = "NUM_CONTADOR_MASCULINO")
    private BigInteger numContadorMasculino;
    
    @Column(name = "NUM_CONTADOR_FEMENINO")
    private BigInteger numContadorFemenino;
    
    @Column(name = "NUM_CONTADOR_TOTAL")
    private BigInteger numContadorTotal;
    
    @Column(name = "TXT_JUSTIFICACION_REPROGRAMADO")
    private String txtJustificacionReprogramado;
    
    @Column(name = "TXT_JUSTIFICACION_ANULADO")
    private String txtJustificacionAnulado;

    @JoinColumn(name = "NID_TIPO_OBJETIVO", referencedColumnName = "NID_TIPO_OBJETIVO")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoObjetivo nidTipoObjetivo;

    @JoinColumn(name = "NID_TIPO_MODALIDAD", referencedColumnName = "NID_TIPO_MODALIDAD")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoModalidad nidTipoModalidad;

    @JoinColumn(name = "NID_MODALIDAD_ACTIVIDAD", referencedColumnName = "NID_MODALIDAD_ACTIVIDAD")
    @ManyToOne(fetch = FetchType.LAZY)
    private ModalidadActividad nidModalidadActividad;

    @JoinColumn(name = "NID_GOBIERNO", referencedColumnName = "NID_GOBIERNO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Gobierno nidGobierno;

    @JoinColumn(name = "NID_FUNCION_TRANSFERIDA", referencedColumnName = "NID_FUNCION_TRANSFERIDA")
    @ManyToOne(fetch = FetchType.LAZY)
    private FuncionTransferida nidFuncionTransferida;

    @Transient
    private BigDecimal nidTipoFuncion;

    @Transient
    private BigDecimal nidTipoGobierno;

    @Transient
    private BigDecimal nidEstadoActividad;

    public ActividadGob() {
    }

    public ActividadGob(BigDecimal nidActividadGob) {
        this.nidActividadGob = nidActividadGob;
    }

    public BigDecimal getNidActividadGob() {
        return nidActividadGob;
    }

    public void setNidActividadGob(BigDecimal nidActividadGob) {
        this.nidActividadGob = nidActividadGob;
    }

    public String getTxtObjetivo() {
        return txtObjetivo;
    }

    public void setTxtObjetivo(String txtObjetivo) {
        this.txtObjetivo = txtObjetivo;
    }

    public String getTxtTema() {
        return txtTema;
    }

    public void setTxtTema(String txtTema) {
        this.txtTema = txtTema;
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

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
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

    public String getTxtObservacionEliminado() {
        return txtObservacionEliminado;
    }

    public void setTxtObservacionEliminado(String txtObservacionEliminado) {
        this.txtObservacionEliminado = txtObservacionEliminado;
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

    public String getTxtResponsableApepat() {
        return txtResponsableApepat;
    }

    public void setTxtResponsableApepat(String txtResponsableApepat) {
        this.txtResponsableApepat = txtResponsableApepat;
    }

    public String getTxtResponsableApemat() {
        return txtResponsableApemat;
    }

    public void setTxtResponsableApemat(String txtResponsableApemat) {
        this.txtResponsableApemat = txtResponsableApemat;
    }

    public String getTxtResponsableNombre() {
        return txtResponsableNombre;
    }

    public void setTxtResponsableNombre(String txtResponsableNombre) {
        this.txtResponsableNombre = txtResponsableNombre;
    }

    public String getTxtResponsableTelef() {
        return txtResponsableTelef;
    }

    public void setTxtResponsableTelef(String txtResponsableTelef) {
        this.txtResponsableTelef = txtResponsableTelef;
    }

    public String getTxtResponsableCorreo() {
        return txtResponsableCorreo;
    }

    public void setTxtResponsableCorreo(String txtResponsableCorreo) {
        this.txtResponsableCorreo = txtResponsableCorreo;
    }

    public BigInteger getNumContadorMasculino() {
        return numContadorMasculino;
    }

    public void setNumContadorMasculino(BigInteger numContadorMasculino) {
        this.numContadorMasculino = numContadorMasculino;
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
    
    public TipoObjetivo getNidTipoObjetivo() {
        return nidTipoObjetivo;
    }

    public void setNidTipoObjetivo(TipoObjetivo nidTipoObjetivo) {
        this.nidTipoObjetivo = nidTipoObjetivo;
    }

    public TipoModalidad getNidTipoModalidad() {
        return nidTipoModalidad;
    }

    public void setNidTipoModalidad(TipoModalidad nidTipoModalidad) {
        this.nidTipoModalidad = nidTipoModalidad;
    }

    public ModalidadActividad getNidModalidadActividad() {
        return nidModalidadActividad;
    }

    public void setNidModalidadActividad(ModalidadActividad nidModalidadActividad) {
        this.nidModalidadActividad = nidModalidadActividad;
    }

    public Gobierno getNidGobierno() {
        return nidGobierno;
    }

    public void setNidGobierno(Gobierno nidGobierno) {
        this.nidGobierno = nidGobierno;
    }

    public FuncionTransferida getNidFuncionTransferida() {
        return nidFuncionTransferida;
    }

    public void setNidFuncionTransferida(FuncionTransferida nidFuncionTransferida) {
        this.nidFuncionTransferida = nidFuncionTransferida;
    }

    public BigDecimal getNidTipoFuncion() {
        return nidTipoFuncion;
    }

    public void setNidTipoFuncion(BigDecimal nidTipoFuncion) {
        this.nidTipoFuncion = nidTipoFuncion;
    }

    public BigDecimal getNidTipoGobierno() {
        return nidTipoGobierno;
    }

    public void setNidTipoGobierno(BigDecimal nidTipoGobierno) {
        this.nidTipoGobierno = nidTipoGobierno;
    }

    public BigDecimal getNidEstadoActividad() {
        return nidEstadoActividad;
    }

    public void setNidEstadoActividad(BigDecimal nidEstadoActividad) {
        this.nidEstadoActividad = nidEstadoActividad;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidActividadGob != null ? nidActividadGob.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadGob)) {
            return false;
        }
        ActividadGob other = (ActividadGob) object;
        if ((this.nidActividadGob == null && other.nidActividadGob != null) || (this.nidActividadGob != null && !this.nidActividadGob.equals(other.nidActividadGob))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.ActividadGob[ nidActividadGob=" + nidActividadGob + " ]";
    }

    @XmlTransient
    public List<ArchivoActividad> getArchivoActividadList() {
        return archivoActividadList;
    }

    public void setArchivoActividadList(List<ArchivoActividad> archivoActividadList) {
        this.archivoActividadList = archivoActividadList;
    }

    @XmlTransient
    public List<Participante> getParticipanteList() {
        return participanteList;
    }

    public void setParticipanteList(List<Participante> participanteList) {
        this.participanteList = participanteList;
    }

}
