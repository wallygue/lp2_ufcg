package lab5;

/**
 * Esta classe representa um cliente.
 * 
 * @author Wallyngson Guedes
 *
 */
public class Cliente {

	private String cpf;
	private String nome;
	private String email;
	private String localizacao;

	public Cliente(String cpf, String nome, String email, String localizacao) {
		
		this.parametroNulo(nome, email, localizacao);
		this.parametroInvalido(nome, email, localizacao);
		
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
		
		
	}

	public String getCPF() {
		return this.cpf;
	}

	public String editarCliente(String nome, String email, String localizacao) {
		this.parametroNulo(nome, email, localizacao);
		this.parametroInvalido(nome, email, localizacao);
		
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
		
		return "Cliente editado com sucesso!";
			
	}
	
	private void parametroNulo(String nome, String email, String localizacao) {
		if (nome == null || email == null || localizacao == null)
			throw new NullPointerException();
	}
	
	private void parametroInvalido(String nome, String email, String localizacao) {
		if (nome.equals("") || email.equals("") || localizacao.equals(""))
			throw new NullPointerException();
	}
	
	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Cliente novo = (Cliente) obj;
		return this.getCPF().equals(novo.getCPF());
	}




}
