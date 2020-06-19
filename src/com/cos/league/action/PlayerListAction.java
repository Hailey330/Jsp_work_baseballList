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

public class PlayerListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		if (request.getParameter("teamId") == null || 
//			request.getParameter("teamId").equals("")) {
//			return;
//		}

		String teamName = request.getParameter("teamName");
		System.out.println("PlayerListAction : teamName : " + teamName);

		PlayerRepository playerRepository = PlayerRepository.getInstance();
		List<Player> players = playerRepository.findById(teamName);

		Gson gson = new Gson();
		String playersJson = gson.toJson(players);

		Script.outJson(playersJson, response);
		System.out.println("PlayerListAction : playersJson : " + playersJson);

	}
}
