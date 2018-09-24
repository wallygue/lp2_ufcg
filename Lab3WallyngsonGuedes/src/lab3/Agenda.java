package lab3;

import java.util.Arrays;

/**
 * ESTA CLASSE EH UMA REPRESENTACAO DE UMA AGENDA, ONDE ï¿½ POSSIVEL ADICIONAR
 * CONTATOS, LISTAR CONTATOS E EXIBIR OS CONTATOS CADASTRADOS NESTA AGENDA;
 * 
 * @author Wallyngson Guedes
 *
 */
public class Agenda {

	/**
	 * ARRAY DE CONTATOS QUE VAI ARMAZENAR TODOS OS CONTATOS, ESSE ARRAY POSSUI 100
	 * POSICOES;
	 */
	private Contato[] contatos = new Contato[100];
	private Contato contato;

	public Agenda() {
	}

	/**
	 * METODO RESPONSAVEL POR CADASTRAR OS CONTATOS NO ARRAY DE CONTATOS. RECEBE OS
	 * PARAMETROS DA CLASSE MENU, A POSICAO ONDE DEVE SER CADASTRADO, O NOME,
	 * SOBRENOME E TELEFONE;
	 * 
	 * @param posicao
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 * @return
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao > this.contatos.length || posicao < 1)
			throw new IndexOutOfBoundsException("Cadastro nao realizado!\n"
					+ "A posicao informada excede o limite de posicoes.\n" + "Informe uma posicao entre 1 e 100.");

		contato = new Contato(nome, sobrenome, telefone);
		contatos[posicao - 1] = contato;
		return "CADASTRO REALIZADO COM SUCESSO!!";

	}

	/**
	 * ESTE METODO EXIBE O CONTATO CADASTRADO EM UMA DETERMINADA POSICAO INFORMADA
	 * PELO USUARIO;
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
	 * METODO QUE LISTA TODOS OS CONTATOS CADASTRADOS LINHA A LINHA, E RETORNA A
	 * CLASSE MENU UMA STRING COM ESSAS INFORMACOES;
	 * 
	 * @return
	 */
	public String listarContatos() {
		String contatosListados = "";

		for (int i = 0; i < contatos.length; i++) {
			if (this.contatos[i] != null) {
				contatosListados += Integer.toString(i + 1) + " - " + contatos[i].getNome() + " "
						+ contatos[i].getSobrenome() + "\n";

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
	 * METODO EQUALS QUE COMPARA SE DUAS AGENDAS SAO IGUAIS; VERIFICA SE O NOME E O
	 * SOBRENOME DE CADA CONTATO CONTIDO NA AGENDA Sï¿½O IGUAIS, SE TODAS AS
	 * POSICOES FOREM IGUAIS, ENTAO AS AGENDAS TAMBEM SAO;
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
		}
		return true;
	}

	// BONUS

	/**
	 * ESTE METODO CHAMA A CLASSE CONTATO E ATRAVES DO SET ATRIBUI UM NIVEL DE
	 * AMIZADE AO CONTATO INDICADO, RECEBENDO A POSICAO DO CONTATO A ADICIONAR O
	 * NIVEL DE AMIZADE;
	 * 
	 * FALTA CASOS DE TESTE;
	 * 
	 * @param nivelAmizade
	 */
	public String adicionaNivelAmizade(int posicao, int nivelAmizade) {
		if (validaContato(posicao) == true) {
			contatos[posicao - 1].SetNivelAmizade(nivelAmizade);
			return "O nivel de amizade foi adicionado ao contato com sucesso!";
		}
		return "Nao foi possivel adicionar o nivel de amizade ao contato!\n"
				+ "Nao existe contato na posicao informada.";

	}

	/**
	 * ESTE METODO RECEBE UM NIVEL DE AMIZADE PARA PESQUISAR TODOS OS CONTATOS QUE
	 * POSSUEM O MESMO NIVEL DE AMIZADE E RETORNA UMA STRING COM OS CONTATOS COM
	 * ESTE INDICADOR;
	 * 
	 * @param nivelAmizadePesquisar
	 * @return
	 */

	private boolean validaContato(int posicao) {
		return contatos[posicao - 1] != null;
	}

	public String contatosPorAmizade(int nivelAmizadePesquisar) {
		String contatosPorNiveisAmizade = "";

		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i].getNivelAmizade() == nivelAmizadePesquisar)
				contatosPorNiveisAmizade = contatos[i].toString() + "\n";
		}
		return contatosPorNiveisAmizade.substring(0, contatosPorNiveisAmizade.length() - 1);

	}

	/**
	 * ESTE METODO PESQUISA NO ARRAY DE CONTATOS TODOS OS CONTATOS QUE POSSUEM O
	 * MESMO NOME E RETORNA UMA REPRESENTACAO TEXTUAL DE TODOS ELES;
	 * 
	 * @param nome
	 * @return
	 */
	public String contatosPorNome(String nome) {
		String contatosPorNome = "";

		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i].getNome().equals(nome))
				contatosPorNome = contatos[i].toString() + "\n";
		}
		return contatosPorNome.substring(0, contatosPorNome.length() - 1);

	}

	/**
	 * ESTE METODO PESQUISA CONTATOS IGUAIS E RETORNA O PRIMEIRO QUE CONTATO QUE
	 * ENCONTRAR IGUAL;
	 * 
	 * @param contatoComparar
	 * @return
	 */
	public Contato pesquisaContatosIguais(Contato contatoComparar) {
		Contato a = null;

		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] == null)
				continue;
			if (contatos[i].equals(contatoComparar)) {
				a = contatos[i];
				break;
			}
		}

		if (a == null)
			throw new NullPointerException("Nao existe contato igual ao informado!\n" + "Informe um novo contato.");

		return a;
	}

	/**
	 * ESTE METODO PERCORRE TODOS OS CONTATOS E VERIFICAM SE QUAIS SAO OS CONTATOS
	 * QUE POSSUEM OS MESMOS NIVEIS DE AMIZADES, SOMAM EM UMA VARIAVEL LOCAL E
	 * RETORNAM ESTA VAR NO FIM A QUEM SOLICITOU;
	 * 
	 * @param nivelAmizade
	 * @return
	 */
	public int qtdNiveisContato(int nivelAmizade) {
		int qtdNiveis = 0;

		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] == null)
				continue;
			if (contatos[i].getNivelAmizade() == nivelAmizade)
				qtdNiveis += 1;
		}

		return qtdNiveis;
	}

	/**
	 * ESTE METODO PERCORRE TODOS CONTATOS DA AGENDA e ADICIONA EM UMA VAR
	 * somaNiveis TODOS OS NIVEIS DOS CONTATOS DA AGENDA, E TAMBÉM ADICIONA EM UMA
	 * VAR qtdNiveis QUANTOS CONTATOS POSSUEM NIVEIS, FAZ A MEDIA E RETORNA ELA;
	 * 
	 * @return
	 */
	public int mediaAmizade() {
		int somaNiveis = 0;
		int qtdNiveis = 0;

		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				somaNiveis += contatos[i].getNivelAmizade();
				if (contatos[i].getNivelAmizade() != 0)
					qtdNiveis += 1;
			}
		}

		int media = (somaNiveis / qtdNiveis);
		return media;
	}
}