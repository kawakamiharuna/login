<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page contentType="text/html; charset=UTF-8" %>


<form action="/login/login" method="post">
<p>IDとパスワードを入力してください。</p>
<p>ID<input type="text" name="id"></p>
<p>パスワード<input type="password" name="password"></p>
<p><input type="submit" value="ログイン"></p>

</form>

</body>
</html>