<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/counseling.css" rel="stylesheet" type ="text/css">
    <title>Judgement</title>
</head>
<body>
    <header>
        <div class="header_logo">
            <a href="home.jsp"><img src="img/logo.jpg" style="width:250px;height:50px;"></a>
        </div>
        <div class="header_navigation">
            <table>
                <ul>
                     <li><a href="mitumori.jsp">見積もり</a></li>
						<li><a href="product.jsp">組み立てPC</a></li>
						<li><a href="counseling.jsp">購入相談</a></li>
						<li><a href="contact.jsp">お問い合わせ</a></li>
						<li><a href="login.jsp"><button style="width: 100px;">ログイン</button></a></li>
                </ul>
            </table>
        </div>
        <br>
    </header>
    <main>
        <form>
            <h2>PC購入相談</h2>
            <p>
                決済方法<font color="red">(必須)</font><br>
                <input type="radio" name="paymentcard" value="paymentcard">クレジットカード
                <input type="radio" name="paymentconbini" value="paymentconbini">コンビニ支払い
                <input type="radio" name="paymentbank" value="paymentbank">銀行振込
            </p>
            <h6></h6>
            <p>
                タイトル<font color="red">(必須)</font>
                <br>
                <input type="text" name="counseling_title"  style="width:500px;height:20px;" placeholder="タイトルを入力してください。">
            </p>
            <h6></h6>
            <p>
                内容
                <br>
                <input type="text" name="counseling_main" style="width:500px;height:20px;" placeholder="内容を入力してください。">
            </p>
            <h6></h6>
            <p>
                商品一覧
                <table rules="all">
                   
                </table>
            </p>
            
            <div class="counseling_save">
                <button><a href="counseling_ok.html">送信</a></button>
                <input type="reset" value="リセット">
            </div>
        </form>
    </main>
</body>
</html>