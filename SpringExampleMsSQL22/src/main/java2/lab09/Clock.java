package lab09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("clock_lab09")
@Scope("singleton")
public class Clock {
    
	private String timeNow;

	@Autowired
	public void setTimeNow(String timeNow) {
		this.timeNow = timeNow;
	}

	@Override
	public String toString() {
		return "現在時間: " + timeNow + ", hashCode=" + hashCode();
	}
	
}
