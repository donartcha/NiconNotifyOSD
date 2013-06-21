/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.gui.windowNotify;

import javax.swing.ImageIcon;
import nicon.notify.core.NiconEvent;
import nicon.notify.core.NotifyConfig;

/**
 *
 * @author frederick
 */
public class MessageNotify extends WindowNotify{
    
    private NiconEvent ev;
    private ImageIcon icon;
    
    private NotifyConfig config;
    
    public MessageNotify(NiconEvent ev) {        
        super(ev);
        config=NotifyConfig.getInstance();
        init();
    }

    private void init() {
        ev=getEv();
       if(ev.getTipeMessage()==NiconEvent.NOTIFY_OK){
           icon=new ImageIcon(getClass().getResource("/nicon/notify/gui/Icons/NiconOK_1.png"));
           this.setForegroundTitle(config.getFontOKColor());
           this.setIconMessage(icon);
           
       }
       
       if(ev.getTipeMessage()==NiconEvent.NOTIFY_WARNING){
           icon=new ImageIcon(getClass().getResource("/nicon/notify/gui/Icons/NiconWarning.png"));
           this.setForegroundTitle(config.getFontWarningColor());
           this.setIconMessage(icon);
       }
       
       if(ev.getTipeMessage()==NiconEvent.NOTIFY_ERROR){
           icon=new ImageIcon(getClass().getResource("/nicon/notify/gui/Icons/NiconError.png"));
           this.setForegroundTitle(config.getFontErrorColor());
           this.setIconMessage(icon);
       }
    }
    
}
