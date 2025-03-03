package com.example.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.bean.Category;
import com.example.dao.DAOException;
import com.example.dao.ItemDAO;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/shopping")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// アプリケーションスコープからcategories属性を取得
		@SuppressWarnings("unchecked")
		List<Category> categories = (List<Category>) getServletContext().getAttribute("categories");
		// 取得したcategories属性が登録されている場合：何もせず終了
		if (categories != null) {
			return;
		}
		
		try {
			// categoiresテーブルからすべてのカテゴリをカテゴリリストとして取得
			ItemDAO dao = new  ItemDAO();
			categories = dao.findAllCategory();
			// 取得したカテゴリリストをアプリケーションスコープに登録
			getServletContext().setAttribute("categories", categories);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServletException();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラータの文字コードを設定
		request.setCharacterEncoding("utf-8");
		// 画面遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/top.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
