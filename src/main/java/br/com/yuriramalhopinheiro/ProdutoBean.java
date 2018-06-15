package br.com.yuriramalhopinheiro;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named("produtoBean")
@ViewScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produto produto;

	@Inject
	private Repository repository;

	private List<Produto> produtos;

	@Transactional
	public String adicionar() {
		produto = this.repository.save(produto);

		exibirMensagem("Produto " + this.produto.getNome() + " adicionado com sucesso!");

		return "index.xhtml";
	}

	public void listar() {
		this.setProdutos(this.repository.findAll());
	}

	private void exibirMensagem(String mensagem) {
		FacesMessage message = new FacesMessage(mensagem);

		FacesContext currentInstance = FacesContext.getCurrentInstance();
		currentInstance.addMessage(null, message);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
