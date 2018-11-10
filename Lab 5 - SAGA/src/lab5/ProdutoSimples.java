package lab5;

import java.text.DecimalFormat;

/**
 * Classe representa um produto simples (com apenas um componente).
 * 
 * @author Wallyngson Guedes
 *
 */
public class ProdutoSimples extends ProdutoAbstrato {

	private String nome, descricao;
	private Double preco;

	public ProdutoSimples(String nome, String descricao, Double preco) {
		super(nome, descricao);
		this.parametroInvalido(preco);

		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public ProdutoSimples(String nome, String descricao) {
		super(nome, descricao);
	}

	/**
	 * Verifica se os parametros sao vazios ou nulos.
	 * 
	 * @param nome
	 * @param descricao
	 * @param preco
	 */
	private void parametroInvalido(Double preco) {
		if (preco <= 0.0 || preco == null)
			throw new IllegalArgumentException("preco invalido.");
	}

	@Override
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return this.nome + " - " + this.descricao + " - R$" + df.format(this.preco);
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

}
