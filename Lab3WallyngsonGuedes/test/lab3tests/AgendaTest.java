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

	@BeforeEach
	void setUp() throws Exception {
		agenda1.cadastraContato(1, "Wall", "Guedes", "(83) 98888.8888");
		agenda3.cadastraContato(1, "Wall", "Guedes", "(83) 98888.8888");
		agenda2.cadastraContato(1, "Rha", "Estrela", "(83) 98888.8888");
		agenda2.cadastraContato(2, "Bk", "Guedes", "(83) 98888.8888");
		agenda2.cadastraContato(3, "Bielly", "Ferreira", "(83) 98888.8888");
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
	
	@Test
	@DisplayName("Teste do metodo adicionaContato(), CADASTRO CORRETO")
	// O TESTE DEVE DAR CERTO SEM NENHUM PROBLEMA
	// O CONTATO EXISTE E O NIVEL FOI ADICIONADO COM SUCESSO;
	void testAdicionaContato() {
		assertEquals("O nivel de amizade foi adicionado ao contato com sucesso!", agenda1.adicionaNivelAmizade(1, 1));
	}
	
	@Test
	@DisplayName("Teste do metodo adicionaContato(), CADASTRO INCORRETO")
	// O TESTE DEVE DAR CERTO SEM NENHUM PROBLEMA
	// O CONTATO  NAO EXISTE NESTA POSICAO POR ISSO NAO EH POSSIVEL ADICIONAR;
	void testAdicionaContato1() {
		assertEquals("Nao foi possivel adicionar o nivel de amizade ao contato!\n"
				+ "Nao existe contato na posicao informada.", agenda1.adicionaNivelAmizade(2, 1));
	}
	
	
}
