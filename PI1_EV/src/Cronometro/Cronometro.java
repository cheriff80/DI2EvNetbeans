/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cronometro;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author esauj
 */
public  class Cronometro extends JLabel implements Serializable {
   
   
    private int h,min,seg,cs;
    private Timer t;
    private DobleClickListener dobleClick;
    private String tiempoFinal;
    private ActionListener acciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            cs++;
            if(cs==100){
                cs=0;
                seg++;
            }if(seg==60){
                seg=0;
                min++;
            }if(min==60){
                min=0;
                h++;
            }actualizarLabel();
        }
    };
    
    public Cronometro() {
        t = new Timer(10, acciones);
        actualizarLabel();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                
                if(dobleClick!= null)
                super.mouseClicked(me);
                int i = me.getClickCount();
                i=0;
                if(me.getClickCount()==2){
                    dobleClick.dobleClick();
                }
            }
            
            
        });
                
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }

    public int getCs() {
        return cs;
    }

    public void setCs(int cs) {
        this.cs = cs;
    }

    public Timer getT() {
        return t;
    }

    public void setT(Timer t) {
        this.t = t;
    }

    public ActionListener getAcciones() {
        return acciones;
    }

    public void setAcciones(ActionListener acciones) {
        this.acciones = acciones;
    }

    public String getTiempoFinal() {
        return tiempoFinal;
    }

    public void setTiempoFinal(String tiempoFinal) {
        this.tiempoFinal = tiempoFinal;
    }
    
    
    
    

    
    
    public void actualizarLabel(){
        String tiempo = (h<=9?"0":"")+h+":"+(min<=9?"0":"")+min+":"+(seg<=9?"0":"")+seg
                +":"+(cs<=9?"0":"")+cs;
        this.setText(tiempo);
        this.tiempoFinal=tiempo;
    }
    
    public void start(){
        t.start();
        
    }
    
    public void stop(){
        t.stop();
    }
    
    public void addDobleClick(DobleClickListener dobleClick){
        this.dobleClick=dobleClick;
    }
    public void removeDobleClick(DobleClickListener dobleClick){
        this.dobleClick=null;
    }

  

    
    
    
    
    
    
}
