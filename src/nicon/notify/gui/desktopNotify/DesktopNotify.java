/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.gui.desktopNotify;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import nicon.notify.core.NLabel;
import nicon.notify.core.NiconEvent;
import nicon.notify.core.NotifyConfig;
import nicon.notify.core.NotifyUtil;

/**
 *
 * @author frederick
 */
public class DesktopNotify extends JDialog{
    
    
    public static int countNotify=0;
    
    private NiconEvent ev;
    private NotifyConfig config;
    private NotifyUtil util;
    
    private JPanel panel;    
    
    private JLabel jlTitle;
    private NLabel jlMessage;
    private JLabel jlIcon;
    
    private ImageIcon icon;
    private Timer timer;
    
    public DesktopNotify(NiconEvent ev){        
        this.ev=ev;
        config=NotifyConfig.getInstance();
        util=NotifyUtil.getInstance();
        
        setSize(380, 110);
        setUndecorated(true);        
        setAlwaysOnTop(true);
        init();        
        setDesktopInterface();
        closeNotify(this);
    }    

    private void init() {
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new java.awt.Color(0,0,0));
                
        jlIcon=new JLabel();
        jlIcon.setBackground(Color.white);
        jlIcon.setOpaque(true);
        jlIcon.setBounds(5,20,65,65);
        
        jlTitle=new JLabel(ev.getTitleEvent());
        jlTitle.setFont(new Font("Ubuntu",Font.PLAIN,18));
        jlTitle.setBounds(75,18,305, 18);
        
        jlMessage=new NLabel(util.setTextMessageEvent(ev.getTextEvent()));
        jlMessage.setFont(new Font("Ubuntu",Font.PLAIN,12));
        jlMessage.setBounds(78,45,295,80);
        jlMessage.setForeground(Color.lightGray);
                
        panel.add(jlIcon);
        panel.add(jlTitle);
        panel.add(jlMessage);
        add(panel);        
    }
    
    private void setDesktopInterface(){
        if(ev.getTipeMessage()==NiconEvent.NOTIFY_OK){
            icon=new ImageIcon(getClass().getResource("/nicon/notify/gui/Icons/small/NiconOK.png"));
            jlTitle.setForeground(config.getFontOKColor());
        }
        if(ev.getTipeMessage()==NiconEvent.NOTIFY_WARNING){
            icon=new ImageIcon(getClass().getResource("/nicon/notify/gui/Icons/small/NiconWarning.png"));
            jlTitle.setForeground(config.getFontWarningColor());
        }
        if(ev.getTipeMessage()==NiconEvent.NOTIFY_ERROR){
            icon=new ImageIcon(getClass().getResource("/nicon/notify/gui/Icons/small/NiconError.png"));
            jlTitle.setForeground(config.getFontErrorColor());
        }
        jlIcon.setIcon(icon);
    }
    
    private  void closeNotify(final DesktopNotify dialog){
        timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                ControllerDesktopNotify.displayed--;
                timer.stop();
                timer=null;
            }
        });
        timer.start();
    }
    
}
