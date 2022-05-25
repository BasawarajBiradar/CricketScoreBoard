package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.MethodsInterface;
import com.example.demo.entity.PlayerInfo;

@Controller
@RequestMapping("/admin")
public class AdminDisplayController {

	@Autowired
	MethodsInterface serviceMethod;

	@RequestMapping("/home")
	public String homePage(Model model) {
		List<PlayerInfo> list = serviceMethod.getListOfCurrentPlayingPlayers();
		model.addAttribute("list", list);
		return "AdminHomePage";

	}

	@GetMapping("/wicket")
	public String updateWicketStatusOfPlayer(@RequestParam(name = "playerId") int playerId, Model model) {
		PlayerInfo player = serviceMethod.updatePlayerWicket(playerId);
		if (player != null) {
			model.addAttribute("player", player);
			return "PlayerDisplay";
		} else {
			String result = "player is already out";
			model.addAttribute("result", result);
			return "AdminHomePage";
		}
	}

	@GetMapping("/list")
	public String getListOfPlayers(Model model) {
		List<PlayerInfo> list = serviceMethod.getListOfPlayers();
		model.addAttribute("list", list);
		return "AdminHomePage";
	}

	@GetMapping("/current")
	public String getListOfCurrentlyPlayingPlayers(Model model) {
		List<PlayerInfo> list = serviceMethod.getListOfCurrentPlayingPlayers();
		model.addAttribute("list", list);
		return "AdminHomePage";
	}

	@GetMapping("/add")
	public String addPlayerInDatabase(@RequestParam(name = "playerName") String playerName, Model model) {
		PlayerInfo player = serviceMethod.addPlayerInDatabase(playerName);
		if (player != null) {
			model.addAttribute("player", player);
			return "PlayerDisplay";
		} else {
			String result = "player adding error";
			model.addAttribute("result", result);
			return "AdminHomePage";
		}
	}

	@GetMapping("/teamScore")
	public String getTotalTeamScore(Model model) {
		String result = serviceMethod.getTotalTeamScore();
		model.addAttribute("result", result);
		return "AdminHomePage";
	}

	@GetMapping("/score")
	public String updatePlayerScoreInDatabase(@RequestParam(name = "playerId") int playerId,
			@RequestParam(name = "playerScore") int playerScore, Model model) {
		PlayerInfo player = serviceMethod.updateScoreOfPlayers(playerId, playerScore);
		if (player != null) {
			model.addAttribute("player", player);
			return "PlayerDisplay";
		} else {
			String result = "updating score error";
			model.addAttribute("result", result);
			return "AdminHomePage";
		}
	}
}
