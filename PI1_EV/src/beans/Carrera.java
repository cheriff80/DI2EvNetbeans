/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author esauj
 */
public class Carrera {

    private LinkedList<Corredor> listaParticipantes;
    private String nombreCarrera;
    private String fecha;
    private String lugar;
    private int numMaxParticipantes;
    private int dorsales;
    private boolean acabada;

    public Carrera(String nombreCarrera, String fecha, String lugar, int numMaxParticipantes) {
        this.listaParticipantes = new LinkedList<>();
        this.nombreCarrera = nombreCarrera;
        this.fecha = fecha;
        this.lugar = lugar;
        this.numMaxParticipantes = numMaxParticipantes;
        this.acabada = false;
        this.dorsales = 1;
    }

    public Carrera(LinkedList<Corredor> listaParticipantes, String nombreCarrera, String fecha, String lugar, int numMaxParticipantes) {
        this.listaParticipantes = listaParticipantes;
        this.nombreCarrera = nombreCarrera;
        this.fecha = fecha;
        this.lugar = lugar;
        this.numMaxParticipantes = numMaxParticipantes;
        this.acabada = false;
        this.dorsales = 1;
    }

    public int getDorsales() {
        return dorsales;
    }

    public void setDorsales(int dorsales) {
        this.dorsales = dorsales;
    }

    public boolean isAcabada() {
        return acabada;
    }

    public void setAcabada(boolean acabada) {
        this.acabada = acabada;
    }

    public List<Corredor> getListaParticipantes() {
        return listaParticipantes;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

    public void darDorsalesCorredores() {
        Iterator it = listaParticipantes.iterator();
        Corredor c;
        for (int i = 1; i < listaParticipantes.size(); i++) {
            while (it.hasNext()) {
                c = (Corredor) it.next();
                c.setDorsal(dorsales);
                dorsales++;
            }
        }
    }

    public String[] toStringArray() {

        String[] s = new String[4];
        s[0] = nombreCarrera;
        s[1] = fecha;
        s[2] = lugar;
        s[3] = Integer.toString(numMaxParticipantes);

        return s;
    }

}
