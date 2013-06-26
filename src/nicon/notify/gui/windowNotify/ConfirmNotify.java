/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.gui.windowNotify;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import nicon.notify.core.NiconEvent;
import nicon.notify.core.NotifyConfig;

/**
 * Esta clase definirá la creacion de Objetos del tipo WindowNotify en su 
 * caractiristica de dialogo de confirmacion, por defecto se proponen dos simples
 * opciones de respuesta si / no, esta clase hereda directamente de WindowNotify
 * y ajusta la interfaz a su necesidad.
 * 
 * @author frederick
 */
public class ConfirmNotify extends WindowNotify {

    private JButton noButton;
    
    private NiconEvent ev;
    private NotifyConfig config;
    private String textAceptButton="Si";
    private String textCancelButton="No";
    
    private ImageIcon icon;
    
    private int option=-1;
    
    /**
     * Este Consructor permite crea una nueva ConfirmNotify recibiendo un 
     * evento del tipo NiconEvent a mostrar
     * @param ev 
     */
    public ConfirmNotify(NiconEvent ev) {
        super(ev);
        this.ev=ev;
        config=NotifyConfig.getInstance();
        setSize(600, 230);
        init();
        setTypeNotify();
    }
    
    /**
     * Este metodo permite crear una nueva ConfirmNotify recibiendo como parametros
     * el evento a mostrar y el texto del boton aceptar y cancelar.
     * @param ev
     * @param buttonText 
     */
    public ConfirmNotify(NiconEvent ev, String yesbuttonText,String noButtonText ){
        super(ev);
        this.ev=ev;
        this.textAceptButton=yesbuttonText;
        this.textCancelButton=noButtonText;
        config=NotifyConfig.getInstance();
        setSize(600, 230);
        init();
        setTypeNotify();
    }

    private void init() {       
        
        jbAcept.setText(textAceptButton);
        jbAcept.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                option=0;
            }
        });
        moveAceptButton(450, 170);
        
        noButton=new JButton(textCancelButton);
        noButton.setBounds(320, 170, 120, 30);
        noButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               option=1;
               dispose();
            }
        });
        addButton(noButton);
        this.getRootPane().setDefaultButton(jbAcept);
    }
    
    /**
     * Este metodo retorna la opcion que ha seleccionado el usuario al momento
     * de escogar una opcion propuesta por el desarrollador, en ella si el usuariio
     * presiona el boton si se retornara el valor 0 en caso de decidir que no se
     * retornará el valor 1.
     * 
     * @return int option
     */
    public int getSelectedOption(){        
        return option;
    }

    /**
     * Este metodo se encarga de ajustar la ConfirmNotify de acuerdo al entorno
     * de ejecucion o  al tipo de evento que se desea informar, bien sea de 
     * confirmacion de notificacion de error o de advertencia o de Exito.
     */
    private void setTypeNotify() {
        if(ev.getTipeMessage()==NiconEvent.NOTIFY_CONFIRM){
            icon=new ImageIcon(getClass().getResource("/nicon/notify/gui/Icons/NiconInterrogative.png")); 
            setForegroundTitle(config.getFontConfirmColor());
        }
       if(ev.getTipeMessage()==NiconEvent.NOTIFY_WARNING){
           icon=new ImageIcon(getClass().getResource("/nicon/notify/gui/Icons/NiconWarning.png")); 
           setForegroundTitle(config.getFontWarningColor());
       }
       if(ev.getTipeMessage()==NiconEvent.NOTIFY_ERROR){
           icon=new ImageIcon(getClass().getResource("/nicon/notify/gui/Icons/NiconError.png")); 
           setForegroundTitle(config.getFontErrorColor());
       }
       if(ev.getTipeMessage()==NiconEvent.NOTIFY_OK){
           icon=new ImageIcon(getClass().getResource("/nicon/notify/gui/Icons/NiconOK_1.png"));  
           setForegroundTitle(config.getFontOKColor());
       }
       setIconMessage(icon);
    }
    
}
