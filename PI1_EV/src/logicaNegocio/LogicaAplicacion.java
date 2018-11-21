/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import beans.Carrera;
import beans.Corredor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
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
    private Set<Carrera> listaCarreras = new LinkedHashSet<>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    //declaramos la ruta absoluta del archivo CSV
    private final File NOMBRE_ARCHIVO_CSV = new File("archivoCSV\\listaCorredores.csv");
    private final File NOMBRE_ARCHIVO = new File("archivoCSV\\listaCorredores.dat");
    private final File NOMBRE_ARCHIVO_CSV_CARRERAS= new File("archivoCSV\\carreras.csv");

    public void tokenizar(String linea) {

        Corredor c;
        try {
            StringTokenizer tokens = new StringTokenizer(linea, ",");
            while (tokens.hasMoreTokens()) {
                String nombre = tokens.nextToken();
                String dni = tokens.nextToken();
                Date fechaNacimiento;

                fechaNacimiento = sdf.parse(tokens.nextToken());

                String direccion = tokens.nextToken();
                String telefono = tokens.nextToken();

                c = new Corredor(nombre, dni, fechaNacimiento, direccion, telefono);
                listaCorredores.add(c);
            }
        } catch (ParseException ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    public void tokenizarCarreras(String linea){
        Carrera ca;
        Date fechaCarrera=null;
        
        StringTokenizer tokens = new StringTokenizer(linea,",");
        while(tokens.hasMoreTokens()){
            String nombreCarrera = tokens.nextToken();
            try {
                 fechaCarrera = sdf.parse(tokens.nextToken());
            } catch (ParseException e) {
                System.out.println("No se trata de una fecha válida");
            }
            String lugar = tokens.nextToken();
            int numMaxParticipantes = Integer.parseInt(tokens.nextToken());
            
            ca = new Carrera(nombreCarrera,fechaCarrera,lugar,numMaxParticipantes);
            listaCarreras.add(ca);
        }
    }
    //nueva clase para que no nos imprima la cabecera cuando añadamos corredores
    public class MyAppendingObjectOutputStream extends ObjectOutputStream {

        public MyAppendingObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset(); // no escribe la cabecera
        }
    }

    public void cargarListaBytes() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        LinkedList<Corredor> ps;

        try {

            if (NOMBRE_ARCHIVO.exists()) {
                fis = new FileInputStream(NOMBRE_ARCHIVO);
                ois = new ObjectInputStream(fis);

                ps = (LinkedList<Corredor>) ois.readObject();
                listaCorredores = ps;

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void guardarListaBytes() {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        MyAppendingObjectOutputStream maoos = null;
        Corredor c;
        Iterator it = listaCorredores.iterator();

        try {
            fos = new FileOutputStream(NOMBRE_ARCHIVO, true);
            oos = new ObjectOutputStream(fos);
            maoos = new MyAppendingObjectOutputStream(fos);

            //confirmamos si existe o no el NOMBRE_ARCHIVO_CSV para añadir el objeto sin o con cabecera
            if (NOMBRE_ARCHIVO.exists()) {

                //iteramos la lista de corredores de la sesion y la añadimos al NOMBRE_ARCHIVO_CSV
                while (it.hasNext()) {
                    c = (Corredor) (it.next());
                    maoos.writeObject(c);
                }
            } else {
                //iteramos la lista de corredores de la sesion y la añadimos al NOMBRE_ARCHIVO_CSV

                while (it.hasNext()) {
                    c = (Corredor) (it.next());
                    oos.writeObject(c);
                }
            }

            //cerramos los flujos
            fos.close();
            oos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarCSV() {

        FileReader fr = null;
        BufferedReader br = null;
        String linea;

        try {
            fr = new FileReader(NOMBRE_ARCHIVO_CSV);
            br = new BufferedReader(fr);
            linea = br.readLine();
            while (linea != null) {
                tokenizar(linea);

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

    public void guardarCsv() {

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            fw = new FileWriter(NOMBRE_ARCHIVO_CSV, true);
            bw = new BufferedWriter(fw);

            //declaro el bucle 
            for (Corredor corredor : listaCorredores) {

                bw.write(corredor.getNombre() + "," + corredor.getDNI() + "," + corredor.getFechaNacimiento() + ","
                        + corredor.getDireccion() + "," + corredor.getTelefonoContacto() + '\n');
            }

            //cierro el buffer
            bw.flush();
            bw.close();

        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

    }
    
     public void cargarCSVCarreras() {

        FileReader fr = null;
        BufferedReader br = null;
        String linea;

        try {
            fr = new FileReader(NOMBRE_ARCHIVO_CSV_CARRERAS);
            br = new BufferedReader(fr);
            linea = br.readLine();
            while (linea != null) {
                tokenizarCarreras(linea);

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

    public void guardarCsvCarreras() {

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            fw = new FileWriter(NOMBRE_ARCHIVO_CSV_CARRERAS, true);
            bw = new BufferedWriter(fw);

            //declaro el bucle 
            for (Carrera carrera : listaCarreras) {

                bw.write(carrera.getNombreCarrera() + "," + carrera.getFecha() + "," + 
                        carrera.getLugar() + ","
                        + carrera.getNumMaxParticipantes() +  '\n');
            }

            //cierro el buffer
            bw.flush();
            bw.close();

        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

    }


    public void aniadirCorredor(Corredor corredor) {

        //añadimos el corredor a la lista
        listaCorredores.add(corredor);
    }

    public void borrarCorredor(Corredor corredor) {
        //borramos el corredor de la lista
        listaCorredores.remove(corredor);
        guardarCsv();
    }

    public LinkedList<Corredor> getListaCorredores() {

        return listaCorredores;
    }

    public void setListaCorredores(LinkedList<Corredor> listaCorredores) {
        this.listaCorredores = listaCorredores;
    }
    
    public void aniadirCarrera(Carrera carrera){
        listaCarreras.add(carrera);
    }

}
