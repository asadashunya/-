<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/product_gamePopular.css" rel="stylesheet" type="text/css">
    <title>Judgement</title>
</head>

<body>
    <header>
        <div class="header_logo">
            <a href="home.html"><img src="./img/logo.jpg" style="width:250px;height:50px;"></a>
        </div>
        <div class="header_search">
            <input type="textbox" style="width:400px;height:30px;" placeholder="検索内容を入力してください🔍">
        </div>
        <br>

        <div class="header_navigation">
            <table>
                <ul>
                    <li><a href="mitumori.html">見積もり</a></li>
                    <li><a href="product.html">組み立てPC</a></li>
                    <li><a href="counseling.html">購入相談</a></li>
                    <li><a href="contact.html">お問い合わせ</a></li>
                    <li><a href="login.html"><button style="width:100px;">ログイン</button></a></li>
                </ul>
            </table>
        </div>
    </header>
    <br>

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


    
    <div class="ano_category">
        <ul class="category_ul">
            <li class="list1" onclick="clickPopular"><a href="./product_game_popular.jsp">人気</a></li>
            <li class="list2" onclick="clickRpg"><a href="./product_game_rpg.jsp">RPG</a></li>
            <li class="list3" onclick="clickAction"><a href="./product_game_action.jsp">アクション/FPS</a></li>
            <li class="list4" onclick="clickStrategy"><a href="./product_game_sports.jsp">戦略/スポーツ</a></li>
        </ul>
    </div>
    
    <div class="gamePopular">
        <table>
            <tr>
                <th>
                    <a href="product_game_kuroisabaku.jsp">
                        <img src="./img/kuroisabaku1.jpg" width="200" height="100"><br>
                        黒い砂漠
                    </a>
                </th>
                <th>
                    <a href="product_game_overwatch.jsp">
                        <img src="./img/OW2_thumbnail.png" width="200" height="100"><br>
                        Over Watch2
                    </a>
                </th>
                <th>
                    <a href="product_game_gensin.jsp">
                        <img src="./img/gennshin_thumbnail.jpg" width="200" height="100"><br>
                        原神
                    </a>
                </th>
                <th>
                    <a href="product_game_valorant.jsp">
                        <img src="./img/Valorant_thumbnail.jpg" width="200" height="100"><br>
                        VALORANT
                    </a>
                </th>
            </tr>
        </table>
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