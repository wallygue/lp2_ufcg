package lab5;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe Controller que controla o Sistema SAGA. Sistema para Auto-Gestao de
 * comercio de Alimentos - SAGA;
 * 
 * @author Wallyngson Guedes
 *
 */
public class ControllerSaga {

	private Map<String, Cliente> clientes;
	private Map<String, Fornecedor> fornecedores;

	public ControllerSaga() {
		this.clientes = new HashMap<>();
		this.fornecedores = new HashMap<>();
	}

	// CLIENTES

	public String cadastrarCliente(String cpf, String nome, String email, String localizacao) {
		this.parametroInvalido(cpf);

		if (this.validaCliente(cpf))
			return "Cliente ja esta cadastrado no sistema!";

		this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
		return "Cliente cadastrado com sucesso!";

	}

	public String retornaCliente(String cpf) {
		this.parametroInvalido(cpf);

		if (validaCliente(cpf))
			return this.clientes.get(cpf).toString();
		return "Este cliente nao esta cadastrado!";

	}

	public String editarCliente(String cpf, String nome, String email, String localizacao) {
		this.parametroInvalido(cpf);

		if (validaCliente(cpf))
			return this.clientes.get(cpf).editarCliente(nome, email, localizacao);
		return "Cliente nao cadastrado!";
	}

	public String removerCliente(String cpf) {
		this.parametroInvalido(cpf);

		if (this.validaCliente(cpf)) {
			this.clientes.remove(cpf);
			return "Cliente removido com sucesso!";
		}

		return "Cliente nao cadastrado!";
	}

	// FORNECEDOR

	public String cadastrarFornecedor(String nome, String email, String telefone) {
		this.parametroInvalido(nome);

		if (this.validaFornecedor(nome))
			return "Fornecedor ja esta cadastrado no sistema!";

		this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		return "Fornecedor cadastrado com sucesso!";

	}

	public String retornaFornecedor(String nome) {
		this.parametroInvalido(nome);

		if (validaFornecedor(nome))
			return this.fornecedores.get(nome).toString();
		return "Este cliente nao esta cadastrado!";

	}

	public String editarFornecedor(String nome, String email, String telefone) {
		this.parametroInvalido(nome);

		if (validaFornecedor(nome))
			return this.fornecedores.get(nome).editarFornecedor(email, telefone);
		return "Fornecedor nao cadastrado!";
	}

	public String removerFornecedor(String nome) {
		this.parametroInvalido(nome);

		if (this.validaFornecedor(nome)) {
			this.fornecedores.remove(nome);
			return "Fornecedor removido com sucesso!";
		}

		return "Fornecedor nao cadastrado!";
	}

	// PRODUTOS

	public String adicionarProduto(String fornecedor, String nomeProduto, String descricao, float preco) {
		this.parametroInvalido(fornecedor);

		if (validaFornecedor(fornecedor)) 
			return this.fornecedores.get(fornecedor).cadastrarProduto(nomeProduto, descricao, preco);

		return "Fornecedor nao cadastrado!";
	}
	
	public String retornaProduto(String fornecedor, String nomeProduto, String descricao) {
		this.parametroInvalido(fornecedor);
		
		if (validaFornecedor(fornecedor))
			return this.fornecedores.get(fornecedor).retornaProduto(nomeProduto, descricao);
		
		return "Fornecedor nao cadastrado!";
	}
	
	public String editarPreco(String fornecedor, String nomeProduto, String descricao, float preco) {
		this.parametroInvalido(fornecedor);
		
		if (validaFornecedor(fornecedor))
			return this.fornecedores.get(fornecedor).editarPreco(nomeProduto, descricao, preco);
		
		return "Fornecedor nao cadastrado!";
	}

	// METODOS PRIVADOS
	
	private boolean validaCliente(String cpf) {
		if (this.clientes.containsKey(cpf))
			return true;
		return false;
	}
	
	private boolean validaFornecedor(String nome) {
		if (this.clientes.containsKey(nome))
			return true;
		return false;
	}

	private void parametroInvalido(String valor) {
		if (valor == null)
			throw new NullPointerException();

		if (valor.equals(""))
			throw new IllegalArgumentException();

	}





}
