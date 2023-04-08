package lab02.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/lab02/ex01/queryAllClassEntities.do")
              
public class QueryAllClassEntityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext  webApplicationContext = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ClassEntityService classEntityService = 
				webApplicationContext.getBean(ClassEntityService.class);
		
		List<ClassEntity> classEntities = classEntityService.findAll();
		request.setAttribute("classEntities", classEntities);
		RequestDispatcher rd = request.getRequestDispatcher("/lab02/ex01/showClasses.jsp");
		rd.forward(request, response);
		return;
	}

}
