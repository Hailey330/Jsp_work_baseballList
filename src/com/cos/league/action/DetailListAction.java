package com.cos.league.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.league.model.Player;
import com.cos.league.repository.PlayerRepository;
import com.cos.league.util.Script;
import com.google.gson.Gson;

public class DetailListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String playerName = request.getParameter("playerName");
		System.out.println("DetailListAction : playerName : " + playerName);

		PlayerRepository playerRepository = PlayerRepository.getInstance();
		List<Player> players = playerRepository.findByName(playerName);

		Gson gson = new Gson();
		String playersJson = gson.toJson(players);

		Script.outJson(playersJson, response);
		System.out.println("DetailListAction : playersJson : " + playersJson);

	}
}
