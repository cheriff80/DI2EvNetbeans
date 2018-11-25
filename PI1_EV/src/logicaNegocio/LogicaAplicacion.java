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
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    //declaramos la ruta absoluta del archivo CSV
    private final File NOMBRE_ARCHIVO_CSV = new File("resources\\listaCorredores.csv");
    private final File NOMBRE_ARCHIVO = new File("resources\\listaCorredores.dat");
    private final File NOMBRE_ARCHIVO_CSV_CARRERAS = new File("resources\\carreras.csv");
    private final File NOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS = new File("resources\\carrerasAcabadas.csv");
    private final File NOMBRE_ARCHIVO_TEMPOTAL = new File("resources\\lista.tmp");

    public File getNOMBRE_ARCHIVO_CSV() {
        return NOMBRE_ARCHIVO_CSV;
    }

    public File getNOMBRE_ARCHIVO() {
        return NOMBRE_ARCHIVO;
    }

    public File getNOMBRE_ARCHIVO_CSV_CARRERAS() {
        return NOMBRE_ARCHIVO_CSV_CARRERAS;
    }

    public File getNOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS() {
        return NOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS;
    }
   public Corredor tokenizar(String linea) {

        Corredor c=null;

        StringTokenizer tokens = new StringTokenizer(linea, ",");
        while (tokens.hasMoreTokens()) {
            String nombre = tokens.nextToken();
            String dni = tokens.nextToken();
            String fechaNacimiento = tokens.nextToken();
            String direccion = tokens.nextToken();
            String telefono = tokens.nextToken();

            c = new Corredor(nombre, dni, fechaNacimiento, direccion, telefono);
            
        }return c;

    }

    public void tokenizarCarreras(String linea) {
        Carrera ca;

        StringTokenizer tokens = new StringTokenizer(linea, ",");
        while (tokens.hasMoreTokens()) {
            String nombreCarrera = tokens.nextToken().trim();
            String fechaCarrera = tokens.nextToken().trim();
            String lugar = tokens.nextToken().trim();
            int numMaxParticipantes = Integer.parseInt(tokens.nextToken().trim());

            ca = new Carrera(nombreCarrera, fechaCarrera, lugar, numMaxParticipantes);
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

    public void cargarCSVCarrerasAcabadas() {

        FileReader fr = null;
        BufferedReader br = null;
        String linea;

        try {
            fr = new FileReader(NOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS);
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

    public void guardarCsvCarreras(File file) {

        
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);

            //declaro el bucle 
            
            
          
            for (Carrera carrera : listaCarreras) {
                if (!carrera.isAcabada()) {
                    bw.write(carrera.getNombreCarrera() + "," + carrera.getFecha() + ","
                            + carrera.getLugar() + ","
                            + carrera.getNumMaxParticipantes() + '\n');
                }
            }

            //cierro el buffer
            bw.flush();
            bw.close();

        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    public void guardarCsvCarrerasAcabadas() {

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            fw = new FileWriter(NOMBRE_ARCHIVO_CSV_CARRERAS_ACABADAS, true);
            bw = new BufferedWriter(fw);

            //declaro el bucle 
            for (Carrera carrera : listaCarreras) {
                if (carrera.isAcabada()) {
                    bw.write(carrera.getNombreCarrera() + "," + carrera.getFecha() + ","
                            + carrera.getLugar() + ","
                            + carrera.getNumMaxParticipantes() + '\n');
                }
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
        guardarCsv(NOMBRE_ARCHIVO_TEMPOTAL);
        
        //borro el archivo viejo
        NOMBRE_ARCHIVO_CSV.delete();
        
        //nombre el archivo temporal que he creado como el antiguo
        NOMBRE_ARCHIVO_TEMPOTAL.renameTo(NOMBRE_ARCHIVO_CSV);
        
    }

    public void borrarCorredor(Corredor corredor) {
        //borramos el corredor de la lista
        listaCorredores.remove(corredor);
        
        guardarCsv(NOMBRE_ARCHIVO_TEMPOTAL);
        
        //borro el archivo viejo
        NOMBRE_ARCHIVO_CSV.delete();
        
        //nombre el archivo temporal que he creado como el antiguo
        NOMBRE_ARCHIVO_TEMPOTAL.renameTo(NOMBRE_ARCHIVO_CSV);
    } 

    public LinkedList<Corredor> getListaCorredores() {
        return listaCorredores;
    }

    public void setListaCorredores(LinkedList<Corredor> listaCorredores) {
        this.listaCorredores = listaCorredores;
    }

    public void aniadirCarrera(Carrera carrera) {
        listaCarreras.add(carrera);
        guardarCsvCarreras(NOMBRE_ARCHIVO_TEMPOTAL);
        
        //borro el archivo viejo
        NOMBRE_ARCHIVO_CSV_CARRERAS.delete();
        
        //nombre el archivo temporal que he creado como el antiguo
        NOMBRE_ARCHIVO_TEMPOTAL.renameTo(NOMBRE_ARCHIVO_CSV_CARRERAS);
    }

    public LinkedList<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    public void setListaCarreras(LinkedList<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public void borrarCarrera(Carrera carrera) {
        //borramos el corredor de la lista
        listaCarreras.remove(carrera);
        guardarCsvCarreras(NOMBRE_ARCHIVO_TEMPOTAL);
        
        //borro el archivo viejo
        NOMBRE_ARCHIVO_CSV_CARRERAS.delete();
        
        //nombre el archivo temporal que he creado como el antiguo
        NOMBRE_ARCHIVO_TEMPOTAL.renameTo(NOMBRE_ARCHIVO_CSV_CARRERAS);
    }

    
}
