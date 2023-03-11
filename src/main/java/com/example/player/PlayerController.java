package com.example.player;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.player.PlayerService;
import com.example.player.Player;
@RestController
public class PlayerController{
    PlayerService playerservice=new PlayerService();

    @GetMapping("/players")
    public ArrayList<Player> getPlayer(){
        return playerservice.getPlayer();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayer1(@PathVariable("playerId") int playerId){
        return playerservice.getPlayer1(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player p){
        return playerservice.addPlayer(p);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player p){
        return playerservice.updatePlayer(playerId,p);
    }
    @DeleteMapping("/players/{playerId}")
    public void deleteplayer(@PathVariable("playerId") int playerId){
        playerservice.deleteplayer(playerId);
        
    }
    
}
