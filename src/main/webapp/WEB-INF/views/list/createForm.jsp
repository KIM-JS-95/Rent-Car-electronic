<%@ page contentType="text/html; charset=UTF-8" %> 
 
<!DOCTYPE html> 
<html> 
<head>
  <title>notice</title>
  <meta charset="utf-8">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
 <script>
 $(document).ready(function() {




  	$('#summernote').summernote({
  				height: 300,                 // 에디터 높이
  				minHeight: null,             // 최소 높이
  				maxHeight: null,             // 최대 높이
  				focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
  				lang: "ko-KR",					// 한글 설정
  				placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
  				callbacks: {	//여기 부분이 이미지를 첨부하는 부분
  					onImageUpload : function(files) {
  						uploadSummernoteImageFile(files[0],this);
  					},
  					onPaste: function (e) {
  						var clipboardData = e.originalEvent.clipboardData;
  						if (clipboardData && clipboardData.items && clipboardData.items.length) {
  							var item = clipboardData.items[0];
  							if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
  								e.preventDefault();
  							}
  						}
  					}
  				}
  	});



  	/**
  	* 이미지 파일 업로드
  	*/
  	function uploadSummernoteImageFile(file, editor) {
  		data = new FormData();
  		data.append("file", file);
  		$.ajax({
  			data : data,
  			type : "POST",
  			url : "/uploadImageFile",
  			contentType : false,
  			processData : false,
  			success : function(data) {
              	//항상 업로드된 파일의 url이 있어야 한다.
  				$('editor').summernote('insertImage', data.url);
  			}
  		});
  	}













	});

















  function checkIn(f){
      if (f.wname.value == ""){
              alert("글쓴이를 입력하세요");
              f.wname.focus()
              return false;
      }
      if (f.title.value == ""){
              alert("제목를 입력하세요");
              f.title.focus();
              return false;
      }
      if (CKEDITOR.instances['content'].getData() == '') {
          window.alert('내용을 입력해 주세요.');
          CKEDITOR.instances['content'].focus();
          return false;
      }
      if (f.passwd.value == ""){
              alert("패스워드를 입력하세요");
              f.passwd.focus();
              return false;
      }
 }

  </script>


 <style>
   .container {
     width: 950px;
     margin: 0 auto;
     position: relative;
   }
   </style>

</head>
<body> 
<div class="container">
<h2 class="col-sm-offset-2 col-sm-10">맛집 생성</h2>
<form class="form-horizontal"
     action="./create"
      method="post"
      enctype="multipart/form-data"
      onsubmit="return checkIn(this)"
      >
 
  <div class="form-group">
    <label class="control-label col-sm-2" for="wname">작성자</label>
    <div class="col-sm-6">
      <input type="text" name="wname" id="wname" class="form-control" value="${dto.wname}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="title">제목</label>
    <div class="col-sm-8">
      <input type="text" name="title" id="title" class="form-control">
    </div>
  </div>
  

    <textarea  id="summernote" name="content" class="summernote"></textarea>



   <div class="form-group">
   <div class="col-sm-offset-2 col-sm-5">
    <button id="btn">등록</button>
    <button type="reset" class="btn">취소</button>
   </div>
 </div>
 </form>
</div>
      <script>
                     let listno = "${dto.listno}";

                  </script>
</body> 
</html> 