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
 <script type="text/JavaScript">

 var content =


$(document).ready(function() {
    $("#summernote").summernote({
        placeholder:'정말 어려워요 ㅠㅠ',
        height:300,
        callbacks: {
            onImageUpload:function(files){

                    sendFile(files[0],this );

            }
        }
    });
});

function sendFile(file){
    data = new FormData();
    data.append("file", file);
    alert(data);
    $.ajax({
        data:data,
        type:"POST",
        url:'/uploadSummernoteImageFile',
        cache:false,
        contentType:false,
        processData:false,
        success:function(data){
         $('#summernote').summernote('insertImage', url);
        },
        error: function(data) {
          alert(data);
        }
    });
}


















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

</body>
</html>