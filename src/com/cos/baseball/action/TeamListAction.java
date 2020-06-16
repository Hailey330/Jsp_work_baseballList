package com.cos.baseball.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.baseball.model.Team;
import com.cos.baseball.repository.TeamRepository;

public class TeamListAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. DB 연결해서 목록 다 불러오기 
		TeamRepository teamRepository = TeamRepository.getInstance();
		List<Team> teams = teamRepository.findAll();
		// 2. request 에 담아서 
		request.setAttribute("teams", teams);
		// 3. team.jsp 로 이동하기
		RequestDispatcher dis = request.getRequestDispatcher("team.jsp");
		dis.forward(request, response);
	}
}
