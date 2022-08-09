
$(function(){


$("#btn_update").click(function(){ //글 수정

	var url = "/contents/list/update";
           url += "?listno="+listno;
//           url += "&col=${col}";
//           url += "&word=${word}";
//           url += "&nowPage=${nowPage}";
           location.href=url;

});






$("#btn_delete").click(function(){ //글 삭제


 var imgs = document.querySelectorAll('img');
        console.log(imgs);
        for(var i=0; i<imgs.length; i++){
        var img = imgs[i];
        console.log(img);
        var img = img.src;
        console.log(img);
        var key = img.substring(46);
        console.log(key);
        console.log(key.length);
        if(key.length>40){
//if(key.lenght)
        $.ajax({
       	url : "/s3/resource",
        type : 'delete',
        data : {
        key : key
        },
        success : function(data) {
        console.log("성공");
        },
        error : function() {
        alert("error");
        }
        });
}


}
	console.log(listno);

 setTimeout(


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
})
 ,1000);




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

        		});




	$("#addreviewBtn").click(function(){// review create


	 var content = document.querySelector("#review11").value;
           	console.log(content);
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