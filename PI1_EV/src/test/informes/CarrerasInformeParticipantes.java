/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.informes;

import beans.Carrera;
import beans.Corredor;
import java.util.ArrayList;
import java.util.List;
import logicaNegocio.LogicaAplicacion;

/**
 *
 * @author esauj
 */
public class CarrerasInformeParticipantes {
    
       //método estático que devuelva la lista de carreras
    public static List<Corredor> listaCarrerasParticipantes(){
        List<Corredor> listaCorredores = new ArrayList<>();
        listaCorredores.add(new Corredor("Pablo", "123453434Z", "1/1/2005", "calle uria", "666666666"));
        listaCorredores.add(new Corredor("Juan", "123453434D", "1/1/2000", "calle uria", "66655555"));
        return listaCorredores;
    }
}
