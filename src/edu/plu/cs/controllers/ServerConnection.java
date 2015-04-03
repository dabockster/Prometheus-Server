/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.plu.cs.controllers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Timothy Ernst
 */
public final class ServerConnection implements Runnable {
    
    private final ServerController controller;
    private final int serverPort; 
    private ServerSocket serverSocket = null;
    protected Thread acceptingNewClients;
    public boolean isStopped = false;

    /**
     * CONSTRUCTOR
     * This creates a new ServerConnection object to accept incoming 
     * ClientConnections.
     * @param control the ServerController for this ServerConnection
     * @param portNum the port through which the server is running
     */
    public ServerConnection(ServerController control, int portNum){
        this.controller = control;
        this.serverPort = portNum;
    }
        
    /**
     * SETUP
     * Initializes the ServerConnection socket on port serverPort.
     */
    private void openServerConnection(){
        try{
            this.serverSocket = new ServerSocket(this.serverPort);
            this.sendServerFeedback("ServerConnection is open and ready for business on port "+serverPort+"!");
        } catch (IOException e) {
            this.sendServerFeedback("Failed to open port "+serverPort+".");
            throw new RuntimeException("Cannot open port "+serverPort+".", e);
        }
    }
    
    /**
     * TEARDOWN
     * Stops the ServerConnection it is no longer accepting new clients.
     */
    public synchronized void stop(){
        this.isStopped = true;
        try{
            this.serverSocket.close();
            this.sendServerFeedback("Server is terminating.");
        } catch ( IOException e ) {
            this.sendServerFeedback("Server failed to terminate.");
            throw new RuntimeException("Error closing server.", e);
        }
    } 
    
    /**
     * RELAY MESSAGE
     * Sends a message to the controller to relay to the view.
     * @param msg 
     */
    public void sendServerFeedback(String msg){
        controller.sendServerFeedback(msg);
    }
   
    /**
     * NETWORK COMMUNICATIONS
     * Runs the ServerConnection and accepts then handles incoming clients.
     */
    @Override
    public void run() {
        this.sendServerFeedback("Running ServerConnection.");
        synchronized(this){
            this.acceptingNewClients = Thread.currentThread();
        }
        openServerConnection();
        while(! isStopped()){
            Socket client = null;
                try{
                    this.sendServerFeedback("ServerConnection is listening for incoming ClientConnections.");
                    client = this.serverSocket.accept();
                    this.sendServerFeedback("Incoming! We have accepted a ClientConnection!");
                } catch (IOException e){
                    if(isStopped()){
                        this.sendServerFeedback("ServerConnection isStopped.");
                        return;
                    }
                    throw new RuntimeException("Error accepting ClientConnection.",e);
                }
                new Thread( new UserConnection(controller, client)).start();
                this.sendServerFeedback("ServerConnections has delegated a UserConnection thread to the ClientConnection.");
        }
    }
    
    /**
     * HELPER
     * Returns true if the ServerConnection is not accepting clients
     * and returns false if the server is accepting clients.
     * @return true if server is isStopped
     */
    private synchronized boolean isStopped(){
        return this.isStopped;
    }
    
}
