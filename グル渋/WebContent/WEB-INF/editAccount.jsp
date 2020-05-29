<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String error = (String) session.getAttribute("error"); %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="/グル渋/EditUser" method="post" id="form">
 <h1>アカウント編集</h1>
    ユーザー名 : <input type="text" id="name" name="name" required><br>
    メールアドレス : <input type="email" id="email" name="email" minlength='8' maxlength='100' required><br>
    パスワード : <input type="password" id="password" name="password" minlength='8' maxlength='32' required><br>
    <a href="/グル渋/MyPage">戻る</a> 
    <input type="submit" value="編集">
    </form>
       <%if(error != null){%>
    <% if(error.equals("error")){%>
    <script>
      alert('このメールアドレスはすでに登録されています');
    </script>
    <% session.setAttribute("error",""); 
    }
    }%>
</body>
</html>