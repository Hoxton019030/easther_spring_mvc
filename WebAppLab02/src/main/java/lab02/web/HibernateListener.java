package lab02.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import lab02.utils.HibernateUtils;

@WebListener
public class HibernateListener implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtils.close();
	}

	public void contextInitialized(ServletContextEvent arg0) {
		new HibernateUtils();
	}
}