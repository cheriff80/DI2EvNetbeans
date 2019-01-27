/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.lowagie.text.pdf.codec.CCITTG4Encoder;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author esauj
 */
public class ListaCorredores extends AbstractListModel {
    
    private  ArrayList<Corredor> lista = new ArrayList<>();

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int i) {
      Corredor c = lista.get(i);
      return c.getNombre()+" , " +c.getDni();
    }
    
    public void addCorredor(Corredor corredor){
        lista.add(corredor);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    
    
    public void eliminarCorredor(int index0){
        lista.remove(index0);
        this.fireIntervalRemoved(index0, getSize(), getSize()+1);
    }
    public Corredor getPersona(int index){
        return lista.get(index);
    }
    
}
