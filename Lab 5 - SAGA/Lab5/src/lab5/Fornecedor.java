package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fornecedor implements Comparable<Fornecedor> {

	private String nome;
	private String email;
	private String telefone;
	private List<Produto> produtos;

	public Fornecedor(String nome, String email, String telefone) {
		this.parametroErrado(email, telefone);

		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new ArrayList<>();
	}

	public String editarFornecedor(String email, String telefone) {
		this.parametroErrado(email, telefone);

		this.email = email;
		this.telefone = telefone;

		return "Fornecedor editado com sucesso!";

	}

	public String getNome() {
		return this.nome;
	}

	public String cadastrarProduto(String nomeProduto, String descricao, String preco) {
		if (validaProduto(nomeProduto, descricao) == null) {
			this.produtos.add(new Produto(nomeProduto, descricao, preco));
			return "Produto cadastrado com sucesso!";
		}
		
		return "Produto ja cadastrado!";
	}

	public String retornaProduto(String nomeProduto, String descricao) {
		if (validaProduto(nomeProduto, descricao) == null)
			return "Produto nao cadastrado!";
		
		return validaProduto(nomeProduto, descricao).toString();
	}
	
	public String editarPreco(String nomeProduto, String descricao, String preco) {
		if(validaProduto(nomeProduto, descricao) == null)
			return "Produto nao cadastrado!";
		
		return this.validaProduto(nomeProduto, descricao).alteraPreco(preco);
		
	}
	
	public String listarProdutos() {
		Collections.sort(produtos);
		return listaDosProdutos(produtos);
	}
	
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
		Fornecedor novoFornecedor = (Fornecedor) obj;
		return this.getNome().equals(novoFornecedor.getNome());
	}

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

	private void parametroErrado(String email, String telefone) {
		if (email == null || telefone == null)
			throw new NullPointerException();
		
		if (email.equals("") || telefone.equals(""))
			throw new NullPointerException();
	}


}
