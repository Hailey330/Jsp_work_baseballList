package com.cos.league.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.league.db.DBConn;
import com.cos.league.model.Player;

public class PlayerRepository {
	private static final String TAG = "PlayerRepository : ";
	private static PlayerRepository instance = new PlayerRepository();

	private PlayerRepository() {
	}

	public static PlayerRepository getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public List<Player> findByName(String playerName) {
		final String SQL = "SELECT id, teamname, playername,position FROM player WHERE playername = ?";
		List<Player> players = new ArrayList<>();

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setString(1, playerName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Player player = new Player();
				player.setId(rs.getInt("id"));
				player.setTeamName(rs.getString("teamName"));
				player.setPlayerName(rs.getString("playername"));
				player.setPosition(rs.getString("position"));
				players.add(player);
			}
			return players;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findByName : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}

	public List<Player> findById(String teamName) {
		final String SQL = "SELECT id, teamname, playername,position FROM player WHERE teamname = ?";
		List<Player> players = new ArrayList<>();

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setString(1, teamName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Player player = new Player();
				player.setId(rs.getInt("id"));
				player.setTeamName(rs.getString("teamName"));
				player.setPlayerName(rs.getString("playername"));
				player.setPosition(rs.getString("position"));
				players.add(player);
			}
			return players;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findById : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}

	public List<Player> findAll() {
		final String SQL = "SELECT id, teamname, playername, position FROM player ORDER BY id ASC";
		List<Player> players = new ArrayList<>();

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Player player = new Player(rs.getInt("id"), rs.getString("teamname"), rs.getString("playername"),
						rs.getString("position"));
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
