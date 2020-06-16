package com.cos.baseball.model;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {
	private int id;
	private int teamId;
	private int playerId;
	private String playerName;
	private String position;
}
