function playerList() {
	
	$.ajax({
		type : "post",
		url : "/PremierLeague/league?cmd=playerList",
		contentType : "application/json; charset=uft-8",
		dataType : "json"
	}).done(function(result) {
		console.log(result);
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