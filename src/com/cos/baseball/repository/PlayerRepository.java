package com.cos.baseball.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.baseball.db.DBConn;
import com.cos.baseball.model.Player;

public class PlayerRepository {
	private static final String TAG = "PlayerRepository : ";
	private static PlayerRepository instance = new PlayerRepository();
	
	private PlayerRepository() {}
	
	public static PlayerRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<Player> findAll() {
		final String SQL = "SELECT id, teamid, playername, position FROM player ORDERB BY id ASC";
		List<Player> players = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Player player = new Player
						(
						rs.getInt("id"),
						rs.getInt("teamId"),
						rs.getString("playername"),
						rs.getString("position")
						);
				players.add(player);
			}
			return players;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
}
