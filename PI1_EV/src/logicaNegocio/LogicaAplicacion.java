/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import beans.Carrera;
import beans.Corredor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.StringTokenizer;
import org.openide.util.Exceptions;

/**
 *
 * @author esauj
 */
public class LogicaAplicacion {

    //instanciamos la lista de corredores, sin duplicados y ordenados por el nombre de insercion
    private LinkedList<Corredor> listaCorredores = new LinkedList<>();
    private LinkedList<Carrera> listaCarreras = new LinkedList<>();
    private LinkedList<Carrera> listaCarrerasAcabadas = new LinkedList<>();

    //dar formato a la fecha
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    //declaramos la ruta absoluta del archivo CSV
    private final File NOMBRE_ARCHIVO_CSV = new File("resources\\listaCorredores.csv");
    private final File NOMBRE_ARCHIVO_CSV_CARRERAS = new File("resources\\carreras.csv");
    private final File NOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS = new File("resources\\carrerasAcabadas.csv");
    private final File NOMBRE_ARCHIVO_TEMPORAL = new File("resources\\lista.tmp");
    

    /**
     *
     * @return
     */
    public File getNOMBRE_ARCHIVO_CSV() {
        return NOMBRE_ARCHIVO_CSV;
    }

    
    /**
     *
     * @return
     */
    public File getNOMBRE_ARCHIVO_CSV_CARRERAS() {
        return NOMBRE_ARCHIVO_CSV_CARRERAS;
    }

    /**
     *
     * @return
     */
    public File getNOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS() {
        return NOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS;
    }

    /**
     * Tokeniza lineas del archivo corredores
     * @param linea
     * @return
     */
    public Corredor tokenizar(String linea) {

        Corredor c = null;

        StringTokenizer tokens = new StringTokenizer(linea, ",");
        while (tokens.hasMoreTokens()) {
            String nombre = tokens.nextToken();
            String dni = tokens.nextToken();
            String fechaNacimiento = tokens.nextToken();
            String direccion = tokens.nextToken();
            String telefono = tokens.nextToken();

            c = new Corredor(nombre, dni, fechaNacimiento, direccion, telefono);

        }
        return c;

    }

    /**
     * Tokeniza líneas del archivo carreras
     * @param linea
     * @return
     */
    public Carrera tokenizarCarreras(String linea) {
        Carrera ca = null;

        StringTokenizer tokens = new StringTokenizer(linea, ",");

        while (tokens.hasMoreTokens()) {
            String nombreCarrera = tokens.nextToken().trim();
            String fechaCarrera = tokens.nextToken().trim();
            String lugar = tokens.nextToken().trim();
            int numMaxParticipantes = Integer.parseInt(tokens.nextToken().trim());

            ca = new Carrera(nombreCarrera, fechaCarrera, lugar, numMaxParticipantes);
            listaCarreras.add(ca);
        }
        return ca;
    }

    /**
     * Tokeniza lineas del archivo carreras acabadas
     * @param linea
     * @return
     */
    public Carrera tokenizarCarrerasAcabadas(String linea) {
        Carrera ca = null;

        StringTokenizer tokens = new StringTokenizer(linea, ",");

        while (tokens.hasMoreTokens()) {
            String nombreCarrera = tokens.nextToken().trim();
            String fechaCarrera = tokens.nextToken().trim();
            String lugar = tokens.nextToken().trim();
            int numMaxParticipantes = Integer.parseInt(tokens.nextToken().trim());

            ca = new Carrera(nombreCarrera, fechaCarrera, lugar, numMaxParticipantes);
            listaCarrerasAcabadas.add(ca);
        }
        return ca;
    }

    /**
     * Tokeniza carreras para sacar corredores a partir del DNI
     * @param linea
     * @param carrera
     * @param la
     */
    public void tokenizarDNI(String linea, Carrera carrera, logicaNegocio.LogicaAplicacion la) {

        StringTokenizer tokens = new StringTokenizer(linea, ",");
        while (tokens.hasMoreTokens()) {
            int dorsal = Integer.parseInt(tokens.nextToken().trim());
            String DNI = tokens.nextToken().trim();
            Iterator it = la.listaCorredores.iterator();
            for (Corredor corredor : la.listaCorredores) {
                while (it.hasNext()) {
                    corredor = (Corredor) it.next();
                    corredor.setDorsal(dorsal);
                    if (corredor.getDNI().equalsIgnoreCase(DNI)) {
                        carrera.getListaParticipantes().add(corredor);
                    }
                }
            }

        }
    }

