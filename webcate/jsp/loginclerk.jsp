<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/login.css" rel="stylesheet" type="text/css">
<title>Judgement LoginCleark</title>
</head>
<body>
	<header>
		<div class="header_logo">
			<a href="home.jsp"><img src="img/logo.jpg"
				style="width: 250px; height: 50px;"></a>
		</div>
		<br>
		<div class="main">
			<h1>Judgement 店員ログイン</h1>
			<form method="POST" action="login">
				<input type="text" style="width: 300; height: 20px;" name="clerk_name"
					placeholder="店員アカウント名"> <br> <br> 
					<input type="password" style="width: 300; height: 20px;" name="clerk_pass"
					placeholder="店員パスワード"> <br> <br> 
					<input type="submit" value="ログイン"
					style="width: 300; height: 20px;"> <br> <br> 
			</form>
		</div>
	</header>
</body>
</html>