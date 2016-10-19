package br.com.romulo.restexample.repositories;

import java.util.List;

import br.com.romulo.restexample.entities.Client;

public interface ClientRepository {

	public List<Client> all();
	
	public Client findById(int id);
	
	public boolean save(Client client);
	
	public boolean delete(Client client);
	
}
