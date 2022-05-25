package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PlayerInfo;
import com.example.demo.repo.PlayerRepository;

@Service
public class SecondaryService {

	@Autowired
	PlayerRepository playerRepo;

	public PlayerInfo getPlayer(int playerId) {
		return playerRepo.findById(playerId).get();
	}

	public boolean updateNumberOfBallsPlayed(int playerId) {
		PlayerInfo player = playerRepo.findById(playerId).get();
		int currentBalls = player.getBalls();
		player.setBalls(currentBalls + 1);
		if (playerRepo.save(player) == null)
			return false;
		else
			return true;
	}

}
