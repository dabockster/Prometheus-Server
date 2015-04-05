/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.plu.cs.models;

/**
 *
 * @author Timothy Ernst
 */
public class UserProfile {
    public String username;
    public String password;
    public int gamesPlayed;
    public int wins;
    
    /**
     * CONSTRUCTOR
     * Creates a new UserProfile
     * @param username
     * @param password 
     */
    public UserProfile(String username, String password){
        this.username = username;
        this.password = password;
        this.gamesPlayed = 0;
        this.wins = 0;
    }
    
    /**
     * CONSTRUCTOR
     * Creates a UserProfile from a String of all its attributes
     */
    public UserProfile(String stats){
        //stubout
    }
    
    /**
     * Returns a string representation of this UserProfile object
     * @return 
     */
    @Override
    public String toString(){
        //returns a string with <&> seperating 
        return null;
    }
    
    /**
     * EXECUTE
     * Increments games played, if win is true also increments
     * this.wins
     * @param win 
     */
    public void playedGame(boolean win){
        if(win)
            this.wins++;
        gamesPlayed++;                  
    }
}
