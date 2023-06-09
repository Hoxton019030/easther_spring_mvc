﻿package ch06.ex01.controller;
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


@WebServlet("/ch06/ex01/register0601.do")
public class RegisterController0601 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	request.setCharacterEncoding("UTF-8");
		// 準備存放錯誤訊息的 List 物件
		Map<String, String> errorMsg = new HashMap<>();
        request.setAttribute("error", errorMsg); 
		// 1. 讀取使用者輸入資料
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("pswd");
		String name = request.getParameter("userName");
		String eMail = request.getParameter("eMail");
		String birthday = request.getParameter("birthday");
		String expericnceStr = request.getParameter("experience");
		// 2. 進行必要的資料轉換
		int experience = 0;
		try {
			experience = Integer.parseInt(expericnceStr.trim());
		} catch (NumberFormatException e) {
			errorMsg.put("experience", "使用Java經驗格式錯誤，應該為整數");
		}
		// 3. 檢查使用者輸入資料
		if (memberId == null || memberId.trim().length() == 0) {
			errorMsg.put("memberId","帳號欄必須輸入");
		}
		if (password == null || password.trim().length() == 0) {
			errorMsg.put("pswd","密碼欄必須輸入");
		}
		if (name == null || name.trim().length() == 0) {
			errorMsg.put("userName", "姓名欄必須輸入");
		}
		if (eMail == null || eMail.trim().length() == 0) {
			errorMsg.put("eMail", "EMail欄必須輸入");
		}
		Timestamp ts = new Timestamp(System.currentTimeMillis());
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
		if (experience < 0) {
			errorMsg.put("experience", "使用Java經驗應該為正整數或 0 ");
		}
		
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/ch06/ex01/ch06_ex01_form.jsp");
			rd.forward(request, response);
			return;
		}
		// 4. 進行 Business Logic 運算
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		Member member = null;
		MemberService service = (MemberService)context.getBean("memberServiceHibernate");
        if (service.existsByMemberId(memberId)) {
			errorMsg.put("memberId", "該代號 (" +  memberId  + ") 已經存在，請換新的代號");
		} else {
			try {
				member = new Member(null, memberId, password, name, eMail, bday, ts, experience);
				service.save(member);
			} catch (Exception e) {
				errorMsg.put("memberId", "儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
				e.printStackTrace();
			}
		}
		// 5.依照 Business Logic 運算結果來挑選適當的畫面
        HttpSession session = request.getSession();
        session.setAttribute("member", member);
		if (errorMsg.isEmpty())	{			
			response.sendRedirect(request.getContextPath() + "/ch06/ex01/success.jsp");
			return ; 
		}  else {
			RequestDispatcher rd = request.getRequestDispatcher("/ch06/ex01/ch06_ex01_form.jsp");
			rd.forward(request, response);
			return;
		}
     }
}   