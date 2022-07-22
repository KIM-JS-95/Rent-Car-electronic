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


<script src="/js/list/editor.js" defer></script>
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
 <h1 class="col-sm-offset-2 col-sm-10">게시판 생성</h1>

      <form class="form-horizontal" action="./create" method="post" enctype="multipart/form-data"
        onsubmit="return checkIn(this)">

 <br>
         <div class="form-group">
             <label class="control-label col-sm-2" for="wname">작성자</label>
             <div class="col-sm-6">
             <input type="text" name="title" id="title" class="form-control" placeholder= '이름을 입력해 주세요.'>
          <!--     <label class="control-label col-sm-2" for="wname">wname</label> -->
             </div>
           </div>
           <div class="form-group">
             <label class="control-label col-sm-2" for="title">제목</label>
             <div class="col-sm-8">
               <input type="text" name="title" id="title" class="form-control" placeholder= '제목을 입력해 주세요.'>
             </div>
           </div>

            <div class="form-group">
             <label class="control-label col-sm-2" for="content">내용</label>
             <div class="col-sm-8">
              <textarea id="summernote" name="content" class="summernote" placeholder: '명예훼손, 개인정보 유출, 분쟁 유발, 허위사실 유포 등의 글은 이용약관에 의해 제재는
법률에 의해 처벌 받을 수 있습니다. 건전한 커뮤니티를 위해 자제를 당부 부탁드립니다.',></textarea>
             </div>
          </div>











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