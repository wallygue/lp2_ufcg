package lab5;

public class Fornecedor {

	private String nome;
	private String email;
	private String telefone;
	
	public Fornecedor(String nome, String email, String telefone) {
		
		this.parametroNulo(email, telefone);
		this.parametroInvalido(email, telefone);
		
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	public String editarFornecedor(String email, String telefone) {
		this.parametroNulo(email, telefone);
		this.parametroInvalido(email, telefone);
		
		this.email = email;
		this.telefone = telefone;
		
		return "Cliente editado com sucesso!";
			
	}
	
	private void parametroNulo(String email, String telefone) {
		if (email == null || telefone == null)
			throw new NullPointerException();
	}
	
	private void parametroInvalido(String email, String telefone) {
		if (email.equals("") || telefone.equals(""))
			throw new NullPointerException();
	}
	
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

}
