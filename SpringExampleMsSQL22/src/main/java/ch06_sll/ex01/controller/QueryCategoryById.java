package ch06_sll.ex01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch06_sll.ex01.model.Category;
import ch06_sll.ex01.service.CategoryService;
import ch06_sll.ex01.service.impl.CategoryServiceImpl;

@WebServlet("/ch06_sll/ex01/queryCategoryByIdS.do")
public class QueryCategoryById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CategoryService categoryService ;
	
	public QueryCategoryById() {
		this.categoryService = new CategoryServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("catId");
		int id = -1;
		try {
			id = Integer.parseInt(sid);
		} catch(Exception e) {
			e.printStackTrace();
		}
		Category category = categoryService.findById(id);
		request.setAttribute("category", category);
		RequestDispatcher rd= request.getRequestDispatcher("/ch06_sll/ex01/showProductsByCategoryS.jsp");
		rd.forward(request, response);
		return;
	}
}
