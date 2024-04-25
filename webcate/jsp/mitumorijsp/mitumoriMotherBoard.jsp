<%@page import="model.MotherBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%ArrayList<MotherBoard> mbdlist = (ArrayList<MotherBoard>) session.getAttribute("motherboardlist");%>

<%int num = 0;%>
<%int price = 0;%>

<%ArrayList<String> gcpcartList = (ArrayList<String>) session.getAttribute("gcpcartList");%>
<%if (gcpcartList != null) { num += gcpcartList.size();}%>
<%ArrayList<Integer> pcpList = (ArrayList<Integer>) session.getAttribute("pcpList");%>
<%if (pcpList != null) { for (int i = 0; i < pcpList.size(); i++) { price += pcpList.get(i); } }%>

<%ArrayList<String> gcocartList = (ArrayList<String>) session.getAttribute("gcocartList");%>
<%if (gcocartList != null) { num += gcocartList.size();}%>
<%ArrayList<Integer> pcoList = (ArrayList<Integer>) session.getAttribute("pcoList");%>
<%if (pcoList != null) { for (int i = 0; i < pcoList.size(); i++) { price += pcoList.get(i); } }%>

<%ArrayList<String> gboxcartList = (ArrayList<String>) session.getAttribute("gboxcartList");%>
<%if (gboxcartList != null) { num += gboxcartList.size();}%>
<%ArrayList<Integer> pboxList = (ArrayList<Integer>) session.getAttribute("pboxList");%>
<%if (pboxList != null) { for (int i = 0; i < pboxList.size(); i++) { price += pboxList.get(i); } }%>

<%ArrayList<String> ggraphiccartList = (ArrayList<String>) session.getAttribute("ggraphiccartList");%>
<%if (ggraphiccartList != null) { num += ggraphiccartList.size();}%>
<%ArrayList<Integer> pgraphicList = (ArrayList<Integer>) session.getAttribute("pgraphicList");%>
<%if (pgraphicList != null) { for (int i = 0; i < pgraphicList.size(); i++) { price += pgraphicList.get(i); } }%>

<%ArrayList<String> gmcartList = (ArrayList<String>) session.getAttribute("gmcartList");%>
<%if (gmcartList != null) { num += gmcartList.size();}%>
<%ArrayList<Integer> pmList = (ArrayList<Integer>) session.getAttribute("pmList");%>
<%if (pmList != null) { for (int i = 0; i < pmList.size(); i++) { price += pmList.get(i); } }%>

<%ArrayList<String> gmbcartList = (ArrayList<String>) session.getAttribute("gmbcartList");%>
<%if (gmbcartList != null) { num += gmbcartList.size();}%>
<%ArrayList<Integer> pmbList = (ArrayList<Integer>) session.getAttribute("pmbList");%>
<%if (pmbList != null) { for (int i = 0; i < pmbList.size(); i++) { price += pmbList.get(i); } }%>

<%ArrayList<String> gpocartList = (ArrayList<String>) session.getAttribute("gpocartList");%>
<%if (gpocartList != null) { num += gpocartList.size();}%>
<%ArrayList<Integer> ppoList = (ArrayList<Integer>) session.getAttribute("ppoList");%>
<%if (ppoList != null) { for (int i = 0; i < ppoList.size(); i++) { price += ppoList.get(i); } }%>

<%ArrayList<String> gssdcartList = (ArrayList<String>) session.getAttribute("gssdcartList");%>
<%if (gssdcartList != null) { num += gssdcartList.size();}%>
<%ArrayList<Integer> pssdList = (ArrayList<Integer>) session.getAttribute("pssdList");%>
<%if (pssdList != null) { for (int i = 0; i < pssdList.size(); i++) { price += pssdList.get(i); } }%>

