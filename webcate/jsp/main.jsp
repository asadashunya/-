<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="./css/vendor.css" rel="stylesheet" type="text/css">
<title>Judgement</title>
</head>
<body>
	<header>
		<div class="header_logo">
			<a href="./home.jsp"><img src="./img/logo.jpg"
				style="width: 250px; height: 50px;"></a>
		</div>
	</header>
	<main>
		<div class="main">
			<div class="one">
				<div class="management">
					<h2>
						<a href="main.jsp">会員専用</a>
					</h2>
					<h4>
						<a href="MitumoriSaveDao">保存見積もり</a>
					</h4>
					<h4>
						<a href="OrderList">注文履歴</a>
					</h4>
					<h4>
						<a href="information_change">会員情報変更</a>
					</h4>
				</div>
			</div>
			<div class="two">
				<div class="aa">
				<% String userId = (String) session.getAttribute("userId"); %>
					<h3>いらっしゃいませ <%= userId %> 様</h3>
				</div>
			</div>
		</div>
	</main>
</body>
</html>