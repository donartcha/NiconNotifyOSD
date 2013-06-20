/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.core;

/**
 * Esta clase será la encargada de crear objetos del tipo Notify que será
 * mostrados al usuario a traves de NotifyOSD, cada notifYEvent deberá poseer
 * un codigo de evento que define si es un mensaje de error, de alerta un mensaje
 * positivo.
 * 
 * @author frederick
 */

public class NiconEvent {
    
    public final static int NOTIFY_OK=0;
    public final static int NOTIFY_ERROR=1;
    public final static int NOTIFY_WARNING=2;
    
    private int codeEvent;
    private String titleEvent;
    private String textEvent;
    private int tipeMessage;
    private int tipeNotify;
    private int stateEvent;

    public NiconEvent(String titleEvent, String textEvent, int tipeMessage, int tipeNotify, int stateEvent) {
        this.titleEvent = titleEvent;
        this.textEvent = textEvent;
        this.tipeMessage = tipeMessage;
        this.tipeNotify = tipeNotify;
        this.stateEvent = stateEvent;
    }

    public String getTitleEvent() {
        return titleEvent;
    }

    public void setTitleEvent(String titleEvent) {
        this.titleEvent = titleEvent;
    }

    public String getTextEvent() {
        return textEvent;
    }

    public void setTextEvent(String textEvent) {
        this.textEvent = textEvent;
    }

    public int getTipeMessage() {
        return tipeMessage;
    }

    public void setTipeMessage(int tipeMessage) {
        this.tipeMessage = tipeMessage;
    }

    public int getTipeNotify() {
        return tipeNotify;
    }

    public void setTipeNotify(int tipeNotify) {
        this.tipeNotify = tipeNotify;
    }

    public int getStateEvent() {
        return stateEvent;
    }

    public void setStateEvent(int stateEvent) {
        this.stateEvent = stateEvent;
    }  
       
}

