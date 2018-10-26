package lab5;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe Controller que controla o Sistema SAGA. 
 * Sistema para Auto-Gestão de comércio de Alimentos - SAGA;
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
		if (this.valida(cpf))
			return "Cliente ja esta cadastrado no sistema!";

		this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
		return "Cliente cadastrado com sucesso!";

	}

	public String retornaCliente(String cpf) {
		if (valida(cpf))
			return this.clientes.get(cpf).toString();
		return "Este cliente nao esta cadastrado!";

	}

	public String editarCliente(String cpf, String nome, String email, String localizacao) {
		if (valida(cpf))
			return this.clientes.get(cpf).editarCliente(nome, email, localizacao);
		return "Cliente nao cadastrado!";
	}
	
	public String removerCliente(String cpf) {
		if (this.valida(cpf)) {
			this.clientes.remove(cpf);
			return "Cliente removido com sucesso!";
		}

		return "Cliente nao cadastrado!";
	}
	
	private boolean valida(String valor) {
		if (this.clientes.containsKey(valor))
			return true;
		return false;
	}

	// FORNECEDOR
	
	public String cadastrarFornecedor(String nome, String email, String telefone) {
		if (this.valida(nome))
			return "Fornecedor ja esta cadastrado no sistema!";

		this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		return "Fornecedor cadastrado com sucesso!";

	}
	
	public String retornaFornecedor(String nome) {
		if (valida(nome))
			return this.fornecedores.get(nome).toString();
		return "Este cliente nao esta cadastrado!";

	}
	
	public String editarFornecedor(String nome, String email, String telefone) {
		if (valida(nome))
			return this.fornecedores.get(nome).editarFornecedor(email, telefone);
		return "Fornecedor nao cadastrado!";
	}
	
	public String removerFornecedor(String nome) {
		if (this.valida(nome)) {
			this.fornecedores.remove(nome);
			return "Fornecedor removido com sucesso!";
		}

		return "Fornecedor nao cadastrado!";
	}
	
	
	
	
	
}
