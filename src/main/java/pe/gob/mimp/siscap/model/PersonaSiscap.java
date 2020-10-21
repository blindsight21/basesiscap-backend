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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "PERSONA_SISCAP")
public class PersonaSiscap implements Serializable {
    @OneToMany(mappedBy = "nidPersonaSiscap", fetch = FetchType.LAZY)
    private List<Participante> participanteList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "SQ_PERSONA_SISCAP", sequenceName = "SQ_PERSONA_SISCAP", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERSONA_SISCAP")
    @Column(name = "NID_PERSONA_SISCAP")
    private BigDecimal nidPersonaSiscap;

    @Column(name = "NID_TIPO_DOCUMENTO")
    private BigInteger nidTipoDocumento;

    @Column(name = "TXT_DOCUMENTO")
    private String txtDocumento;

    @Column(name = "TXT_APELLIDO_PATERNO")
    private String txtApellidoPaterno;

    @Column(name = "TXT_APELLIDO_MATERNO")
    private String txtApellidoMaterno;

    @Column(name = "TXT_NOMBRES")
    private String txtNombres;

    @Column(name = "FEC_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNacimiento;

    @Column(name = "TXT_SEXO")
    private String txtSexo;

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

    public PersonaSiscap() {
    }

    public PersonaSiscap(BigDecimal nidPersonaSiscap) {
        this.nidPersonaSiscap = nidPersonaSiscap;
    }

    public BigDecimal getNidPersonaSiscap() {
        return nidPersonaSiscap;
    }

    public void setNidPersonaSiscap(BigDecimal nidPersonaSiscap) {
        this.nidPersonaSiscap = nidPersonaSiscap;
    }

    public BigInteger getNidTipoDocumento() {
        return nidTipoDocumento;
    }

    public void setNidTipoDocumento(BigInteger nidTipoDocumento) {
        this.nidTipoDocumento = nidTipoDocumento;
    }

    public String getTxtDocumento() {
        return txtDocumento;
    }

    public void setTxtDocumento(String txtDocumento) {
        this.txtDocumento = txtDocumento;
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

    public String getTxtSexo() {
        return txtSexo;
    }

    public void setTxtSexo(String txtSexo) {
        this.txtSexo = txtSexo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidPersonaSiscap != null ? nidPersonaSiscap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaSiscap)) {
            return false;
        }
        PersonaSiscap other = (PersonaSiscap) object;
        if ((this.nidPersonaSiscap == null && other.nidPersonaSiscap != null) || (this.nidPersonaSiscap != null && !this.nidPersonaSiscap.equals(other.nidPersonaSiscap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.siscap.modelo.PersonaSiscap[ nidPersonaSiscap=" + nidPersonaSiscap + " ]";
    }

    @XmlTransient
    public List<Participante> getParticipanteList() {
        return participanteList;
    }

    public void setParticipanteList(List<Participante> participanteList) {
        this.participanteList = participanteList;
    }

}
