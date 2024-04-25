<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="model.Mitumori"%>

<%
ArrayList<Mitumori> mdlist = (ArrayList<Mitumori>) session.getAttribute("mdlist");
%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="utf-8">
<meta name="description" content="商品詳細画面">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link href="./css/detail.css" rel="stylesheet" type="text/css">
<title>Judgement</title>
</head>
<body>
	<header>
		<div class="header_logo">
			<a href="home.jsp"><img src="img/logo.jpg"
				style="width: 250px; height: 50px;"></a>
		</div>
		<table>
			<%
			for(Mitumori md : mdlist){
			%>
			<tr>
				<th>CPU</th>
				<%
				if(md.getMitumori_cpu() != null) {
				%>
				<td><%=md.getMitumori_cpu() %></td>
				<%
				}else{
				%>
				<td>なし</td>
				<%
				}
				%>
			</tr>
			<tr>
				<th>クーラー</th>
				<%
				if(md.getMitumori_cooler() != null) {
				%>
				<td><%=md.getMitumori_cooler() %></td>
				<%
				}else{
				%>
				<td>なし</td>
				<%
				}
				%>
			</tr>
			<tr>
				<th>マザーボード</th>
				<%
				if(md.getMitumori_motherboard() != null) {
				%>
				<td><%=md.getMitumori_motherboard() %></td>
				<%
				}else{
				%>
				<td>なし</td>
				<%
				}
				%>
			</tr>
			<tr>
				<th>メモリ</th>
				<%
				if(md.getMitumori_memory() != null) {
				%>
				<td><%=md.getMitumori_memory() %></td>
				<%
				}else{
				%>
				<td>なし</td>
				<%
				}
				%>
			</tr>
			<tr>
				<th>グラフィックカード</th>
				<%
				if(md.getMitumori_graphic() != null) {
				%>
				<td><%=md.getMitumori_cpu() %></td>
				<%
				}else{
				%>
				<td>なし</td>
				<%
				}
				%>
			</tr>
			<tr>
				<th>SSD</th>
				<%
				if(md.getMitumori_ssd() != null) {
				%>
				<td><%=md.getMitumori_ssd() %></td>
				<%
				}else{
				%>
				<td>なし</td>
				<%
				}
				%>
			</tr>
			<tr>
				<th>ケース</th>
				<%
				if(md.getMitumori_box() != null) {
				%>
				<td><%=md.getMitumori_box() %></td>
				<%
				}else{
				%>
				<td>なし</td>
				<%
				}
				%>
			</tr>
			<tr>
				<th>電源</th>
				<%
				if(md.getMitumori_power() != null) {
				%>
				<td><%=md.getMitumori_power() %></td>
				<%
				}else{
				%>
				<td>なし</td>
				<%
				}
				%>
			</tr>
			<%
			}
			%>
			
		</table>
		<%
		session.removeAttribute("mdlist");
		%>
</body>
</html>