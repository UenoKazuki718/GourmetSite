<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント作成</title>
</head>
<body>
<h1>アカウント作成</h1>
 <form action="/グル渋/MakeUser" method="post" id="form">
    ユーザー名 : <input type="text" id="username" name="username" ><br>
    メールアドレス : <input type="email" id="email" name="email" minlength='8' maxlength='100' ><br>
    パスワード : <input type="password" id="password" name="password" minlength='8' maxlength='32'><br>
    <a href="/グル渋/list.jsp">戻る</a>
    <input type="submit" value="作成">
    </form>
</body>
</html>