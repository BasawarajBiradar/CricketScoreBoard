package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.PlayerInfo;

public interface PlayerRepository extends JpaRepository<PlayerInfo, Integer> {

	@Query(nativeQuery = true, value = "select sum(wicket_status) from player_info where wicket_status= true")
	public Integer findCountByWicket();

	@Query(nativeQuery = true, value = "select sum(balls) from player_info")
	public Integer findCountByBalls();

	@Query(nativeQuery = true, value = "select sum(player_score) from player_info")
	public Integer findCountByPlayerScore();

	@Query(nativeQuery = true, value = "select * from player_info where balls>0 and wicket_status= false")
	public List<PlayerInfo> findListOfCurrentlyPlayingPlayers();

}
