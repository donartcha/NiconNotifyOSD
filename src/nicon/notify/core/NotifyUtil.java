/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.core;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * NotifyUtil crea un objeto que se encarga de proveer metodos y herramientas
 * de utilidad a toda la libreria NiconNotifyOSD, asi todos los componentes y clases
 * del sistema podrán acceder a estas utilidades de forma simple.
 * @author frederick
 */
public class NotifyUtil {
    
    private static NotifyUtil instance;
    
    private int [] screenResol;
    private int [] notifyPosition;
    private Toolkit tk;
    private Dimension screen;
    private String textMessage;
    
    
    private NotifyUtil(){
        
    }
    
    /**
     * Retorna la resolucion de la pantalla en la que se esta ejecutando la app, 
     * 
     * @return int [] screnResol
     */
    public int[] getScreenResulotion(){
        screenResol=new int[2];
        screen=new Dimension();
        tk = Toolkit.getDefaultToolkit();
        screen = tk.getScreenSize();
        screenResol[0]=screen.width;
        screenResol[1]=screen.height;
        
        return screenResol;
    }
    
    /**
     * Este metodo se encarga de calcular la posision inicial de una Notificacion
     * dentro de la pantalla del dispositivo en el cual se esta ejecutando la app
     * este calculo tiene en cuenta los ejes X / Y en los cuales se posisionará
     * por defecto la 1ra notificacion a mostrar
     * @return 
     */
    public int[] getDesktopNotifyPosition(){
        System.out.println("Calculando posision de la notificacion ...");
        notifyPosition=new int [2];
        screenResol=getScreenResulotion();
        
        /*
         * NotifyPosition es un vector de tamaño 2 que representa la ubicacion
         * de un objeto en los ejes X , Y, en la posision cero del vector se 
         * almacenará la posision respectiva al eje x de la notificacion y en la 
         * posison 1 se almacenará la posision respectiva al eje Y de la notificacion.
         */
         notifyPosition[0]=screenResol[0]-380-5;
         notifyPosition[1]=20;
        return notifyPosition;
    }
    
    /**
     * Este metodo se encarga de ajustar el texto que se mostrará en una Notificacion, 
     * este ajuste se hace para las DesktoNotify, en caso de que un String con el
     * mensaje a mostrar en la notificacion tenga mas de 180 caracteres entonces
     * este texto será reajustado a un nuevo String en el cual estarán los caracteres
     * entre 0 y 180 y que será mostrados como Intro
     * @param text
     * @return String texxtMessage
     */
    public String setTextMessageEvent(String text){
        textMessage=text;
        if(textMessage.length()>180){
            textMessage=text.substring(0,180);
        }
        return this.textMessage;
    }     
    
    /**
     * Retorna uuna Instancia de la Clase NotifyUtil.
     * @return 
     */
    public static NotifyUtil getInstance(){
        if(instance==null){
            instance=new NotifyUtil();
        }
        return instance;
    }
}
