<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/member_registration.css" rel="stylesheet"
	type="text/css">
<title>Judgement</title>
</head>
<body>
	<header>
		<div class="header_logo">
			<a href="home.jsp"><img src="img/logo.jpg"
				style="width: 250px; height: 50px;"></a>
		</div>
	</header>

	<main>
		
		<form method="GET" action="registration_ckeck.jsp">
			<table>
				<th>アカウント名</th>
				<td><input type="text" name="cust_username"></td>
				<tr></tr>
				<th>お名前</th>
				<td><input type="text" name="cust_fname"> <input
					type="text" name="cust_lname"></td>
				<tr></tr>
				<th>お名前(フリガナ)</th>
				<td><input type="text" name="cust_fkana"> <input
					type="text" name="cust_lkana"></td>
				<tr></tr>
				<th>メールアドレス</th>
				<td><input type="text" name="cust_mail"></td>
				<tr></tr>
				<th>パスワード</th>
				<td><input type="password" name="cust_pass"></td>
				<tr></tr>
				<th>パスワード確認</th>
				<td><input type="password" name="passwordcheck"></td>
				<tr></tr>
				<th>電話番号</th>
				<td><input type="tel" name="cust_tel" placeholder="ハイフン(-)なし">
				</td>
				<tr></tr>
				<th>郵便番号</th>
				<td><input type="number" name="cust_postnum"
					placeholder="ハイフン(-)なし"></td>
				<tr></tr>
				<th>住所</th>
				<td><input type="text" name="cust_address"
					placeholder="都道府県から建物名までお願いします。"></td>
				<tr></tr>
				<th></th>
				<td><input type="submit" value="登録"> 
				<input type="button" onclick="history.back()" value="キャンセル"></td>
			</table>
		</form>
	</main>


	<footer>
		<div id="shopfooter">
			<h4>
				住所:〒152-0004 東京都目黒区鷹番1丁目11-9 代表:申東鉉<br> 電話番号:02-5448-8745
				会社名:株式会社Judgement
			</h4>
		</div>
	</footer>
</body>
</html>