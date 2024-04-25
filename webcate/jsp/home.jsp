<%@page import="model.Assembly"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Assembly> adlist = (ArrayList<Assembly>) session.getAttribute("assemblylist");
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/home.css" rel="stylesheet" type="text/css">
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
					<li><a href="MitumoriCpu">見積もり</a></li>
					<li><a href="product.jsp">組み立てPC</a></li>
					<li><a href="contact.jsp">お問い合わせ</a></li>
					 <% String userId = (String) session.getAttribute("userId"); 
                    if(userId == null) { // ログインしていない場合
                	%>
					<li><a href="login.jsp"><button style="width: 100px">ログイン</button></a></li>
					 <% } else { // ログインしている場合 %>
                <li><p>おはようございます。<br> <%= userId %>様</p></li>
                <input type="button" value="ログアウト" onclick="location.href='logout'">
                <a href="main.jsp">マイページ</a>
                <% } %>
				</ul>
			</table>
		</div>
		<br>
	</header>
	<main>
		<img src="img/sample_pc1.png" style="width: 1100px; height: 800px;">
		<h3>おすすめ商品</h3>
		<div class="menu">
			 <% if (adlist != null) { %>
            <% int count = 0;
            for (Assembly ad : adlist) {
                if (count >= 5) {
                    break;
                }
            %>
			<div class="menu_item">
				<a href="#"> <img src="img/<%=ad.getAssembly_img()%>"><br>
					<%=ad.getAssembly_name()%><br>[<%=ad.getAssembly_cpu()%>/<%=ad.getAssembly_graphic()%>~<br><%=ad.getAssembly_price()%>円
				</a>
			</div>
			<%
			count++;
			} %>
			 <% } else { %>
            <p>おすすめ商品はありません。</p>
        <% } %>
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