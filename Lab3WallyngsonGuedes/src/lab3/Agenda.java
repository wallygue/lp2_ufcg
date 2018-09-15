package lab3;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Agenda {

	private Contato[] contatos = new Contato[100];

	public Agenda() {
		// Este construtor n�o constr�i nada, apenas inicia a Classe;		
	}

	public Boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao > contatos.length || posicao < 1)
			throw new IndexOutOfBoundsException("POSI��O INV�LIDA!!");
		
		if (nome != null) {
			if (sobrenome != null) {
				if (telefone != null) {
					Contato contato = new Contato(nome, sobrenome, telefone);
					contatos[posicao - 1] = contato;
					return true;
				}
			}
		} return false;

	}

	public String exibirContato(int posicao) {
		if (contatos[posicao - 1] == null) 
			throw new NoSuchElementException("N�O EXISTE CONTATO NESTA POSI��O!!");
		if (posicao > contatos.length || posicao < 1)
			throw new IndexOutOfBoundsException("POSI��O INV�LIDA!!");
		
		return contatos[posicao - 1].toString() + System.lineSeparator();
		
	}
	
	public String listarContatos() {
		String contatosListados = "";
		
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				contatosListados += Integer.toString(i + 1) + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome() + System.lineSeparator();
			}

		}
		
		if (contatosListados.trim().equals(""))
			throw new IllegalArgumentException("N�O EXISTE CONTATOS CADASTRADOS!!");
		
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
