package lab3tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lab3.Contato;

/**
 * CLASSE RESPONSÁVEL POR TESTAR TODOS O MÉTODOS DA CLASSE AGENDA;
 * 
 * @author Wallyngson Guedes
 *
 */
class AgendaTest {

	private Contato contato1;

	@BeforeEach
	void setUp() throws Exception {
		contato1 = new Contato("Rha", "Estrela", "(83) 98888.8888");
	}

	@Test
	@DisplayName("Teste do método cadastraContato()")
	// DEVE DAR CORRETO, POIS O CONTATO FOI CADASTRADO CORRETAMENTE;
	void testCadastraContato() {
		assertEquals("Rha", contato1.getNome());
		assertEquals("Estrela", contato1.getSobrenome());
		assertEquals("(83) 98888.8888", contato1.getTelefone());

	}

	@Test
	@DisplayName("Teste de Contrucao do Contato com o sobrenome nulo")
	// DEVE RETORNAR UMA EXCEPTION;
	void testCadastrarContato1() {
		assertThrows(NullPointerException.class, () -> {
			new Contato(null, "Guedes", "98888.8888");
		});
	}

	@Test
	@DisplayName("Teste de Contrucao do Contato com o sobrenome vazio")
	// DEVE RETORNAR UMA EXCEPTION;
	void testCadastrarContato2() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contato(" ", "Guedes", "98888.8888");
		});
	}

	@Test
	@DisplayName("Teste de Contrucao do Contato com o sobrenome nulo")
	// DEVE RETORNAR UMA EXCEPTION;
	void testCadastrarContato3() {
		assertThrows(NullPointerException.class, () -> {
			new Contato("Wall", null, "98888.8888");
		});
	}

	@Test
	@DisplayName("Teste de Contrucao do Contato com o sobrenome vazio")
	// DEVE RETORNAR UMA EXCEPTION;
	void testCadastrarContato4() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contato("Wall", " ", "98888.8888");
		});
	}

	@Test
	@DisplayName("Teste de Contrucao do Contato com o telefone nulo")
	// DEVE RETORNAR UMA EXCEPTION;
	void testCadastrarContato5() {
		assertThrows(NullPointerException.class, () -> {
			new Contato("Wall", "Guedes", null);
		});
	}

	@Test
	@DisplayName("Teste de Contrucao do Contato com o telefone vazio")
	// DEVE RETORNAR UMA EXCEPTION;
	void testCadastrarContato6() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contato("Wall", "Guedes", " ");
		});
	}

	@Test
	// DEVE DAR CORRETO, POIS O CONTATO A SER EXIBIDO FOI CADASTRADO CORRETAMENTE
	void testExibirContato() {
		assertEquals("Rha Estrela - (83) 98888.8888", contato1.toString());
	}
}
