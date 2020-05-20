<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/グル渋/list.jsp">戻る</a>
<h1>店名</h1>
<img style="width: 100px; height: 100px" src="http://localhost:8080/グル渋/image/noimage.png">
<img style="width: 100px; height: 100px" src="http://localhost:8080/グル渋/image/noimage.png">
<img style="width: 100px; height: 100px" src="http://localhost:8080/グル渋/image/noimage.png"><br>
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
        とてもお肉が美味しい<br>
        お寿司も美味しい<br>
</div>

<div id="menu" class="tabcontent">
    <ul>
        <li>ステーキ 1800円</li>
        <li>寿司盛り合わせ 1200円</li>
        <li>鍋 1000円</li>
    </ul>    
 </div>
 <div id="image" class="tabcontent">
	<img style="width: 100px; height: 100px" src="http://localhost:8080/グル渋/image/noimage.png">
	<img style="width: 100px; height: 100px" src="http://localhost:8080/グル渋/image/noimage.png">
	<img style="width: 100px; height: 100px" src="http://localhost:8080/グル渋/image/noimage.png">
 </div>

<div id="book" class="tabcontent">
 
</div>

<div id="review" class="tabcontent">
    レビュー内容
</div>

電話番号
<li>0120-828-828</li>
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3240.8280303808788!2d139.76493611525882!3d35.68123618019432!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x60188bfbd89f700b%3A0x277c49ba34ed38!2z5p2x5Lqs6aeF!5e0!3m2!1sja!2sjp!4v1589862253530!5m2!1sja!2sjp" width="400" height="300" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>

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

</body>
</html>