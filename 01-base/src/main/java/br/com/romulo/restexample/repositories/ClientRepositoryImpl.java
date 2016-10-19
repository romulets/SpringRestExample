package br.com.romulo.restexample.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.romulo.restexample.entities.Client;
import br.com.romulo.restexample.exceptions.ResourceNotFoundException;

@Repository
@Primary
public class ClientRepositoryImpl implements ClientRepository {
	
	@PersistenceContext(unitName = "restExamplePU")
	protected EntityManager entityManager;
	
	public List<Client> all() {
		String hql = "SELECT c FROM Client c";
		List<Client> clients = (List<Client>) entityManager.createQuery(hql).getResultList();
		return clients;
	}
	
	public Client findById(int id) {
		try{
			String hql = "SELECT c FROM Client c WHERE c.id = :id";
			Query query =  entityManager.createQuery(hql);
			query.setParameter("id", id);
			
			Client client = (Client) query.getSingleResult();
			return client;
		} catch (DataAccessException e) {
			throw new ResourceNotFoundException("Client entity not found.");
		}
	}
	
	@Transactional
	@Override
	public boolean save(Client entity) {
		try {
			this.entityManager.persist(entity);
		} catch (PersistenceException error) {
			error.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	@Override
	public boolean delete(Client entity) {
		try {
			this.entityManager.remove(entity);
		} catch (PersistenceException error) {
			error.printStackTrace();
			return false;
		}
		return true;
	}
	
}
