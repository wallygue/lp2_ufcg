package lab3tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lab3.Agenda;

/**
 * CLASSE RESPONSAVEL POR TESTAR TODOS O METODOS DA CLASSE AGENDA;
 * 
 * @author Wallyngson Guedes
 *
 */
class AgendaTest {

	private Agenda agenda = new Agenda();
	private Agenda agenda1 = new Agenda();
	private Agenda agenda2 = new Agenda();
	private Agenda agenda3 = new Agenda();
	private Agenda agenda4 = new Agenda();

	@BeforeEach
	void setUp() throws Exception {
		agenda1.cadastraContato(1, "Wall", "Guedes", "(83) 98888.8888");
		agenda3.cadastraContato(1, "Wall", "Guedes", "(83) 98888.8888");
		agenda2.cadastraContato(1, "Rha", "Estrela", "(83) 98888.8888");
		agenda2.cadastraContato(2, "Bk", "Guedes", "(83) 98888.8888");
		agenda2.cadastraContato(3, "Bielly", "Ferreira", "(83) 98888.8888");
		agenda4.cadastraContato(1, "Wall", "Guedes", "(83) 98888.8888");
		agenda4.cadastraContato(4, "Wall", "Ferreira", "(83) 99999.9999");

		agenda2.adicionaNivelAmizade(1, 1);
		agenda2.adicionaNivelAmizade(2, 1);
		agenda1.adicionaNivelAmizade(1, 2);
		agenda4.adicionaNivelAmizade(1, 2);
		agenda4.adicionaNivelAmizade(4, 5);
	}

	/**
	 * TESTE CADASTRAR CONTATOS
	 */

