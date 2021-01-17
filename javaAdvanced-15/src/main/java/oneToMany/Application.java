package oneToMany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Application {

	public static void main(String[] args) {

		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("META-INF/hibernate.cfg.xml").build();
		
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		
		Post post = new Post();
		post.setTitle("Cars");
		
		Comment comment = new Comment();
		
		comment.setAuthorName("Max");
		
		Comment comment2 = new Comment();
		
		comment2.setAuthorName("Ne Max");
		
		Set<Comment> coments = new HashSet();
		coments.add(comment);
		coments.add(comment2);
		
		post.setComents(coments);
		
        session.save(post);
		
		session.getTransaction().commit();
		
		session.close();
		
		sessionFactory.close();
	}

}
