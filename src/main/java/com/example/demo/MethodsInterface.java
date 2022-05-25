package com.example.demo;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.entity.PlayerInfo;


@Service
public interface MethodsInterface {

	String getTotalTeamScore();

	PlayerInfo addPlayerInDatabase(String playerName);

	List<PlayerInfo> getListOfPlayers();

	PlayerInfo updateScoreOfPlayers(int playerId, int playerScore);

	PlayerInfo updatePlayerWicket(int playerId);

	List<PlayerInfo> getListOfCurrentPlayingPlayers();
}
