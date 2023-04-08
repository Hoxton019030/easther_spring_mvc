package lab05.solution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
	改寫lab02，但以註釋的方式來定義Bean元件。
        請將相關的程式與組態檔寫在套件lab07.anno之下。
        改寫步驟 : 請參考Lab02與Lab05

 */
public class CircleMain {
    public static void main(String args[]) {
//       	ICircle c = new Circle();
//       	c.setRadius(10);
//       	System.out.println("半徑為" + c.getRadius() + "之圓的面積為: " + c.getArea());
    	
    	ApplicationContext ctx = new  ClassPathXmlApplicationContext("lab05/solution/Beans.xml");
    	
    	ICircle circle = ctx.getBean(ICircle.class);
    	System.out.println("半徑為: "+circle.getRadius()+"此圓面積為: "+circle.getArea());
    	
    	((ConfigurableApplicationContext)ctx).close();
    	
    	
    	
    	
    	
    }
}
