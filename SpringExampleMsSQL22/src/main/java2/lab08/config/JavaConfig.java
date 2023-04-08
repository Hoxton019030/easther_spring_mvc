package lab08.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:eeit_lab04.properties")
public class JavaConfig {

	@Value("${eeit.lab08.sourceFileName}")
	String sourceFileName;
	
	@Value("${eeit.lab08.targetFileName}")
	String targetFileName;
	
	@Bean
	public File inFile() {
		File file = new File(sourceFileName);
		return file;
	}
	
	@Bean
	public File outFile() {
		File file = new File(targetFileName);
		return file;
	}
	@Bean
	public FileInputStream fis() {
		FileInputStream is = null;
		try {
			is = new FileInputStream(inFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return is;
	}
	@Bean
	public FileOutputStream fos() {
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(outFile(), true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return os;
	}
}
