/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author esauj
 */
public class Corredor implements Serializable {

    //atributos
    private String nombre;
    private String dni;
    private String fechaNacimiento;
    private String direccion;
    private String telefonoContacto;
    private int dorsal;
    private String tiempoFinal;
    private int posicionCarrera;
    //listaCarreras
    private List<Carrera> carrerasInscrito;

    //constructor
    public Corredor(String nombre, String DNI, String fechaNacimiento, String direccion, String telefonoContacto) {
        this.nombre = nombre;
        this.dni = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
        this.dorsal=0;
        this.carrerasInscrito=new LinkedList<>();
    }

    public Corredor(String nombre, String dni, String fechaNacimiento, String direccion, String telefonoContacto, int dorsal) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
        this.dorsal = dorsal;
        this.carrerasInscrito= new LinkedList<>();
    }

    
    //getter and setter

    public List<Carrera> getCarrerasInscrito() {
        return carrerasInscrito;
    }

    public void setCarrerasInscrito(List<Carrera> carrerasInscrito) {
        this.carrerasInscrito = carrerasInscrito;
    }
    
    

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
        return   nombre + ", " + dni + " , "+ telefonoContacto;
    }
    
    //método para cargar en el combobox dni y nombre
    public String cargarCombo(){
        return nombre + " " + dni;
    }
    
    

    public String[] toStringArray() {
       
        String[] s = new String[5];
        s[0] = nombre;
        s[1] = dni;
        s[2] = fechaNacimiento;
        s[3] = direccion;
        s[4] = telefonoContacto;
        return s;
    }
    
    public String[] toStringArrayDorsal(){
    
        String[] s = new String[6];
        
        s[0] = nombre;
        s[1] = dni;
        s[2] = fechaNacimiento;
        s[3] = direccion;
        s[4] = telefonoContacto;
        s[5] = Integer.toString(dorsal);
        return s;
    }

}
