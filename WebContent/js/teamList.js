function membersList() {
	
	$.ajax({
		type : "post",
		url : "/BaseballList/teamList?cmd=membersList",
		contentType : "application/json; charset=uft-8",
		dataType : "json"
	}).done(function(result) {
		console.log(result);
		$("#team__list").empty();

		for(var product of result) {
			var string = 
			`<td>${team.id}</td>
			<td onclick="membersList()">${team.teamName}</td>`;	
			
			$("#team__list").append(string);
		}
	}).fail(function(error) {
		alert("정보 불러오기 에러")
	});
}