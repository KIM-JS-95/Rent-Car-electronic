
$(function(){









	$("#btn1").click(function(){

	console.log(listno);


		fetch(`/list/${listno}`,{method: 'post'})
                       .then(response => response.text())
                        .then(location.reload())
                       .catch(console.log);

});



});