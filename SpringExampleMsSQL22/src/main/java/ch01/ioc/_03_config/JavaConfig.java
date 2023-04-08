package ch01.ioc._03_config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch01.ioc._03_config.model.impl.Cat;
import ch01.ioc._03_config.model.impl.Dog;
import ch01.ioc._03_config.model.impl.Master;

@Configuration
public class JavaConfig {
	
	@Value("${cat}")
	String catname;
    @Bean //<bean id='方法名稱' class='傳回值的型態'>
//    @Scope("singleton")
    public Cat cat() {
    	return new Cat("catname");
    }
    @Bean
    public Dog dog() {
    	return new Dog("高飛狗(Spring.config)");
    }
    @Bean
    public Master master() {
    	return new Master(dog());
    }
}
