/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.plu.cs.models;

import edu.plu.cs.controllers.ServerController;
import edu.plu.cs.controllers.UserConnection;
import java.util.ArrayList;

/**
 *
 * @author Timothy Ernst
 */
public class ServerModel {
    
    private final ServerController controller;
    
    public ArrayList<UserConnection> online; //everyone that is logged in
    public ArrayList<UserProfile> allRegisteredPlayers; //all possible players
    
    
    /**
     * CONSTRUCTOR
     * Creates a new ServerModel object and sets its controller equal to controller
     * @param controller the ServerController for this ServerModel
     */
    public ServerModel(ServerController controller){
        this.controller = controller;
    }
}
