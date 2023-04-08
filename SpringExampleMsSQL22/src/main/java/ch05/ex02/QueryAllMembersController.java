package ch05.ex02;

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

import ch05.ex00.entity.Member;
import ch05.ex00.service.MemberService;

// 本控制器使用的Dao元件為ch05.ex01.model.MemberDaoJdbcTemplate.java
@WebServlet("/ch05/ex02/queryAllMembers.do")
public class QueryAllMembersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		MemberService service = (MemberService)context.getBean("memberServiceInMemory");
		List<Member> members = service.findAll();
		
		System.out.println("members=" + members);
		
		request.setAttribute("AllMembers", members);
		RequestDispatcher rd = request
				.getRequestDispatcher("/ch05/ex02/showAllMembers.jsp");
		rd.forward(request, response);
		return;
	}
}
