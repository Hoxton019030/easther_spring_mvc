package lab09;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {
	@Bean
	@Scope("singleton")
    public String now() {
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒 SSS毫秒" );
		sdf.setLenient(false);
		Date d = new Date();
		//System.out.println("JavaConfig, 現在時間: " + d);
		return sdf.format(d);
	} 
}
