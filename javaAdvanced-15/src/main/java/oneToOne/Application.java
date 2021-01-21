package oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Application {

	public static void main(String[] args) {
		
//		Configuration configuration = new Configuration().configure("META-INF/hibernate.cfg.xml");
		
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("META-INF/hibernate.cfg.xml").build();
		
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		//  configuration.buildSessionFactory(serviceRegistry);
		
		Person person = new Person();
		person.setName("max");
		
		FinancialOperation financialOperation = new FinancialOperation();
		
		financialOperation.setTotal(1);
		
//		person.setFinancialOperation(financialOperation);
		
		session.save(person);
		
		session.getTransaction().commit();
		
		session.close();
		
		sessionFactory.close();
		
	}

}
