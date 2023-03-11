package com.example.player;

import com.example.player.Player;
import com.example.player.PlayerRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.*;
 

// Don't modify the below code


public class PlayerService implements PlayerRepository {

    private static HashMap<Integer, Player> team = new HashMap<>();
    int uniquePlayerId = 12;
    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));

        
    }

    // Don't modify the above code

    @Override
    public ArrayList<Player> getPlayer() {
        Collection<Player> players1 = team.values();
        ArrayList<Player> players = new ArrayList<>(players1);
        System.out.println(players);
        return players;
    }

    @Override
    public Player getPlayer1(int playerId){
        Player p=team.get(playerId);
        if(p == null ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
        return p;
    }

    @Override
    public Player addPlayer(Player p){
        p.setplayerId(uniquePlayerId);
        team.put(uniquePlayerId, p);
        uniquePlayerId=uniquePlayerId+1;
        return p;
    }
    @Override
    public Player updatePlayer(int playerId,Player p){
        
        Player existingplayer=team.get(playerId);
        Integer r=Integer.valueOf(p.getJerseyNumber());
        
        if(existingplayer==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (p.getPlayerName() != null) {
            existingplayer.setPlayerName(p.getPlayerName());
        }
        if ( r != null) {
            existingplayer.setJerseyNumber(p.getJerseyNumber());
        }
        
        if (p.getRole() != null) {
            existingplayer.setRole(p.getRole());
        }
        return existingplayer;
    }

    @Override
    public void deleteplayer(int playerId){
        Player p=team.get(playerId);

        if(p == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        else{
            team.remove(playerId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
  

