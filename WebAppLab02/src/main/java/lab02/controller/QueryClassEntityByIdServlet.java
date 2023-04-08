package lab02.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import lab02.model.ClassEntity;
import lab02.service.ClassEntityService;

@WebServlet("/lab02/ex01/queryClassEntityById.do")
public class QueryClassEntityByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext  webApplicationContext = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ClassEntityService classEntityService = 
				webApplicationContext.getBean(ClassEntityService.class);
		
		String sid = request.getParameter("catId");
		int id = -1;
		try {
			id = Integer.parseInt(sid);
		} catch(Exception e) {
			e.printStackTrace();
		}
		ClassEntity classEntity = classEntityService.findById(id);
		request.setAttribute("classEntity", classEntity);
		RequestDispatcher rd= request.getRequestDispatcher("/lab02/ex01/showStudentsByClassEntity.jsp");
		rd.forward(request, response);
		return;
	}
}
