/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author esauj
 */
public class Carrera {

    private Set <Corredor> listaParticipantes;
    private String nombreCarrera;
    private Date fecha;
    private String lugar;
    private int numMaxParticipantes;
    private boolean acabada;

    public Carrera( String nombreCarrera, Date fecha, String lugar, int numMaxParticipantes) {
        this.listaParticipantes = new LinkedHashSet<>() ;
        this.nombreCarrera = nombreCarrera;
        this.fecha = fecha;
        this.lugar = lugar;
        this.numMaxParticipantes = numMaxParticipantes;
        this.acabada=false;
    }

    public Set<Corredor> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(Set<Corredor> listaParticipantes) {
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
    
    public void dorsalCorredores (){
        
        int dorsal=1;
        Iterator it = listaParticipantes.iterator();
        while(it.hasNext()){
            Corredor c = (Corredor) it.next();
            c.setDorsal(dorsal);
            dorsal++;
        }
        
    } 

}
