package ch05.ex00.listener;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ch05.ex00.entity.Member;

@WebListener
public class CreateInMemoryMembersListener implements ServletContextListener {

	//Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("globalService", new GlobalService());
		
		Member m1 = new Member(101L, "kitty101", "Do!ng123", "貓凱蒂", 
				"catkitty_2023@outlook.com", 
				Date.valueOf("1990-5-1"), Timestamp.valueOf("2020-12-25 17:48:12") , 1);
		
		Member m2 = new Member(237L, "mickey230", "m!ck3YAbC", "米小薯",	"mickey230230@gmail.com", 
				Date.valueOf("1999-12-18"), Timestamp.valueOf("2020-10-17 10:18:10") , 3);
		
		Member m3 = new Member(400L, "garfield997", "poInt8523", "賈非貓", 
				"garfield997@outlook.com", 
				Date.valueOf("2021-3-10"), Timestamp.valueOf("2019-2-9 5:9:30") , 1);
        
		List<Member> members = 
				new ArrayList<>(Arrays.asList(m1, m2, m3));
		GlobalService.setMembers(members);
//		GlobalService.getMembers().add(m1);
//		GlobalService.getMembers().add(m2);
//		GlobalService.getMembers().add(m3);
		//logger.info(GlobalService.getMembers().toString());
		System.out.println("====================================" + GlobalService.getMembers().toString());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		

	}

}
