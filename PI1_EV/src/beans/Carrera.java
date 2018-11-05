/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import java.util.List;

/**
 *
 * @author esauj
 */
public class Carrera {
    
    private List<Corredor> listaParticipantes;
    private String nombreCarrera;
    private Date fecha;
    private String lugar;
    private int numMaxParticipantes;

    public Carrera(List<Corredor> listaParticipantes, String nombreCarrera, Date fecha, String lugar, int numMaxParticipantes) {
        this.listaParticipantes = listaParticipantes;
        this.nombreCarrera = nombreCarrera;
        this.fecha = fecha;
        this.lugar = lugar;
        this.numMaxParticipantes = numMaxParticipantes;
    }

    public List<Corredor> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(List<Corredor> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getNumMaxParticipantes() {
        return numMaxParticipantes;
    }

    public void setNumMaxParticipantes(int numMaxParticipantes) {
        this.numMaxParticipantes = numMaxParticipantes;
    }
    
    
    
}
