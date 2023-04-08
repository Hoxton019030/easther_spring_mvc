package lab06.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lab06.config.bean.ICat;

public class CarMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		ctx.scan("lab06.config.bean");
		ICar car1 = ctx.getBean(ICar.class);
		ICat cat = ctx.getBean(ICat.class);
		car1.getComment();
		System.out.println("--------------");
		cat.hello();
		ctx.close();
	}
}