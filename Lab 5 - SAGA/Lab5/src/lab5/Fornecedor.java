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
	private List<Produto> produtos;

	public Fornecedor(String nome, String email, String telefone) {
		this.nomeInvalido(nome);
		this.parametroErrado(email, telefone);

		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new ArrayList<>();
	}

	/**
	 * Edita os parametros do fornecedor.
	 * 
	 * @param email
	 * @param telefone
	 * @return
	 */
	public String editarFornecedor(String email, String telefone) {
		this.parametroErrado(email, telefone);

		this.email = email;
		this.telefone = telefone;

		return "Fornecedor editado com sucesso!";

	}

	public String getNome() {
		return this.nome;
	}

	/**
	 * Cadastra um produto do fornecedor.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return
	 */
	public String cadastrarProduto(String nomeProduto, String descricao, String preco) {
		if (validaProduto(nomeProduto, descricao) == null) {
			this.produtos.add(new Produto(nomeProduto, descricao, preco));
			return "Produto cadastrado com sucesso!";
		}

		return "Produto ja cadastrado!";
	}

	/**
	 * Pesquisa o produto passado por parametro e retorna uma representacao textual
	 * do produto.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @return
	 */
	public String retornaProduto(String nomeProduto, String descricao) {
		this.parametroErrado(nomeProduto, descricao);
		
		if (validaProduto(nomeProduto, descricao) == null)
			return "Produto nao cadastrado!";

		return validaProduto(nomeProduto, descricao).toString();
	}

	/**
	 * Edita o preco de um produto passado por parametro.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return
	 */
	public String editarPreco(String nomeProduto, String descricao, String preco) {
		this.parametroErrado(nomeProduto, descricao);
		
		if (validaProduto(nomeProduto, descricao) == null)
			return "Produto nao cadastrado!";

		return this.validaProduto(nomeProduto, descricao).alteraPreco(preco);

	}

	/**
	 * Lista todos os produtos que o fornecedor vende.
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
	 * @param produtos
	 * @return
	 */
	private String listaDosProdutos(List<Produto> produtos) {
		if (produtos.size() == 0)
			return "";

		String listaProdutos = "";

		for (int i = 0; i < produtos.size(); i++) {
			listaProdutos += this.getNome() + " - " + produtos.get(i).toString() + " | ";
		}

		return listaProdutos;
	}

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
			return this.getNome().equals(novoFornecedor.getNome());
		}

		return false;
	}

	/**
	 * Valida se o produto esta ou nao cadastrado.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @return
	 */
	private Produto validaProduto(String nomeProduto, String descricao) {
		for (Produto produto : produtos) {
			if (produto != null && produto.equals(new Produto(nomeProduto, descricao)))
				return produto;
		}

		return null;
	}

	@Override
	public int compareTo(Fornecedor f2) {
		return this.getNome().compareTo(f2.getNome());
	}

	/**
	 * Verifica se os parametros passados sao nulos ou invalidos.
	 * 
	 * @param arg1
	 * @param arg2
	 */
	private void parametroErrado(String arg1, String arg2) {
		if (arg1 == null || arg2 == null)
			throw new NullPointerException();

		if (arg1.equals("") || arg2.equals(""))
			throw new IllegalArgumentException();
	}

	/**
	 * Verifica se o nome do produto eh invalido ou nulo.
	 * 
	 * @param nome
	 */
	private void nomeInvalido(String nome) {
		if (nome == null)
			throw new NullPointerException();
		if (nome.equals(""))
			throw new IllegalArgumentException();
	}

}
