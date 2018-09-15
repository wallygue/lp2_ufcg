package lab3;

import java.util.Arrays;

public class Agenda {

	private Contato[] contatos = new Contato[100];

	public Agenda() {
		// TODO Auto-generated constructor stub
	}
		

	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao > contatos.length || posicao < 1)
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!!");
		if (nome != null) {
			if (sobrenome != null) {
				if (telefone != null) {
					Contato contato = new Contato(nome, sobrenome, telefone);
					contatos[posicao - 1] = contato;
				}
			}
		}

	}

	public String exibirContato(int posicao) {
		return contatos[posicao - 1].toString() + System.lineSeparator();
		
	}
	
	public String listarContatos() {
		String contatosListados = "";
		
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				contatosListados += Integer.toString(i + 1) + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome() + System.lineSeparator();
			}

		}
		return contatosListados;
	}

	/* 
	 * HashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
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
		if (!(obj instanceof Agenda)) {
			return false;
		}
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos)) {
			return false;
		}
		return true;
	}
}
