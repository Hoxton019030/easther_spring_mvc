package ch05.ex02;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ch05.ex00.entity.Member;
import ch05.ex00.service.MemberService;

@WebServlet("/ch05/ex02/updateMember.do")
public class UpdateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession hsession = request.getSession();
		Map<String, String>  errorMsg = new HashMap<>();
		hsession.setAttribute("error", errorMsg);
		String modify = request.getParameter("finalDecision");
		String sid = request.getParameter("id");
		Long id = Long.parseLong(sid);
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		MemberService service = (MemberService)context.getBean("memberServiceInMemory");
//		int count = 0 ;
		
		if (modify.equalsIgnoreCase("DELETE")) {
			try {
				service.deleteById(id);
				hsession.setAttribute("modify", "刪除成功");
			} catch(Exception ex) {
				ex.printStackTrace();
				hsession.setAttribute("modify", "刪除時發生異常");
			}
		} else if (modify.equalsIgnoreCase("UPDATE")) {
			
			String memberId = request.getParameter("memberId");
			String password = request.getParameter("password");
			String name = request.getParameter("userName");
			String mail = request.getParameter("eMail");
			String birthday = request.getParameter("birthday");
			String expericnceStr = request.getParameter("experience");
			String registerDate = request.getParameter("registerDate");
			
			// 2. 進行必要的資料轉換
			int experience = 0;
			try {
				experience = Integer.parseInt(expericnceStr.trim());
			} catch (NumberFormatException e) {
				errorMsg.put("experience", "使用Java經驗格式錯誤，應該為整數");
			}
			if (password == null || password.trim().length() == 0) {
				errorMsg.put("password", "密碼欄必須輸入");
			}
			if (name == null || name.trim().length() == 0) {
				errorMsg.put("userName", "姓名欄必須輸入");
			}
			if (mail == null || mail.trim().length() == 0) {
				errorMsg.put("eMail", "EMail欄必須輸入");
			}
			java.sql.Date bday = null; 
			if (birthday == null || birthday.trim().length() == 0) {
				errorMsg.put("birthday","生日欄必須輸入");
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.setLenient(false);
				try {
					bday = new java.sql.Date(sdf.parse(birthday.trim()).getTime());
				} catch(Exception ex){
					errorMsg.put("birthday","生日欄格式錯誤");
				}
			}
			Timestamp ts = Timestamp.valueOf(registerDate);
			if (experience < 0) {
				errorMsg.put("experience", "使用Java經驗應該為正整數或 0 ");
			}
			if (experience > 99) {
				errorMsg.put("experience", "使用Java經驗不應該超過99");
			}
			System.out.println("password:" + password);
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("/ch05/ex02/updateMember.jsp");
				rd.forward(request, response);
				return;
			}
			
			Member m = new Member(id, memberId, password, name, mail, bday, ts, experience);
			try {
				service.update(m);
				hsession.setAttribute("modify", "修改成功");
			} catch(Exception ex) {
				hsession.setAttribute("modify", "修改時發生異常");
			}
		} 		
		response.sendRedirect(request.getContextPath() + "/ch05/ex02/queryAllMembers.do");
	}
}
