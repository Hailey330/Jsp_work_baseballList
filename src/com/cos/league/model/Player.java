package com.cos.league.model;

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
	private String teamName;
	private String playerName;
	private String position;
}
