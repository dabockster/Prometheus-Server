/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.plu.cs.controllers;

import edu.plu.cs.views.ClientConnectionView;

/**
 *
 * @author Timothy Ernst
 */
public class ClientConnectionController {
    public String clientID;
    public ClientConnectionView connectionView;
    public ClientConnection clientConnection;
    
    
    
    /**
     * CONSTRUCTOR
     * Creates a new ClientConnectionController object
     */
    public ClientConnectionController(){
        connectionView = new ClientConnectionView(this);
        connectionView.pack();
        connectionView.setVisible(true);
    }
     
    /**
     * SETUP
     * Creates the ClientConnection
     */
    public void setupClient(){
        if(clientConnection == null){
            this.sendClientFeedback("Booting up client.");
        clientConnection = new ClientConnection(this,clientID);
        }
        sendClientFeedback("Client is ready to try and connect.");
    }
    
    /**
     * RELAY MESSAGE
     * Relays a message to the connectionView
     * @param msg the message to be relayed
     */
    public void sendClientFeedback(String msg){
        connectionView.clientFeedback(msg);
    }

    /**
     * SETUP
     * Sends request to connect to server
     * @param serverName the name of the server
     * @param serverPort the port number
     */
    public void connectToServer(String serverName, int serverPort){
        this.setupClient();
        clientConnection.connect(serverName, serverPort);
        connectionView.connected();
    }
    
    /**
     * TEARDOWN
     * Halts ClientConnection communication with UserConnection
     */
    public void closeClientConnection(){
        clientConnection.closeConnection();
    }
    
    /**
     * BUILDS COMMAND
     * Compiles a command to send to ClientConnection to send to the UserConnection
     * @param cmndType the type of command to be transmitted
     * @param data the command data to be transmitted
     */
    public void sendCmnd(String cmndType, String data){
        String cmnd = "error<&>Failed to compile command."; //default cmnd
        switch(cmndType){ //listed alphabetically
            case "login" : //LOGIN
                //get login info from loginScreen
                break;
            case "msg" : //SEND MESSAGE
                cmnd = cmndType+"<&>"+data;
                break;
        }
        clientConnection.sendCmnd(cmnd);
    }
    

    
}
