<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String url = (String) session.getAttribute("back");
   if(url==null){
	   url = "/グル渋/makeAccount.jsp";
   }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<form action="/グル渋/Login" method="post">
メールアドレス：<input type="text" name="mail" required><br>
パスワード：<input type="password" name="password" required><br>
<input type="submit" value="ログイン"><br>
</form>
<p>
アカウント登録がお済みでない方はこちらへ↓<br>
<a href="makeAccount.jsp"><button>新規登録</button></a>
</p>
<a href=<%= url%>>戻る</a>
</body>
</html>