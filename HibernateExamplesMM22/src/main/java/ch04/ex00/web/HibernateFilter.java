//package ch04.ex00.web;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//import ch00.HibernateUtils;
//
////@WebFilter(urlPatterns = { "/ch04/ex03/*", "/ch04/ex04/*" })
//public class HibernateFilter implements Filter {
//	@SuppressWarnings("unused")
//	private FilterConfig fConfig;
//	private SessionFactory factory;
//
//	public void init(FilterConfig fConfig) throws ServletException {
//		this.fConfig = fConfig;
//		factory = HibernateUtils.getSessionFactory();
//		System.out.println("HibernateFilter已經載入...");
//	}
//
//	public void destroy() {
//		factory.close();
//	}
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		System.out.println("==== HibernateFilter 開始監控 ====");
//		Transaction tx = null;
//		try {
//			Session session = factory.getCurrentSession();
//			tx = session.beginTransaction();
//			System.out.println("HibernateFilter 即將執行監控對象");
//			// 下一敘述會啟動控制器(Servlet), DAO, 視圖(JSP)，這些程式執行時Session都保持在開啟狀態
//			chain.doFilter(request, response);
//			System.out.println("HibernateFilter 由監控的對象返回，準備執行tx.commit()");
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		}
//		System.out.println("==== HibernateFilter 結束監控 ====");
//	}
//
//}
