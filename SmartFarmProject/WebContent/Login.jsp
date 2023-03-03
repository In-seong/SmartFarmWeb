<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./resource/css/login.css" />
<meta charset="UTF-8">
<title>마이팜 로그인</title>
</head>
<body>
    <div class="login-wrapper">
        <h2>Rolling Farm</h2>
        <form method="post" action="login.do" id="login-form">
            <input type="text" name="userName" placeholder="ID">
            <input type="password" name="userPassword" placeholder="Password">
            <label for="remember-check">
                <input type="checkbox" id="remember-check">&nbsp;아이디 저장하기
            </label>
            <input type="submit" value="로그인">
            <input type="submit" value="회원가입">
        </form>
    </div>
</body>
	
</body>
</html>