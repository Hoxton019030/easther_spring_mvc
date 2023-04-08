package lab05.anno;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")   // 單例
@PropertySource("lab05.properties")
public class Circle implements ICircle{
	@Value("${eeit.lab05.radius}")
	public double radius;

	public Circle() {
	}

	@Override
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@PostConstruct
	public void init() {
		//...
	}
	@PreDestroy
	public void destroy() {
		//...
	}
	
	
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}
}