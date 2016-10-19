package br.com.romulo.restexample.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.com.romulo.restexample.exceptions.ResourceNotFoundException;
import br.com.romulo.restexample.models.Client;

@Repository
@Primary
public class ClientRepositoryImpl implements ClientRepository {

	private List<Client> clients;
	
	public ClientRepositoryImpl() {
		clients = new ArrayList<>();
		clients.add(new Client(){{ setId(1); setName("Rômulo"); }});
		clients.add(new Client(){{ setId(2); setName("Jean"); }});
		clients.add(new Client(){{ setId(3); setName("Heitor"); }});
	}
	
	
	public List<Client> all() {
		return clients;
	}
	
	public Client findById(int id) {
		for(Client client : clients)
			if(client.getId() == id)
				return client;
		
		throw new ResourceNotFoundException("Client entity not found.");
	}
	
}
