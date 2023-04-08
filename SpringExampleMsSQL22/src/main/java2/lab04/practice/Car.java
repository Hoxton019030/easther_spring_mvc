package lab04.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Car implements ICar {
	@Autowired
	private Integer speed;
	@Autowired
	private Double hour;
    
	public Car() {
	}
	
	@Override
	public void getComment() {
		System.out.println("此車走了" + speed * hour + "公里");
	}

	@Override
	public Integer getSpeed() {
		return speed;
	}

	@Override
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	@Override
	public Double getHour() {
		return hour;
	}

	@Override
	public void setHour(Double hour) {
		this.hour = hour;
	}
	
}
