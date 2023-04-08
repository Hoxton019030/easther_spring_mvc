package lab07.solution;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("lab07_eeit61.properties")
public class JavaConfig {

	@Value("${lab07.radius}")
	Double radius;

	@Bean
	public Circle circle() {
		Circle circle = new Circle();
		circle.setRadius(radius);
		return circle;
	}

}
