package sample.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの文字コード設定
		request.setCharacterEncoding("utf-8");
		// actionパラメータを取得
		String action = request.getParameter("action");
		// 取得したactionパラメータによる処理の分岐
		if (action == null || action.isEmpty()) {
			response.getWriter().append("Served at: ").append(request.getContextPath());
		} else {
			String nextURL = "";
			if ("app".equals(action)) {
				nextURL = "/hello.jsp";
			} else if ("sample".equals(action)) {
				List<String> seasons = (List<String>) Arrays.asList("春", "夏", "秋" ,"冬");
				request.setAttribute("seasons", seasons);
				nextURL = "/WEB-INF/view/sample/sample.jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextURL);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
