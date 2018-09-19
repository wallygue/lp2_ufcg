package lab3;

/**
 * ESTA CLASSE REPRESENTA OS CONTATOS QUE DEVEM 
 * SER CADASTRADOS NUMA AGENDA, CONTROI E É 
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
	 * RESPONSÁVEL POR CONSTRUIR O CONTATO A SER ADICIONADO
	 * NA AGENDA. RECEBENDO COMO PARÂMETRO O NOME, SOBRENOME
	 * E TELEFONE;
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		
		/*
		 * EXCEPTIONS, RESPOSÁVEIS POR SABER SE O NOME, SOBRENOME
		 * E TELEFONE SÃO INVÁLIDOS OU NULOS;
		 */
		if(nome == null)
			throw new NullPointerException("OCORREU UM ERRO (NOME NULO), DIGITE UM NOME!!");
		
		if(nome.trim().equals(""))
			throw new IllegalArgumentException("OCORREU UM ERRO (NOME INVÁLIDO), DIGITE UM NOME!!");
		
		if(sobrenome == null)
			throw new NullPointerException("OCORREU UM ERRO (SOBRENOME NULO), DIGITE UM SOBRENOME!!");
		
		if(sobrenome == null || sobrenome.trim().equals(""))
			throw new IllegalArgumentException("OCORREU UM ERRO (NOME INVÁLIDO), DIGITE UM NOME!!");

		if(telefone == null)
			throw new NullPointerException("OCORREU UM ERRO (TELEFONE NULO), DIGITE UM TELEFONE!!");
		
		if(telefone == null || telefone.trim().equals(""))
			throw new IllegalArgumentException("OCORREU UM ERRO (NOME INVÁLIDO), DIGITE UM NOME!!");
		
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
	 * RETORNA A AGENDA REPRESENTAÇÃO TEXTUAL DO CONTATO;
	 */
	public String toString() {
		return nome + " " + sobrenome + " - " + telefone;
		
	}

	/* 
	 * HashCode
	 */
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
	 * Equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Contato)) {
			return false;
		}
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (sobrenome == null) {
			if (other.sobrenome != null) {
				return false;
			}
		} else if (!sobrenome.equals(other.sobrenome)) {
			return false;
		}
		if (telefone == null) {
			if (other.telefone != null) {
				return false;
			}
		} else if (!telefone.equals(other.telefone)) {
			return false;
		}
		return true;
	}
	
	
}