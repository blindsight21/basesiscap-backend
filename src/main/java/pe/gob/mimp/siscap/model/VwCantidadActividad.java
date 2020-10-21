/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.siscap.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "VW_CANTIDAD_ACTIVIDAD")
public class VwCantidadActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "DEPARTAMENTO_ACTIVIDAD")
    private BigInteger departamentoActividad;
    @Column(name = "CANTIDAD_ACTIVIDAD")
    private BigInteger cantidadActividad;

    public VwCantidadActividad() {
    }

    public BigInteger getDepartamentoActividad() {
        return departamentoActividad;
    }

    public void setDepartamentoActividad(BigInteger departamentoActividad) {
        this.departamentoActividad = departamentoActividad;
    }

    public BigInteger getCantidadActividad() {
        return cantidadActividad;
    }

    public void setCantidadActividad(BigInteger cantidadActividad) {
        this.cantidadActividad = cantidadActividad;
    }

}
