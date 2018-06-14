package br.com.yuriramalhopinheiro;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named("produtoBean")
@RequestScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produto produto;

	@Inject
	private Repository repository;
	
	@Transactional
	public String adicionar() {
		produto = this.repository.save(produto);
		
		System.out.println("Produto adicionado com sucesso!");
		
		List<Produto> produtos = this.repository.findAll();
		
		for(Produto produto : produtos) {
			System.out.println(produto.getNome());
		}
		
		return "index.xhtml?faces-redirect=true";
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
