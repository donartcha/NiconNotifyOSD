/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.gui.windowNotify;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import nicon.notify.core.NiconEvent;
import nicon.notify.core.NotifyConfig;

/**
 *
 * @author frederick
 */
public class WindowNotify extends JDialog {
      

    private JPanel panel;
    private JLabel jlIcon;
    private JLabel jlTitle;
    private JLabel jlMessage;
    private ImageIcon image;
    private JButton jbAcept;
    
    private NiconEvent ev;
    private NotifyConfig config;

    public WindowNotify(NiconEvent ev) {
        this.setTitle(ev.getTitleEvent());
        this.setModal(true);
        this.setSize(600,210);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        image=new ImageIcon(getClass().getResource("/nicon/notify/gui/Icons/NiconOK.png"));
        config=NotifyConfig.getInstance();
        this.ev = ev;
        init();
    }

    private void init() {
        panel = new JPanel();
        panel.setBackground(new java.awt.Color(35, 35, 35));
        panel.setLayout(null);

        jlTitle=new JLabel(ev.getTitleEvent());
        jlTitle.setBounds(80, 10,600, 30);
        jlTitle.setFont(config.getTitleFont());
        jlTitle.setForeground(Color.white);
        
        jlMessage=new JLabel(ev.getTextEvent());
        jlMessage.setBounds(140, 40,500, 100);
        jlMessage.setVerticalTextPosition(SwingConstants.TOP);
        jlMessage.setFont(config.getMessageFont());
        jlMessage.setForeground(Color.gray);
        
        jlIcon=new JLabel();
        jlIcon.setIcon(image);
        jlIcon.setBounds(15,50,80,80);
        
        jbAcept=new JButton("Aceptar");
        jbAcept.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dispose();
                    ev=null;
                } catch (Throwable ex) {
                    Logger.getLogger(WindowNotify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jbAcept.setBounds(450, 150, 120,30);
                
        panel.add(jlTitle);
        panel.add(jlMessage);
        panel.add(jlIcon);
        panel.add(jbAcept);
        
        add(panel);
    }
    
    public void setTitleNotify(String title){
        this.jlTitle.setText(title);
    }
    
    public void setMessage(String message){
        this.jlMessage.setText(message);
    }
    
    public void setIconMessage(ImageIcon icon){
        this.image=icon;
        this.jlIcon.setIcon(icon);
    }
    
    public void setForegroundTitle(Color color){
        this.jlTitle.setForeground(color);
    }

    public NiconEvent getEv() {
        return ev;
    }
    
    
}
