/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.plu.cs.controllers;

import edu.plu.cs.controllers.ClientConnectionController;
import edu.plu.cs.models.ServerModel;
import edu.plu.cs.models.UserProfile;
import edu.plu.cs.views.ServerView;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TO DO ON THIS CLASS:
 * 
 * 
 * @author Timothy Ernst
 */
public class ServerController {
    private ServerView view;
    private ServerConnection connection;
    private ServerModel model;

    //needs to be moved to the model
    public ArrayList<UserConnection> connectedClients;
    private String ipAddress;
    
    
    
    /**
     * CONSTRUCTOR
     * Obtains IP address of the current machine and creates a ServerView.
     */
    public ServerController(){
        InetAddress address;        
        try {
            address = InetAddress.getLocalHost();
            ipAddress = address.getHostAddress();
            view = new ServerView(this, ipAddress);
            view.serverFeedback("Created server.");
            view.serverFeedback("Determined this machine's IP address.");
        } catch (UnknownHostException ex) {
            view.serverFeedback("Failed to identify this machine's IP address.");
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.pack();
        view.setVisible(true);
    }
    
    /** RELAY MESSAGE
     * Relays a message to the view to be displayed
     * @param msg the message to be relayed
     */
    public void sendServerFeedback(String msg){
        view.serverFeedback(msg);
    }
    
    /** RELAY MESSAGE
     * Relays a message to the view to be displayed
     * @param msg the message to be relayed
     */
    public void sendUserConnectionFeedback(String msg){
        view.userConnectionFeedback(msg);
    }
    
    /**
     * SETUP ServerModel
     * Creates a ServerModel object to store all this server's data.
     */
    private void setupServerModel(){
        this.model = new ServerModel(this);
    }
        
    /**
     * SETUP ServerModel
     * Retrieves profiles from a text file.
     * @param fileName the name of the text file with strings of profiles
     * @return an ArrayList of all registered profiles
     */
    public ArrayList<UserProfile> getProfiles(String fileName){
        //Reads a file.txt and return an ArrayList of 
        //all the registered UserProfiles.
        return null;
    }
    
    /**
     * TEARDOWN ServerModel
     * Writes all profiles to a text file.
     * @param 
     */
    public File writeProfiles(ArrayList<UserProfile> allProfiles, String fileName){
        //Takes allProfiles and writes it to file fileName.txt
        return null;
    }
    
    /**
     * SETUP ServerConnection
     * Creates the ServerConnection using the local address and the specified port number.
     * @param port the port to be used by the server
     */
    public void setupServerConnection(int port){
        sendServerFeedback("Setting up ServerConnection.");
        connection = new ServerConnection(this,port);
        new Thread(connection).start();
    }
    /**
     * TEARDOWN ServerConnection
     * Stops the ServerConnection
     */
    public void stopServerConnection(){
        if(connection.isStopped){
            sendServerFeedback("How does one stop that which never began?");
        }else            
            connection.stop();
    }
    
   /**
     * BUILDS COMMANDS FOR UserConnection
     * Compiles a command to send to a specified UserConnection to its ClientConnection
     * @param receivingClient the UserConnection that is connected to designated client
     * @param cmndType the type of command to be transmitted
     * @param data the command data to be transmitted
     */
    public void sendCmnd(UserConnection receivingClient, String cmndType, String data){
        String cmnd = "error<&>Failed to compile command.";
        switch(cmndType){//listed alphabetically
            case "msg" : //SEND MESSAGE
                cmnd = cmndType+"<&>"+data;
                break;
        }
        receivingClient.sendCmnd(cmnd);
    }
    
    /**
     * TO BE DELETED
     * Generates a new client view and sets that client's clientID to the specified value. 
     */
    public void generateNewClientView(){
        ClientConnectionController newClient = new ClientConnectionController();
    }


}
