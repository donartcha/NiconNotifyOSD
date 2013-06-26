/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.core;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author frederick
 */
public class NotifyConfig {
    
    private Font titleFont;
    private Font messageFont;
    
    private Color fontErrorColor;
    private Color fontWarningColor;
    private Color fontOKColor;
    private Color fontConfirmColor;
    
    private static NotifyConfig instance;
    
    private NotifyConfig() {
        titleFont=new Font("Verdana",Font.BOLD,20);
        messageFont=new Font("Verdana",Font.PLAIN,14);
        
        fontErrorColor=new java.awt.Color(166,16,12);
        fontWarningColor=new java.awt.Color(230,89,0);
        fontOKColor=new java.awt.Color(116,164,0);
        fontConfirmColor=new java.awt.Color(90, 130, 202);
    } 
      
    public  Font getTitleFont() {
        return titleFont;
    }

    public Font getMessageFont() {
        return messageFont;
    }

    public  Color getFontErrorColor() {
        return fontErrorColor;
    }

    public  Color getFontWarningColor() {
        return fontWarningColor;
    }  

    public  Color getFontOKColor() {
        return fontOKColor;
    }

    public Color getFontConfirmColor() {
        return fontConfirmColor;
    }
        
    public static NotifyConfig getInstance(){
        if(instance==null){
            instance=new NotifyConfig();
        }
        return instance;
    }
    
}
