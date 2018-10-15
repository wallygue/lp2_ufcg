package lab3;

public class Contato {
	String nome;
	String sobrenome;
	String telefone;

	
	public Contato(String nome, String sobrenome, String telefone) {
		if(nome == null)
			throw new NullPointerException("NOME VAZIO!!");
		if(nome.trim().equals(""))
			throw new IllegalArgumentException("DIGITE UM NOME!!");
		
		if(sobrenome == null)
			throw new NullPointerException("SOBRENOME VAZIO!!");
		if(sobrenome.trim().equals(""))
			throw new IllegalArgumentException("DIGITE UM SOBRENOME!!");
		
		if(telefone == null)
			throw new NullPointerException("TELEFONE VAZIO!!");
		if(telefone.trim().equals(""))
			throw new IllegalArgumentException("DIGITE UM TELEFONE BRO!!");
		
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