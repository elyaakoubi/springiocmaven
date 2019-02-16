package ma.ensa.dao;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ma.ensa.entities.Client;

@Repository
@Transactional
public class Dao implements Idao{

    private SessionFactory sessionFactory;
    
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int addClient(Client client) {
		Session session = sessionFactory.getCurrentSession();
		session.save(client);
		return client.getId();
	}

	@Override
	public Set<Client> allClients() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Client");
		Set<Client> clients = new HashSet<Client>(query.getResultList());
		return clients;
	}
	
}
