/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.gui.desktopNotify;

import javax.swing.Timer;
import nicon.notify.core.NotifyUtil;

/**
 * Esta clase es la encargada de Controlar y gestionar el buen uso de las 
 * DesktopNotify que ofrece la libreria, el acceso a esta clase permitirá mostrar
 * la notificacion deseada de forma ordenada en el escritorio del dispositivo en 
 * el que se esta ejecutando la aplicacion cliente.
 * 
 * @author frederick
 */
public class ControllerDesktopNotify {

    private static DesktopNotify notifyDesk;
    
    private static NotifyUtil util = NotifyUtil.getInstance();
    
    public static int displayed = 0;
    private static int ypos;
    private static int[] pos = util.getDesktopNotifyPosition();
    private static Timer timer;

    /**
     * Este metodo permite mostrar una notificacion del tipo DesktopNotify o 
     * descendientes (Que heredan directamente de DesktopNotify) en el escritorio
     * del dispositov en ejecucion, permitiendo asi que las notificaciones sean
     * acomodadas segun el orden de llegada 
     * @param notify 
     */
    public static void showNotify(DesktopNotify notify) {
        notifyDesk = notify;
            if (notify != null) {
                System.out.println("ControllerDesktopNotify:  Ajustando notificacion ...");
                ypos=setYAxisPosition();
                notifyDesk.setLocation(pos[0], ypos);
                notifyDesk.setVisible(true);
                displayed++;
            }
    }
    
    /**
     * Este metodo permite Ajustar la posision de una notificacion en su eje Y
     * de acuerdo a parametros de ejecucion como la cantida de notificaciones
     * mostradas en ese momento, asi recalcula un nuevo valor para el eje Y y este
     * es usado al momento de servir la notificacion en el escritorio.
     * 
     * @return int ypos
     */
    private static int setYAxisPosition(){
        if(displayed==0){ 
            System.out.println("Total Notify Displayed:  # "+ displayed);
            ypos=pos[1];
            System.out.println("ControllerDesktopNotify: YAxisPosition #"+ypos);            
        }else {            
            System.out.println("Total Notify Displayed:  # "+ displayed);
            ypos=notifyDesk.getHeight()+30;
            ypos=ypos*displayed;
            System.out.println("ControllerDesktopNotify: YAxisPosition #"+ypos);
        }        
        return ypos;
    }    
   
  
}
