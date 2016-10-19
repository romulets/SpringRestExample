package br.com.romulo.restexample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.romulo.restexample.entities.Client;
import br.com.romulo.restexample.repositories.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Client> all(){
		return repo.all();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public Client findById(@PathVariable("id") int id){
		return repo.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void insert(@RequestBody Client client){
		repo.save(client);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public void update(@PathVariable("id") int id, @RequestBody Client client){
		Client persistedClient = repo.findById(id);
		persistedClient.setName(client.getName());
		repo.save(client);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id){
		Client client = repo.findById(id);
		repo.delete(client);
	}
	
}
