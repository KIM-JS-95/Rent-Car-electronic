<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>아이디 찾기</title>
	<meta charset="utf-8">
  <!-- css 파일 -->
  <link href="/css/common.css" rel="Stylesheet" type="text/css">
  <link href="/css/findId.css" rel="Stylesheet" type="text/css">
	<script type="text/javascript">
		function findid(mname, email) {
			if (mname == '') {
				alert("이름을 입력하세요");
				document.frm.mname.focus();
			} else if (email == '') {
				alert("이메일을 입력하세요");
				document.frm.email.focus();
			} else {
				var url = "searchid";
				url += "?mname=" + mname;
				url += "&email=" + email;
			
				$.get(url, function(data, textStatus) {
					$("#searchid").text(data.str);
				})
			}
		}
	</script>
</head>
<body class="wrapper memberWrapper">
	<div id="container" class="container">
		<div id="contents" class="contents">
		<p class="titDep2 titDepC">아이디 찾기
		<small>
		ISOSIM의 가입된 정보를 입력하세요.
		</small>
		</p>		
		<form class="form-horizontal" action="findid" method="post" name='frm' enctype="multipart/form-data">
			<label for="mname">이름</label>
			<div class="form-group">
				<input type="text" class="form-control" id="mname" placeholder="이름을 입력해주세요." name="mname">
			</div>
			<label for="email">이메일</label>
			<div class="form-group">
				<input type="text" class="form-control" id="email" placeholder="이메일 주소를 정확하게 입력해주세요." name="email">
			</div>
			<div class="btnArea">
				<button type="button" class="btnDefault btnL action" onclick="findid(document.frm.mname.value, document.frm.email.value)">확인</button>
			<div id="searchid"></div>
			</div>
		</form>
		</div>
	</div>
</body>
</html>