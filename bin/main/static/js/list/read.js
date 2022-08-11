
$(function(){


<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 075891db93b8c540f48f8f0b541247a11113231f
$("#btn_update").click(function(){ //글 삭제

	var url = "/contents/list/update";
           url += "?listno="+listno;
//           url += "&col=${col}";
//           url += "&word=${word}";
//           url += "&nowPage=${nowPage}";
           location.href=url;

});






$("#btn_delete").click(function(){ //글 삭제
<<<<<<< HEAD
=======
=======
$("#btn").click(function(){ //글 삭제
>>>>>>> 6a34f9b4afab89cc31c37bf2d6b014dbe52e5e48
>>>>>>> 075891db93b8c540f48f8f0b541247a11113231f

	console.log(listno);


<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 075891db93b8c540f48f8f0b541247a11113231f



$.ajax({
	url : "http://localhost:9090/contents/list/delete",
	type : 'post',
	data : {
		listno : listno
	},
	success : function(data) {
				location.href="/contents/list";
     },
	error : function() {
		alert("error");
	}
});




<<<<<<< HEAD
=======
=======
		fetch(`/list/delete`,{method: 'post'})
                       .then(response => response.text())
                        .then(location.href="/contents/list")
                       .catch(console.log);
>>>>>>> 6a34f9b4afab89cc31c37bf2d6b014dbe52e5e48
>>>>>>> 075891db93b8c540f48f8f0b541247a11113231f

});






	$("#btn1").click(function(){ // 추천 up

	console.log(listno);


		fetch(`/list/${listno}`,{method: 'post'})
                       .then(response => response.text())
                        .then(location.reload())
                       .catch(console.log);

});


$("#delete").click(function(){ // 리뷰 삭제

var rnum = document.querySelector("#rnum").value;


       	console.log(rnum);



fetch(`/review/${rnum}`,{method: 'delete'})
               .then(response => response.text())
               .then(location.reload())
               .catch(console.log);
<<<<<<< HEAD

=======
<<<<<<< HEAD

        		});




	$("#addreviewBtn").click(function(){// review create


	 var content = document.querySelector("#review11").value;
           	console.log(content);
=======
>>>>>>> 075891db93b8c540f48f8f0b541247a11113231f
        		});




<<<<<<< HEAD
	$("#addreviewBtn").click(function(){// review create


	 var content = document.querySelector("#review11").value;
           	console.log(content);
=======
>>>>>>> 6a34f9b4afab89cc31c37bf2d6b014dbe52e5e48
>>>>>>> 075891db93b8c540f48f8f0b541247a11113231f
  	var data = {
		"content" : content,
		"listno" : listno
	}
	console.log(data);

 	$.ajax({

	    type : "post",
	    url : "/review/create",
	     data : JSON.stringify(data),
	    //data: data,
	    // dataType:"json",
	    contentType: "application/json",
	    success:function(data){
		   console.log('성공입니다.');
		   console.log(data);
            location.reload()

	    },
	    error:function(){
	        alert("에러입니다");
	    }
	});
		});

});