<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/member_registration.css" rel="stylesheet" type ="text/css">
    <title>Judgement - 登録確認</title>
</head>
<body>
    <header>
        <div class="header_logo">
            <a href="home.jsp"><img src="img/logo.jpg" style="width:250px;height:50px;"></a>
        </div>
    </header>

    <main>
        <h1>入力情報確認</h1>
        <table>
            <tr>
                <th>項目</th>
                <th>入力内容</th>
            </tr>
            <tr>
                <td>アカウント名</td>
                <td><%= request.getParameter("cust_username") %></td>
            </tr>
            <tr>
                <td>お名前(姓、名)</td>
                <td><%= request.getParameter("cust_fname") %>　<%= request.getParameter("cust_lname") %></td>
            </tr>
            <tr>
                <td>お名前(フリガナ)</td>
                <td><%= request.getParameter("cust_fkana") %>　<%= request.getParameter("cust_lkana") %></td>
            </tr>
            <tr>
                <td>メールアドレス名</td>
                <td><%= request.getParameter("cust_mail") %></td>
            </tr>
            <tr>
                <td>電話番号</td>
                <td><%= request.getParameter("cust_tel") %></td>
            </tr>
            <tr>
                <td>郵便番号</td>
                <td><%= request.getParameter("cust_postnum") %></td>
            </tr>
            <tr>
                <td>住所</td>
                <td><%= request.getParameter("cust_address") %></td>
            </tr>
            
            
        </table>
        
        <form method="GET" action="registration_process">
            <input type="hidden" name="cust_username" value="<%= request.getParameter("cust_username") %>">
            <input type="hidden" name="cust_fname" value="<%= request.getParameter("cust_fname") %>">
            <input type="hidden" name="cust_lname" value="<%= request.getParameter("cust_lname") %>">
            <input type="hidden" name="cust_fkana" value="<%= request.getParameter("cust_fkana") %>">
            <input type="hidden" name="cust_lkana" value="<%= request.getParameter("cust_lkana") %>">
            <input type="hidden" name="cust_mail" value="<%= request.getParameter("cust_mail") %>">
            <input type="hidden" name="cust_tel" value="<%= request.getParameter("cust_tel") %>">
            <input type="hidden" name="cust_postnum" value="<%= request.getParameter("cust_postnum") %>">
            <input type="hidden" name="cust_address" value="<%= request.getParameter("cust_address") %>">
            <input type="hidden" name="cust_pass" value="<%= request.getParameter("cust_pass") %>">
            <input type="hidden" name="cust_pass" value="<%= request.getParameter("cust_pass") %>">
            
           <% 
                String password = request.getParameter("cust_pass");
                String passwordConfirmation = request.getParameter("passwordcheck");
                if (password != null && passwordConfirmation != null && password.equals(passwordConfirmation)) {
            %>
                <input type="submit" value="登録">
            <% } else { %>
                <div style="color: red;">パスワードとパスワード確認が一致しません。</div>
                <input type="button" onclick="history.back()" value="戻る">
            <% } %>
        </form>
    </main>

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