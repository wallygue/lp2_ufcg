package lab3tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lab3.Contato;

/**
 * ESTA CLASSE VAI TESTAR A CLASSE CONTATO;
 * 
 * @author Wallyngson Guedes
 *
 */
class ContatoTest {
	
	Contato c;
	Contato c1;
	Contato c2;

	@BeforeEach
	void setUp() throws Exception {
		c = new Contato("Casa", "de Papel", "99999.8888");
		c1 = new Contato("Wall", "Guedes", "98888.8888");
		c2 = new Contato("Wall", "Guedes", "98888.8888");
	}
	
	/**
	 * TESTES DO CONTRUTOR DEVEM DAR CORRETOS TODOS OS CADASTROS;
	 */
	@Test
	@DisplayName("Tests de Construcao do Contato")
	// DEVE DAR CORRETO, POIS TODAS AS INFORMACOES ESTAO CORRETAS;
	void testContato() {
		assertEquals("Rha Estrela - 988888888", new Contato("Rha", "Estrela", "988888888").toString());
	}

	@Test
	@DisplayName("Tests de Construcao do Contato")
	// DEVE DAR CORRETO, POIS TODAS AS INFORMACOES ESTAO CORRETAS;
	void testContato2() {
		assertEquals("a l - 98888.8888", new Contato("a", "l", "98888.8888").toString());
	}
	
	/**
	 * TESTE DAS EXCECOES DA CLASSE CONTATO:
	 * TENTAR CADASTRAR INVALIDOS OU NULOS;
	 */
	
	@Test
	@DisplayName("Teste de Contrucao do Contato com o sobrenome nulo")
	// DEVE RETORNAR UMA EXCEPTION;
	void testContato1() {
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

	/**
	 * TESTE GET E ToSTRING;
	 */
	@Test
	@DisplayName("")
	void testGetNome() {
		assertEquals("Wall", c1.getNome());
	}
	
	@Test
	@DisplayName("")
	void testGetSobrenome() {
		assertEquals("Guedes", c1.getSobrenome());
	}
	
	@Test
	@DisplayName("")
	void testGetTelefone() {
		assertEquals("98888.8888", c1.getTelefone());
	}
	
	@Test
	@DisplayName("")
	void testToString() {
		assertEquals("Wall Guedes - 98888.8888", c1.toString());
	}
	
	/**
	 * TESTE EQUALS;
	 */
	
	@Test
	@DisplayName("Teste equals() CONTATOS DIFERENTES")
	// ESTE TESTE DEVE RETORNAR FALSE, PORQUE OS CONTATOS NAO SAO IGUAIS.
	// O QUE OS FAZ SER IGUAIS EH O NOME E O SEU SOBRENOMES;
	void testEquals() {
		assertEquals(false, c1.equals(c));
		
	}
	
	@Test
	@DisplayName("Teste equals() CONTATOS IGUAIS")
	// ESTE TESTE DEVE RETORNAR TRUE, PORQUE OS CONTATOS SAO IGUAIS.
	// O QUE OS FAZ SER IGUAIS EH O SEU NOME E O SEU SOBRENOMES;
	void testEquals1() {
		assertEquals(true, c1.equals(c2));
	}
}
