/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.gui.windowNotify;

import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import nicon.notify.core.NiconEvent;
import nicon.notify.core.NotifyConfig;
import nicon.notify.core.NotifyFactory;

/**
 * Esta clase instancia un objeto del tipo InputNotify que es utilizada para
 * capturar datos simples por parte del usuario, Hereda directamente de
 * WindowNotify y puede retornar los datos ingresados por el usuario.
 *
 * @author frederick
 */
public class InputNotify extends WindowNotify {

    private NotifyConfig config;
    private JTextField textField;
    private JButton jbCancelar;
    private ImageIcon icon;

    public InputNotify(NiconEvent ev) {
        super(ev);
        this.setSize(600, 230);
        config = NotifyConfig.getInstance();
        init();
    }

    private void init() {
        icon=new ImageIcon(getClass().getResource("/nicon/notify/gui/Icons/NiconQuestion.png"));
        setIconMessage(icon);
        this.setForegroundTitle(new java.awt.Color(0, 151, 214));
        
        textField = new JTextField("Ingrese los valores:");
        textField.setBounds(140, 130, 430, 30);
        addTextField(textField);

        jbCancelar = new JButton("Cancelar");
        jbCancelar.setBounds(320, 170, 120, 30);
        addButton(jbCancelar);
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        jbAcept.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getInputData();
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(InputNotify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        moveAceptButton(450, 170);

    }

    public String getInputData() throws UnsupportedLookAndFeelException {
        String data=textField.getText();
            if(data.equals("")){
                NiconEvent ev=new NiconEvent("Not InputData:","No ha ingresado datos",NiconEvent.NOTIFY_ERROR,0,0);
                NotifyFactory.showNotifyMessage(ev);                
            } 
            return data;
    }
}
