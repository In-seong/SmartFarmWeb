<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./resource/css/login.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <div class="login-wrapper2">
        <h2>회원 가입</h2>
        <form method="post" action="AddMember.do" id="login-form">
        	<h3>아이디</h3>
            <input type="text" name="userName" placeholder="ID">
            <h3>비밀번호</h3>
            <input type="password" name="userPassword" placeholder="Password">
            <h3>이름</h3>
            <input type="text" name="userName" placeholder="Nickname">
            <h3>이메일</h3>
            <input type="email" name="userEmail" placeholder="E-mail">
            <h3>전화번호</h3>
            <input type="text" name="userTell" placeholder="000-0000-0000">
            <br>
            <input type="submit" value="회원 가입">
        </form>
    </div>
</body>
</html>