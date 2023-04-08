package com.web.store.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class RootAppConfig {
	
	@Value("${jdbc.initPoolSize}")
	int initialPoolSize;
	@Value("${jdbc.maxPoolSize}")
	int maxPoolSize;
	
	Environment env;
	
	@Autowired
	public RootAppConfig(Environment env) {
		this.env=env;
	}
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setUser(env.getProperty("jdbc.user"));
		ds.setPassword(env.getProperty("jdbc.password"));
		ds.setJdbcUrl(env.getProperty("jdbc.jdbcUrl"));
		ds.setInitialPoolSize(initialPoolSize);
		ds.setMaxPoolSize(maxPoolSize);
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory () {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.web.store.model");//放要掃描的永續類別套件
		factory.setHibernateProperties(addtionalProperties());
		return factory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory factory) {
	HibernateTransactionManager tx = new HibernateTransactionManager();
	 tx.setSessionFactory(factory);
	 return tx;
	}    
	
	
	
	private Properties addtionalProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", org.hibernate.dialect.SQLServer2016Dialect.class);
		properties.put("hibernate.show_sql", Boolean.TRUE);
		properties.put("hibernate.format_sql", Boolean.TRUE);
		properties.put("default_batch_fetch_size", 10);
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

}
