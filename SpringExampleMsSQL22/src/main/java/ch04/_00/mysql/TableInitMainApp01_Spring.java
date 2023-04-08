//package ch04._00.mysql;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
///*
//      本程式單憑Spring組態檔就可以建立一個表格。
//      優點：快速、簡潔、
//      缺點：無法顯示錯誤訊息
//*/
//
//public class TableInitMainApp01_Spring {
//	public static void main(String[] args) {
//
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"ch04/mysql/_00/Beans_MySQL.xml");
//		// 沒有其它的程式碼，但是可以Drop與Create Table，關鍵就在組態檔
//		Object obj =context.getBean("exec0");
//		System.out.println("新建表格成功(MySQL)");
//        ((ConfigurableApplicationContext)context).close();       		
//	}
//
//}
