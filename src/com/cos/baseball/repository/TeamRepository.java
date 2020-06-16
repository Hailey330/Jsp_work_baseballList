package com.cos.baseball.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.baseball.db.DBConn;
import com.cos.baseball.model.Team;

public class TeamRepository {
	private static final String TAG = "TeamRepository : ";
	private static TeamRepository instance = new TeamRepository();
	
	private TeamRepository() {}
	
	public static TeamRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public List<Team> findAll() {
		final String SQL = "SELECT id, teamname FROM team ORDER BY id ASC";
		List<Team> teams = new ArrayList<>();

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Team team = new Team
						(
						rs.getInt("id"), 
						rs.getString("teamname") 
						);
				teams.add(team);
			}
			return teams;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
}