    /**
     * Tokeniza lista de corredores de carreras acabadas
     * @param linea
     * @param carrera
     * @param la
     */
    public void tokenizarCorredoresAcabada(String linea, Carrera carrera, logicaNegocio.LogicaAplicacion la) {

        StringTokenizer tokens = new StringTokenizer(linea, ",");
        while (tokens.hasMoreTokens()) {
            int posicion = Integer.parseInt(tokens.nextToken().trim());
            int dorsal = Integer.parseInt(tokens.nextToken().trim());
            String tiempoCarrera = tokens.nextToken().trim();
            String DNI = tokens.nextToken().trim();
            Iterator it = la.listaCorredores.iterator();
            for (Corredor corredor : la.listaCorredores) {
                while (it.hasNext()) {
                    corredor = (Corredor) it.next();
                    corredor.setPosicionCarrera(posicion);
                    corredor.setDorsal(dorsal);
                    corredor.setTiempoFinal(tiempoCarrera);
                    if (corredor.getDNI().equalsIgnoreCase(DNI)) {
                        carrera.getListaFinalCarrera().add(corredor);
                    }
                }
            }

        }
    }

    /**
     *Cargo el archivo de corredores
     */
    public void cargarCSV() {

        FileReader fr = null;
        BufferedReader br = null;
        String linea;

        try {
            fr = new FileReader(NOMBRE_ARCHIVO_CSV);
            br = new BufferedReader(fr);
            linea = br.readLine();
            while (linea != null) {
                listaCorredores.add(tokenizar(linea));
                linea = br.readLine();
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo");;
        } catch (IOException ex) {
            System.out.println("Error en la entrada o salida");;
        }

    }

    /**
     * Guarda archivo corredores
     * @param file
     */
    public void guardarCsv(File file) {

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {

            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            //declaro el bucle 
            if (NOMBRE_ARCHIVO_CSV.exists()) {
                for (Corredor corredor : listaCorredores) {
                    bw.write(corredor.getNombre() + "," + corredor.getDNI() + "," + corredor.getFechaNacimiento() + ","
                            + corredor.getDireccion() + "," + corredor.getTelefonoContacto() + '\n');
                }
            }
            //cierro el buffer
            bw.flush();
            bw.close();

        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    /**
     *Carga el archivo carreras
     */
    public void cargarCSVCarreras() {

        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        Carrera carrera;

        try {
            fr = new FileReader(NOMBRE_ARCHIVO_CSV_CARRERAS);
            br = new BufferedReader(fr);
            linea = br.readLine();
            while (linea != null) {

                carrera = tokenizarCarreras(linea);
                linea = br.readLine();
                tokenizarDNI(linea, carrera, this);
                linea = br.readLine();
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo");;
        } catch (IOException ex) {
            System.out.println("Error en la entrada o salida");;
        }

    }

    /**
     *Carga el archivo carreras acabadas
     */
    public void cargarCSVCarrerasAcabadas() {

        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        Carrera carrera;

        try {
            fr = new FileReader(NOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS);
            br = new BufferedReader(fr);
            linea = br.readLine();
            while (linea != null) {
                carrera = tokenizarCarrerasAcabadas(linea);
                linea = br.readLine();
                tokenizarCorredoresAcabada(linea, carrera, this);
                linea = br.readLine();
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo");;
        } catch (IOException ex) {
            System.out.println("Error en la entrada o salida");;
        }
    }

    /**
     * Guarda el archivo carreras
     * @param file
     */
    public void guardarCsvCarreras(File file) {

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);

            //declaro el bucle 
            for (Carrera carrera : listaCarreras) {

                bw.write(carrera.getNombreCarrera() + "," + carrera.getFecha() + ","
                        + carrera.getLugar() + ","
                        + carrera.getNumMaxParticipantes() + '\n');
                for (Corredor corredor : carrera.getListaParticipantes()) {
                    bw.write(corredor.getDorsal() + "," + corredor.getDNI() + ",");

                }
                bw.write("\n");
            }

            //cierro el buffer
            bw.flush();
            bw.close();

        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    /**
     * Guarda el archivo carreras acabadas
     * @param file
     */
    public void guardarCsvCarrerasAcabadas(File file) {

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            fw = new FileWriter(NOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS, true);
            bw = new BufferedWriter(fw);

            //declaro el bucle 
            for (Carrera carrera : listaCarreras) {

                bw.write(carrera.getNombreCarrera() + "," + carrera.getFecha() + ","
                        + carrera.getLugar() + ","
                        + carrera.getNumMaxParticipantes() + '\n');
                for (Corredor corredor : carrera.getListaFinalCarrera()) {
                    bw.write(corredor.getPosicionCarrera() + "," + corredor.getDorsal() + "," + corredor.getTiempoFinal()
                            + "," + corredor.getDNI()
                            + ",");
                }
                bw.write("\n");
            }
            //cierro el buffer
            bw.flush();
            bw.close();

        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    /**
     * Prepara el informe de la carrera que se pasa 
     * @param carrera
     */
    public void informeCarreraAcabada(Carrera carrera) {

        //creo el archivo de la carrera acabada
        File carreraAcabada = new File("resources\\carrerasAcabadas\\" + carrera.getNombreCarrera() + ".txt");
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            fw = new FileWriter(carreraAcabada, true);
            bw = new BufferedWriter(fw);

            bw.write(carrera.getNombreCarrera() + "\n");
            bw.write(carrera.getFecha() + "\n");

            //declaro el bucle 
            for (Corredor corredor : carrera.getListaFinalCarrera()) {

                bw.write(corredor.getDorsal() + "   " + corredor.getTiempoFinal() + "    " + corredor.getNombre() + "\n");

            }
            //cierro el buffer
            bw.flush();
            bw.close();

        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    /**
     * Añado un corredor a la lista y borro la lista anterior
     * @param corredor
     */
    public void aniadirCorredor(Corredor corredor) {

        //añadimos el corredor a la lista
        listaCorredores.add(corredor);
        guardarCsv(NOMBRE_ARCHIVO_TEMPORAL);

        //borro el archivo viejo
        NOMBRE_ARCHIVO_CSV.delete();

        //nombre el archivo temporal que he creado como el antiguo
        NOMBRE_ARCHIVO_TEMPORAL.renameTo(NOMBRE_ARCHIVO_CSV);

    }

    /**
     * Borro corredor de la lista y creo la nueva lista de corredores
     * @param corredor
     */
    public void borrarCorredor(Corredor corredor) {
        //borramos el corredor de la lista
        listaCorredores.remove(corredor);

        guardarCsv(NOMBRE_ARCHIVO_TEMPORAL);

        //borro el archivo viejo
        NOMBRE_ARCHIVO_CSV.delete();

        //nombre el archivo temporal que he creado como el antiguo
        NOMBRE_ARCHIVO_TEMPORAL.renameTo(NOMBRE_ARCHIVO_CSV);
    }

    /**
     *
     * @return
     */
    public LinkedList<Corredor> getListaCorredores() {
        return listaCorredores;
    }

    /**
     *
     * @param listaCorredores
     */
    public void setListaCorredores(LinkedList<Corredor> listaCorredores) {
        this.listaCorredores = listaCorredores;
    }

    /**
     * Añade carrera
     * @param carrera
     */
    public void aniadirCarrera(Carrera carrera) {
        listaCarreras.add(carrera);
        guardarCsvCarreras(NOMBRE_ARCHIVO_TEMPORAL);

        //borro el archivo viejo
        NOMBRE_ARCHIVO_CSV_CARRERAS.delete();

        //nombre el archivo temporal que he creado como el antiguo
        NOMBRE_ARCHIVO_TEMPORAL.renameTo(NOMBRE_ARCHIVO_CSV_CARRERAS);
    }

    /**
     *
     * @return
     */
    public LinkedList<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    /**
     *
     * @param listaCarreras
     */
    public void setListaCarreras(LinkedList<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    /**
     *
     * @return
     */
    public LinkedList<Carrera> getListaCarrerasAcabadas() {
        return listaCarrerasAcabadas;
    }

    /**
     *
     * @param listaCarrerasAcabadas
     */
    public void setListaCarrerasAcabadas(LinkedList<Carrera> listaCarrerasAcabadas) {
        this.listaCarrerasAcabadas = listaCarrerasAcabadas;
    }

    /**
     *
     * @return
     */
    public SimpleDateFormat getSdf() {
        return sdf;
    }

    /**
     *
     * @param sdf
     */
    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    /**
     * Borra carrera y guarda la linea
     * @param carrera
     */
    public void borrarCarrera(Carrera carrera) {
        //borramos el corredor de la lista
        listaCarreras.remove(carrera);
        guardarCsvCarreras(NOMBRE_ARCHIVO_TEMPORAL);

        //borro el archivo viejo
        NOMBRE_ARCHIVO_CSV_CARRERAS.delete();

        //nombre el archivo temporal que he creado como el antiguo
        NOMBRE_ARCHIVO_TEMPORAL.renameTo(NOMBRE_ARCHIVO_CSV_CARRERAS);
    }

    /**
     * Borra carrera acabada
     * @param carrera
     */
    public void borrarCarreraAcabada(Carrera carrera) {
        //borramos el corredor de la lista
        listaCarrerasAcabadas.remove(carrera);
        guardarCsvCarrerasAcabadas(NOMBRE_ARCHIVO_TEMPORAL);

        //borro el archivo viejo
        NOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS.delete();

        //nombre el archivo temporal que he creado como el antiguo
        NOMBRE_ARCHIVO_TEMPORAL.renameTo(NOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS);
    }

    /**
     * Borra corredores de carrera
     * @param corredor
     * @param carrera
     */
    public void borrarCorredorCarrera(Corredor corredor, Carrera carrera) {

        //borramos el corredor de la lista
        carrera.getListaParticipantes().remove(corredor);
        guardarCsvCarreras(NOMBRE_ARCHIVO_TEMPORAL);

        //borro el archivo viejo
        NOMBRE_ARCHIVO_CSV_CARRERAS.delete();

        //nombre el archivo temporal que he creado como el antiguo
        NOMBRE_ARCHIVO_TEMPORAL.renameTo(NOMBRE_ARCHIVO_CSV_CARRERAS);
    }

}
