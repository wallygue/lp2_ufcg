package lab3;

/**
 * ESTA CLASSE REPRESENTA OS CONTATOS QUE DEVEM 
 * SER CADASTRADOS NUMA AGENDA, CONTROI E � 
 * ADICIONADO NO ARRAY;
 * 
 * @author Wallyngson Guedes
 *
 */
public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;

	/**
	 * RESPONS�VEL POR CONSTRUIR O CONTATO A SER ADICIONADO
	 * NA AGENDA. RECEBENDO COMO PAR�METRO O NOME, SOBRENOME
	 * E TELEFONE;
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		
		/*
		 * EXCEPTIONS, RESPOSAVEIS POR SABER SE O NOME, SOBRENOME
		 * E TELEFONE SAO INVALIDOS OU NULOS;
		 */
		if(nome == null)
			throw new NullPointerException("OCORREU UM ERRO (NOME NULO), DIGITE UM NOME!!");
		
		if(nome.trim().equals(""))
			throw new IllegalArgumentException("OCORREU UM ERRO (NOME INVALIDO), DIGITE UM NOME!!");
		
		if(sobrenome == null)
			throw new NullPointerException("OCORREU UM ERRO (SOBRENOME NULO), DIGITE UM SOBRENOME!!");
		
		if(sobrenome == null || sobrenome.trim().equals(""))
			throw new IllegalArgumentException("OCORREU UM ERRO (NOME INVALIDO), DIGITE UM NOME!!");

		if(telefone == null)
			throw new NullPointerException("OCORREU UM ERRO (TELEFONE NULO), DIGITE UM TELEFONE!!");
		
		if(telefone == null || telefone.trim().equals(""))
			throw new IllegalArgumentException("OCORREU UM ERRO (NOME INVALIDO), DIGITE UM NOME!!");
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getTelefone() {
		return telefone;

	}

	/**
	 * RETORNA A AGENDA REPRESENTA��O TEXTUAL DO CONTATO;
	 */
	public String toString() {
		return nome + " " + sobrenome + " - " + telefone;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/* 
	 * METODO EQUALS QUE COMPARA SE DOIS CONTATOS SAO IGUAIS;
	 * VERIFICA SE O NOME E O SOBRENOME FOREM IGUAL, ENTAO
	 * OS CONTATOS TAMBEM SAO;
	 */
	@Override
	public boolean equals(Object obj) {
		Contato other = (Contato) obj;
		if (this.getNome().equals(other.getNome()) 
				&& this.getSobrenome().equals(other.getSobrenome())) {
			return true;
		} else
			return false;
		
	}
	
	
}