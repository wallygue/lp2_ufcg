package lab5;

import java.text.DecimalFormat;

public class Combo implements Comparable<Combo> {

	private String nomeCombo, descricao, combo;
	private Double fator, preco;
	
	public Combo(String nomeCombo, String descricao, Double fator, String combo) {
		this.nomeCombo = nomeCombo;
		this.descricao = descricao;
		this.fator = fator;
		this.combo = combo;
	
	}
	
	public Combo(String nomeCombo, String descricao) {
		this.nomeCombo = nomeCombo;
		this.descricao = descricao;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	

	private String nomeCompletoCombo() {
		String nome = this.nomeCombo + " - " + this.descricao;
		return nome.toLowerCase().replace(" ", "");
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((combo == null) ? 0 : combo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fator == null) ? 0 : fator.hashCode());
		result = prime * result + ((nomeCombo == null) ? 0 : nomeCombo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Combo) {
			Combo novoCombo = (Combo) obj;
			return this.nomeCompletoCombo().equals(novoCombo.nomeCompletoCombo());
		}
		
		return false;
	}

	@Override
	public String toString() {
		DecimalFormat dc = new DecimalFormat("0.00");
		return this.nomeCombo + " - " + this.descricao + " - R$" + dc.format(preco);
	}
	
	@Override
	public int compareTo(Combo c1) {
		return this.nomeCompletoCombo().compareTo(c1.nomeCompletoCombo());
	}
	
	
	
}
