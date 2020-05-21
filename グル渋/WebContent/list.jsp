<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.sql.Connection,java.sql.DriverManager,java.sql.ResultSet,java.sql.Statement"
%>
<% String check = (String) session.getAttribute("session"); 
request.setCharacterEncoding("UTF-8");
//データベースに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
			Statement stmt = con.createStatement();
			//stmt.executeUpdate("INSERT INTO user (name,password,email) VALUES ('ueno','kazuki','topgate.com')");
			
			stmt.close();
			con.close();
			}catch(Exception e){
				System.out.println("MySQLに接続できませんでした。");
			}
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
<script>
function test(){
	var list = "a";//session.getAttribute("list"); 
	//session.invalidate();
	//alert("OK");
	//System.out.printf(list);
	if(list == "a") {
		//alert("OK");
		var req = new XMLHttpRequest();
		req.open("POST", "/グル渋/getList"); // /application名/Servlet名
    	// リクエストを送信
    	req.send();
	}
	
	}
</script>
</body>
</html>