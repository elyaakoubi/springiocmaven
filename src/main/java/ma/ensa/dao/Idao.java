package ma.ensa.dao;

import java.util.Set;
import ma.ensa.entities.Client;

public interface Idao {
	
	public int addClient(Client client);
	public Set<Client> allClients();

}
