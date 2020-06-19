<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Premier League Team</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4">
				<h2>Premier League Team</h2>
				<table class="table">
					<thead>
						<tr>
							<th>Number</th>
							<th>Team Name</th>
						</tr>
					</thead>
					<tbody id="team__list">
						<c:forEach var="team" items="${teams}">
							<tr onclick="playerList('${team.teamName}')">
								<td>${team.id}</td>
								<td>${team.teamName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="col-sm-4">
				<h2>Team Players</h2>
				<table class="table">
					<thead>
						<tr>
							<th>Player Number</th>
							<th>Player Name</th>
						</tr>
					</thead>
					<tbody id="players__list">
						<c:forEach var="player" items="${players}">
							<tr class="table-info">
								<td>${player.id}</td>
								<td>${player.playerName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="col-sm-4">
				<h2>Player Details</h2>
				<table class="table">
					<thead>
						<tr>
							<th>Player Number</th>
							<th>Player Name</th>
							<th>Player Position</th>
						</tr>
					</thead>
					<tbody id="details__list">
						<c:forEach var="player" items="${players}">
							<tr class="table-warning">
								<td>${player.id}</td>
								<td>${player.playerName}</td>
								<td>${player.position}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

<script src="/premierLeague/js/team.js"></script>

</html>
