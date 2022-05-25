package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MethodsInterface;
import com.example.demo.entity.PlayerInfo;

@RestController
@RequestMapping("/rest")
public class ModelController {

	@Autowired
	MethodsInterface serviceMethod;

	@GetMapping("/list")
	public List<PlayerInfo> getListOfPlayers() {
		return serviceMethod.getListOfPlayers();
	}
	
	@GetMapping("/teamScore")
	public String getTotalTeamScore() {
		return serviceMethod.getTotalTeamScore();
	}
	
	@GetMapping("/add/{playerId}/{playerName}")
	public PlayerInfo addPlayerInDatabase(@PathVariable (name = "playerId") int playerId, @PathVariable (name = "playerName") String playerName) {
		return serviceMethod.addPlayerInDatabase(playerId, playerName);
	}
	
	@GetMapping("/score/{playerId}/{score}")
	public PlayerInfo updatePlayerScoreInDatabase(@PathVariable (name = "playerId") int playerId, @PathVariable (name = "score") int playerScore) {
		return serviceMethod.updateScoreOfPlayers(playerId, playerScore);
	}
	
	@GetMapping("/wicket/{playerId}")
	public PlayerInfo updateWicketStatusOfPlayer(@PathVariable (name = "playerId") int playerId) {
		return serviceMethod.updatePlayerWicket(playerId);
	}
	
	@GetMapping("/current")
	public List<PlayerInfo> getListOfCurrentlyPlayingPlayers(){
		return serviceMethod.getListOfCurrentPlayingPlayers();
	}
}
