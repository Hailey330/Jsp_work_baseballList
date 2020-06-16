package com.cos.baseball.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.baseball.model.Player;
import com.cos.baseball.repository.PlayerRepository;
import com.cos.baseball.util.Script;
import com.google.gson.Gson;

public class PlayerListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		
		PlayerRepository playerRepository = PlayerRepository.getInstance();
		List<Player> players = playerRepository.findAll();
		String playersJson = gson.toJson(players);
		Script.outJson(playersJson, response);
		System.out.println("PlayerListAction : playersJson : " + playersJson);
		
	}
}
