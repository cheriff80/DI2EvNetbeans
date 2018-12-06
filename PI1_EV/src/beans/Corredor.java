/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author esauj
 */
public class Corredor implements Serializable {

    //atributos
    private String nombre;
    private String DNI;
    private String fechaNacimiento;
    private String direccion;
    private String telefonoContacto;
    private int dorsal;
    private String tiempoFinal;
    private int posicionCarrera;

    //constructor
    public Corredor(String nombre, String DNI, String fechaNacimiento, String direccion, String telefonoContacto) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
    }

    //getter and setter

    public int getPosicionCarrera() {
        return posicionCarrera;
    }

    public void setPosicionCarrera(int posicionCarrera) {
        this.posicionCarrera = posicionCarrera;
    }
    

    public String getTiempoFinal() {
        return tiempoFinal;
    }

    public void setTiempoFinal(String tiempoFinal) {
        this.tiempoFinal = tiempoFinal;
    }
    
    

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Override
    public String toString() {
        return   nombre + ", " + DNI + " , "+ telefonoContacto;
    }
    
    

    public String[] toStringArray() {
       
        String[] s = new String[5];
        s[0] = nombre;
        s[1] = DNI;
        s[2] = fechaNacimiento;
        s[3] = direccion;
        s[4] = telefonoContacto;
        return s;
    }
    
    public String[] toStringArrayDorsal(){
    
        String[] s = new String[6];
        
        s[0] = nombre;
        s[1] = DNI;
        s[2] = fechaNacimiento;
        s[3] = direccion;
        s[4] = telefonoContacto;
        s[5] = Integer.toString(dorsal);
        return s;
    }

}
