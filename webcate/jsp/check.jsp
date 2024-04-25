<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Box" %>
<%ArrayList<Box> bdlist = (ArrayList<Box>) session.getAttribute("boxlist");%>
<%@page import="model.Cooler" %>
<%ArrayList<Cooler> cldlist = (ArrayList<Cooler>) session.getAttribute("coolerlist");%>
<%@page import="model.Cpu" %>
<%ArrayList<Cpu> cdlist = (ArrayList<Cpu>) session.getAttribute("cpulist");%>
<%@page import="model.Graphic_board" %>
<%ArrayList<Graphic_board> gbdlist = (ArrayList<Graphic_board>) session.getAttribute("graphiclist");%>
<%@page import="model.Memory" %>
<%ArrayList<Memory> mdlist = (ArrayList<Memory>) session.getAttribute("memorylist");%>
<%@page import="model.MotherBoard" %>
<%ArrayList<MotherBoard> mbdlist = (ArrayList<MotherBoard>) session.getAttribute("motherboardlist");%>
<%@page import="model.Power" %>
<%ArrayList<Power> pdlist = (ArrayList<Power>) session.getAttribute("powerlist");%>
<%@page import="model.Ssd" %>
<%ArrayList<Ssd> sdlist = (ArrayList<Ssd>) session.getAttribute("ssdlist");%>
<%
int box_power = 0;
String box_mother = "";
int box_graphic = 0;
String cpu_socket = "";
String motherboard_socket = "";
int power_height = 0;
int graphic_width = 0;
String memory_standard = "";

for(Box bd : bdlist){
    box_power = bd.getBox_power();
    box_mother = bd.getBox_mother();
    box_graphic = bd.getBox_graphic();
}

for(Cpu cd : cdlist){
    cpu_socket = cd.getCpu_socket();
}

for(MotherBoard mbd : mbdlist){
    motherboard_socket = mbd.getMotherboard_socket();
    // motherboard_factor の処理も必要ならここで行う
}

for(Power pd : pdlist){
    power_height = pd.getPower_height();
}

for(Graphic_board gbd : gbdlist){
    graphic_width = gbd.getGraphic_width();
}

for(Memory md : mdlist){
    memory_standard = md.getMemory_standard();
}
%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/check.css" rel="stylesheet" type ="text/css">
    <title>Judgement</title>
