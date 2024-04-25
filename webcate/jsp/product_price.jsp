<%@page import="model.Assembly" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Assembly> adlist = (ArrayList<Assembly>)session.getAttribute("assemblylist");
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/product_price.css" rel="stylesheet" type="text/css">
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
						<li><a href="counseling.jsp">購入相談</a></li>
						<li><a href="contact.jsp">お問い合わせ</a></li>
						<li><a href="login.jsp"><button style="width: 100px;">ログイン</button></a></li>
					</ul>
				</table>
			</div>
			<br>
	</header>
    <div class="PriceAndGame">
        <table>
            <tr>
                <td colspan="3">価格別</td>
                <td colspan="4"><a href="product_game.jsp">ゲーム別</a></td>
            </tr>
            <tr>
                <th><a href="product_price.jsp?min=5&max=7">5~7万</a></th>
                <th><a href="product_price.jsp?min=11&max=13">11~13万</a></th>
                <th><a href="product_price.jsp?min=17&max=19">17~19万</a></th>
                <th><a href="product_game_diablo.jsp?sortBy=0">Diablo4</a></th>
                <th><a href="product_game_valorant.jsp">Valorant</a></th>
                <th><a href="product_game_overwatch.jsp">OverWatch2</a></th>
                <th><a href="product_game_monsterhunter.jsp">MonsterHunter</a></th>
            </tr>
            <tr>
                <th><a href="product_price.jsp?min=8&max=10">8~10万</a></th>
                <th><a href="product_price.jsp?min=14&max=16">14~16万</a></th>
                <th><a href="product_price.jsp?min=20&max=50">20万以上</a></th>
                <th><a href="product_game_apexlegends.jsp">APEXLegends</a></th>
                <th><a href="product_game_kuroisabaku.jsp">黒い砂漠</a></th>
                <th><a href="product_game_fifa.jsp">FIFA23</a></th>
                <th><a href="product_game_gensin.jsp">原神</a></th>
            </tr>
        </table>
    </div>

    <p>
        	<%
        	int min = 0;
		    int max = Integer.MAX_VALUE; // デフォルト値として Integer.MAX_VALUE を使用
		    
		    String minValue = request.getParameter("min");
		    String maxValue = request.getParameter("max");
		    
			 // 最小値と最大値をint型に変換
		    if (minValue != null && !minValue.isEmpty()) {
		        min = Integer.parseInt(minValue);
		    }
		
		    if (maxValue != null && !maxValue.isEmpty()) {
		        max = Integer.parseInt(maxValue);
		    }
        	%>
        	
        <font color="red">
        <%
        if(max == 50){
        %>
        <%= min + "~万円台 "%>
        <%
        }else{
        %>
        <%= min + "~" + max + "万円台 "%>
        <%
        }
        %>
        </font>価格別組立PC
    </p>

    <div class="sort">
        <ul class="sort_ul">
            <li><a href="Product_price?sortBy=lowprice&min=<%= min%>&max=<%= max%>">低価格順</a></li>
			<li><a href="Product_price?sortBy=highprice&min=<%= min%>&max=<%= max%>">高価格順</a></li>
        </ul>
    </div>

    <div class="menu">
         <%
         max = max*10000;
         min = min*10000;
         
		    for (Assembly ad : adlist) {
		        // 価格帯が指定されていないか、価格帯が一致する場合に商品を表示
		        if (ad.getAssembly_price() >= min && ad.getAssembly_price() <= max) {
		%>
		            <div class="menu_item">
		            	<a href="product_detail.jsp?name=<%=ad.getAssembly_name()%>">
		                <!-- 商品画像の表示 -->
		                <img src="img/<%=ad.getAssembly_img() %>" style="width:150px; height:150px;"><br>
		                <!-- 商品名と価格の表示 -->
		                <%=ad.getAssembly_name() %><br><%=ad.getAssembly_price() %> 円
		                </a>
		            </div>
		<%
		        }
		    }
		%>
    </div>

    <footer>
        <div id="shopfooter">
            <h4>
                住所:〒152-0004 東京都目黒区鷹番1丁目11-9 代表:申東鉉<br>
                電話番号:02-5448-8745 会社名:株式会社Judgement
            </h4>
        </div>
    </footer>

</body>

</html>