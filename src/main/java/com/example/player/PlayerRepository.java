package com.example.player;
import java.util.*;
import com.example.player.Player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
public interface PlayerRepository{
    ArrayList<Player> getPlayer();
    Player getPlayer1(int playerId);
    Player addPlayer(Player p);
    Player updatePlayer(int playerId,Player p);
    void deleteplayer(int playerId);
}