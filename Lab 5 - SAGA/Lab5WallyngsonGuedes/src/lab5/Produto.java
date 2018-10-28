package lab5;

public class Produto implements Comparable<Produto> {

	private String nome;
	private String descricao;
	private String preco;

	public Produto(String nome, String descricao, String preco) {
		this.parametroErrado(nome, descricao, preco);
		
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Produto(String nomeProduto, String descricao) {
		this.nome = nomeProduto;
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDesricao() {
		return this.descricao;
	}
	
	public String nomeCompleto() {
		return this.nome + " " + this.descricao;
	}
	
	public String alteraPreco(String preco) {
		this.validaPreco(preco);
		
		this.preco = preco;
		return "Preco alterado com sucesso!";
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + this.preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Produto novoProduto = (Produto) obj;
		return this.formataFrase(this.nomeCompleto()).equals(formataFrase(novoProduto.nomeCompleto()));
	}

	private String formataFrase(String frase) {
		return frase.toLowerCase().replace(" ", "");
	}
	
	private void validaPreco(String preco) {
		if (preco == null)
			throw new NullPointerException();
		if (preco.equals(""))
			throw new IllegalArgumentException();
	}
	
	private void parametroErrado(String nome, String descricao, String preco) {
		if (nome == null || descricao == null || preco == null)
			throw new NullPointerException();
		if (nome.equals("") || descricao.equals("") || preco.equals(""))
			throw new IllegalArgumentException();
	}

	@Override
	public int compareTo(Produto p2) {
		return this.nomeCompleto().compareTo(p2.nomeCompleto());
	}


}
