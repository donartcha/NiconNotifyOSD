/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.core;

/**
 * Esta clase será la encargada de crear objetos del tipo Notifyevent que serán
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
    public final static int NOTIFY_CONFIRM=3;
    
    private int codeEvent;
    private String titleEvent;
    private String textEvent;
    private int tipeMessage;
    private int tipeNotify;
    private int stateEvent;

    /**
     * Este metodo inicializa una nueva instancia de NotifyEvent con los parametros
     * recibidos tales como :<p>
     *  titlo del evento, mensaje a mostrar, tipo de mensaje (Error,Adevertencia etc)
     *  tipo de notificacion si es Window o Desktop Notify, estado del evento.
     *  
     * @param titleEvent
     * @param textEvent
     * @param tipeMessage
     * @param tipeNotify
     * @param stateEvent 
     */
    public NiconEvent(String titleEvent, String textEvent, int tipeMessage, int tipeNotify, int stateEvent) {
        this.titleEvent = titleEvent;
        this.textEvent = textEvent;
        this.tipeMessage = tipeMessage;
        this.tipeNotify = tipeNotify;
        this.stateEvent = stateEvent;
    }

    /**
     * retorna el titulo del objeto NotifyEvent
     * @return String titleEvent
     */
    public String getTitleEvent() {
        return titleEvent;
    }

    /**
     * Ajusta el titulo del NotifyEvent
     * @param titleEvent 
     */
    public void setTitleEvent(String titleEvent) {
        this.titleEvent = titleEvent;
    }

    /**
     * retorna el texto del mensaje del NotifyEvent
     * @return String textEvent
     */
    public String getTextEvent() {
        return textEvent;
    }

    /**
     * Ajusta el texto del evento
     * @param textEvent 
     */
    public void setTextEvent(String textEvent) {
        this.textEvent = textEvent;
    }

    /**
     * retorna el tipo de mensaje que tiene el NotifyEvent (Error,Warning,OK)
     * @return int tipeMessage
     */
    public int getTipeMessage() {
        return tipeMessage;
    }

    /**
     * Este metodo permite ajustar el tipo de mensaje al que será representado
     * el objeto NiconEvent.
     * @param tipeMessage 
     */
    public void setTipeMessage(int tipeMessage) {
        this.tipeMessage = tipeMessage;
    }

    /**
     * Este metodo retorna el tipo de mensaje que ha sido usado para mostrar
     * el objeto NiconEvent.
     * @return int tipeNotify
     */
    public int getTipeNotify() {
        return tipeNotify;
    }

    /**
     * Ajusta el tipo de Notificacion que será usada para mostrar el objeto 
     * NiconEvent, puede ser DesktopNotify o WindowNotify
     * @param tipeNotify 
     */
    public void setTipeNotify(int tipeNotify) {
        this.tipeNotify = tipeNotify;
    }

    /**
     * Este metodo retorna el estado actual del Objeto NiconEvent que se refiere
     * a si el Evento ha sido visto, o esta siendo almacenado.
     * @return in stateEvent
     */    
    public int getStateEvent() {
        return stateEvent;
    }

    /**
     * Este metodo permite Ajustar el estado Actual del evento puede ser, visto,
     * o no visto.
     * @param stateEvent 
     */
    public void setStateEvent(int stateEvent) {
        this.stateEvent = stateEvent;
    }  

    @Override
    public String toString() {
        return "NiconEvent {" + "codeEvent=" + codeEvent + ", titleEvent=" + titleEvent + ", textEvent=" + textEvent + ", tipeMessage=" + tipeMessage + ", tipeNotify=" + tipeNotify + ", stateEvent=" + stateEvent + '}';
    }
    
    
       
}

