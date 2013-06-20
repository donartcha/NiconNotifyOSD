/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.core;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import nicon.notify.gui.windowNotify.MessageNotify;
import nicon.notify.gui.windowNotify.WindowNotify;

/**
 *
 * @author frederick
 */
public class NotifyFactory {
    
    private static WindowNotify windowNotify;
    private static MessageNotify messageNotify;
    
    public static void showWindowNotfy(NiconEvent ev) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        windowNotify=new WindowNotify(ev);
        windowNotify.setVisible(true);
    }
    
    public static void showNotifyMessage(NiconEvent ev) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        messageNotify=new MessageNotify(ev);
        messageNotify.setVisible(true);
    }
}
