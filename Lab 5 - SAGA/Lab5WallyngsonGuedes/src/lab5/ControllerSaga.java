package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe Controller do Sistema SAGA. Sistema para Auto-Gestao de comercio de
 * Alimentos;
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

	// CLIENTES OK

	/**
	 * Metodo responsavel por cadastrar Clientes.
	 * 
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param localizacao
	 * 
	 * @return se o cliente ou nao criado;
	 */
	public String cadastrarCliente(String cpf, String nome, String email, String localizacao) {
		this.parametroInvalido(cpf);

		if (this.validaCliente(cpf))
			return "Cliente ja esta cadastrado no sistema!";

		this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
		return "Cliente cadastrado com sucesso!";

	}

	/**
	 * Este metodo retorna o cliente solicitado atraves de sua chave.
	 * 
	 * @param cpf
	 * @return cliente ou uma mensagem informando que ele nao existe;
	 */
	public String retornaCliente(String cpf) {
		this.parametroInvalido(cpf);

		if (validaCliente(cpf))
			return this.clientes.get(cpf).toString();
		return "Este cliente nao esta cadastrado no sistema!";

	}

	/**
	 * Este metodo edita os atributos do cliente solicitado atraves do seu CPF.
	 * 
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param localizacao
	 * @return se o cliente foi ou nao editado;
	 */
	public String editarCliente(String cpf, String nome, String email, String localizacao) {
		this.parametroInvalido(cpf);

		if (validaCliente(cpf))
			return this.clientes.get(cpf).editarCliente(nome, email, localizacao);
		return "Cliente nao cadastrado no sistema!";
	}

	/**
	 * Metodo responsavel por remover um cliente do sistema.
	 * 
	 * @param cpf
	 * @return se o cliente foi ou nao removido;
	 */
	public String removerCliente(String cpf) {
		this.parametroInvalido(cpf);

		if (this.validaCliente(cpf)) {
			this.clientes.remove(cpf);
			return "Cliente removido com sucesso!";
		}

		return "Cliente nao cadastrado no sistema!";
	}

	/**
	 * Este metodo coloca todos os valores de Clientes(Map) em uma List e ordena
	 * pelo nome do cliente.
	 * 
	 * @return lista com os clientes;
	 */
	public String listarClientes() {
		if (this.clientes.size() == 0)
			return "Nao existe nenhum cliente cadastrado nesse sistema.";
		
		List<Cliente> listaClientes = new ArrayList<Cliente>(clientes.values());
		Collections.sort(listaClientes);

		return this.listaDosClientes(listaClientes);
	}
	

	private boolean validaCliente(String cpf) {
		if (this.clientes.containsKey(cpf))
			return true;
		return false;
	}
	

	private String listaDosClientes(List<Cliente> listaClientes) {
		String clientes = "";

		for (int i = 0; i < listaClientes.size(); i++) {
			clientes += listaClientes.get(i).toString() + " | ";
		}

		return clientes.substring(0, clientes.length() - 3);
	}

	// FORNECEDOR OK


	/**
	 * Metodo responsavel por cadastrar um fornecedor no sistema.
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 * @return se o fornecedor ou nao criado;
	 */
	public String cadastrarFornecedor(String nome, String email, String telefone) {
		this.parametroInvalido(nome);

		if (this.validaFornecedor(nome))
			return "Fornecedor ja esta cadastrado no sistema!";

		this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		return "Fornecedor cadastrado com sucesso!";

	}
	

	/**
	 * Este metodo retorna um fornecedor passado como parametro.
	 * 
	 * @param nome
	 * @return se o fornecedor existe ou nao;
	 */
	public String retornaFornecedor(String nome) {
		this.parametroInvalido(nome);

		if (validaFornecedor(nome))
			return this.fornecedores.get(nome).toString();
		return "Fornecedor nao esta cadastrado no sistema!";

	}
	

	/**
	 * Este metodo retorna todos os fornecedores cadastrados no sistema por ordem
	 * alfabetica.
	 * 
	 * @return todos os fornecedores ou se nao existe nenhum;
	 */
	public String listarFornecedores() {
		if (fornecedores.size() == 0)
			return "Nao existe nenhum fornecedor cadastrado no sistema.";
		
		List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>(fornecedores.values());
		Collections.sort(listaFornecedor);

		return this.listaDeFornecedores(listaFornecedor);
	}
	

	/**
	 * Este metodo edita os atributos de um fornecedor.
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 * @return se o fornecedor foi ou nao editado;
	 */
	public String editarFornecedor(String nome, String email, String telefone) {
		this.parametroInvalido(nome);

		if (validaFornecedor(nome))
			return this.fornecedores.get(nome).editarFornecedor(email, telefone);
		return "Fornecedor nao cadastrado no sistema!";
	}
	

	/**
	 * Este metodo remove um fornecedor do sistema atraves do seu nome.
	 * 
	 * @param nome
	 * @return se foi ou nao possivel remove-lo;
	 */
	public String removerFornecedor(String nome) {
		this.parametroInvalido(nome);

		if (this.validaFornecedor(nome)) {
			this.fornecedores.remove(nome);
			return "Fornecedor removido com sucesso!";
		}

		return "Fornecedor nao cadastrado no sistema!";
	}
	

	private boolean validaFornecedor(String nome) {
		if (this.fornecedores.containsKey(nome))
			return true;
		return false;
	}
	

	private String listaDeFornecedores(List<Fornecedor> listaFornecedor) {
		String fornecedores = "";

		for (int i = 0; i < listaFornecedor.size(); i++) {
			fornecedores += listaFornecedor.get(i).toString() + " | ";
		}

		return fornecedores.substring(0, fornecedores.length() - 3);
	}

	// PRODUTOS OK


	/**
	 * Adiciona produtos ao fornecedor.
	 * 
	 * @param fornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return se foi ou nao possivel adicionar o produto;
	 */
	public String adicionarProduto(String fornecedor, String nomeProduto, String descricao, String preco) {
		this.parametroInvalido(fornecedor);

		if (validaFornecedor(fornecedor))
			return this.fornecedores.get(fornecedor).cadastrarProduto(nomeProduto, descricao, preco);

		return "Fornecedor nao cadastrado!";
	}
	

	/**
	 * Metodo que retorna um produto pelo seu nome.
	 * 
	 * @param fornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @return se o produto existe ou nao;
	 */
	public String retornaProduto(String fornecedor, String nomeProduto, String descricao) {
		this.parametroInvalido(fornecedor);

		if (validaFornecedor(fornecedor))
			return this.fornecedores.get(fornecedor).retornaProduto(nomeProduto, descricao);

		return "Fornecedor nao cadastrado!";
	}
	

	/**
	 * Edita o preco do produto passado como parametro.
	 * 
	 * @param fornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return se o preco foi ou nao editado;
	 */
	public String editarPreco(String fornecedor, String nomeProduto, String descricao, String preco) {
		this.parametroInvalido(fornecedor);

		if (validaFornecedor(fornecedor))
			return this.fornecedores.get(fornecedor).editarPreco(nomeProduto, descricao, preco);

		return "Fornecedor nao cadastrado!";
	}
	
	/**
	 * Este metodo lista todos os produtos de todos os fornecedores.
	 * @return
	 */

	public String listarProdutos() {
		List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>(fornecedores.values());
		Collections.sort(listaFornecedor);

		return this.listaDeProdutos(listaFornecedor);
	}
	
	/**
	 * Metodo retorna todos os produtos de um fornecedor passado por parametro.
	 * 
	 * @param fornecedor
	 * @return os produtos ou informando que nao existe nenhum cadastrado;
	 */

	public String listarProdutosDeUmFornecedor(String fornecedor) {
		if (this.fornecedores.get(fornecedor).listarProdutos().equals(""))
			return "Nenhum produto cadastrado!";
		
		String lista = this.fornecedores.get(fornecedor).listarProdutos();
		return lista.substring(0, lista.length() - 3);
	}

	private String listaDeProdutos(List<Fornecedor> listaFornecedor) {
		String produtos = "";

		for (int i = 0; i < listaFornecedor.size(); i++) {
			produtos += listaFornecedor.get(i).listarProdutos();
		}

		return produtos.substring(0, produtos.length() - 3);
	}

	// METODOS PRIVADOS

	private void parametroInvalido(String valor) {
		if (valor == null)
			throw new NullPointerException("Por favor digite novamente, o parametro informado foi nulo.");

		if (valor.equals(""))
			throw new IllegalArgumentException("Por favor digite novamente, o parametro informado foi vazio.");

	}

}
