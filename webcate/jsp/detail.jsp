<%@page import="model.Box"%>
<%@page import="model.Cooler"%>
<%@page import="model.Cpu"%>
<%@page import="model.Graphic_board"%>
<%@page import="model.Memory"%>
<%@page import="model.MotherBoard"%>
<%@page import="model.Power"%>
<%@page import="model.Ssd"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Box> bdlist = (ArrayList<Box>) session.getAttribute("boxlist");
ArrayList<Cooler> cldlist = (ArrayList<Cooler>) session.getAttribute("coolerlist");
ArrayList<Cpu> cdlist = (ArrayList<Cpu>) session.getAttribute("cpulist");
ArrayList<Graphic_board> gbdlist = (ArrayList<Graphic_board>) session.getAttribute("graphiclist");
ArrayList<Memory> mdlist = (ArrayList<Memory>) session.getAttribute("memorylist");
ArrayList<MotherBoard> mbdlist = (ArrayList<MotherBoard>) session.getAttribute("motherboardlist");
ArrayList<Power> pdlist = (ArrayList<Power>) session.getAttribute("powerlist");
ArrayList<Ssd> sdlist = (ArrayList<Ssd>) session.getAttribute("ssdlist");
%>
<%ArrayList<String> detail = (ArrayList<String>) session.getAttribute("detail");%>

<%
String name = "";
for (String goods : detail) { 
	name = goods; 
	}
%>

<!DOCTYPE html>

<html lang="ja">

<head>
<meta charset="utf-8">
<meta name="description" content="商品詳細画面">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link href="./css/detail.css" rel="stylesheet" type="text/css">
<title>商品詳細</title>
</head>

