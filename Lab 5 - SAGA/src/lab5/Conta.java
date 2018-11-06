package lab5;

public class Conta {

	private String fornecedor, data, nomeProduto, descricao;
	
	public Conta(String fornecedor, String data, String nomeProduto, String descricao) {
		this.validaData(data);
		
		this.fornecedor = fornecedor;
		this.data = data;
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
	
	}
	
	private void validaData(String data) {
		if (data.length() > 10)
			throw new IllegalArgumentException("data invalida.");
		if (data.trim().isEmpty() || data == null)
			throw new IllegalArgumentException("data nao pode ser vazia ou nula");
	}
	
	public String getDescricao() { 
		return this.descricao;
	}
	
	@Override
	public String toString() {
		return this.fornecedor + " - " + this.nomeProduto + " - " + this.data;
	}

}
