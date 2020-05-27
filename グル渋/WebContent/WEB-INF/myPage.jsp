<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.ArrayList,グル渋.BookDetails"
%>
<% ArrayList<BookDetails> list = (ArrayList<BookDetails>) session.getAttribute("bookList"); %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/グル渋/css/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
    <h1>
        グル渋
    </h1>
    <nav class="pc-nav">
        <ul>
            <li><a href="/グル渋/list.jsp">一覧に戻る</a></li>
        </ul>
    </nav>
</header>

<% if (list != null) { %>
<% for(BookDetails post : list) {%>
<div id ="link1">
<a href="/グル渋/Detail?id=<%= post.getRestaurantId()%>">
<div class="box">
<div class="box-text">
店名 : <%= post.getRestaurantName()%><br>
日付 : <%= post.getDate()%><br>
人数 : <%= post.getPeople()%><br>
コース : <%= post.getCourseName()%><br>
</div>
</div>
</a>
</div>
		<% } %>
<% } %>

</body>
</html>