<% String userId = (String) session.getAttribute("userId"); %>
<% session.setAttribute("price", price);%>
<%
String cCpu = "";
String cCoo = "";
String cMob = "";
String cMem = "";
String cGra = "";
String cSsd = "";
String cBox = "";
String cPow = "";
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="./css/mitumori.css" rel="stylesheet" type="text/css">
<script src="./js/jquery-3.7.0.min.js"></script>
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
					<% 
                    if(userId == null) { // ログインしていない場合
                	%>
					<li><a href="login.jsp"><button style="width: 100px">ログイン</button></a></li>
					 <% } else { // ログインしている場合 %>
                <li><p>おはようございます。<br> <%= userId %>様</p></li>
                <input type="button" value="ログアウト" onclick="location.href='logout'">
                <% } %>
				</ul>
			</table>
		</div>
		<br>
	</header>
	<main>
		<div class="main_search">
			<form method="GET" action="MitumoriMotherBoard">
				<input type="text" style="width: 900px; height: 30px;" id="PartName"
					name="PartName" placeholder="商品名を入力してください。🔍"> <input
					type="submit" value="検索">
			</form>
		</div>

		<div class="mein">
			<div class="main_sub">
				<div class="category_list">
					<ul>
						<li><a href="?sortBy=popularity">人気商品順</a></li>
						<li><a href="?sortBy=lowprice">低価格順</a></li>
						<li><a href="?sortBy=highprice">高価格順</a></li>
					</ul>
				</div>
				<div class="scroll_box">
					<table rules="all">
						<%
						String searchKeyword = request.getParameter("PartName");

						// 検索条件に一致するアイテムの総数を計算
						int totalItems = 0;
						for (MotherBoard mbd : mbdlist) {
							if (searchKeyword == null || mbd.getMotherboard_name().toLowerCase().contains(searchKeyword.toLowerCase())) {
								totalItems++;
							}
						}

						// ページの総数を計算
						int itemsPerPage = 7; // 1ページに表示するアイテムの数
						int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);

						// クエリパラメータからページ番号を取得
						String pageParam = request.getParameter("page");
						int currentPage = (pageParam != null && !pageParam.isEmpty()) ? Integer.parseInt(pageParam) : 1;

						// 表示するアイテムの開始と終了インデックスを計算
						int startIndex = (currentPage - 1) * itemsPerPage;
						int endIndex = Math.min(startIndex + itemsPerPage, totalItems);

						int displayedItems = 0;
						for (int i = startIndex; i < endIndex; i++) {
							MotherBoard mbd = mbdlist.get(i);
							// アイテムが検索条件に一致するか確認
							if (searchKeyword == null || mbd.getMotherboard_name().toLowerCase().contains(searchKeyword.toLowerCase())) {
								displayedItems++;
						%>
						<!-- アイテムの表示部分 -->
						<tr>
							<form action="Detail" method="post">
								<input type="hidden" name="goodsName"
									value="<%=mbd.getMotherboard_name()%>">
								<td rowspan="2">
									<button type="submit"
										style="border: none; background: none; padding: 0; margin: 0;">
										<img src="./img/<%=mbd.getMotherboard_img()%>"
											style="width: 100px; height: 100px;">
									</button>
								</td>
							</form>
							<td width="950"><%=mbd.getMotherboard_name()%></td>
							<td><%=mbd.getMotherboard_price()%>円</td>
						</tr>
						<tr>
							<td>説明:フォームファクタ<%=mbd.getMotherboard_factor()%>,製品会社/<%=mbd.getMotherboard_maker()%>,チップセット/<%=mbd.getMotherboard_chipset()%></td>
							<form action="MitumoriMotherBoard" method="post">
								<input type="hidden" name="goodsName"
									value="<%=mbd.getMotherboard_name()%>"> <input type="hidden"
									name="price" value="<%=mbd.getMotherboard_price()%>">
								<td><button type="submit">追加→</button></td>
							</form>
						</tr>
						<%
						}
						}
						%>
					</table>
					<ul>
						<%-- 前のページへのリンク --%>
						<%
						if (currentPage > 1) {
						%>
						<li><a
							href="?page=<%=currentPage - 1%><%if (searchKeyword != null) {%>&PartName=<%=searchKeyword%><%}%>">前へ</a></li>
						<%
						}
						%>

						<%-- ページ番号のリンク --%>
						<%
						for (int i = 1; i <= totalPages; i++) {
						%>
						<%
						String pageLink = "?page=" + i;
						%>
						<%
						if (searchKeyword != null) {
						%>
						<%
						pageLink += "&PartName=" + searchKeyword;
						%>
						<%
						}
						%>
						<li><a href="<%=pageLink%>"><%=i%></a></li>
						<%
						}
						%>

						<%-- 次のページへのリンク --%>
						<%
						if (currentPage < totalPages) {
						%>
						<%
						String nextPageLink = "?page=" + (currentPage + 1);
						%>
						<%
						if (searchKeyword != null) {
						%>
						<%
						nextPageLink += "&PartName=" + searchKeyword;
						%>
						<%
						}
						%>
						<li><a href="<%=nextPageLink%>">次へ</a></li>
						<%
						}
						%>
					</ul>
				</div>
			</div>
			<div class="cart_list">
				<div class="cart_title">
					<h2>見積もりカート</h2>
				</div>
				<div class="cart_item">
					<table>
						<tr>
							<td>
								<a href="MitumoriCpu">CPU</a><br>
								<%
								if (gcpcartList != null) {
									for (String cpu : gcpcartList) {
								%>
								<%=cpu%><br>
								<%
								cCpu = cpu;
									}
								}
								%>
							</td>
						</tr>
						<tr>
							<td>
								<a href="MitumoriCooler">クーラー</a><br>
								<%
								if (gcocartList != null) {
									for (String cooler : gcocartList) {
								%>
								<%=cooler%><br>
								<%
								cCoo = cooler;
									}
								}
								%>
							</td>
						</tr>
						<tr>
							<td>
								<a href="MitumoriMotherBoard">マザーボード</a><br>
								<%
								if (gmbcartList != null) {
									for (String motherBoard : gmbcartList) {
								%>
								<%=motherBoard%><br>
								<%
								cMob = motherBoard;
									}
								}
								%>
							</td>
						</tr>
						<tr>
							<td>
								<a href="MitumoriMemory">メモリ</a><br>
								<%
								if (gmcartList != null) {
									for (String memory : gmcartList) {
								%>
								<%=memory%><br>
								<%
								cMem = memory;
									}
								}
								%>
							</td>
						</tr>
						<tr>
							<td>
								<a href="MitumoriGraphic">グラフィックカード</a><br>
								<%
								if (ggraphiccartList != null) {
									for (String graphic : ggraphiccartList) {
								%>
								<%=graphic%><br>
								<%
								cGra = graphic;
									}
								}
								%>
							</td>
						<tr>
							<td>
								<a href="MitumoriSsd">SSD</a><br>
								<%
								if (gssdcartList != null) {
									for (String ssd : gssdcartList) {
								%>
								<%=ssd%><br>
								<%
								cSsd = ssd;
									}
								}
								%>
							</td>
						</tr>
						<tr>
							<td>
								<a href="MitumoriBox">ケース</a><br>
								<%
								if (gboxcartList != null) {
									for (String box : gboxcartList) {
								%>
								<%=box%><br>
								<%
								cBox = box;
									}
								}
								%>
							</td>
						</tr>
						<tr>
							<td>
								<a href="MitumoriPower">電源</a><br>
								<%
								if (gpocartList != null) {
									for (String power : gpocartList) {
								%>
								<%=power%><br>
								<%
								cPow = power;
									}
								}
								%>
							</td>
						</tr>
					</table>
				</div>

				<div class="cart_text">
					<h4>
						合計<%=num %>個のアイテムを選択
						<form method="post" action="Alldelete">
							<button>完全削除</button>
						</form>
					</h4>
					<h2>
						<u>合計金額 <%=price%>円</u>
					</h2>
				</div>
				<div class="cart_button">
					<ul>
						<li>
							<form method="get"
								action="Compatibility">
								<button>互換性チェック</button>
								<input type="hidden" name="sCpu" value="<%=cCpu%>"> <input
								type="hidden" name="sCoo" value="<%=cCoo%>"> <input
								type="hidden" name="sMob" value="<%=cMob%>"> <input
								type="hidden" name="sMem" value="<%=cMem%>"> <input
								type="hidden" name="sGra" value="<%=cGra%>"> <input
								type="hidden" name="sSsd" value="<%=cSsd%>"> <input
								type="hidden" name="sBox" value="<%=cBox%>"> <input
								type="hidden" name="sPow" value="<%=cPow%>">
							</form>
						</li>
						<li>
							<form method="get"
								action="<%if (userId == null) {%>login.jsp<%} else {%>Mitusave<%}%>">
								<button>見積保存</button>
							</form>
						</li>
						<li>
							<form action="<%if (userId == null) {%>login.jsp<%} else {%>pay_mitumori.jsp<%}%>">
								<button>購入申込</button>
								<input type="hidden" name="sCpu" value="<%=cCpu%>"> <input
								type="hidden" name="sCoo" value="<%=cCoo%>"> <input
								type="hidden" name="sMob" value="<%=cMob%>"> <input
								type="hidden" name="sMem" value="<%=cMem%>"> <input
								type="hidden" name="sGra" value="<%=cGra%>"> <input
								type="hidden" name="sSsd" value="<%=cSsd%>"> <input
								type="hidden" name="sBox" value="<%=cBox%>"> <input
								type="hidden" name="sPow" value="<%=cPow%>">
							</form>
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