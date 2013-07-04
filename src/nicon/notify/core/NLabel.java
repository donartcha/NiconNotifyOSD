/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.core;

import javax.swing.JTextArea;

/**
 *
 * @author frederick
 */
public class NLabel extends JTextArea{
    
    private String text;

    public NLabel(String text) {
        super(text);
        this.text = text;
        
        this.setEditable(false);
        this.setLineWrap(true);
        this.setBackground(null);
        this.setBorder(null);
        this.setWrapStyleWord(true);
        this.setFocusable(false);        
    }
    
    
}
