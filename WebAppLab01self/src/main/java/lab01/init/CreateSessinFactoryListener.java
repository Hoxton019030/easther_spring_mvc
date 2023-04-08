//package lab01.init;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//import lab01.utils.HibernateUtils;
//
///**
// * Application Lifecycle Listener implementation class CreateSessinFactoryListener
// *
// */
//@WebListener
//public class CreateSessinFactoryListener implements ServletContextListener {
//
//
//    public CreateSessinFactoryListener() {
//
//    }
//
//
//    public void contextDestroyed(ServletContextEvent sce)  { 
//    	HibernateUtils.getSessionFactory().close();
//    }
//
//
//    public void contextInitialized(ServletContextEvent sce)  { 
//    	HibernateUtils.getSessionFactory();
//    }
//	
//}
