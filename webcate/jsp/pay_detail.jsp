<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<%@ page import="java.text.DecimalFormat" %>
    
    <%
    // ランダムな13桁の数字を生成
    Random random = new Random();
    long randomNumber = Math.abs(random.nextLong() % 10000000000000L);
    
    // 13桁に満たない場合は0で埋める
    DecimalFormat df = new DecimalFormat("0000000000000");
    String formattedNumber = df.format(randomNumber);
   
    String name1 = request.getParameter("name1");
    String phonenum = request.getParameter("phonenum");
    String postnum = request.getParameter("postnum");
    String address = request.getParameter("address");
    String selectedProductName = (String) session.getAttribute("selectedProductName");
    String selectedMouseText = request.getParameter("selectedMouseText");
    String selectedKeyboardText = request.getParameter("selectedKeyboardText");

    String mouse = (String) session.getAttribute("mouse");
    String keyboard = (String) session.getAttribute("keyboard");
    String userId = (String) session.getAttribute("userId");
    
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
            <a href="home.jsp"><img src="img/logo.jpg" style="width:250px;height:50px;"></a>
        </div>
    </header>

    <main>
    <form method = "POST" action="order_take" accept-charset="UTF-8" onsubmit="alert('注文完了しました。'); return true;" >
        <h1>お届け先情報</h1>
        <!-- お届け先情報の表示 -->
        <table rules="all">
        <tr>
        	<th>名前</th>
        	<td><%= request.getParameter("name1") %> </td>
        </tr>
         <tr>
        	<th>電話番号</th>
        	<td><%= request.getParameter("phonenum") %> </td>
        </tr>
            <tr>
                <th>郵便番号</th>
                <td><%= request.getParameter("postnum") %></td>
            </tr>
            <tr>
                <th>都道府県市町村</th>
                <td><%= request.getParameter("address") %></td>
            </tr>
        </table>

        <h1>選択した商品</h1>
	
        <!-- マウスとキーボードの名前を表示 -->
        <table rules="all">
        <tr>
        <th>選択した商品</th>
        <td><%= session.getAttribute("selectedProductName") %>
        </tr>
            <tr>
                <th>マウス</th>
                 <td><%= request.getParameter("selectedMouseText") %></td>
            </tr>
            <tr>
                <th>キーボード</th>
                 <td><%= request.getParameter("selectedKeyboardText") %></td>
                
            </tr>
            <tr>
                <th>マウスの金額</th>
                <td><%= request.getParameter("mouse") %>円</td>
            </tr>
            <tr>
                <th>キーボードの金額</th>
                <td><%= request.getParameter("keyboard") %>円</td>
            </tr>
            <tr>
            <%
            int mousePrice = request.getParameter("mouse") != null ? Integer.parseInt(request.getParameter("mouse")) : 0;
            int keyboardPrice = request.getParameter("keyboard") != null ? Integer.parseInt(request.getParameter("keyboard")) : 0;
            int selectedProductPrice = (int) session.getAttribute("selectedProductPrice");
            int totalPriceValue  = mousePrice + keyboardPrice + selectedProductPrice;
    		%>
            <th>合計金額</th>
            
            <td><%= totalPriceValue   %>円 </td>
      
            </tr>
        </table>
        <input type ="hidden" name="name1" value="<%= name1 %>">
        <input type ="hidden" name="phonenum" value="<%=phonenum %>">
        <input type ="hidden" name="postnum" value="<%=postnum %>">
        <input type ="hidden" name="address" value="<%=address %>">
        <input type ="hidden" name="selectedProductName" value="<%=selectedProductName %>">
        <input type ="hidden" name="selectedMouseText" value="<%=selectedMouseText %>">
        <input type ="hidden" name="selectedKeyboardText" value="<%=selectedKeyboardText %>">
        <input type ="hidden" name="mouse" value="<%=mouse %>">
        <input type ="hidden" name="keyboard" value="<%=keyboard %>">
        <input type ="hidden" name="totalPriceValue" value="<%=totalPriceValue %>">
        
        

        <h1>支払い情報</h1>
        <% String paymentMethod = request.getParameter("payment");
        if(paymentMethod != null){
           if (paymentMethod.equals("クレジットカード")) { %>
            
                <label for="cardNumber">カード番号:</label>
                <input type="text" id="cardNumber" name="cardNumber" placeholder="カード番号を入力してください" required><br>
                <label for="expirationDate">有効期限:</label>
                <input type="text" id="expirationDate" name="expirationDate" placeholder="MM/YY" required><br>
                <label for="csv">CSV:</label>
                <input type="text" id="csv" name="csv" placeholder="CSVを入力してください" required><br>
                <label for="cardHolderName">名前:</label>
                <input type="text" id="cardHolderName" name="cardHolderName" placeholder="カード名義人の名前を入力してください" required><br>
             
                <input type="submit" value="完了">
          
        <% } else if (paymentMethod.equals("コンビニ支払い")) { %>
        <p>コンビニ払込番号: <%= formattedNumber %></p>
        <input type="submit" value="完了">
        <% } else if (paymentMethod.equals("口座振替")) { %>
        	<p>銀行名:　ゆうちょ銀行</p>
        	<p>口座種別 : 普通</p>
        	<p>支店　: 一ニ三</p>
            <p>口座名義: 銀行太郎</p>
            <p>口座番号: 6241250</p>
            <input type="submit" value="完了">
        <% }else{ %>
        <p>支払い方法が選択されていません。</p>
         <% } 
        } else { %>
          <p>支払い方法が選択されていません。</p>
          <% } %>
    <button onclick="history.back()">戻る</button>
    </main>
</form>
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
