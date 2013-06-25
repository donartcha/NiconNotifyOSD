/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.gui.windowNotify;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import nicon.notify.core.NiconEvent;

/**
 * Esta clase definirá la creacion de Objetos del tipo WindowNotify en su 
 * caractiristica de dialogo de confirmacion, por defecto se proponen dos simples
 * opciones de respuesta si / no, esta clase hereda directamente de WindowNotify
 * y ajusta la interfaz a su necesidad.
 * 
 * @author frederick
 */
public class ConfirmNotify extends WindowNotify {

    private JButton yesButton;
    private JButton noButton;
    
    private ImageIcon icon;
    
    private int option=-1;
    
    public ConfirmNotify(NiconEvent ev) {
        super(ev);
        setSize(600, 230);
        init();
    }

    private void init() {      
        icon=new ImageIcon(getClass().getResource("/nicon/notify/gui/Icons/NiconInterrogative.png"));
        setIconMessage(icon);
        setForegroundTitle(new java.awt.Color(90, 130, 202));
        
        jbAcept.setText("Si");
        jbAcept.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                option=0;
            }
        });
        moveAceptButton(450, 170);
        
        noButton=new JButton("No");
        noButton.setBounds(320, 170, 120, 30);
        noButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               option=1;
               dispose();
            }
        });
        addButton(noButton);
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
    
}
