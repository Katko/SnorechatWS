/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snorechatws;


/**
 *
 * @author Katerina,Michalis
 */
public class Message {
    private String message;
    private String sender;
    private String received;

    public final String getMessage() {
        return message;
    }

    public final void setMessage(final String message) {
        this.message = message;
    }

    public final String getSender() {
        return sender;
    }

    public final void setSender(final String sender) {
        this.sender = sender;
    }

    public final String getReceived() { 
        return received;
    }

    public void setReceived(final String received) {
        this.received = received;
    }
    @Override
    public String toString(){
        return "Message [message=" + message + ",sender=" + sender +",received=" + received + "]";
    }
    
}
