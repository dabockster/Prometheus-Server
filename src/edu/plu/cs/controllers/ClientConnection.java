/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.plu.cs.controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Timothy Ernst
 */
public class ClientConnection implements Runnable{
    private final String clientID;
    private final ClientConnectionController controller;
    private boolean connected = false;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket server;
    
    
    /**
     * CONSTRUCTOR
     * Default constructor
     * @param control the ClientConnectionController for this Client
     * @param id this client's clientID
     */
    public ClientConnection(ClientConnectionController control, String id){
        this.controller = control;
        this.clientID = id;
    }
    
    /**
     * RELAY MESSAGE
     * Sends a message to the controller to relay to the view.
     * @param msg
     */
    public void sendClientFeedback(String msg){
        controller.sendClientFeedback(msg);
    }
    
    /**
     * SETUP
     * Attempts to connect this ServerConnection to a server at the designated address.
     * @param serverName the IP name of the server
     * @param serverPort the port number of the server's socket
     * @return 
     */
    public boolean connect(String serverName, int serverPort){
        this.sendClientFeedback("Connecting to ServerConnection at the IP "+serverName + ", Port "+serverPort+".");
        try{
            server = new Socket(serverName, serverPort);
            this.sendClientFeedback("Successfully connected to ServerConnection.");
            establishCommunicationWithClient();
            connected = true;
            return true;
        }catch(IOException e){
            this.sendClientFeedback("Error connecting to ServerConnection.");
            throw new RuntimeException("Failed to connect to ServerConnection.",e);
        }
    }
    
    /**
     * TEARDOWN
     * Closes serverSocket and sets connection to false.
     * Cease all communication with server.
     */
    public void closeConnection(){
        this.connected = false;
        try {
            server.close();
        } catch (IOException ex) {
            this.sendClientFeedback("Failed to close connection.");
        }
    }
    
    /**
     * SETUP
     * Initializes in and out to allow this to read from and write to the UserConnection
     */
    private void establishCommunicationWithClient(){
        try{
            in = new DataInputStream(server.getInputStream());
            out = new DataOutputStream(server.getOutputStream());
            this.sendClientFeedback("Established communication with UserConnection.");
        } catch (IOException e){
            this.sendClientFeedback("ClientConnection failed to establish communcation with UserConnection.");
            if(!connected){
                this.sendClientFeedback("Handler is not connected to UserConnection.");
            }
        }
    }
    
    /**
     * NETWORK COMMUNICATIONS
     * manages all interactions with this UserConnection.
     */
    @Override
    public void run() {
        this.sendClientFeedback("Prepared to read and write data to ServerConnection.");
        while(connected){
            try{
                String msg = in.readUTF();
                String msgComposition[] = msg.split("<&>");
                interpretServerCmnd(msgComposition);
            } catch (IOException ex) {
                connected = false;
                this.sendClientFeedback("ClientConnection left without saying goodbye.");            
            }
        }
    }
    
    /**
     * NETWORK COMMUNICATIONS
     * Transmits a command to UserConnection
     * @param cmnd the command to be sent
     */
    public void sendCmnd(String cmnd){
        this.sendClientFeedback("Transmitting command to UserConnection.");
        try{
            out.writeUTF(cmnd);
            this.sendClientFeedback("Transmission sent.");
        } catch(IOException e){
            this.sendClientFeedback("Failed to send message to server.");
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
    private void interpretServerCmnd(String[] cmndComponents){
        switch(cmndComponents[0]){
            case "msg" :
                //perform action to send msg
                break;
        }
    }
    
}
