/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.plu.cs.controllers;

import edu.plu.cs.models.UserProfile;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Timothy Ernst
 */
public class UserConnection implements Runnable {
    private final ServerController controller;
    private final Socket client;
    
    private UserProfile userProfile; //add getter method
    
    private DataInputStream in;
    private DataOutputStream out;
    public String username = "Anonymous";
    public boolean connected = true;
    
    /**
     * CONSTRUCTOR
     * Creates a new UserConnectionHandler object and assigns its controller and socket.
     * @param controller this UserConnectionHandler's controller
     * @param newClient the socket to be threaded
     */
    public UserConnection(ServerController controller, Socket newClient){
        this.controller = controller;
        this.client = newClient;
    }
    
    /**
     * SETUP
     * Creates means to read and write to from the ClientConnection
     */
    private void establishCommunicationWithClient(){
        try{
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
            this.sendServerFeedback("This UserConnection established communication ClientConnection.");
        } catch (IOException e){
            this.sendServerFeedback("This UserConnection failed to establish communcation with ClientConnection.");
            if(!connected){
                this.sendServerFeedback("This UserConnection is not connected to ClientConnection.");
            }
        }
    }
    
    /**
     * TEARDOWN
     * Closes client and sets connection to false.
     */
    public void closeUserConnection(){
        this.connected=false;
        try{
            this.sendUserConnectionFeedback("Closed UserConnection.");
            client.close();
        } catch (IOException ex){
            this.sendUserConnectionFeedback("Failed to close UserConnection.");
        }
    }
    
    /**
     * RELAY MESSAGE
     * Sends a message to server controller to relay to view.
     * @param msg 
     */
    private void sendServerFeedback(String msg){
        controller.sendServerFeedback(msg);
    }
    
    /**
     * RELAY MESSAGE
     * Sends a message to server controller to relay to view.
     * @param msg 
     */
    private void sendUserConnectionFeedback(String msg){
        controller.sendUserConnectionFeedback(username+": "+ msg);
    }
    
    /**
     * NETWORK COMMUNICATIONS
     * Manages all interactions with this ClientConnection.
     */
    @Override
    public void run(){
        establishCommunicationWithClient();
        while(connected){
            try{
                String cmnd = in.readUTF();
                String cmndParts[] = cmnd.split("<&>");
                interpretClientCmnd(cmndParts);
            } catch (IOException ex) {
                connected = false;
                this.sendUserConnectionFeedback("ClientConnection left without saying goodbye.");            
            }
        }
    }
    
    /**
     * NETWORK COMMUNICATIONS
     * Transmits a command to ClientConnection
     * @param cmnd the command to be sent
     */
    public void sendCmnd(String cmnd){
        sendUserConnectionFeedback("Transmitting command to ClientConnection.");
        try{
            out.writeUTF(cmnd);
            sendUserConnectionFeedback("Transmission sent.");
        } catch(IOException e){
            sendUserConnectionFeedback("Failed to send message to server.");
        }
    }    
    
    /**
     * INTERPRET COMMUNICATIONS
     * Receives a string, assesses the string's purpose, then executes an operation.
     * This method takes an array of Strings and interprets the first index 
     * to determine an operation. The method then passes the unused indexes
     * of the string array to the method of the subsequent operation.
     * @param cmndComponents the string array to be interpreted 
     */
    private void interpretClientCmnd(String[] cmndComponents){
        switch(cmndComponents[0]){
            case "error":
                this.errorCmnd(cmndComponents[1]);
                break;
            case "login" :
                //perform action to login
                break;
            case "msg" :
                msgCmnd(cmndComponents[1]);
                break;
            case "setUsername" :
                //perform action to set username
                break;
            }
    }
    
    /**
     * EXECUTE COMMAND
     * This relays a message to userConnectionFeedback signaling an error.
     * @param errorMsg the error message to be relayed
     */
    private void errorCmnd(String errorMsg){
        this.sendUserConnectionFeedback(errorMsg);
    }
    
    /**
     * EXECUTE COMMAND
     * This receives a message from ClientConnection and
     * relays it to userConnectionFeedback.
     * @param msg the message to be relayed
     */
    private void msgCmnd(String msg){
        this.sendUserConnectionFeedback(msg);
    }

    
}
    
