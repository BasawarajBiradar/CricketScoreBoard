package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.MethodsInterface;
import com.example.demo.entity.PlayerInfo;

@Controller
@RequestMapping("/user")
public class UserDisplaycontroller {

	@Autowired
	MethodsInterface serviceMethod;

	@RequestMapping("/home")
	public String homePage(Model model) {
		List<PlayerInfo> list = serviceMethod.getListOfCurrentPlayingPlayers();
		model.addAttribute("list", list);
		return "UserHomePage";

	}

	@GetMapping("/list")
	public String getListOfPlayers(Model model) {
		List<PlayerInfo> list = serviceMethod.getListOfPlayers();
		model.addAttribute("list", list);
		return "UserHomePage";
	}

	@GetMapping("/current")
	public String getListOfCurrentlyPlayingPlayers(Model model) {
		List<PlayerInfo> list = serviceMethod.getListOfCurrentPlayingPlayers();
		model.addAttribute("list", list);
		return "UserHomePage";
	}

	@GetMapping("/teamScore")
	public String getTotalTeamScore(Model model) {
		String result = serviceMethod.getTotalTeamScore();
		model.addAttribute("result", result);
		return "UserHomePage";
	}

}
