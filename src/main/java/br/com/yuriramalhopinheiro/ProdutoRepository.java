package br.com.yuriramalhopinheiro;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class ProdutoRepository {

	@Inject
	private EntityManager entityManager;

	public void adicionar(Produto produto) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(produto);
			this.entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			this.entityManager.getTransaction().rollback();
		} finally {
			this.entityManager.close();
		}
	}

	
	public void adicionar2(Produto produto) {
			this.entityManager.merge(produto);
	}
	
}