	@Test
	@DisplayName("Teste do metodo cadastraContato()")
	// DEVE DAR ERRADO, POIS A POSICAO MAIOR QUE O TAMANHO DO ARRAY;
	void testCadastraContato() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			agenda1.cadastraContato(1200, "Wall", "Guedes", "8888.8888");
		});
	}

	@Test
	@DisplayName("Teste Cadastrar contato em uma posicao ja existente")
	// ESTE TESTE DEVE OCORRER TUDO BEM, POIS PODE CADASTRAR CONTATOS
	// SOB OUTRO SEM ERROS;
	void testCadastraContato1() {
		assertEquals("CADASTRO REALIZADO COM SUCESSO!!", agenda.cadastraContato(1, "Novo", "Contato", "986846.7515"));
	}

	@Test
	@DisplayName("Teste do metodo cadastraContato()")
	// DEVE CADASTRAR CORRETAMENTE, POSICAO 1 TESTADA;
	void testCadastraContato2() {
		assertEquals("CADASTRO REALIZADO COM SUCESSO!!",
				agenda.cadastraContato(1, "Wall", "Guedes", "(83) 98888.8888"));
	}

	@Test
	@DisplayName("Teste do metodo cadastraContato()")
	// DEVE CADASTRAR CORRETAMENTE, POSICAO 100 TESTADA;
	void testCadastraContato3() {
		assertEquals("CADASTRO REALIZADO COM SUCESSO!!",
				agenda.cadastraContato(100, "Rha", "Estrela", "(83) 98888.8888"));
	}

	/**
	 * TESTE LISTAR CONTATOS
	 */

	@Test
	@DisplayName("Teste do metodo listarContato()")
	// DEVE DAR UM ERRO, POIS NAO EXISTE NENHUM CONTATO CADASTRADO NA AGENDA PARA
	// LISTAR;
	void testListarContatos() {
		assertThrows(NullPointerException.class, () -> {
			agenda.listarContatos();
		});
	}

	@Test
	@DisplayName("Teste do metodo listarContatos()")
	// TESTE CORRETO, IMPRESSAO DE UMA STRING LINHA A LINHA, COM UMA REPRESENTACAO
	// TEXTUAL DOS CONTATOS;
	void testListarContatos1() {
		assertEquals("1 - Wall Guedes", agenda1.listarContatos());
	}

	@Test
	@DisplayName("Teste do metodo listarContatos()")
	// TESTE CORRETO, IMPRESSAO DE UMA STRING LINHA A LINHA, COM UMA REPRESENTACAO
	// TEXTUAL DOS CONTATOS;
	void testListarContatos2() {
		assertEquals("1 - Rha Estrela\n" + "2 - Bk Guedes\n" + "3 - Bielly Ferreira", agenda2.listarContatos());
	}

	/**
	 * TESTE EXIBIR CONTATOS
	 */

	@Test
	@DisplayName("Teste metodo exibirContato()")
	// DEVE DAR ERRO, POIS NA POSICAO INFORMADA NAO EXISTE CONTATO CADASTRADO;
	void testExibirContato() {
		assertThrows(NullPointerException.class, () -> {
			agenda1.exibirContato(2);
		});
	}

	@Test
	@DisplayName("Teste metodo exibirContato()")
	// DEVE DAR ERRO, POIS A POSICAO INFORMADA EH MAIOR QUE O TAMANHO DA AGENDA;
	void testExibirContato1() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			agenda1.exibirContato(200);
		});
	}

	@Test
	@DisplayName("Teste do metodo exibirContato()")
	// ESTE TESTE ESTAH CORRETO, IMPRIMIR UMA REPRESENTACAO TEXTUAL DO CONTATO
	// CADASTRADO;
	void testExibirContato2() {
		assertEquals("Wall Guedes - (83) 98888.8888", agenda1.exibirContato(1));
	}

	/**
	 * TESTE EQUALS
	 */

	@Test
	@DisplayName("Teste do metodo equals(), CORRETO")
	// DEVE RETORNAR TRUE PORQUE AS DUAS AGENDAS
	// TEM TODOS OS CONTATOS IUAIS NAS MESMAS POSICOES;
	void testEquals() {
		assertEquals(true, this.agenda1.equals(this.agenda3));
	}

	@Test
	@DisplayName("Teste do metodo equals(), FALSO")
	// DEVE RETORNAR FALSE PORQUE AS DUAS AGENDAS
	// NAO TEM TODOS OS CONTATOS IGUAIS NAS MESMAS POSICOES;
	void testEquals2() {
		assertEquals(false, this.agenda1.equals(this.agenda2));
	}

	/**
	 * TESTE BONUS
	 */

	@Test
	@DisplayName("Teste do metodo adicionaContato(), CONTATO VALIDO")
	// O TESTE DEVE DAR CERTO SEM NENHUM PROBLEMA
	// O CONTATO EXISTE E O NIVEL FOI ADICIONADO COM SUCESSO;
	void testAdicionaContato() {
		assertEquals("O nivel de amizade foi adicionado ao contato com sucesso!", agenda1.adicionaNivelAmizade(1, 1));
	}

	@Test
	@DisplayName("Teste do metodo adicionaContato(), CONTATO INVALIDO")
	// O TESTE DEVE DAR CERTO SEM NENHUM PROBLEMA
	// O CONTATO NAO EXISTE NESTA POSICAO POR ISSO NAO EH POSSIVEL ADICIONAR;
	void testAdicionaContato1() {
		assertEquals("Nao foi possivel adicionar o nivel de amizade ao contato!\n"
				+ "Nao existe contato na posicao informada.", agenda1.adicionaNivelAmizade(2, 1));
	}

	@Test
	@DisplayName("Teste do metodo adicionaContato(), NIVEL 0 INVALIDO")
	// DEVE RESULTAR EM EXCESSAO PORQUE NAO SE PODE ADICIONAR
	// UM NIVEL MENOR QUE 1 OU MAIOR QUE 5;
	public void testAdicionaContato2() {
		assertThrows(IllegalArgumentException.class, () -> {
			agenda1.adicionaNivelAmizade(1, 0);
		});
	}

	@Test
	@DisplayName("Teste do metodo adicionaContato(), NIVEL 6 INVALIDO")
	// DEVE RESULTAR EM EXCESSAO PORQUE NAO SE PODE ADICIONAR
	// UM NIVEL MENOR QUE 1 OU MAIOR QUE 5;
	public void testAdicionaContato3() {
		assertThrows(IllegalArgumentException.class, () -> {
			agenda1.adicionaNivelAmizade(1, 6);
		});
	}

	@Test
	@DisplayName("Teste do metodo contatosPorAmizade()")
	// NAO EXISTEM CONTATOS COM ESTE NIVEL DE AMIZADE, DEVE RETORNAR UMA
	// MENSAGEM INFORMANDO QUE NAO EXISTEM CONTATOS COM ESTE NIVEL DE AMIZADE;
	public void testContatosPorAmizade() {
		assertEquals(
				"Nao existem contatos com este nivel de amizade!\n"
						+ "Informe outro nivel de amizade ou cadastre este nivel de amizade em um contato.",
				agenda.contatosPorAmizade(1));
	}

	@Test
	@DisplayName("Teste do metodo contatosPorAmizade(), CORRETO")
	// ESTE METODO IMPRIMIRA TODOS OS CONTATOS COM O MESMO NIVEL DE AMIZADE
	// CORRETAMENTE;
	public void testContatosPorAmizade1() {
		assertEquals("Rha Estrela - (83) 98888.8888\n" + "Bk Guedes - (83) 98888.8888", agenda2.contatosPorAmizade(1));
	}

	@Test
	@DisplayName("Teste do metodo contatosPorAmizade(), CORRETO")
	// RETORNA UMA STRING COM O NOME DE UM CONTATO, SE SOMENTE ESTIVER
	// O MESMO CADASTRADO COM O DETERMINADO NIVEL DE AMIZADE;
	public void testContatosPorAmizade2() {
		assertEquals("Wall Guedes - (83) 98888.8888", agenda1.contatosPorAmizade(2));
	}

	@Test
	@DisplayName("Test do metodo contatosPorNome()")
	// ESTE METODO DEVE RETORNAR UMA MENSAGEM INFORMANDO QUE NAO EXISTE
	// CONTATOS COM O NOME PESQUISADO;
	public void testContatosPorNome() {
		assertEquals("Nao existe nenhum contato cadastrado com este nome!", agenda1.contatosPorNome("Rha"));
	}

	@Test
	@DisplayName("Teste do metodo contatoPorNome(), CORRETO")
	// QUANDO EXISTE UM CONTATO COM O MESMO NOME, ELE
	// IMPRIME ESTE CONTATO NORMALMENTE;
	public void testContatosPorNome1() {
		assertEquals("Wall Guedes - (83) 98888.8888", agenda1.contatosPorNome("Wall"));
	}

	@Test
	@DisplayName("Teste do metodo contatoPorNome(), CORRETO")
	// QUANDO EXISTE MAIS DE UM CONTATO COM O MESMO NOME, DEVE
	// SE IMPRIMIR UMA LISTA LINHA-A-LINHA COM OS NOMES DOS CONTATOS;
	public void testContatosPorNome2() {
		assertEquals("Wall Guedes - (83) 98888.8888\n" + "Wall Ferreira - (83) 99999.9999",
				agenda4.contatosPorNome("Wall"));
	}

	@Test
	@DisplayName("Teste do metodo qtdNiveisContatos()")
	// RETORNA 0 PORQUE NAO EXISTE NENHUM CONTATO CADASTRADO COM ESTE NIVEL;
	public void testQtdNiveisContatos() {
		assertEquals(0, agenda1.qtdNiveisContato(4));

	}

	@Test
	@DisplayName("Teste do metodo qtdNiveisContatos()")
	// RETORNA 2 PORQUE EXISTEM DOIS CONTATOS COM ESTE NIVEL DE AMIZADE;
	public void testQtdNiveisContatos1() {
		assertEquals(2, agenda2.qtdNiveisContato(1));
	}

	@Test
	@DisplayName("Teste do metodo mediaAmizades()")
	// DEVE RETORNAR UMA EXCESSAO, POIS A QUANTIDADE DE NIVEIS EH 0, ENTAO
	// QUALQUER DIVISAO POR 0 RETORNA ESTA EXCESSAO;
	public void testMediaAmizade() {
		assertThrows(ArithmeticException.class, () -> {
			agenda.mediaAmizade();
		});
	}

	@Test
	@DisplayName("Teste do metodo mediaAmizade(), DOUBLE")
	// ESTE METODO RETORNA AO USUARIO UM A MEDIA DE NIVEIS DE
	// AMIZADES DE UMA AGENDA;
	public void testMediaAmizade1() {
		assertEquals(3.5, agenda4.mediaAmizade());
	}

	@Test
	@DisplayName("Teste do metodo mediaAmizade()")
	// ESTE METODO RETORNA AO USUARIO UM A MEDIA DE NIVEIS DE
	// AMIZADES DE UMA AGENDA;
	public void testMediaAmizade2() {
		assertEquals(1.0, agenda2.mediaAmizade());
	}

}
