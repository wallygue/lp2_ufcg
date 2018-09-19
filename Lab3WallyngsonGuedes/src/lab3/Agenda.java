package lab3;

import java.util.Arrays;

/**
 * ESTA CLASSE � UMA REPRESENTA��O DE UMA AGENDA, ONDE �
 * POSSIVEL ADICIONAR CONTATOS, LISTAR CONTATOS E EXIBIR
 * OS CONTATOS CADASTRADOS NESTA AGENDA;
 * 
 * @author Wallyngson Guedes
 *
 */
public class Agenda {
	
	/**
	 * ARRAY DE CONTATOS QUE VAI ARMAZENAR TODOS OS CONTATOS,
	 * ESSE ARRAY POSSUI 100 POSI��ES;
	 */
	private Contato[] contatos = new Contato[100];

	public Agenda() {
	}

	/**
	 * M�TODO RESPONS�VEL POR CADASTRAR OS CONTATOS NO ARRAY
	 * DE CONTATOS. RECEBE OS PARAM�TROS DA CLASSE MENU, A 
	 * POSI��O ONDE DEVE SER CADASTRADO, O NOME, SOBRENOME E 
	 * TELEFONE;
	 * 
	 * @param posicao
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 * @return
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao > this.contatos.length || posicao < 1)
			throw new IndexOutOfBoundsException("POSI��O INV�LIDA!!");
		
		if (nome != null && sobrenome != null && telefone != null) {
					Contato contato = new Contato(nome, sobrenome, telefone);
					contatos[posicao - 1] = contato;
					return "CADASTRO REALIZADO COM SUCESSO!!";
					
		} return "CADASTRO N�O REALIZADO!!";

	}

	/**
	 * ESTE M�TODO EXIBE O CONTATO CADASTRADO EM
	 * UMA DETERMINADA POSI��O INFORMADA PELO USU�RIO;
	 * 
	 * @param posicao
	 * @return
	 */
	public String exibirContato(int posicao) {
		// EXCEPTIONS
		if (this.contatos[posicao - 1] == null) 
			throw new NullPointerException("N�O EXISTE CONTATO NESTA POSI��O!!");
		if (posicao > this.contatos.length || posicao < 1)
			throw new IndexOutOfBoundsException("POSI��O SOLICITADA � INV�LIDA!!");
		
		return contatos[posicao - 1].toString();
		
	}
	
	/**
	 * M�TODO QUE LISTA TODOS OS CONTATOS CADASTRADOS 
	 * LINHA A LINHA, E RETORNA A CLASSE MENU UMA STRING
	 * COM ESSAS INFORMA��ES;
	 * 
	 * @return
	 */
	public String listarContatos() {
		String contatosListados = "";
		
		for (int i = 0; i < contatos.length; i++) {
			if (this.contatos[i] != null) {
				contatosListados += Integer.toString(i + 1) + " - " 
				+ contatos[i].getNome() + " " + contatos[i].getSobrenome() + "\n";

			}
		}
		
		// EXCEPTION
		if (contatosListados.trim().equals(""))
			throw new NullPointerException("N�O EXISTEM CONTATOS CADASTRADOS!!");
		
		contatosListados = contatosListados.substring(0, contatosListados.length() - 1);
		return contatosListados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
		return result;
	}
	
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
