package manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Application {

	public static void main(String[] args) {

		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure("META-INF/hibernate.cfg.xml").build();

		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		User userMax = new User();

		userMax.setUserName("Max");

		User userAdmin = new User();

		userAdmin.setUserName("Admin");

		Group groupAdmin = new Group("Admin Group");

		Group groupUser = new Group("User Group");

		groupAdmin.addUser(userAdmin);

		groupAdmin.addUser(userMax);

		groupUser.addUser(userMax);

		userAdmin.addGroup(groupAdmin);

		userMax.addGroup(groupUser);

		session.save(groupUser);

		session.save(groupAdmin);

		session.getTransaction().commit();

		session.close();

		sessionFactory.close();
	}

}
