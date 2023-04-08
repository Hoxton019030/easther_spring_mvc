package lab06.config.bean;

import org.springframework.stereotype.Component;

@Component
public class Cat implements ICat {

	public Cat() {
		super();
	}
	@Override
	public void hello() {
		System.out.println("Hello");
	}
}
