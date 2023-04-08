package lab05.solution;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements ICircle {

	@Value("${lab05.solution.radius}")
	public double radius;

	public Circle() {
	}

	@Override
	public double getRadius() {
		return radius;
	}

	@Override
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}
}