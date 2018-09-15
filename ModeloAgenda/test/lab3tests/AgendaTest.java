package lab3tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab3.Contato;

class AgendaTest {
	
	private Contato cont;
	
	@BeforeEach
	void setUp() throws Exception {
		cont = new Contato("Rha", "Estrela", "(83) 98888.8888");
//		Contato[] listaContatos = new Contato[100];
	}

	@Test
	void testCadastraContato() {
		Contato contato1 = new Contato("Wall", "Guedes", "(83) 99999.9999");
		assertEquals("Wall", contato1.getNome());
		assertEquals("Guedes", contato1.getSobrenome());
		assertEquals("(83) 99999.9999", contato1.getTelefone());
		
	}

	@Test
	void testExibirContato() {
		assertEquals("Rha Estrela - (83) 98888.8888", cont.toString());
	}

	@Test
	void testListarContatos() {

	}

}
