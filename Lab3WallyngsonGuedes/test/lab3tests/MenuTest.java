package lab3tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lab3.Agenda;

/**
 * CLASSE RESPONSÁVEL POR FAZER TODOS OS TESTES DOS MÉTODOS DA CLASSE MENU;
 * 
 * @author Wallyngson Guedes
 *
 */
class MenuTest {

	Agenda agenda1 = new Agenda();
	Agenda agenda;

	@BeforeEach
	void setUp() throws Exception {
		agenda1.cadastraContato(1, "Wall", "Guedes", "(83) 98888.8888");
	}

	// TESTE CADASTRAR CONTATOS

	@Test
	@DisplayName("Teste do método cadastraContato()")
	// DEVE DAR ERRADO, POIS A POSIÇÃO É MAIOR QUE O TAMANHO DO ARRAY;
	void testMain() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			agenda1.cadastraContato(1200, "Wall", "Guedes", "8888.8888");
		});
	}

	@Test
	@DisplayName("Teste do método cadastraContato()")
	// DEVE CADASTRAR CORRETAMENTE;
	void testMain1() {
		assertEquals("CADASTRO REALIZADO COM SUCESSO!!",
				agenda1.cadastraContato(1, "Wall", "Guedes", "(83) 98888.8888"));
	}

	// TESTE LISTAR CONTATOS

	@Test
	@DisplayName("Teste do método listarContato()")
	// DEVE DAR UM ERRO, POIS NÃO EXISTE NENHUM CONTATO CADASTRADO NA AGENDA PARA
	// LISTAR;
	void testMain2() {
		assertThrows(NullPointerException.class, () -> {
			agenda.listarContatos();
		});
	}

	@Test
	@DisplayName("Teste do método listarContatos()")
	// TESTE CORRETO, IMPRESSÃO DE UMA STRING LINHA A LINHA, COM UMA REPRESENTAÇÃO
	// TEXTUAL
	// DOS CONTATOS;
	void testMain3() {
		assertEquals("1 - Wall Guedes", agenda1.listarContatos());
	}

	// TESTE EXIBIR CONTATOS

	@Test
	@DisplayName("Teste metodo exibirContato()")
	// DEVE DAR ERRO, POIS NA POSIÇÃO INFORMADA NÃO EXISTE CONTATO CADASTRADO;
	void testMain4() {
		assertThrows(NullPointerException.class, () -> {
			agenda1.exibirContato(2);
		});
	}

	@Test
	@DisplayName("Teste metodo exibirContato()")
	// DEVE DAR ERRO, POIS A POSIÇÃO INFORMADA É MAIOR QUE O TAMANHO DA AGENDA;
	void testMain5() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			agenda1.exibirContato(200);
		});
	}

	@Test
	@DisplayName("Teste do método exibirContato()")
	// ESTE TESTE ESTÁ CORRETO, IMPRIMIRÁ UMA REPRESENTAÇÃO TEXTUAL DO CONTATO
	// CADASTRADO;
	void testMain6() {
		assertEquals("Wall Guedes - (83) 98888.8888", agenda1.exibirContato(1));
	}

}
