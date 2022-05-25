package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PlayerInfo;
import com.example.demo.repo.PlayerRepository;

@Service
public class ServiceImplementation implements MethodsInterface {

	@Autowired
	PlayerRepository playerRepo;

	@Autowired
	SecondaryService secondaryService;

	@Override
	public List<PlayerInfo> getListOfPlayers() {
		return playerRepo.findAll();
	}

	@Override
	public String getTotalTeamScore() {

		Integer wicketCount = playerRepo.findCountByWicket();
		Integer ballCount = playerRepo.findCountByBalls();
		Integer scoreCount = playerRepo.findCountByPlayerScore();
		if (wicketCount == null)
			wicketCount = 0;
		if (ballCount == null)
			ballCount = 0;
		if (scoreCount == null)
			scoreCount = 0;
		return "( " + scoreCount + "/ " + wicketCount + ") in " + ballCount + " balls";

	}

	@Override
	public PlayerInfo addPlayerInDatabase(String playerName) {
		if (playerRepo.count() > 10)
			return null;
		PlayerInfo player = new PlayerInfo();
		player.setPlayerName(playerName);
		player.setBalls(0);
		player.setPlayerScore(0);
		player.setWicketStatus(false);
		return playerRepo.save(player);
	}

	@Override
	public PlayerInfo updateScoreOfPlayers(int playerId, int playerScore) {
		if(playerScore>6 || playerScore==5 || playerScore < 0)
			return null;
		PlayerInfo player = secondaryService.getPlayer(playerId);
		if (player.isWicketStatus() == true)
			return null;
		if (playerRepo.findListOfCurrentlyPlayingPlayers().size() > 1)
			return null;
		int currentScoreplayer = player.getPlayerScore();
		player.setPlayerScore(playerScore + currentScoreplayer);
		secondaryService.updateNumberOfBallsPlayed(playerId);
		return playerRepo.save(player);

	}

	@Override
	public PlayerInfo updatePlayerWicket(int playerId) {
		PlayerInfo player = secondaryService.getPlayer(playerId);
		if(player.isWicketStatus()==true)
			return null;
		player.setWicketStatus(true);
		secondaryService.updateNumberOfBallsPlayed(playerId);
		return playerRepo.save(player);

	}

	@Override
	public List<PlayerInfo> getListOfCurrentPlayingPlayers() {
		return playerRepo.findListOfCurrentlyPlayingPlayers();
	}

}
