package com.fantasybuddy.user.fuudi;

/**
 * Created by William G on 11/28/2015.
 */
import android.content.Context;

import java.util.ArrayList;
import java.util.Hashtable;

public class PlayerDatabase {

    Hashtable<String, Player>playerIdDatabase;
    Hashtable<String, Player>playerNameDatabase;

    ArrayList<Player> playerList;

    Context context;

    public PlayerDatabase(Context context){
        this.context = context;
        playerIdDatabase = new Hashtable<String, Player>();
        playerNameDatabase = new Hashtable<String, Player>();
        updateDatabases();
    }
    
    /**
     * merge the raw data into the database
     */
    private void updateDatabases(){
        PlayerTextFileHandler textHandler = new PlayerTextFileHandler(context);
        playerList = textHandler.getPlayers();
        for(int i = 0; i < playerList.size(); i++){
            Player currentPlayer = playerList.get(i);
            String playerName = currentPlayer.getFirstName() + " " +
		                currentPlayer.getLastName();
            String playerId = currentPlayer.getId();
            playerIdDatabase.put(playerId, currentPlayer);
            playerNameDatabase.put(playerName.toLowerCase(), currentPlayer);
        }
    }

    public Hashtable<String, Player> getPlayerIdDatabase(){
        return playerIdDatabase;
    }

    public Hashtable<String, Player> getPlayerNameDatabase(){
        return playerNameDatabase;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
}
