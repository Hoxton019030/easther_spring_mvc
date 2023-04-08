package lab02.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import lab02.model.ClassEntity;
import lab02.model.StudentEntity;
import lab02.service.StudentEntityService;

@WebServlet("/lab02/initData.do")
public class InitDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext  webApplicationContext = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		StudentEntityService stduentuctService = 
				webApplicationContext.getBean(StudentEntityService.class);
		
		
		try {
			ClassEntity class1 = new ClassEntity("EEIT52", "Java全方位程式設計班");
			ClassEntity class2 = new ClassEntity("AIIT40", "人工智慧程式設計班");
			ClassEntity class3 = new ClassEntity("WEBA42", "前端網頁設計班");
			
			StudentEntity stduent1 = new StudentEntity();
			stduent1.setName("張鈞雅");
			stduent1.setScore(80);
			stduent1.setClassEntity(class1);
			stduentuctService.save(stduent1);

			StudentEntity stduent2 = new StudentEntity();
			stduent2.setName("林筱珍");
			stduent2.setScore(12);
			stduent2.setClassEntity(class1);
			stduentuctService.save(stduent2);
			
			StudentEntity stduent3 = new StudentEntity();
			stduent3.setName("穆拉拉");
			stduent3.setScore(75);
			stduent3.setClassEntity(class1);
			stduentuctService.save(stduent3);
			
			StudentEntity stduent4 = new StudentEntity();
			stduent4.setName("吳柏毅");
			stduent4.setScore(92);
			stduent4.setClassEntity(class2);
			stduentuctService.save(stduent4);

			StudentEntity stduent5 = new StudentEntity();
			stduent5.setName("魏護名");
			stduent5.setScore(63);
			stduent5.setClassEntity(class2);
			stduentuctService.save(stduent5);
			
			StudentEntity stduent6 = new StudentEntity();
			stduent6.setName("王登華");
			stduent6.setScore(74);
			stduent6.setClassEntity(class2);
			stduentuctService.save(stduent6);
			
			StudentEntity stduent7 = new StudentEntity();
			stduent7.setName("郭羽名");
			stduent7.setScore(73);
			stduent7.setClassEntity(class2);
			stduentuctService.save(stduent7);
			
			StudentEntity stduent8 = new StudentEntity();
			stduent8.setName("劉進益");
			stduent8.setScore(76);
			stduent8.setClassEntity(class3);
			stduentuctService.save(stduent8);
			
			HttpSession session = request.getSession();
			session.setAttribute("SUCCESS", "資料新增成功");
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("FAIL", "資料新增失敗，原因:" + e.getMessage());
			rd.forward(request, response);
			return;
		}
	}
}
