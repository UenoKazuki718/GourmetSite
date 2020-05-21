<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" 
%>
<% String check = (String) session.getAttribute("session"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/グル渋/css/style.css">
<title>Insert title here</title>
</head>
<body>
<header>
    <h1>
        <a href="/">グル渋</a>
    </h1>
    <nav class="pc-nav">
        <ul>
        <% if(check == null) { %>
            <li><a href="/グル渋/login.html">ログイン</a></li>
        <% }else {  %>
            <li><a href="/グル渋/Logout">ログアウト</a></li>
        <% } %>
            <li><a href="/グル渋/makeAccount.jsp">アカウント作成</a></li>
        </ul>
    </nav>
</header>
<form action="/グル渋/Search" method="post">
  キーワード検索 : <input type="search" name="search" placeholder="キーワードを入力">
  <input type="submit" name="submit" value="検索">
</form>
<div id ="link1">
<a href="/グル渋/Detail">
<div class="box">
<div class="box-img">
<img style="width: 100px; height: 100px" src="http://localhost:8080/グル渋/image/noimage.png" style="float:left;">
</div>
<div class="box-text">
店名<br>
場所<br>
カテゴリ
</div>
</div>
</a>
</div>
<div id ="link1">
<a href="/グル渋/Detail">
<div class="box">
<div class="box-img">
<img style="width: 100px; height: 100px" src="http://localhost:8080/グル渋/image/noimage.png" style="float:left;">
</div>
<div class="box-text">
店名<br>
場所<br>
カテゴリ
</div>
</div>
</a>
</div>
<div id ="link1">
<a href="/グル渋/Detail">
<div class="box">
<div class="box-img">
<img style="width: 100px; height: 100px" src="http://localhost:8080/グル渋/image/noimage.png" style="float:left;">
</div>
<div class="box-text">
店名<br>
場所<br>
カテゴリ
</div>
</div>
</a>
</div>

</body>
</html>