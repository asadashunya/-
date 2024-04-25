package Judgment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Alldelete")
public class Alldelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // gcpcartListとpriceListを削除
        session.removeAttribute("gcpcartList");
        session.removeAttribute("pcpList");
        session.removeAttribute("gcocartList");
        session.removeAttribute("pcoList");
        session.removeAttribute("gboxcartList");
        session.removeAttribute("pboxList");
        session.removeAttribute("ggraphiccartList");
        session.removeAttribute("pgraphicList");
        session.removeAttribute("gmcartList");
        session.removeAttribute("pmList");
        session.removeAttribute("gmbcartList");
        session.removeAttribute("pmbList");
        session.removeAttribute("gpocartList");
        session.removeAttribute("ppoList");
        session.removeAttribute("gssdcartList");
        session.removeAttribute("pssdList");
        // MitumoriCpuにリダイレクト
        response.sendRedirect("MitumoriCpu");
    }
}