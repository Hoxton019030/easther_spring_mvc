package ch06.ex02;

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
/*  
 * 本程式經由Hibernate來存取資料庫
 */
@WebServlet("/ch06/ex02/FindMemberServlet")
public class FindMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sid = request.getParameter("id");
		Long id = Long.parseLong(sid);
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		MemberService service = context.getBean("memberServiceHibernate", MemberService.class);
		Member member = service.findById(id);
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("/ch06/ex02/updateMember.jsp");
		rd.forward(request, response);
		return;
	}
}
