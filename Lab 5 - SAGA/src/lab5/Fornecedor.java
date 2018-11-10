package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe que representa um fornecedor.
 * 
 * @author Wallyngson Guedes
 *
 */
public class Fornecedor implements Comparable<Fornecedor> {

	private String nome;
	private String email;
	private String telefone;
	private List<ProdutoAbstrato> produtos;

	public Fornecedor(String nome, String email, String telefone) {
		this.parametrosInvalidos(email, telefone);

		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new ArrayList<>();
	}

	/**
	 * Verifica se o email e o telefone do fornecedor sao invalidos.
	 * 
	 * @param email
	 * @param telefone
	 */
	private void parametrosInvalidos(String email, String telefone) {
		if (email.trim().isEmpty() || email == null)
			throw new IllegalArgumentException("email nao pode ser vazio ou nulo.");
		if (telefone.trim().isEmpty() || telefone == null)
			throw new IllegalArgumentException("telefone nao pode ser vazio ou nulo.");
	}

	public String getNomeFornecedor() {
		return this.nome;
	}

	public void setEmailFornecedor(String email) {
		this.email = email;
	}

	public void setTelefoneFornecedor(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Cadastra um produto do fornecedor.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return
	 */
	public void adicionaProduto(String nomeProduto, String descricao, Double preco) {
		this.validaProduto(nomeProduto, descricao);

		this.produtos.add(new ProdutoSimples(nomeProduto, descricao, preco));
	}

	/**
	 * Verifica se o nome ou a descricao do produto passado por parametro eh
	 * invalido.
	 * 
	 * @param nome
	 */
	private void nomeProdutoInvalido(String nome, String descricao) {
		if (nome.trim().isEmpty() || nome == null)
			throw new IllegalArgumentException("nome nao pode ser vazio ou nulo.");
		if (descricao.trim().isEmpty() || descricao == null)
			throw new IllegalArgumentException("descricao nao pode ser vazia ou nula.");
	}

	/**
	 * Valida se o produto esta ou nao cadastrado.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @return
	 */
	private void validaProduto(String nomeProduto, String descricao) {
		for (ProdutoAbstrato produto : produtos) {
			if (produto.equals(new ProdutoSimples(nomeProduto, descricao)))
				throw new IllegalArgumentException("produto ja existe.");
		}
	}

	/**
	 * Pesquisa o produto passado por parametro e retorna uma representacao textual
	 * do produto.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @return
	 */
	public String exibeProduto(String nomeProduto, String descricao) {
		this.nomeProdutoInvalido(nomeProduto, descricao);
		return this.exibe(nomeProduto, descricao).toString();
	}

	/**
	 * Verifica se o produto existe e o retorna.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @return
	 */
	private ProdutoAbstrato exibe(String nomeProduto, String descricao) {
		for (ProdutoAbstrato produto : produtos) {
			if (produto.equals(new ProdutoSimples(nomeProduto, descricao)))
				return produto;
		}
		throw new IllegalArgumentException("produto nao existe.");
	}

	/**
	 * Edita o preco de um produto passado por parametro.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return
	 */

	public void editaPreco(String nomeProduto, String descricao, Double preco) {
		this.nomeProdutoInvalido(nomeProduto, descricao);
		if (preco <= 0 || preco == null)
			throw new IllegalArgumentException("preco invalido.");

		this.exibe(nomeProduto, descricao).setPreco(preco);
	}

	/**
	 * Lista todos os produtos do fornecedor.
	 * 
	 * @return
	 */
	public String listarProdutos() {
		Collections.sort(produtos);
		return listaDosProdutos(produtos);
	}

	/**
	 * Percorre a Colecao e retorna todos os produtos em uma representacao textual;
	 * 
	 * @param produtosSimples
	 * @return
	 */
	private String listaDosProdutos(List<ProdutoAbstrato> produtos) {
		if (produtos.size() == 0)
			return "";

		String listaProdutos = "";

		for (int i = 0; i < produtos.size(); i++) {
			listaProdutos += this.nome + " - " + produtos.get(i).toString() + " | ";
		}

		return listaProdutos;
	}

	/**
	 * Remove um produto passado por parametro.
	 * 
	 * @param nome
	 * @param descricao
	 */
	public void removeProduto(String nome, String descricao) {
		this.nomeProdutoInvalido(nome, descricao);
		this.produtoInexistente(nome, descricao);

		this.produtos.remove(this.indiceProduto(nome, descricao));
	}

	/**
	 * Verifica se o produto existe.
	 * 
	 * @param nome
	 * @param descricao
	 */
	private void produtoInexistente(String nome, String descricao) {
		if (this.indiceProduto(nome, descricao) == -1)
			throw new IllegalArgumentException("produto nao existe.");
	}

	/**
	 * Retorna o indice do produto valido.
	 * 
	 * @param nome
	 * @param descricao
	 * @return
	 */
	private int indiceProduto(String nome, String descricao) {
		for (int i = 0; i < produtos.size(); i++) {
			if (this.produtos.get(i).equals(new ProdutoSimples(nome, descricao)))
				return i;
		}
		return -1;
	}

//	public Double retornaPreco(String nome, String descricao) {
//		return this.produtos.get(this.indiceProduto(nome, descricao)).getPreco();
//	}
//
//	/**
//	 * Valida o produto a ser usado, modificado ou excluido;
//	 * 
//	 * @param nome
//	 * @param descricao
//	 */
//	public void validarProduto(String nome, String descricao) {
//		this.nomeProdutoInvalido(nome, descricao);
//		this.produtoInexistente(nome, descricao);
//	}

	// COMBO

	/**
	 * Adiciona um combo ao fornecedor.
	 * 
	 * @param nomeCombo
	 * @param descricao
	 * @param fator
	 * @param combo
	 */
	public void adicionaCombo(String nomeCombo, String descricao, Double fator, String combo) {
		this.validaCombo(nomeCombo, descricao);
		this.comboInvalido(fator, combo);
		this.verificaProduto(combo);

		this.produtos.add(new ProdutoCombo(nomeCombo, descricao, fator, combo));
	}

	/**
	 * EU ACHEI QUE ESSE TESTE ESTA ERRADO POIS DEVERIA SER TESTADO NO COMBO NAO NO
	 * FORNECEDOR. Verifica se o fator do preco informado eh valido.
	 * 
	 * @param fator
	 */
	private void comboInvalido(Double fator, String combo) {
		if (fator == null || fator <= 0.0)
			throw new IllegalArgumentException("fator invalido.");
		if (combo.trim().isEmpty() || combo == null)
			throw new IllegalArgumentException("combo deve ter produtos.");
	}

	/**
	 * Valida se o produto esta ou nao cadastrado.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @return
	 */
	private void validaCombo(String nome, String descricao) {
		for (ProdutoAbstrato produto : produtos) {
			if (produto.equals(new ProdutoCombo(nome, descricao)))
				throw new IllegalArgumentException("combo ja existe.");
		}
	}

	/**
	 * Torna o combo produtos individuais. Divide as entradas.
	 * 
	 * @param combo
	 */
	private void verificaProduto(String combo) {
		String[] produtosCombo = combo.split(", ");
		this.validaProduto(produtosCombo[0]);
		this.validaProduto(produtosCombo[1]);
	}

	/**
	 * Recebe uma string com o nome e o sobrenome dos produtos e verifica se existem
	 * ou nao.
	 * 
	 * @param string
	 */
	private void validaProduto(String string) {
		String[] produto = string.split(" - ");
		String nome = produto[0];
		String descricao = produto[1];
		this.produtoInexistente(nome, descricao);

	}

	// /**
//	 * Verifica se um combo ja existe.
//	 * 
//	 * @param nomeCombo
//	 * @param descricao
//	 */
//	private void validaCombo(String nomeCombo, String descricao) {
//		for (int i = 0; i < combos.size(); i++) {
//			if (this.combos.get(i) != null && this.combos.get(i).equals(new ProdutoCombo(nomeCombo, descricao)))
//				throw new IllegalArgumentException("combo ja existe.");
//		}
//	}
//
//	/**
//	 * Verifica se algum dos parametros do combo eh ivalido ou nulo.
//	 * 
//	 * @param nome
//	 * @param descricao
//	 * @param fator
//	 * @param produtos
//	 */
//	private void comboInvalido(String nome, String descricao, Double fator, String produtos) {
//		if (nome.trim().isEmpty() || nome == null)
//			throw new IllegalArgumentException("nome nao pode ser vazio ou nulo.");
//		if (descricao.trim().isEmpty() || descricao == null)
//			throw new IllegalArgumentException("descricao nao pode ser vazia ou nula.");
//		if (produtos.trim().isEmpty() || produtos == null)
//			throw new IllegalArgumentException("combo deve ter produtos.");
//		if (fator <= 0.0 || fator == null)
//			throw new IllegalArgumentException("fator invalido.");
//	}
//

//	/**
//	 * Separa os produtos e calcula o preco geral do combo.
//	 * 
//	 * @param combo
//	 * @param fator
//	 * @return
//	 */
//	private Double calculaPrecoCombo(String combo, Double fator) {
//		String[] produtosCombo = combo.split(", ");
//		Double preco1 = this.retornaPreco(produtosCombo[0]);
//		Double preco2 = this.retornaPreco(produtosCombo[1]);
//
//		return (preco1 + preco2) - ((preco1 + preco2) * fator);
//	}
//
//	/**
//	 * Retorna o preco do produto passado por parametros.
//	 * 
//	 * @param produto
//	 * @return
//	 */
//	private Double retornaPreco(String produto) {
//		String[] nomes = produto.split(" - ");
//		return this.produtos.get(this.indiceProduto(nomes[0], nomes[1])).getPreco();
//	}
//
//	/**
//	 * Retorna o indice em que o combo se encontra na colecao dos combos.
//	 * 
//	 * @param nomeCombo
//	 * @param descricao
//	 * @return
//	 */
//	private int indiceCombo(String nomeCombo, String descricao) {
//		for (int i = 0; i < produtos.size(); i++) {
//			if (produtos.get(i) != null && combos.get(i).equals(new ProdutoCombo(nomeCombo, descricao)))
//				return i;
//		}
//
//		throw new IllegalArgumentException("Combo nao existe.");
//	}

	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fornecedor) {
			Fornecedor novoFornecedor = (Fornecedor) obj;
			return this.nome.equals(novoFornecedor.getNomeFornecedor());
		}

		return false;
	}

	@Override
	public int compareTo(Fornecedor f2) {
		return this.nome.compareTo(f2.getNomeFornecedor());
	}

}
