/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import java.util.Date;

/**
 *
 * @author esauj
 */
public class Corredor {
    
    //atributos
    private String nombre;
    private String DNI;
    private Date fechaNacimiento;
    private String direccion;
    private String telefonoContacto;
    
    //constructor

    public Corredor(String nombre, String DNI, Date fechaNacimiento, String direccion, String telefonoContacto) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
    }
    
    
    
}
