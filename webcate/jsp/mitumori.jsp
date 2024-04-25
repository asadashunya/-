<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/mitumori.css" rel="stylesheet" type="text/css">
<title>Judgement</title>
</head>
<script type="text/javascript">
	function ImageUp1() {
		window.open("detail.html", "window1",
				"width=500,height=500,scrollbars=1");
	}
	function ImageUp2() {
		window.open("check.html", "window1",
				"width=500,height=500,scrollbars=1");
	}
</script>

<body>
	<header>
		<div class="header_logo">
			<a href="home.jsp"><img src="./img/logo.jpg"
				style="width: 250px; height: 50px;"></a>
		</div>
		<br>
		<div class="header_navigation">
			<table>
				<ul>
					<li><a href="mitumori.jsp">見積もり</a></li>
					<li><a href="product.jsp">組み立てPC</a></li>
					<li><a href="contact.jsp">お問い合わせ</a></li>
					<li><a href=""><button style="width: 100px;">ログイン</button></a></li>
				</ul>
			</table>
		</div>
		<br>
	</header>
	<main>
		<div class="main_search">
		<form method="POST" action="">
			<input type="textbox" style="width: 900px; height: 30px;"
				id="PartName" name="PartName"
				placeholder="商品名を入力してください。🔍">
				</form>
		</div>
		<br>
		<div class="mein">
		
			<div class="main_sub">
			
				<table class="item_checkbox">
					
				<div class="category_list">
					<ul>
						<li><a href="popularity">人気商品順</a></li>
						<li><a href="lowprice">低価格順</a></li>
						<li><a href="highprice">高価格順</a></li>
						<li><a href="productnameorder">商品名順</a></li>
					
					<th>sss</th>
					
					</ul>
				</div>
				</table>
				<div class="scroll_box">
					<table rules="all">
					<tr>
					<th>ss1</th>
					</tr>
					</table>
				</div>
			</div>
			<div class="cart_list">
				<div class="cart_title">
					<h2>見積もりカート</h2>
				</div>
				<div class="cart_item">
					<table>
						<tr>
							<td>CPU</td>
						</tr>
						<tr>
							<td>クーラー</td>
						</tr>
						<tr>
							<td>メモリ</td>
						</tr>
						<tr>
							<td>グラフィックカード</td>
						</tr>
						<tr>
							<td>SSD</td>
						</tr>
						<tr>
							<td>HDD</td>
						</tr>
						<tr>
							<td>ケース</td>
						</tr>
						<tr>
							<td>電源</td>
						</tr>
					</table>
				</div>

				<div class="cart_text">
					<h4>
						合計0個のアイテムを選択
						<button style="justify-content: right;">完全削除</button>
					</h4>

					<h2>
						<u>合計金額 0円</u>
					</h2>
				</div>
				<div class="cart_button">
					<ul>
						<li>
							<button>
								<a href="javascript:ImageUp2();">互換性チェック</a>
							</button>
						</li>
						<li>
							<button>
								<a href="save.html">見積保存</a>
							</button>
						</li>
						<li>
							<button>
								<a href="pay_mitumori.html">購入申込</a>
							</button>
						</li>
					</ul>
				</div>
			</div>
		</div>

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