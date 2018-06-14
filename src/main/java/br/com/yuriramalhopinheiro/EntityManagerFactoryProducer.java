package br.com.yuriramalhopinheiro;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerFactoryProducer {
	
	@Produces
	public EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("jsf-cdi-spring-data");
	}

	public void close(@Disposes EntityManagerFactory entityManagerFactory) {
		entityManagerFactory.close();
	}
	
	//@RequestScoped
	@Produces				
	public EntityManager createEntityManager(EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.createEntityManager();
	}

	public void close(@Disposes EntityManager entityManager) {
		entityManager.close();
	}
	
}
