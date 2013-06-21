/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.core;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import nicon.notify.gui.windowNotify.InputNotify;
import nicon.notify.gui.windowNotify.MessageNotify;
import nicon.notify.gui.windowNotify.WindowNotify;

/**
 * NotifyFactory es una clase que ofrece en su mayoria metodo estaticos para
 * la creacion de una multitud de tipos de WindowNotify o DesktopNotify, 
 * @author frederick
 */
public class NotifyFactory {
    
    private static WindowNotify windowNotify;
    private static MessageNotify messageNotify;
    private static InputNotify inputNotify;
    private static String response;
    
    /**
     * Este metodo crea una caja de Dialogo del tipo WindowMessage para mostrar
     * una información cualquiera, este metodo puede ser accedido desde cualquier
     * lugar a traves de NotifyFactory.
     * 
     * @param ev
     * @throws UnsupportedLookAndFeelException 
     */
    public static void showWindowNotify(NiconEvent ev) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        windowNotify=new WindowNotify(ev);
        windowNotify.setVisible(true);
    }
    
    /**
     * Este metodo crea una caja de Dialogo del tipo NotifyMessage para mostrar
     * una información especifica de un determinado estado del mensaje, bien puede
     * ser de Error, Advertencia u OK este metodo puede ser accedido desde cualquier
     * lugar a traves de NotifyFactory.
     * @param ev
     * @throws UnsupportedLookAndFeelException 
     */
    public static void showNotifyMessage(NiconEvent ev) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        messageNotify=new MessageNotify(ev);
        messageNotify.setVisible(true);
    }
    
    /**
     * Este metodo crea una caja de Dialogo del tipo InputMessage para que el usuario
     * pueda ingresar datos hacia la aplicacion, los datos son retornados como una
     * cadena de String, este metodo puede ser accedido desde cualquier
     * lugar a traves de NotifyFactory.
     * @param ev
     * @return
     * @throws UnsupportedLookAndFeelException 
     */
    public static String showInputNotify(NiconEvent ev) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        inputNotify=new InputNotify(ev);
        inputNotify.setVisible(true);
            while(inputNotify.isShowing()!=true){
                response=inputNotify.getInputData();
                System.out.println("Dato Ingresado:  "+response);
                break;
            }
        return response;
    }
}
