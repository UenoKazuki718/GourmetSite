<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.ArrayList,グル渋.Rating,グル渋.Menu,グル渋.Restaurant"
%>
<% String check = (String) session.getAttribute("session"); 
request.setCharacterEncoding("UTF-8");
ArrayList<Rating> ratingList = (ArrayList<Rating>) session.getAttribute("rating");
ArrayList<Menu> menuList = (ArrayList<Menu>) session.getAttribute("menu");
Restaurant detail = (Restaurant) session.getAttribute("detail");
String img = "http://localhost:8080/グル渋/image/" + detail.getImage();
ArrayList<String> imgList = (ArrayList<String>) session.getAttribute("image");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/グル渋/css/starability-all.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/jquery-datetimepicker@2.5.20/jquery.datetimepicker.css">
<title>Insert title here</title>
</head>
<body>
<a href="/グル渋/list.jsp">戻る</a>
<h1><img style="width: 100px; height: 100px" src=<%= img%> > <%= detail.getName()%></h1>
<style>
.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
}

.tab button:hover {
    background-color: #ddd;
}

.tab button.active {
    background-color: #ccc;
}

.tabcontent {
    display: none;
    padding: 6px 24px;
    border: 1px solid #ccc;
    border-top: none;
}
</style>

<div class="tab">
  <button class="tablinks" onclick="detail(event, 'introduction')" id="defaultOpen">お店の紹介</button>
  <button class="tablinks" onclick="detail(event, 'menu')">メニュー</button>
  <button class="tablinks" onclick="detail(event, 'image')">写真</button>
  <button class="tablinks" onclick="detail(event, 'book')">予約</button>
  <button class="tablinks" onclick="detail(event, 'review')">レビュー</button>
</div>

<div id="introduction" class="tabcontent">
        お店の紹介内容  <br>
        <%= detail.getInf()%>   
</div>

<div id="menu" class="tabcontent">
    <ul>
        <% if (menuList != null) { %>
		<% for(Menu post : menuList) {%>
		 	<li><%= post.getName()%> : <%= post.getPrice()%> 円</li>
		<% } %>
		<% } %>
    </ul>    
 </div>
 
 
 <div id="image" class="tabcontent">
	<% if (imgList != null) { %>
		<% for(String post : imgList) {%>
		 	<% String image = "http://localhost:8080/グル渋/image/" + post;%>
		 	<img style="width: 100px; height: 100px" src=<%= image%>>
		<% } %>
	<% } %>
 </div>

<div id="book" class="tabcontent">
 <form action="/グル渋/Book" method="post">
  名前  : <input type="text" id="name" name="name" required><br>
  予約日 : <input type="text"  id="date" name="date" class="datetimepicker" required><br>
  人数  : <input type="text" id="num" name="num" maxlength='2' pattern="[1-9]|[1-9][0-9]" required>人<br>
  コース : <select name="course" id="course" required>
<option value="選択肢1">選択肢1</option>
<option value="選択肢2">選択肢2</option>
<option value="選択肢3">選択肢3</option>
</select><br>
  電話番号 : <input type="tel" name="telNumber" pattern="\d{1,5}-\d{1,4}-\d{4,5}"  placeholder="080-1234-5678" required><br>
  <input type ="submit" value="予約する">
</form>
</div>

<div id="review" class="tabcontent">
<% if(check != null) { %>
    レビューするにはログインしてください<br>
    <li><a href="/グル渋/login.html">ログイン</a></li>
<% }else {  %>
    <form action="/グル渋/Review" method="post">
    <fieldset class="starability-basic">
    <legend>レビュー内容:</legend>
    <input type="radio" id="rate5" name="rating" value="1" required>
    <label for="rate5" title="Amazing" aria-label="Amazing, 5 stars">5 stars</label>
    <input type="radio" id="rate4" name="rating" value="2">
    <label for="rate4" title="Very good" aria-label="Very good, 4 stars">4 stars</label> 
    <input type="radio" id="rate3" name="rating" value="3">
    <label for="rate3" title="Average" aria-label="Average, 3 stars">3 stars</label>
    <input type="radio" id="rate2" name="rating" value="4">
    <label for="rate2" title="Not good" aria-label="Not good, 2 stars">2 stars</label>
    <input type="radio" id="rate1" name="rating" value="5">
    <label for="rate1" title="Terrible" aria-label="Terrible, 1 star">1 star</label>
    </fieldset>
    <textarea name="text" cols="30" rows="5" required></textarea><br>
    <input type ="submit" value="レビューする">
    </form>
   <% } %>
    <div style="width:100%;height:150px;overflow:auto;">
<% if (ratingList != null) { %>
<% for(Rating post : ratingList) {%>
 	<p>評価 : <%= post.getScore()%> </p>
 	<li> <%= post.getText()%> </li>
<% } %>
<% } %>
</div>
</div>

電話番号
<li><%= detail.getTel()%></li>
<%= detail.getMap()%>

<script>
function detail(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
document.getElementById("defaultOpen").click();
</script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-datetimepicker@2.5.20/build/jquery.datetimepicker.full.min.js"></script>
<script>
  $(function() {
    $(".datetimepicker").datetimepicker();
  });
</script>
</body>
</html>