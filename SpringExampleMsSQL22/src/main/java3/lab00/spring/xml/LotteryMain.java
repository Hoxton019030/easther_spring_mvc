package lab00.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LotteryMain {

	public static void main(String[] args) {
//		ILotteryService  service = new LotteryService();
//		service.setBallNumber(6);
//		service.setLowerBound(1);
//		service.setUpperBound(49);
//		System.out.println(service.getLuckyNumbers());
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/lab00/spring/Beans.xml");
		
		ILotteryService service  = context.getBean(ILotteryService.class);
		
		System.out.println(service.getLuckyNumbers());
		
	
		((ConfigurableApplicationContext)context).close();
	}
}
