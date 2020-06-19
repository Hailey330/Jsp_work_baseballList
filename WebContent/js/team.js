function detailList(playerName) {
	
	var data = {
			playerName : playerName
	};
	console.log(playerName);

	$.ajax({
		type : "post",
		url : "/premierLeague/league?cmd=detailList",
		data : data,
		dataType : "json"
	}).done(function(result) {
		console.log(result);
		$("#details__list").empty();

		for(var player of result) {
			var string = 
			`<tr class="table-warning">
			<td>${player.id}</td>
			<td>${player.playerName}</td>
			<td>${player.position}</td>
			</tr>`;
			
			$("#details__list").append(string);
		}
	}).fail(function(error) {
		alert("디테일 정보 불러오기 에러")
	});
}

function playerList(teamName) {
	
	var data = {
			teamName : teamName
	};
	
	$.ajax({
		type : "post",
		url : "/premierLeague/league?cmd=playerList",
		data : data,
		dataType : "json"
	}).done(function(result) {
		console.log(result);
		$("#players__list").empty();

		for(var player of result) {
			var string = 
			`<tr class="table-info" onclick="detailList('${player.playerName}')">
			<td>${player.id}</td>
			<td>${player.playerName}</td>
			</tr>`;
			
			$("#players__list").append(string);
		}
	}).fail(function(error) {
		alert("player 정보 불러오기 에러")
	});
}

