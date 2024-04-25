<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Save" %>
<%ArrayList<String> gcpcartList = (ArrayList<String>) session.getAttribute("gcpcartList");%>
<%ArrayList<String> gcocartList = (ArrayList<String>) session.getAttribute("gcocartList");%>
<%ArrayList<String> gboxcartList = (ArrayList<String>) session.getAttribute("gboxcartList");%>
<%ArrayList<String> ggraphiccartList = (ArrayList<String>) session.getAttribute("ggraphiccartList");%>
<%ArrayList<String> gmcartList = (ArrayList<String>) session.getAttribute("gmcartList");%>
<%ArrayList<String> gmbcartList = (ArrayList<String>) session.getAttribute("gmbcartList");%>
<%ArrayList<String> gpocartList = (ArrayList<String>) session.getAttribute("gpocartList");%>
<%ArrayList<String> gssdcartList = (ArrayList<String>) session.getAttribute("gssdcartList");%>
<%
String sCpu = "";
String sCoo = "";
String sMob = "";
String sMem = "";
String sGra = "";
String sSsd = "";
String sBox = "";
String sPow = "";
%>
<%ArrayList<Save> savedlist = (ArrayList<Save>) session.getAttribute("savedlist");%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/save.css" rel="stylesheet" type="text/css">
<title>Judgement</title>
</head>
<body>
	<header>
		<h1 style="width: 600px; border-bottom: 2px solid black;">見積もり</h1>
	</header>

	<main>
		<div class="save_list">
			<% if (savedlist != null) {
				for(Save saved : savedlist){ %>
				<p><%=saved.getMitusave_id() %></p>
			<%} }%>
		</div>

		
		<form method="post" action="MitumoriSave" >
			<h3>
				見積もりの生成 <input type="text" style="width: 350px; height: 20px;"
					id="sName" name="sName"  placeholder="見積もり名を入力してください。"><br>
					<table border="1">
						<tr>
							<th>CPU</th>
							<% if (gcpcartList != null) { for (String cpu : gcpcartList) {%>
							<td><%=cpu%></td>
							<% sCpu = cpu; } } %>
						</tr>
						<tr>
							<th>クーラー</th>
							<%  if (gcocartList != null) { for (String cooler : gcocartList) {%>
							<td><%=cooler%></td>
							<% sCoo = cooler; } } %>
						</tr>
						<tr>
							<th>マザーボード</th>
							<%  if (gmbcartList != null) { for (String motherBoard : gmbcartList) {%>
							<td><%=motherBoard%></td>
							<% sMob = motherBoard; } } %>
						</tr>
						<tr>
							<th>メモリ</th>
							<%  if (gmcartList != null) { for (String memory : gmcartList) {%> 
							<td><%=memory%></td>
							<% sMem = memory; } }%>
						</tr>
						<tr>
							<th>グラフィックカード</th>
							<%  if (ggraphiccartList != null) { for (String graphic : ggraphiccartList) { %>
							<td><%=graphic%></td>
							 <% sGra = graphic; } } %>
						</tr>
						<tr>
							<th>SSD</th>
							<% if (gssdcartList != null) { for (String ssd : gssdcartList) {%>
							<td><%=ssd%></td>
							<% sSsd = ssd; } }%>
						</tr>
						<tr>
							<th>ケース</th>
							<%  if (gboxcartList != null) { for (String box : gboxcartList) {%>
							<td><%=box%></td> 
							<% sBox = box; } }%>
						</tr>
						<tr>
							<th>電源</th>
							<% if (gpocartList != null) { for (String power : gpocartList) {%>
							<td><%=power%></td>
							<% sPow = power; } } %>
						</tr>
					</table>
				
			</h3>
	
			<h4>見積もり保存ガイド</h4>
			<ul>
				<li>カートに入れた商品を見積もりに保存できます。</li>
				<li>保存した見積もりは「見積もりを読み込む」で確認できます。</li>
				<li>見積もりが保存されている見積もりに新しく保存すると、既存の見積もりは削除されます。</li>
				<li>見積もりの修正と削除は、マイページ>興味のある商品/見積もりわご利用ください。</li>
				<li>保存可能な見積もりは最大10個です。</li>
				<li>見積もりに保存された商品は1年間保持されます。</li>
				<li>見積もりは最大30文字、日本語、英語、数字のみ入力できます。</li>
			</ul>
	
			<div class="save_save">
				<input type="hidden" name="sCpu" value="<%=sCpu%>"> <input
				type="hidden" name="sCoo" value="<%=sCoo%>"> <input
				type="hidden" name="sMob" value="<%=sMob%>"> <input
				type="hidden" name="sMem" value="<%=sMem%>"> <input
				type="hidden" name="sGra" value="<%=sGra%>"> <input
				type="hidden" name="sSsd" value="<%=sSsd%>"> <input
				type="hidden" name="sBox" value="<%=sBox%>"> <input
				type="hidden" name="sPow" value="<%=sPow%>">
				<input type="submit" value="保存">
			</div>
		</form>
		<div class="save_save">	
			<button>
				<a href="javascript:history.back()">キャンセル</a>
			</button>
		</div>
	</main>
</body>
</html>