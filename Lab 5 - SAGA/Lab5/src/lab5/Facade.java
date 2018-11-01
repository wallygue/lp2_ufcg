package lab5;

public class Facade {

	private ControllerSaga controller;

	public Facade() {
		controller = new ControllerSaga();
	}

	// CLIENTE

	public String cadastrarCliente(String cpf, String nome, String email, String localizacao) {
		return this.controller.cadastrarCliente(cpf, nome, email, localizacao);

	}

	public String retornaCliente(String cpf) {
		return this.controller.retornaCliente(cpf);
	}

	public String listarClientes() {
		return this.controller.listarClientes();
	}

	public String editarCliente(String cpf, String nome, String email, String localizacao) {
		return this.controller.editarCliente(cpf, nome, email, localizacao);
	}

	public String removerCliente(String cpf) {
		return this.controller.removerCliente(cpf);
	}

	// FORNECEDOR

	public String cadastrarFornecedor(String nome, String email, String telefone) {
		return this.controller.cadastrarFornecedor(nome, email, telefone);
	}

	public String retornarFornecedor(String nome) {
		return this.controller.retornaFornecedor(nome);
	}

	public String listarFornecedores() {
		return this.controller.listarFornecedores();
	}

	public String editarFornecedor(String nome, String email, String telefone) {
		return this.editarFornecedor(nome, email, telefone);
	}

	public String removerFornecedor(String nome) {
		return this.removerFornecedor(nome);
	}

	// PRODUTO

	public String adicionarProduto(String fornecedor, String nomeProduto, String descricao, String preco) {
		return this.controller.adicionarProduto(fornecedor, nomeProduto, descricao, preco);
	}

	public String retornaProduto(String fornecedor, String nomeProduto, String descricao) {
		return this.controller.retornaProduto(fornecedor, nomeProduto, descricao);
	}

	public String editarPreco(String fornecedor, String nomeProduto, String descricao, String preco) {
		return this.controller.editarPreco(fornecedor, nomeProduto, descricao, preco);
	}

//	public String listarProdutos() {
//		return this.controller.listarProdutos();
//	}

	public String listarProdutosDeUmFornecedor(String fornecedor) {
		return this.controller.listarProdutosDeUmFornecedor(fornecedor);
	}
}
