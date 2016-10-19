package br.com.romulo.restexample.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.romulo.restexample.models.Client;
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
	
}
