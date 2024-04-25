<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Order"%>

<%
ArrayList<Order> orlist = (ArrayList<Order>) session.getAttribute("Orderlist");
ArrayList<Order> userOrders = new ArrayList<>();
if (orlist != null) {
	String userId = (String) session.getAttribute("userId");
	for (Order order : orlist) {
		if (order.getOrder_customer().equals(userId)) {
			userOrders.add(order);
		}
	}
} else {
	// orlistがnullの場合の処理
	// エラーメッセージを出力する、もしくは適切な処理を行う
}
%>

<%
int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
int itemsPerPage = 7;

int startIndex = (currentPage - 1) * itemsPerPage;
int endIndex = Math.min(startIndex + itemsPerPage, userOrders.size());

ArrayList<Order> sublist = new ArrayList<>(userOrders.subList(startIndex, endIndex));
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="./css/vendor.css" rel="stylesheet" type="text/css">
<title>Judgement</title>

</head>
<body>
    <header>
        <div class="header_logo">
            <a href="./home.jsp"><img src="./img/logo.jpg"
                style="width: 250px; height: 50px;"></a>
        </div>
    </header>
    <main>
        <div class="main">
            <div class="one">
                <div class="management">
                    <h2>
                        <a href="main.jsp">会員専用</a>
                    </h2>
                    <h4>
                        <a href="MitumoriSaveDao">保存見積もり</a>
                    </h4>
                    <h4>
                        <a href="OrderList">注文履歴</a>
                    </h4>
                    <h4>
                        <a href="information_change">会員情報変更</a>
                    </h4>
                </div>
            </div>
            <div class="two">
                <table>
                    <tr>
                        <th width="85px">注文日付</th>
                        <th width="100px">お客様指名</th>
                        <th width="150px">商品名</th>
                        <th width="85px">価格</th>
                    </tr>
                </table>

                <div class="aa">
                    <br>
                    <%
                    if (orlist != null && !userOrders.isEmpty()) {
                        int count = 0;
                        for (Order or : userOrders) {
                    %>
                    <table style="border-bottom: 1px solid black;">

                        <th width="85px"><%=or.getOrder_date()%></th>
                        <th width="100px"><%=or.getOrder_customer()%></th>
                        <th width="150px">
                            <%
                            if (or.getOrder_assembly() != null) {
                            %>
                            <%=or.getOrder_assembly()%>
                            <%
                            } else {
                            int mituid = or.getOrder_mitumori();
                            %>
                            <form id="orderForm" method="get" action="OrderMitumoriDetail">
                                <button type="button" class="orderButton" data-mituid="<%= or.getOrder_mitumori() %>"><%= or.getOrder_mitumori() %></button>
                                <input type="hidden" name="mituid" value="<%= or.getOrder_mitumori() %>">
                            </form>
                            <%
                            }
                            %>
                        </th>
                        <th width="85px"><%=or.getOrder_price()%></th>
                        </tr>


                    </table>
                    <%
                    count++;
                    }

                    } else {
                    %>
                    <p>情報がありません。</p>
                    <%
                    }
                    %>

                </div>
                <div class="pagination">
                    <%
                    int totalPages = (int) Math.ceil((double) userOrders.size() / itemsPerPage);
                    if (totalPages > 1) {
                    %>
                    <span>ページ:</span>
                    <%
                    for (int i = 1; i <= totalPages; i++) {
                    %>
                    <a href="?page=<%=i%>"><%=i%></a>
                    <%
                    }
                    %>
                    <%
                    }
                    %>
                </div>
            </div>
        </div>
    </main>
<script type="text/javascript">
    function openPopup(url) {
        window.open(url, "popup", "width=600,height=400");
    }
    // 注文ボタンのクリックイベントにイベントリスナーを追加
    var orderButtons = document.querySelectorAll('.orderButton');
    orderButtons.forEach(function(button) {
        button.addEventListener('click', function(event) {
            event.preventDefault(); // フォームの送信をキャンセル
            var mituid = button.getAttribute('data-mituid'); // ボタンの属性からmituidを取得
            openPopup('OrderMitumoriDetail?mituid=' + mituid);
        });
    });
</script>
</body>
</html>