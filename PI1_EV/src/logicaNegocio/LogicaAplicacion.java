/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esauj
 */
public class LogicaAplicacion {

    //instanciamos la lista de corredores, sin duplicados y ordenados por el nombre de insercion
    Set<Corredor> listaCorredores = new LinkedHashSet<>();

    File archivo = new File("C:\\Users\\esauj\\OneDrive\\Documentos\\NetBeansProjects\\DI1819\\PI1_EV\\src\\archivoCSV\\listaCorredores.csv");

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

    public void guardarLista() {

        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        MyAppendingObjectOutputStream maoos = null;
        Corredor c;
        Iterator it = listaCorredores.iterator();

        try {
            fos = new FileOutputStream(archivo, true);
            oos = new ObjectOutputStream(oos);

            //confirmamos si existe o no el archivo para añadir el objeto sin o con cabecera
            if (archivo.exists()) {

                //iteramos la lista de corredores de la sesiion y la añadimos al archivo
                while (it.hasNext()) {
                    c = (Corredor) (it.next());
                    maoos.writeObject(c);
                }
            } else {
                //iteramos la lista de corredores de la sesiion y la añadimos al archivo

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

    public void aniadirCorredor(String nombre, String dni, Date fechaNacimiento, String direccion, String telefonoContacto) {

        //creamos un nuevo corredor con el constructor
        Corredor c = new Corredor(nombre, dni, fechaNacimiento, direccion, telefonoContacto);

        //añadimos el corredor a la lista
        listaCorredores.add(c);

        //cargamos el corredor y lo guardamos en el archivo
        guardarLista();
    }

}
