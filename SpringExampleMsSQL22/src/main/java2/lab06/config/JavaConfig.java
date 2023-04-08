package lab06.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/eeit_lab04.properties")
public class JavaConfig {

	@Value("${eeit.lab06.speed}")
	Integer speed ;
	
	@Value("${eeit.lab06.hour}")
	Double hour ;
	
	@Bean
	public Car car() {
		Car c = new Car();
		c.setSpeed(speed);
		c.setHour(hour);
		return c;
	}

}
