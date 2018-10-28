package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lab5.ControllerSaga;

class ControllerTest {

	private ControllerSaga controller;

	@BeforeEach
	void setUp() throws Exception {

		controller = new ControllerSaga();

		controller.cadastrarCliente("123", "Wall", "wall@ccc", "cg");
		controller.cadastrarCliente("122", "Amanda", "amands@ccc", "cg");
		controller.cadastrarCliente("111", "Rhalise", "rha@ccc", "cg");

		controller.cadastrarFornecedor("Josenilda", "nilda@computacao.ufcg.edu.br", "83 98736-5050");
		controller.cadastrarFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		controller.cadastrarFornecedor("Ron Weasley", "rweasley@splab.ufcg.edu.br", "83 99936-5050");

		controller.adicionarProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", 3.00);
		controller.adicionarProduto("Dona Inês", "Bolo", "Bolo de chocolate", 3.00);
		controller.adicionarProduto("Dona Inês", "Tapioca completa", "Tapioca com côco, queijo e manteiga", 3.50);
		
	}

	@Test
	@DisplayName("teste do metodo listarClientes() que ordena todos os clientes por nome.")
	void testListarClientes() {
		assertEquals("Amanda - cg - amands@ccc | Rhalise - cg - rha@ccc | Wall - cg - wall@ccc",
				controller.listarClientes());

	}

	@Test
	@DisplayName("teste do metodo listarFornecedores() que ordena todos os fornecedores por nome.")
	void testListarFornecedores() {
		assertEquals(
				"Dona Inês - dines@gmail.com - 83 9999-5050 | Josenilda - nilda@computacao.ufcg.edu.br - 83 98736-5050 | Ron Weasley - rweasley@splab.ufcg.edu.br - 83 99936-5050",
				controller.listarFornecedores());

	}
	
	@Test
	void test() {
		assertEquals("a", controller.listarProdutosDeUmFornecedor("Dona Inês"));
	}

}
