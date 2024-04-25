<<%@page import="model.Assembly" %>
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
<link href="css/product.css" rel="stylesheet" type="text/css">
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
                <th><a href="product_game_diablo.jsp">Diablo4</a></th>
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
    <main>
        <h3>おすすめ商品</h3>
        <div class="item">
	        <table>
	        		
	        		<% 
					int count = 0;
					for(Assembly ad : adlist){
						if(count >= 9){
							break;
						}
					%>
					
					<% 
						if(count == 0){
					%>
						<tr><td><img src="./img/Valorant.jpg" width="480" height="240"></td>
					<%	
						}else if(count == 3){
			        %>
			             <tr>
			        <% 
			             }else if(count == 6){
			        %>
			             <tr><td><img src="./img/MonsterHunter_thumbnail.jpg" width="480" height="240"></td>
					<%
			             }
					%>
					<td align="center">
						<div class="menu_item">
			                <a href="product_detail.jsp?name=<%=ad.getAssembly_name()%>">
			                    <img src="img/<%=ad.getAssembly_img() %>" style="width:150px; height:150px;"><br>
			                    <%=ad.getAssembly_name() %><br><%=ad.getAssembly_price() %> 円
			                </a>
			             </div>
					</td>
					
					<% 
						if(count == 2){
					%>
						</tr>
					<%	
						}else if(count == 5){
			        %>
			             <td><img src="./img/OW2.png" width="480" height="240"></td></tr>
			        <% 
			             }else if(count == 8){
			        %>
			        	</tr>
					<%
			            }
						count++;
					}
					%>
	        </table>
        </div>
    </main>
</body>

	<footer>
		<div id="shopfooter">
			<h4>
				住所:〒152-0004 東京都目黒区鷹番1丁目11-9 代表:申東鉉<br> 電話番号:02-5448-8745
				会社名:株式会社Judgement
			</h4>
		</div>
	</footer>
</html>