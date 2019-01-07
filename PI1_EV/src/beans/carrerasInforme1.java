/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author esauj
 */
public class carrerasInforme1 {
    
    //importo la clase logica aplicación para cargar la lista de carreras
    static logicaNegocio.LogicaAplicacion la;
   
    //método estático que devuelva la lista de carreras
    public static List<Carrera> listaCarrerasInforme1(){
       List<Carrera> listaCarrerasInforme1 = new ArrayList<>();
        //recorro la lista de carreras
    
        for (Carrera carrera : la.getListaCarreras()) {
            listaCarrerasInforme1.add(new Carrera(carrera.getNombreCarrera(),carrera.getLugar()
                    ,carrera.getDorsales()));
        }
       return listaCarrerasInforme1;
    }
}
