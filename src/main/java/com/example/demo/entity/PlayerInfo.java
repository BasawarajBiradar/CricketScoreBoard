package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player_info")
public class PlayerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	private String playerName;
	private int playerScore;
	private int balls;
	private boolean wicketStatus;

	public PlayerInfo(int playerId, String playerName, int playerScore, int balls, boolean wicketStatus) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerScore = playerScore;
		this.balls = balls;
		this.wicketStatus = wicketStatus;
	}

	public PlayerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public boolean isWicketStatus() {
		return wicketStatus;
	}

	public void setWicketStatus(boolean wicketStatus) {
		this.wicketStatus = wicketStatus;
	}

}
