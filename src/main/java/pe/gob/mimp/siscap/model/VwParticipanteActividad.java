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
@Table(name = "VW_PARTICIPANTE_ACTIVIDAD")
public class VwParticipanteActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_ACTIVIDAD_GOB")
    private BigInteger nidActividadGob;
    @Column(name = "TXT_TEMA")
    private String txtTema;
    @Column(name = "NID_PERSONA_SISCAP")
    private BigInteger nidPersonaSiscap;
    @Column(name = "TXT_APELLIDO_PATERNO")
    private String txtApellidoPaterno;
    @Column(name = "TXT_APELLIDO_MATERNO")
    private String txtApellidoMaterno;
    @Column(name = "TXT_NOMBRES")
    private String txtNombres;
    @Column(name = "FEC_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNacimiento;
    @Column(name = "TXT_DOCUMENTO")
    private String txtDocumento;

    public VwParticipanteActividad() {
    }

    public BigInteger getNidActividadGob() {
        return nidActividadGob;
    }

    public void setNidActividadGob(BigInteger nidActividadGob) {
        this.nidActividadGob = nidActividadGob;
    }

    public String getTxtTema() {
        return txtTema;
    }

    public void setTxtTema(String txtTema) {
        this.txtTema = txtTema;
    }

    public BigInteger getNidPersonaSiscap() {
        return nidPersonaSiscap;
    }

    public void setNidPersonaSiscap(BigInteger nidPersonaSiscap) {
        this.nidPersonaSiscap = nidPersonaSiscap;
    }

    public String getTxtApellidoPaterno() {
        return txtApellidoPaterno;
    }

    public void setTxtApellidoPaterno(String txtApellidoPaterno) {
        this.txtApellidoPaterno = txtApellidoPaterno;
    }

    public String getTxtApellidoMaterno() {
        return txtApellidoMaterno;
    }

    public void setTxtApellidoMaterno(String txtApellidoMaterno) {
        this.txtApellidoMaterno = txtApellidoMaterno;
    }

    public String getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(String txtNombres) {
        this.txtNombres = txtNombres;
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public String getTxtDocumento() {
        return txtDocumento;
    }

    public void setTxtDocumento(String txtDocumento) {
        this.txtDocumento = txtDocumento;
    }

}
