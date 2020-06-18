function detailList() {
	
	$.ajax({
		type : "post",
		url : "/PremierLeague/league?cmd=detailList",
		contentType : "application/json; charset=uft-8",
		dataType : "json"
	}).done(function(result) {
		console.log(result);
		alert("선수 디테일 정보 불러오기 성공");
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

function playerList() {
	
	$.ajax({
		type : "post",
		url : "/PremierLeague/league?cmd=playerList",
		contentType : "application/json; charset=uft-8",
		dataType : "json"
	}).done(function(result) {
		console.log(result);
		alert("선수 목록 불러오기 성공");
		$("#players__list").empty();

		for(var player of result) {
			var string = 
			`<tr class="table-info">
				<td>${player.id}</td>
				<td>${player.playerName}</td>
			 </tr>`;
			
			$("#players__list").append(string);
		}
	}).fail(function(error) {
		alert("player 정보 불러오기 에러")
	});
}

