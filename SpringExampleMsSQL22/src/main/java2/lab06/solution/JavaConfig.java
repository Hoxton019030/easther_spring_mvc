package lab06.solution;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("lab06_eeit61.properties")
public class JavaConfig {
	
	@Value("${lab06_eeit61.speed}")
	Integer speed;
	@Value("${lab06_eeit61.hour}")
	Double hour; 
	@Bean
	public Car car() {
		Car c = new Car();
		c.setSpeed(speed);
		c.setHour(hour);
		return c;
	}

	

}
