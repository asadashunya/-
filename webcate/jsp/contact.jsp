<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/contact.css" rel="stylesheet" type="text/css">
<title>Judgement</title>
</head>

<body>
	<header>
		<div class="header_logo">
			<a href="home.jsp"><img src="img/logo.jpg"
				style="width: 250px; height: 50px;"></a>
		</div>
		<br>
		<div class="header_navigation">
			<table>
				<ul>
					<li><a href="mitumori.jsp">見積もり</a></li>
					<li><a href="product.jsp">組み立てPC</a></li>
					<li><a href="contact.jsp">お問い合わせ</a></li>
					<li><a href="login.jsp"><button style="width: 100px;">ログイン</button></a></li>
				</ul>
			</table>
		</div>
	</header>
	<main>
		<br>
		<div style="text-align: center;">
			<img src="img/otoiawase.jpg"
				style="width: 1000px; height: 500px; text-align: left;">
		</div>
		<form method="GET" action="Contact"onsubmit="<% if (request.getParameter("consent_1") == null || request.getParameter("consent_2") == null) { %>alert('お問い合わせ登録完了。'); return true;<%}%>">

			<div class="consult">
				<table rules="all">
					<tr>
						<td>名前<font color="red">(必須)</font></td>
						<td colspan="3"><input style="width: 200px;" type="text"
							name="name" placeholder="名前"></td>
					</tr>
					<tr>
						<td>電話番号<font color="red">(必須)</font></td>
						<td><input style="width: 200px;" type="text" name="tel"
							placeholder="電話番号"></td>
						<td>メールアドレス<font color="red">(必須)</font></td>
						<td><input style="width: 200px;" type="text" name="mail"
							placeholder="exsample@gmail.com"></td>
					</tr>
					<tr>
						<td>タイトル<font color="red">(必須)</font></td>
						<td colspan="3"><input style="width: 400px;" type="text"
							name="title" placeholder="タイトル"></td>
					</tr>
					<tr>
						<td>相談内容</td>
						<td colspan="3"><textarea style="width: 600px; height: 200px"
								name="main">
1.使用用途:

2.相談内容:
			
3.予算:
			
4.決済方法
			
			</textarea></td>
					</tr>
				</table>
			</div>
			<br>
			<div class="consent_use">
				<h4>個人情報の収集と利用の同意</h4>
				<table rules="all">
					<tr>
						<td>目的</td>
						<td>情報</td>
						<td>保持期間</td>
					</tr>
					<tr>
						<td>相談問い合わせ受付・返信</td>
						<td>名前、携帯電話番号、メールアドレス</td>
						<td>3ヶ月</td>
					</tr>
				</table>
				<h6>※上記の個人情報提供に対する同意を拒否する権利がありますが、拒否する場合は相談に制限を受けることがあります。</h6>
			</div>
			<div class="consent_use">
				<h4>個人情報第三者提供の同意</h4>
				<table rules="all">
					<tr>
						<td>提供者</td>
						<td>目的</td>
						<td>情報</td>
					</tr>
					<tr>
						<td>(株)Judgement</td>
						<td>相談問い合わせ受付・返信</td>
						<td>名前、携帯電話番号、メールアドレス</td>
					</tr>
				</table>
				<h6>※上記の個人情報提供に対する同意を拒否する権利がありますが、拒否する場合は相談に制限を受けることがあります。</h6>
			</div>
			<div class="consult_send">
				<p style="color: red;">※送信を押すと個人情報の収集および利用、そして個人情報第三者提供に同意する事になります。</p>
				<input type='submit' value="送信">
		</form>
		</button>
		</div>
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