<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Assembly"%>
<%@page import="take.PriceCalculator"%>
<%@page import="model.Customer"%> 


<%
String user = (String) session.getAttribute("userId");


if ( user != null) {


// PriceCalculator インスタンスを作成
PriceCalculator calculator = new PriceCalculator();

// Assembly インスタンスを取得
ArrayList<Assembly> adlist = (ArrayList<Assembly>) session.getAttribute("assemblylist");
Assembly selectedAssembly = null;
String name = request.getParameter("assembly_name");
for (Assembly assembly : adlist) {
	if (assembly.getAssembly_name().equals(name)) {
		selectedAssembly = assembly;
		break;
	}
}

// nullチェックを行う
if (selectedAssembly == null) {
	// エラーハンドリングまたは適切な処理を行う
	// この例では、例外をスローすることにしました
	throw new IllegalArgumentException("Selected assembly not found");
}
%>

<%
// 選択された商品の名前と金額をsessionに保存する
session.setAttribute("selectedProductName", name);
session.setAttribute("selectedProductPrice", selectedAssembly.getAssembly_price());
%>

<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/pay_product.css" rel="stylesheet" type="text/css">
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
		<form action="pay_detail.jsp" method="get" accept-charset="UTF-8"
			onsubmit="updateHiddenFields()">

			<h1>商品一覧</h1>
			<h2><%=name%></h2>
			<%
			for (Assembly ad : adlist) {
				if (ad.getAssembly_name().equals(name)) {
			%>
			<img src="img/<%=ad.getAssembly_img()%>" width="300" height="500">
			<h2><%=ad.getAssembly_price()%>円
			</h2>

			<%
			}
			}
			%>

			<!-- checkout.jspはお支払い情報登録処理を行うページと仮定 -->

			<table rules="all">
				<tr>
					<th>名前</th>
					<td><input type="text" name="name1" placeholder="名前を入力してください。">
					</td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><input type="num" name="phonenum"
						placeholder="電話番号を入力してください。"></td>
				</tr>
				<tr>
					<th>郵便番号</th>
					<td><input type="text" name="postnum"
						placeholder="郵便番号を入力してください"></td>
				</tr>
				<tr>
					<th>都道府県市町村,建物名</th>
					<td><input type="text" style="width: 500px;" name="address"
						placeholder="都道府県市町村,建物名を入力してください"></td>
				</tr>
				<tr>
					<th>お支払い情報</th>
					<td><input type="radio" id="card" name="payment"
						value="クレジットカード"><label for="select1">クレジットカード</label> <input
						type="radio" id="conbini" name="payment" value="コンビニ支払い"><label
						for="select2">コンビニ支</label> <input type="radio" id="tuucyou"
						name="payment" value="口座振替"><label for="select3">口座振替
					</label></td>
				</tr>
			</table>
			<th>キーボード</th>
			<td>
				<p>
					<select name="keyboard" id="keyboard"
						onchange="updateKeyboardHiddenField()">
						<option value="0">なし</option>
						<option value="4000">ELECOM 有線フルキーボード</option>
						<option value="5000">ELECOM 洗える 抗菌 有線キーボード</option>
						<option value="6500">ELECOM 有線メカニカルテンキーレスキーボード</option>
						<option value="7000">logicool PRO キーボード</option>
						<option value="10000">logicool G713</option>
						<option value="12000">logicool PRO X TKL</option>
					</select> <input type="hidden" name="selectedKeyboardText"
						id="selectedKeyboardText" value="">
				</p>
			</td>
			</tr>
			<tr>
				<th>マウス</th>
				<td>
					<p>
						<select name="mouse" id="mouse"
							onchange="updateMouseHiddenField()">
							<option value="0">なし</option>
							<option value="2500">ELECOM 抗菌 有線 静音 BlueLEDマウス (5ボタン)</option>
							<option value="3500">ELECOM 有線レーザーマウス(5ボタン・チルトホイール)</option>
							<option value="4500">ELECOM 5ボタンBlueLED有線マウス</option>
							<option value="5500">logicool PRO</option>
							<option value="6000">logicool PRO X マウス</option>
							<option value="10000">logicool PRO X SUPERLIGHT2</option>
						</select> <input type="hidden" name="selectedMouseText"
							id="selectedMouseText" value="">
					<div id="submit">
						<input type="submit" value="支払い"></a>
						<button type="button" onclick="history.back()">
							キャンセル</a>
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
	<script>
		function updateHiddenFields() {
			// 選択されたキーボードとマウスのテキストを取得して、hidden inputフィールドに設定する
			var keyboardSelect = document.getElementById("keyboard");
			var selectedKeyboardText = keyboardSelect.options[keyboardSelect.selectedIndex].text;
			document.getElementById("selectedKeyboardText").value = selectedKeyboardText;

			var mouseSelect = document.getElementById("mouse");
			var selectedMouseText = mouseSelect.options[mouseSelect.selectedIndex].text;
			document.getElementById("selectedMouseText").value = selectedMouseText;
		}
	</script>
</body>

</html>
<%
}else{
    response.sendRedirect("login.jsp");
}
%>
