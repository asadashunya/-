package Judgment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoxDao;
import dao.CoolerDao;
import dao.CpuDao;
import dao.Graphic_boardDao;
import dao.MemoryDao;
import dao.MotherBoardDao;
import dao.PowerDao;
import dao.SsdDao;
import model.Box;
import model.Cooler;
import model.Cpu;
import model.Graphic_board;
import model.Memory;
import model.MotherBoard;
import model.Power;
import model.Ssd;

/**
 * Servlet implementation class Compatibility
 */
@WebServlet("/Compatibility")
public class Compatibility extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		// 各hiddenフィールドの値を受け取り、その名前の機能をすべて取得
		CpuDao cd = new CpuDao();
        ArrayList<Cpu> cdlist;
		String sCpu = request.getParameter("sCpu");
		cdlist = cd.findPerCpuByName(sCpu);
		session.setAttribute("cpulist", cdlist);
		
		CoolerDao cld = new CoolerDao();
        ArrayList<Cooler> cldlist;
		String sCoo = request.getParameter("sCoo");
		cldlist = cld.findPerCoolerByName(sCoo);
		session.setAttribute("coolerlist", cldlist);
		
		MotherBoardDao mbd = new MotherBoardDao();
        ArrayList<MotherBoard> mbdlist;
		String sMob = request.getParameter("sMob");
		mbdlist = mbd.findPerMotherBoardByName(sMob);
		session.setAttribute("motherboardlist", mbdlist);
		
		MemoryDao md = new MemoryDao();
        ArrayList<Memory> mdlist;
		String sMem = request.getParameter("sMem");
		mdlist = md.findPerMemoryByName(sMem);
		session.setAttribute("memorylist", mdlist);
		
		Graphic_boardDao gbd = new Graphic_boardDao();
        ArrayList<Graphic_board> gbdlist;
		String sGra = request.getParameter("sGra");
		gbdlist = gbd.findPerGraphic_boardByName(sGra);
		session.setAttribute("graphiclist", gbdlist);
		
		SsdDao sd = new SsdDao();
        ArrayList<Ssd> sdlist;
		String sSsd = request.getParameter("sSsd");
		sdlist = sd.findPerSsdByName(sSsd);
		session.setAttribute("ssdlist", sdlist);
		
		BoxDao bd = new BoxDao();
		ArrayList<Box> bdlist;
		String sBox = request.getParameter("sBox");
		bdlist = bd.findPerBoxByName(sBox);
		session.setAttribute("boxlist", bdlist);
		
		PowerDao pd = new PowerDao();
        ArrayList<Power> pdlist;
		String sPow = request.getParameter("sPow");
		pdlist = pd.findPerPowerByName(sPow);
		session.setAttribute("powerlist", pdlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("check.jsp");
		rd.forward(request, response);

	}
}
