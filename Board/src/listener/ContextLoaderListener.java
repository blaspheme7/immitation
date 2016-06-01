package listener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import context.ApplicationContext;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	
	static ApplicationContext applicationContext;
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			
			applicationContext=new ApplicationContext();
			
			String resource="dao/mybatis-config.xml";
			InputStream inputStream=Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			
			applicationContext.addBean("sqlSessionFactory", sqlSessionFactory);
			
			ServletContext sc = event.getServletContext();
			String propertiesPath=sc.getRealPath(sc.getInitParameter("contextConfigLocation"));
			
			applicationContext.prepareObjectsByProperties(propertiesPath);
			applicationContext.prepareObjectsByAnnotation("");
			applicationContext.injectDependency();
			
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}
