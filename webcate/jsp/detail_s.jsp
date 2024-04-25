<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="model.Customer"%>
<%@ page import="model.Inquiry"%>
<%@ page import="model.Order"%>
<%@ page import="dao.CustomerDao"%>
<%@ page import="dao.InquiryDao"%>
<%@ page import="dao.OrderDao"%>



<%
ArrayList<Customer> cslist = (ArrayList<Customer>) session.getAttribute("Customerlist");
ArrayList<Inquiry> inlist = (ArrayList<Inquiry>) session.getAttribute("Inquirylist");
ArrayList<Order> orlist = (ArrayList<Order>) session.getAttribute("Orderlist");
%>



<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="./css/vendor.css" rel="stylesheet" type="text/css">
<title>詳細ページ</title>
</head>
<body>
    <header>
        <div class="header_logo">
            <a href="./home.jsp"><img src="./img/logo.jpg" style="width: 250px; height: 50px;"></a>
        </div>
    </header>
    <main>
    
        <div class="main">
            <div class="detail">
                <h2>詳細情報</h2>
                <% 
                // customer_info.jspからの情報を表示する
                if(cslist != null && request.getParameter("cust_num") != null) {
                	int num = Integer.parseInt(request.getParameter("cust_num"));
                	for(Customer cs : cslist){
                		if(cs.getCust_num() == num){
                %>
                <h3>顧客情報</h3>
                <table border="1">
                <tr>
                	<th>ユーザID:</th>
                    <td><%= cs.getCust_num() %></td>
                </tr>
                <tr>
                    <th>ユーザ名:</th>
                    <td><%= cs.getCust_username() %></td>
                </tr>
                <tr>
                    <th>ユーザ名(漢字):</th>
                    <td><%= cs.getCust_fname() %>　<%= cs.getCust_lname() %></td>
                    </tr>
                    <tr>
                    <th>ユーザ名（フリガナ）: </th>
                    <td><%= cs.getCust_fkana() %>　<%= cs.getCust_lkana() %></td>
                    </tr>
                    <tr>
                    <th>郵便番号: </th> 
                    <td><%= cs.getCust_postnum() %></td>
                    </tr>
                    <tr>
                    <th>住所: </th> 
                    <td><%= cs.getCust_address() %></td>
                    </tr>
                    <tr>
                    <th>メールアドレス: </th>
                     <td><%= cs.getCust_mail() %></td>
                    </tr>
                    <tr>
                    <th>電話番号: </th>
                    <td><%= cs.getCust_tel() %></td>
                    </tr>
                    </table>
                    <button type="button" onclick="history.back()" >戻る</button>
                <% }
                }
               }else if(inlist != null && request.getParameter("inquiry_id") != null){
            	   int num = Integer.parseInt(request.getParameter("inquiry_id"));
            	   for(Inquiry in : inlist){
            		   if(in.getInquiry_id() == num){
                %>
                <h3>お問い合わせ情報</h3>
                <table border="1">
                <tr>
                    <th>お問い合わせID: </th>
                    <td><%= in.getInquiry_id() %></td>
                </tr>
                <tr>
                    <th>お問い合わせ内容: </th>
                    <td><%= in.getInquiry_main() %></td>
                </tr>
                <tr>
                    <th>名前: </th>
                    <td><%= in.getInquiry_name() %></td>
                </tr>
                <tr>
                    <th>電話番号: </th>
                    <td><%= in.getInquiry_tel() %></td>
                </tr>
                <tr>
                    <th>メールアドレス: </th>
                    <td><%= in.getInquiry_mail() %></td>
                </tr>
                <tr>
                    <th>題目: </th>
                    <td><%= in.getInquiry_title() %></td>
                </tr>
                    </table>
                    <button type="button" onclick="history.back()" >戻る</button>
                    <!-- 他のお問い合わせ情報を表示するプロパティがあれば、ここに追加 -->
                <% 
            		   }
            	   }
               }else if(orlist != null && request.getParameter("order_id") != null){
            	   int num = Integer.parseInt(request.getParameter("order_id"));
            	               for(Order or : orlist){
            	               			   if(or.getOrder_id() == num){
                %>

                    <h3>注文情報</h3>
                    <table border="1">
                    <tr>
                    	<th>注文ID: </th>
                    	<td><%= or.getOrder_id() %></td>
                    </tr>
                    <tr>
                    	<th>注文者: </th>
                    	<td><%= or.getOrder_customer() %></td>
                    </tr>
                    <tr>
                    	<th>注文日付: </th>
                    	<td><%= or.getOrder_date() %></td>
                    </tr>
                    <tr>
                    	<th>注文価格: </th>
                    	<td><%= or.getOrder_price() %></td>
                    </tr>
                    <tr>
                    	<th>注文見積もり: </th>
                    	<td><%= or.getOrder_mitumori() %></td>
                    </tr>
                    <tr>
                    	<th>組み立て注文: </th>
                    	<td><%= or.getOrder_assembly() %></td>
                    </tr>
                    <tr>
                    	<th>注文内容: </th>
                    	<td><%= or.getOrder_customer() %></td>
                    </tr>
                    
                    </table>
                    <button type="button" onclick="history.back()" >戻る</button>
                    <!-- 他の注文情報を表示するプロパティがあれば、ここに追加 -->
                <% 
         	   
            		   }
            	   }
               }
                
                
                %>
            </div>
        </div>
    </main>
</body>
</html>