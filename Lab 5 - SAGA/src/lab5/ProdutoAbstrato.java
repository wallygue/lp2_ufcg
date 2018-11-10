package lab5;

/**
 * Classe abstrata que reprensenta um produto, podendo ser um produto simples ou
 * um combo.
 * 
 * @author Wallyngson Guedes
 *
 */
public abstract class ProdutoAbstrato implements Comparable<ProdutoAbstrato> {

	public String nome, descricao;

	public ProdutoAbstrato(String nome, String descricao) {
		this.parametrosInvalidos(nome, descricao);

		this.nome = nome;
		this.descricao = descricao;
	}

	/**
	 * Verifica se os parametros passados por nome e descricao sao validos.
	 * 
	 * @param nome
	 * @param descricao
	 */
	private void parametrosInvalidos(String nome, String descricao) {
		if (nome.trim().isEmpty() || nome == null)
			throw new IllegalArgumentException("nome nao pode ser vazio ou nulo.");
		if (descricao.trim().isEmpty() || descricao == null)
			throw new IllegalArgumentException("descricao nao pode ser vazia ou nula.");
	}

	public abstract void setPreco(Double preco);

	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	private String formataFrase(String nome, String descricao) {
		String nomeCompleto = this.nome + " - " + this.descricao;
		return nomeCompleto.toLowerCase().replace(" ", "");
	}

	public boolean equals(Object obj) {
		if (obj instanceof ProdutoAbstrato) {
			ProdutoAbstrato p1 = (ProdutoAbstrato) obj;
			return this.formataFrase(this.nome, this.descricao).equals(p1.formataFrase(getNome(), getDescricao()));
		}

		return false;
	}

	public int compareTo(ProdutoAbstrato p2) {
		return this.formataFrase(getNome(), getDescricao()).compareTo(p2.formataFrase(getNome(), getDescricao()));
	}
}
