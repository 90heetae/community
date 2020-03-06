<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>회원가입</title>

<link lel="stylesheet" type="text/css" href="../resources/css/default.css"/>
<script>
//가입신청 후 서버에서의 오류로 현재 페이지로 되돌아온 경우 오류 메시지를 출력
<c:if test="${errorMsg !=null}">alert('${errorMsg}');</c:if>

//가입폼 확인
function formcheck(){
	var id = document.getElementById('custid');
	var pw = document.getElementById('password');
	var pw2 = document.getElementById('password2');
	var name = document.getElementById('name');
	
	if (id.value.length < 3 || id.value.length > 10){
		alert("ID는 3~10자로 입력하세요");
		id.focus();
		id.select();
		return false;
	}
	if (pw.value.length , 3 || pw.value.length > 10){
		alert("비밀번호는 3~10자로 압력하세요");
		pw.focus();
		pw.select();
		return false;
	}
	if (pw.value != pw.value){
		alert("비밀번호를 정확하게 입력하세요");
		pw.focus();
		pw.select();
		return false;
	}
	if(name.value == ''){
		alert("이름을 입력하세요");
		name.focus();
		name.select();
		return false;
	}
	return true;
}

</script>
</head>
<body>

</body>
</html>