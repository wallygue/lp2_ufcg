package lab5;

/**
 * Esta classe representa um cliente.
 * 
 * @author Wallyngson Guedes
 *
 */
public class Cliente implements Comparable<Cliente> {

	private String cpf;
	private String nome;
	private String email;
	private String localizacao;

	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.cpfErrado(cpf);
		this.parametroErrado( nome, email, localizacao);

		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}

	public String getCPF() {
		return this.cpf;
	}

	public String getNome() {
		return this.nome;
	}

	/**
	 * Edita as informacoes do cliente, como seu nome, email e localizacao.
	 * 
	 * @param nome
	 * @param email
	 * @param localizacao
	 * @return
	 */
	public String editarCliente(String nome, String email, String localizacao) {
		this.parametroErrado(nome, email, localizacao);

		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
		return "Cliente editado com sucesso!";
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
		if (obj instanceof Cliente) {
			Cliente novo = (Cliente) obj;
			return this.getCPF().equals(novo.getCPF());
		}
		return false;
	}

	@Override
	public int compareTo(Cliente c1) {
		return this.getNome().compareTo(c1.getNome());

	}

	private void parametroErrado(String nome, String email, String localizacao) {
		if (nome == null || email == null || localizacao == null)
			throw new NullPointerException("Algum ou todos os parametros sao nulos, por favor digite novamente.");
		if (nome.equals("") || email.equals("") || localizacao.equals(""))
			throw new IllegalArgumentException("Algum ou todos os parametros sao vazios, por favor digite novamente.");
	}
	
	private void cpfErrado(String cpf) {
		if (cpf == null)
			throw new  NullPointerException();
		if (cpf.equals(""))
			throw new  IllegalArgumentException();
	}

}
