<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Mitumori"%>

<%
ArrayList<Mitumori> mitumoriList = (ArrayList<Mitumori>) session.getAttribute("mitumoriList");
ArrayList<String> mitusaveIdList = (ArrayList<String>) session.getAttribute("mitusaveIdList");
String userId = (String) session.getAttribute("userId");

%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/vendor.css" rel="stylesheet" type="text/css">
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
				<div class="activity">
					<h2>
						<a href="main.jsp">会員専用</a>
					</h2>
					<h4>
						<a href="MitumoriSaveDao">保存見積もり</a>
					</h4>
					<h4>
						<a href="order_list.jsp">注文履歴</a>
					</h4>
					<h4>
						<a href="information_change">会員情報変更</a>
					</h4>
				</div>
			</div>
			<div class="two">
				<div class="goods">
					<table rules="all" border="1">
						<%
						if (mitusaveIdList != null && mitumoriList != null) {
							for (int i = 0; i < Math.min(mitusaveIdList.size(), mitumoriList.size()); i++) {
								String msid = mitusaveIdList.get(i);
								Mitumori ml = mitumoriList.get(i);
						%>
						<tr>
							<th>保存名</th>
							<td><%=msid%></td>
						</tr>
						<tr>
							<th>CPU</th>
							<td><%=ml.getMitumori_cpu()%></td>
						</tr>
						<tr>
							<th>クーラー</th>
							<td><%=ml.getMitumori_cooler()%></td>
						</tr>
						<tr>
							<th>マザーボード</th>
							<td><%=ml.getMitumori_motherboard()%></td>
						</tr>
						<tr>
							<th>メモリ</th>
							<td><%=ml.getMitumori_memory()%></td>
						</tr>
						<tr>
							<th>グラフィックカード</th>
							<td><%=ml.getMitumori_graphic()%></td>
						</tr>
						<tr>
							<th>SSD</th>
							<td><%=ml.getMitumori_ssd()%></td>
						</tr>
						<tr>
							<th>ケース</th>
							<td><%=ml.getMitumori_box()%></td>
						</tr>
						<tr>
							<th>電源</th>
							<td><%=ml.getMitumori_power()%></td>
						</tr>
						<%
						}
						}
						%>
					</table>
				</div>
			</div>
		</div>
	</main>
</body>
</html>