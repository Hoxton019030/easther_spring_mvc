package lab08.solution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("lab08_eeit61.properties")
public class JavaConfig {
	
	@Value("${lab08.infilename}")
	String inFileName;
	@Value("${lab08.outfilename}")
	String outFileName;
	
	@Bean 
	public File inFile() {
		File f  = new File(inFileName);
		return f;
	}
	
	
	@Bean 
	public File outFile() {
		File f  = new File(outFileName);
		return f;
		
	}
	
	@Bean 
	public FileInputStream fis() throws FileNotFoundException {
		 FileInputStream is  = new FileInputStream(inFile());
		return is;
		
	}
	
	@Bean 
	public FileOutputStream fos() throws FileNotFoundException {
		 FileOutputStream os  = new FileOutputStream(outFile());
		return os;
		
	}
	
	
}
