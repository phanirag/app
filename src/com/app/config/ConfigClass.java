package com.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.app")
public class ConfigClass extends WebMvcConfigurerAdapter {
	
	//${internalVR.properties}
    @Value("${view.location}")     							private String location;
    @Value("${view.extention}")     						private String extention;

	//${jdbc.driverClassName}
    @Value("${jdbc.driver}")     							private String driverClassName;
    @Value("${jdbc.url}")               					private String url;
    @Value("${jdbc.name}")             						private String user;
    @Value("${jdbc.pass}")             						private String pass;

    //${hibernate.properties}
    @Value("${hibernate.dialect}")      					private String hibernateDialect;
    @Value("${hibernate.show_sql}")   					  	private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}") 					private String hibernateHbm2ddlAuto;
    @Value("${hibernate.format_sql}")						private String hibernateformatsql;
    @Value("${hibernate.validator.apply_to_ddl}")			private String validatorapplytoddl;
    @Value("${hibernate.validator.autoregister_listeners}")	private String autoregisterlisterner;
    @Value("${hibernate.generate_statistics}")				private String generateStatics;
    									
    //{mail.properties}
    @Value("${mail.protocol}") 			   			 		private String protocol;
    @Value("${mail.host}")							 		private String host;
    @Value("${mail.port}")					    			private int port;
    @Value("${mail.smtp.socketFactory.port}")    			private int socketPort;
    @Value("${mail.smtp.auth}")					    		private boolean auth;
    @Value("${mail.smtp.starttls.enable}")		    		private boolean starttls;
    @Value("${mail.smtp.starttls.required}")				private boolean startlls_required;
    @Value("${mail.smtp.debug}")					    	private boolean debug;
    @Value("${mail.smtp.socketFactory.fallback}")			private boolean fallback;
    @Value("${mail.from}")									private String from;
    @Value("${mail.username}")		    					private String username;
    @Value("${mail.password}")		    					private String password;

    
    @Bean
	public InternalResourceViewResolver ivr(){
		InternalResourceViewResolver v=new InternalResourceViewResolver();
		v.setPrefix(location);
		v.setSuffix(extention);
		return v;
	}
    
   
    @Bean(name = "multipartResolver")
	public CommonsMultipartResolver cmr(){
		CommonsMultipartResolver c=new CommonsMultipartResolver();
	    c.setDefaultEncoding("utf-8");
		return c;
		}
    
    @Bean  
    public ViewResolver xmlViewResolver() {  
	XmlViewResolver resolver = new XmlViewResolver();
	resolver.setLocation(new ClassPathResource("spring-views.xml"));
    return resolver;  
    }
    
    @Bean    
    public DataSource getDataSource()
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();        
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(pass);        
        return ds;
    }
    
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }
    
    @Bean
    @Autowired
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory)
    {
        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
        return hibernateTemplate;
    }
        
    @Bean
    public Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        properties.put("hibernate.generate_statistics", generateStatics);
        properties.put("hibernate.validator.apply_to_ddl", validatorapplytoddl);
        properties.put("hibernate.validator.autoregister_listeners", autoregisterlisterner);
        properties.put("hibernate.format_sql", hibernateformatsql);
        return properties;
    }

    @Bean
    public AnnotationSessionFactoryBean getSessionFactory()
    {
        AnnotationSessionFactoryBean asfb = new AnnotationSessionFactoryBean();
        asfb.setDataSource(getDataSource());
        asfb.setHibernateProperties(getHibernateProperties());        
        asfb.setPackagesToScan(new String[]{"com.app.model"});
        return asfb;
    }
    
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", auth);
        mailProperties.put("mail.smtp.starttls.enable", starttls);
        mailProperties.put("mail.smtp.starttls.required", startlls_required);
        mailProperties.put("mail.smtp.socketFactory.port", socketPort);
        mailProperties.put("mail.smtp.debug", debug);
        mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        mailProperties.put("mail.smtp.socketFactory.fallback", fallback);

        mailSender.setJavaMailProperties(mailProperties);
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setProtocol(protocol);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        return mailSender;
    }
}