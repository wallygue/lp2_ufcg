package lab5;

import java.text.DecimalFormat;

/**
 * Classe que representa um combo (juncao de um ou mais produtos).
 * 
 * @author Wallyngson Guedes
 *
 */
public class ProdutoCombo extends ProdutoAbstrato {

	private String nome, descricao, combo;
	private Double fator, preco;

	public ProdutoCombo(String nome, String descricao, Double fator, String combo) {
		super(nome, descricao);
		this.comboInvalido(fator, combo);

		this.nome = nome;
		this.descricao = descricao;
		this.fator = fator;
		this.combo = combo;

	}

	public ProdutoCombo(String nome, String descricao) {
		super(nome, descricao);

		this.nome = nome;
		this.descricao = descricao;
	}

	/**
	 * Verifica se o fator do preco informado eh valido.
	 * 
	 * @param fator
	 */
	private void comboInvalido(Double fator, String combo) {
		if (fator == null || fator <= 0.0)
			throw new IllegalArgumentException("fator invalido.");
		if (combo.trim().isEmpty() || combo == null)
			throw new IllegalArgumentException("combo deve ter produtos.");
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((combo == null) ? 0 : combo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fator == null) ? 0 : fator.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public String toString() {
		DecimalFormat dc = new DecimalFormat("0.00");
		return this.nome + " - " + this.descricao + " - R$" + dc.format(preco);
	}

}
