<%@page import="model.Assembly"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Assembly> adlist = (ArrayList<Assembly>) session.getAttribute("assemblylist");
%>
<!DOCTYPE html>

<html lang="ja">

<head>
    <meta charset="utf-8">
    <meta name="description" content="商品詳細画面">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link href="./css/product_detail.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.7.0.min.js"></script>
    <title>商品詳細</title>
</head>

<body>
<%
String name = request.getParameter("name"); 
%>

    <h2><%=name %></h2>
    <div class="main">
        <div class="one">
        
        

<%
for (Assembly ad : adlist) {
    if(ad.getAssembly_name().equals(name)){
%>
        
     <img src="img/<%=ad.getAssembly_img() %>" width="450" height="600">
        </div>
        <div class="two">
            <div class="product">
                <table>
                    <tr>
                        <th><b>商品</b></th>
                        <td>2年出張AS+PC</td>
                    </tr>
                    <tr>
                        <th><b>配送方法</b></th>
                        <td>送料無料|クイックサービス|直接受領 安全配送</td>
                    </tr>
                    <tr>
                        <th><b>注文数</b></th>
                        <td>1</td>
                    </tr>
                    <tr>
                        <th><b>販売価格</b></th>
                        <td><%=ad.getAssembly_price() %>円</td>
                    </tr>
                    <tr>
                       <th><a href="pay_product.jsp?assembly_name=<%= ad.getAssembly_name() %>"><button>購入する</button></a></th>
                      
                    </tr>
                    <tr>
                    <td><input type="button" onClick="history.back();" value="戻る">
                    </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div class="detail">
        <h3>基本仕様</h3>
	    
	    <table border="1">
	   		 <tr>
                <th><b>分類</b></th>
                <th><b>商品名</b></th>
            </tr>
	        <tr>
	            <th>メモリー</th>
	            <td><%=ad.getAssembly_memory() %></td>
	        </tr>
	        <tr>
	            <th>電源</th>
	            <td><%=ad.getAssembly_power() %></td>
	        </tr>
	        <tr>
	            <th>クーラー</th>
	            <td><%=ad.getAssembly_cooler() %></td>
	        </tr>
	        <tr>
	            <th>ケース</th>
	            <td><%=ad.getAssembly_box() %></td>
	        </tr>
	        <tr>
	            <th>CPU</th>
	            <td><%=ad.getAssembly_cpu() %></td>
	        </tr>
	    </table>
    </div>
    <%
    	}
    }
    %>
</body>

</html>