</head>
<body>
    <header>
        <h1 style="width:80%; border-bottom:2px solid black;">PC見積もり互換性チェック</h1>
    </header>
    <main>
        <div class="main_guide">
            <table rules="all">
                <td><a href="check.jsp">互換性チェック</a></td>
                <td><a href="check_guide.jsp">互換性チェックガイド</a></td>
            </table>
        </div>

        <ul>
            <li>互換性チェックは、CPU、マザーボード、メモリ、ケース、グラッフィックカード、電源を対象としています。</li>
            <li>本サービスはメーカーの商品情報に基づいて提供され、一部の商品については互換性チェックの対象から除外されます。</li>
            <li><font color="red">互換性があるかどうかは単純な参考用であり、詳細については販売店またはメーカーに再確認が必要な場合があります。</font></li>
        </ul>

		<%
        if(cpu_socket != null){
            if(motherboard_socket != null){
                if(cpu_socket.equals(motherboard_socket)){
        %>
        
        <div class="check_result">
            <table rules="all">
                <tr>
                    <td rowspan="2"><font color="lightgreen">〇互換性あり</font></td>
                    <td>マザーボード</td>
                    <td rowspan="2">互換性問題ありません。</td>
                </tr>
                <tr>
                    <td>CPU</td>
                </tr>
            </table>
        </div>
        <%
                }else{
        %>
        <div class="check_result">
            <table rules="all">
                <tr>
                    <td rowspan="2"><font color="red">X互換性なし</font></td>
                    <td>マザーボード</td>
                    <td rowspan="2">マザーボード(<%=motherboard_socket %>)とメモリ(<%=cpu_socket %>)は互換性がありません。</td>
                </tr>
                <tr>
                    <td>CPU</td>
                </tr>
            </table>
        </div>
        <%
                }
            }
        }
        if(cpu_socket != null){
            if(memory_standard != null){
                if(memory_standard == "DDR4"){
                	if(!(cpu_socket.equals("LGA1151") || cpu_socket.equals("LGA1200") || cpu_socket.equals("AM4"))) {
        %>
        <div class="check_result">
            <table rules="all">
                <tr>
                    <td rowspan="2"><font color="lightgreen">〇互換性あり</font></td>
                    <td>メモリ</td>
                    <td rowspan="2">互換性問題ありません。</td>
                </tr>
                <tr>
                    <td>CPU</td>
                </tr>
            </table>
        </div>
        <%
                }else{
        %>
        <div class="check_result">
            <table rules="all">
                <tr>
                    <td rowspan="2"><font color="red">X互換性なし</font></td>
                    <td>メモリ</td>
                    <td rowspan="2">メモリ(<%=memory_standard %>)とCPU(<%=cpu_socket %>)は互換性がありません。</td>
                </tr>
                <tr>
                    <td>CPU</td>
                </tr>
            </table>
        </div>
        <%
                	}
                }
            }
        }
        if(cpu_socket != null){
            if(memory_standard != null){
                if(memory_standard == "DDR5"){
                	if (cpu_socket.equals("LGA4677") || cpu_socket.equals("LGA1700") || cpu_socket.equals("AM5")) {
        %>
        <div class="check_result">
            <table rules="all">
                <tr>
                    <td rowspan="2"><font color="lightgreen">〇互換性あり</font></td>
                    <td>メモリ</td>
                    <td rowspan="2">互換性問題ありません。</td>
                </tr>
                <tr>
                    <td>CPU</td>
                </tr>
            </table>
        </div>
        <%
                }else{
        %>
        <div class="check_result">
            <table rules="all">
                <tr>
                    <td rowspan="2"><font color="red">X互換性なし</font></td>
                    <td>メモリ</td>
                    <td rowspan="2">メモリ(<%=memory_standard %>)とCPU(<%=cpu_socket %>)は互換性がありません。</td>
                </tr>
                <tr>
                    <td>CPU</td>
                </tr>
            </table>
        </div>
        <%
                	}
                }
            }
        }
        if(box_power != 0){
            if(power_height != 0){
                if(box_power >= power_height){
        %>
        
        <div class="check_result">
            <table rules="all">
                <tr>
                    <td rowspan="2"><font color="lightgreen">〇互換性あり</font></td>
                    <td>ケース</td>
                    <td rowspan="2">サイズに問題ありません。</td>
                </tr>
                <tr>
                    <td>電源</td>
                </tr>
            </table>
        </div>
        <%
                }else{
        %>
        <div class="check_result">
            <table rules="all">
                <tr>
                    <td rowspan="2"><font color="red">X互換性なし</font></td>
                    <td>ケース</td>
                    <td rowspan="2">マザーボードとメモリはサイズに問題があります。</td>
                </tr>
                <tr>
                    <td>電源</td>
                </tr>
            </table>
        </div>
        <%
                }
            }
        }
        if(box_graphic != 0){
            if(graphic_width != 0){
                if(box_graphic >= graphic_width){
        %>
        
        <div class="check_result">
            <table rules="all">
                <tr>
                    <td rowspan="2"><font color="lightgreen">〇互換性あり</font></td>
                    <td>ケース</td>
                    <td rowspan="2">サイズに問題ありません。</td>
                </tr>
                <tr>
                    <td>グラフィックボード</td>
                </tr>
            </table>
        </div>
        <%
                }else{
        %>
        <div class="check_result">
            <table rules="all">
                <tr>
                    <td rowspan="2"><font color="red">X互換性なし</font></td>
                    <td>ケース</td>
                    <td rowspan="2">マザーボードとメモリはサイズに問題があります。</td>
                </tr>
                <tr>
                    <td>グラフィックボード</td>
                </tr>
            </table>
        </div>
        <%
                }
            }
        }
        %>
        
    </main>
    
</body>
</html>