package ch05.ex02;

import java.io.IOException;

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
  
// 本控制器使用的Service元件為ch05.ex00.service.MemberService.java

@WebServlet("/ch05/ex02/FindMemberServlet")
public class FindMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sid = request.getParameter("id");
		Long id = Long.parseLong(sid);
		// 本控制器使用的Dao元件為ch05.ex01.model.MemberDaoJdbcTemplate.java
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		MemberService service = (MemberService)context.getBean("memberServiceInMemory");
		Member member = service.findById(id);
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("/ch05/ex02/updateMember.jsp");
		rd.forward(request, response);
		return;
	}
}
