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
	
	Contato c1;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new Contato("Wall", "Guedes", "98888.8888");
	}
	
	@Test
	void testGetNome() {
		assertEquals("Wall", c1.getNome());
	}
	
	@Test
	void testGetSobrenome() {
		assertEquals("Guedes", c1.getSobrenome());
	}
	
	@Test
	void testGetTelefone() {
		assertEquals("98888.8888", c1.getTelefone());
	}
	
	@Test
	void testToString() {
		assertEquals("Wall Guedes - 98888.8888", c1.toString());
	}
}
