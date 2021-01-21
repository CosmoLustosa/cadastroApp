package cadastro.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory = null;
	
	private static Configuration conf;
	
	private static SessionFactory buildSessionFactory() {
		try {
			conf = new Configuration();
			conf.configure("hibernate.cfg.xml");
			
			System.out.println("Configurou...");
			
			
			factory = conf.buildSessionFactory();
			System.out.println("Construiu...");
			
			return factory;
			
		}catch(Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError();
		}
		
	}
	
	public static SessionFactory getSessionFactory() {
		if(factory == null)
			factory = buildSessionFactory();
		
		return factory;
	}	
}