<body>
	<h2><%=name %></h2>
	
	<%
		if(bdlist != null){
			    for (Box bx : bdlist) {
			        if(bx.getBox_name().equals(name)){
			%>
	<img src="img/<%=bx.getBox_img() %>" width="600" height="450">

	<h2>製品詳細</h2>

	<table>
		<tr>
			<th>メーカー</th>
			<td><%=bx.getBox_maker() %></td>
			<th>水冷対応</th>
			<td><%=bx.getBox_water() %></td>
		</tr>
		<tr>
			<th>対応グラフィックボード</th>
			<td>最大<%=bx.getBox_maker() %>mm
			</td>
			<th>対応CPUクーラー</th>
			<td>最大<%=bx.getBox_maker() %>mm
			</td>
		</tr>
		<tr>
			<th>対応電源ユニット</th>
			<td>最大<%=bx.getBox_maker() %>mm
			</td>
			<th>対応マザーボード</th>
			<td><%=bx.getBox_mother() %></td>
		</tr>
		<tr>
			<th>サイズ(幅x高さx奥行)</th>
			<td><%=bx.getBox_size() %>mm</td>
			<th>価格</th>
			<td><%=bx.getBox_price() %></td>
		</tr>
	</table>
	<%
			    }
			 }
		}
	if(cldlist != null){
				for (Cooler cl : cldlist) {
			        if(cl.getCooler_name().equals(name)){
%>
	<img src="img/<%=cl.getCooler_img() %>" width="600" height="450">

	<h2>製品詳細</h2>

	<table>
		<tr>
			<th>メーカー</th>
			<td><%=cl.getCooler_maker() %></td>
			<th>コネクタ</th>
			<td><%=cl.getCooler_conector() %>pin</td>
		</tr>
		<tr>
			<th colspan="3">対応ソケット</th>
			<td><%=cl.getCooler_socket() %></td>
		</tr>
		<tr>
			<th>消費電力</th>
			<td>最大<%=cl.getCooler_power() %>W
			</td>
			<th>ファン数</th>
			<td><%=cl.getCooler_fans() %></td>
		</tr>
		<tr>
			<th>価格</th>
			<td><%=cl.getCooler_price() %>円</td>
		</tr>
	</table>
	<%
			    }
			}
		}
	if(cdlist != null){
			for (Cpu cp : cdlist) {
			        if(cp.getCpu_name().equals(name)){
			%>
	<img src="img/<%=cp.getCpu_img() %>" width="600" height="450">

	<h2>製品詳細</h2>

	<table>
		<tr>
			<th>プロセッサ名</th>
			<td><%=cp.getCpu_processor() %></td>
			<th>ソケット形状</th>
			<td><%=cp.getCpu_socket() %></td>
		</tr>
		<tr>
			<th>コア数</th>
			<td><%=cp.getCpu_cores() %></td>
			<th>TDP</th>
			<td><%=cp.getCpu_power() %>W</td>
		</tr>
		<tr>
			<th>スレッド数</th>
			<td><%=cp.getCpu_thread() %></td>
			<th>クロック周波数</th>
			<td><%=cp.getCpu_ghz() %></td>
		</tr>
		<tr>
			<th>価格</th>
			<td><%=cp.getCpu_price() %></td>
		</tr>
	</table>
	<%
			    }
			}
		}
	if(gbdlist != null){
			for (Graphic_board gb : gbdlist) {
			        if(gb.getGraphic_name().equals(name)){
			%>
	<img src="img/<%=gb.getGraphic_img() %>" width="600" height="450">

	<h2>製品詳細</h2>

	<table>
		<tr>
			<th>搭載チップ</th>
			<td><%=gb.getGraphic_chip() %></td>
			<th>メモリ</th>
			<td><%=gb.getGraphic_memory() %></td>
		</tr>
		<tr>
			<th colspan="3">モニタ端子</th>
			<td><%=gb.getGraphic_monitor() %></td>
		</tr>
		<tr>
			<th>メーカー</th>
			<td><%=gb.getGraphic_maker() %></td>
			<th>冷却タイプ</th>
			<td><%=gb.getGraphic_cool() %></td>
		</tr>
		<tr>
			<th>クロック</th>
			<td><%=gb.getGraphic_clock() %></td>
			<th>消費電力</th>
			<td><%=gb.getGraphic_power() %>W</td>
		</tr>
		<tr>
			<th>価格</th>
			<td><%=gb.getGraphic_price() %>円</td>
		</tr>
	</table>
	<%
			    }
			}
		}
	if(mdlist != null){
			for (Memory md : mdlist) {
			        if(md.getMemory_name().equals(name)){
			%>
	<img src="img/<%=md.getMemory_img() %>" width="600" height="450">

	<h2>製品詳細</h2>

	<table>
		<tr>
			<th>メモリ容量</th>
			<td><%=md.getMemory_size() %></td>
			<th>枚数</th>
			<td><%=md.getMemory_num() %></td>
		</tr>
		<tr>
			<th>メーカー</th>
			<td><%=md.getMemory_maker() %></td>
			<th>メモリ規格</th>
			<td><%=md.getMemory_standard() %></td>
		</tr>
		<tr>
			<th>電圧</th>
			<td><%=md.getMemory_volt() %>v</td>
			<th>価格</th>
			<td><%=md.getMemory_price() %>円</td>
		</tr>
	</table>
	<%
			    }
			}
		}
	if(mbdlist != null){
			for (MotherBoard mbd : mbdlist) {
			        if(mbd.getMotherboard_name().equals(name)){
			%>
	<img src="img/<%=mbd.getMotherboard_img() %>" width="600" height="450">

	<h2>製品詳細</h2>

	<table>
		<tr>
			<th>チップセット</th>
			<td><%=mbd.getMotherboard_chipset() %></td>
			<th>ソケット</th>
			<td><%=mbd.getMotherboard_socket() %></td>
		</tr>
		<tr>
			<th>フォームファクタ</th>
			<td><%=mbd.getMotherboard_factor() %></td>
			<th>メモリスロット</th>
			<td><%=mbd.getMotherboard_memory_slot() %></td>
		</tr>
		<tr>
			<th>最大メモリ容量</th>
			<td><%=mbd.getMotherboard_memory_size() %></td>
			<th>幅ｘ奥行</th>
			<td><%=mbd.getMotherboard_width() %>x<%=mbd.getMotherboard_depth() %>mm</td>
		</tr>
		<tr>
			<th>M.2サイズ</th>
			<td><%=mbd.getMotherboard_socket() %></td>
			<th>M.2ソケット数</th>
			<td><%=mbd.getMotherboard_socket_size() %></td>
		</tr>
		<tr>
			<th>メーカー</th>
			<td><%=mbd.getMotherboard_maker() %></td>
			<th>価格</th>
			<td><%=mbd.getMotherboard_price() %>円</td>
		</tr>
	</table>
	<%
			    }
			}
		}
	if(pdlist != null){
			for (Power pd : pdlist) {
			        if(pd.getPower_name().equals(name)){
			%>
	<img src="img/<%=pd.getPower_img() %>" width="600" height="450">

	<h2>製品詳細</h2>

	<table>
		<tr>
			<th colspan="3">対応規格</th>
			<td><%=pd.getPower_socket() %></td>
		</tr>
		<tr>
			<th>電源容量</th>
			<td><%=pd.getPower_capacity() %>W</td>
			<th>プラグ対応</th>
			<td><%=pd.getPower_plug() %></td>
		</tr>
		<tr>
			<th>80PLUS認証</th>
			<td><%=pd.getPower_80plus() %></td>
			<th>サイズ(幅x高さx奥行)</th>
			<td><%=pd.getPower_width() %>x<%=pd.getPower_height() %>x<%=pd.getPower_depth() %>mm</td>
		</tr>
		<tr>
			<th>メーカー</th>
			<td><%=pd.getPower_maker() %></td>
			<th>価格</th>
			<td><%=pd.getPower_price() %>円</td>
		</tr>
	</table>
	<%
			    }
			}
		}
	if(sdlist != null){
			for (Ssd sd : sdlist) {
			        if(sd.getSsd_name().equals(name)){
			%>
	<img src="img/<%=sd.getSsd_img() %>" width="600" height="450">

	<h2>製品詳細</h2>

	<table>
		<tr>
			<th>容量</th>
			<td><%=sd.getSsd_capacity() %>GB</td>
			<th>規格サイズ</th>
			<td><%=sd.getSsd_standard() %></td>
		</tr>
		<tr>
			<th>インターフェイス</th>
			<td><%=sd.getSsd_interface() %></td>
			<th>TBW</th>
			<td><%=sd.getSsd_power() %>TBW</td>
		</tr>
		<tr>
			<th>読込速度</th>
			<td><%=sd.getSsd_load() %>MB/s</td>
			<th>書込速度</th>
			<td><%=sd.getSsd_write() %>MB/s</td>
		</tr>
		<tr>
			<th>メーカー</th>
			<td><%=sd.getSsd_maker() %></td>
			<th>価格</th>
			<td><%=sd.getSsd_price() %>円</td>
		</tr>
	</table>
	<%
			    }
			}
		}
	session.removeAttribute("detail");
%>
	<input type="button" onClick="history.back();" value="閉じる">
</body>

</html>
