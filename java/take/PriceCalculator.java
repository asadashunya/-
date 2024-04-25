package take;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class PriceCalculator
 */
@WebServlet("/PriceCalculator")
public class PriceCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public int getPrice(String item) {
		if(item != null) {
			return 0;
		}else {
		    int price = 0;
		    // キーボードやマウスに対応する価格をデータベースや価格リストから取得するコードをここに追加する
		    // ここでは簡略化のために固定の価格を返す例を示します
		    if (item.equals("ELECOM 有線フルキーボード")) {
		        price = 5000; // キーボードの価格を設定する
		    } else if (item.equals("ELECOM 洗える 抗菌 有線キーボード")) {
		        price = 3000; // マウスの価格を設定する
		    } else if (item.equals("ELECOM 有線メカニカルテンキーレスキーボード")) {
				price = 4000;
		    } else if (item.equals("logicool PRO キーボード")) {
				price = 2000;
		    } else if (item.equals("logicool G713")) {
				price = 7000;
		    } else if (item.equals("logicool PRO X TKL")) {
				price = 3000;
		    } else if (item.equals("ELECOM 抗菌 有線 静音 BlueLEDマウス (5ボタン)")) {
				price = 8000;
		    } else if (item.equals("ELECOM 有線レーザーマウス(5ボタン・チルトホイール)")) {
				price = 6000;
		    } else if (item.equals("ELECOM 5ボタンBlueLED有線マウス")) {
				price = 4500;
		    } else if (item.equals("logicool PRO")) {
				price = 3000;
		    } else if (item.equals("logicool PRO X マウス")) {
				price = 5600;
		    } else if (item.equals("logicool PRO X SUPERLIGHT2")) {
				price = 7200;
		    } 
		    
		    return price;
		}
		}
	}