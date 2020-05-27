<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.sql.Connection,java.sql.DriverManager,java.sql.ResultSet,java.sql.Statement,java.util.ArrayList,グル渋.Restaurant"
%>
<% String check = (String) session.getAttribute("session"); 
request.setCharacterEncoding("UTF-8");
//データベースに接続
	ArrayList<Restaurant> list = new ArrayList<Restaurant>();
	if((String) session.getAttribute("key")==null){
		try {
			Class.forName("com.mysql.jdbc.Driver");			 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from restaurant");
			while (rs.next()) {
				Restaurant rest = new Restaurant(rs.getInt("id"),rs.getString("name"),rs.getString("information"),rs.getString("map"),rs.getString("address"),rs.getString("tel"),rs.getString("image"));
				list.add(rest);
			}
			rs.close();
			stmt.close();
			con.close();
			}catch(Exception e){
				System.out.println("MySQLに接続できませんでした。");
			}
	}else{
		session.setAttribute("key", null);
		list = (ArrayList<Restaurant>) session.getAttribute("searchList");
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
        グル渋
    </h1>
    <nav class="pc-nav">
        <ul>
        <% if(check == null) { %>
            <li><a href="/グル渋/login.jsp">ログイン</a></li>
        <% }else {  %>
        	<li><a href="/グル渋/MyPage">マイページ</a></li>
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

<% if (list != null) { %>
<% request.setCharacterEncoding("UTF-8");
//データベースに接続
	if((String) session.getAttribute("key")==null){
		try {
			Class.forName("com.mysql.jdbc.Driver");			 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/GuruSibu", "root", "Gfreke38");
			Statement stmt = con.createStatement();%>
<% for(Restaurant post : list) {%>
<div id ="link1">
<a href="/グル渋/Detail?id=<%= post.getId()%>">
<div class="box">
<div class="box-img">
<% String img = "http://localhost:8080/グル渋/image/" + post.getImage(); %>
<img style="width: 100px; height: 100px" src=<%= img%> style="float:left;">
</div>
<div class="box-text">
店名 : <%= post.getName()%><br>
場所 : <%= post.getAddress()%><br>
カテゴリ:
		<% ResultSet rs = stmt.executeQuery("SELECT * from category WHERE restaurantId = '"+post.getId()+"'");
		while (rs.next()) {%>
			<%= rs.getString("category")%>
		<%}
		rs.close();%>
<% ResultSet rs2 = stmt.executeQuery("SELECT AVG(score) AS 'avg' from review WHERE restaurantId = '"+post.getId()+"'");
		while (rs2.next()) {
			double rate = rs2.getDouble("avg")*20;
			if(rate != 0){%>
			<div class="star-ratings-sprite"><span style="width:<%= rate%>%" class="star-ratings-sprite-rating"></span></div>
		<%	}
			}
		rs2.close();%>
</div>
</div>
</a>
</div>
		<% } %>
		<% stmt.close();
		con.close();
		}catch(Exception e){
			System.out.println("MySQLに接続できませんでした。");
		}
	}%>
<% } %>


</body>
</html>