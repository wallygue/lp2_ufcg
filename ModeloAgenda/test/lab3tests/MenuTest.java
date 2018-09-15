package lab3tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab3.Agenda;

class MenuTest {

	Agenda agenda1 = new Agenda();

	@BeforeEach
	void setUp() throws Exception {
		agenda1.cadastraContato(1, "WAll", "Guedes", "(83) 98888.8888");
	}

	@Test
	void testMain() {
		assertEquals("1 - Wall Guedes", agenda1.listarContatos());
		assertEquals("Wall Guedes - (83) 98888.8888", agenda1.exibirContato(1));
	}

}
