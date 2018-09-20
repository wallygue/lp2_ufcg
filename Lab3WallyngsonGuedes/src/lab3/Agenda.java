package lab3;

import java.util.Arrays;

/**
 * ESTA CLASSE EH UMA REPRESENTACAO DE UMA AGENDA, ONDE ï¿½
 * POSSIVEL ADICIONAR CONTATOS, LISTAR CONTATOS E EXIBIR
 * OS CONTATOS CADASTRADOS NESTA AGENDA;
 * 
 * @author Wallyngson Guedes
 *
 */
public class Agenda {
	
	/**
	 * ARRAY DE CONTATOS QUE VAI ARMAZENAR TODOS OS CONTATOS,
	 * ESSE ARRAY POSSUI 100 POSICOES;
	 */
	private Contato[] contatos = new Contato[100];

	public Agenda() {
	}

	/**
	 * METODO RESPONSAVEL POR CADASTRAR OS CONTATOS NO ARRAY
	 * DE CONTATOS. RECEBE OS PARAMï¿½TROS DA CLASSE MENU, A 
	 * POSICAO ONDE DEVE SER CADASTRADO, O NOME, SOBRENOME E 
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
			throw new IndexOutOfBoundsException("POSICAO INVALIDA!!");
		
		if (nome != null && sobrenome != null && telefone != null) {
					Contato contato = new Contato(nome, sobrenome, telefone);
					contatos[posicao - 1] = contato;
					return "CADASTRO REALIZADO COM SUCESSO!!";
					
		} return "CADASTRO NAO REALIZADO!!";

	}

	/**
	 * ESTE METODO EXIBE O CONTATO CADASTRADO EM
	 * UMA DETERMINADA POSICAO INFORMADA PELO USUARIO;
	 * 
	 * @param posicao
	 * @return
	 */
	public String exibirContato(int posicao) {
		// EXCEPTIONS
		if (this.contatos[posicao - 1] == null) 
			throw new NullPointerException("NAO EXISTE CONTATO NESTA POSICAO!!");
		if (posicao > this.contatos.length || posicao < 1)
			throw new IndexOutOfBoundsException("POSICAO SOLICITADA EH INVALIDA!!");
		
		return contatos[posicao - 1].toString();
		
	}
	
	/**
	 * METODO QUE LISTA TODOS OS CONTATOS CADASTRADOS 
	 * LINHA A LINHA, E RETORNA A CLASSE MENU UMA STRING
	 * COM ESSAS INFORMACOES;
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
			throw new NullPointerException("NAO EXISTEM CONTATOS CADASTRADOS!!");
		
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
	
	/* 
	 * METODO EQUALS QUE COMPARA SE DUAS AGENDAS SAO IGUAIS;
	 * VERIFICA SE O NOME E O SOBRENOME DE CADA CONTATO CONTIDO NA AGENDA
	 * SÃO IGUAIS, SE TODAS AS POSICOES FOREM IGUAIS, ENTAO AS AGENDAS
	 * TAMBEM SAO;
	 */
	@Override
	public boolean equals(Object obj) {
		Agenda novaAgenda = (Agenda) obj;
		for (int i = 0; i < contatos.length; i++) {
			if (this.contatos[i] == null)
				continue;
			if (!this.contatos[i].equals(novaAgenda.contatos[i])) {
				return false;
			} 
		} return true;
	}
}