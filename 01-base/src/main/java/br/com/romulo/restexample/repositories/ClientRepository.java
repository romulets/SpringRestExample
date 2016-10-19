package br.com.romulo.restexample.repositories;

import java.util.List;

import br.com.romulo.restexample.models.Client;

public interface ClientRepository {

	public List<Client> all();
	
	public Client findById(int id);
	
}
