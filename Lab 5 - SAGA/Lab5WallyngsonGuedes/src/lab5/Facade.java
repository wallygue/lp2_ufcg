package lab5;

public class Facade {

	private ControllerSaga controller;

	public Facade() {
		controller = new ControllerSaga();
	}

	public String cadastrarCliente(String cpf, String nome, String email, String localizacao) {
		return this.controller.cadastrarCliente(cpf, nome, email, localizacao);
		
	}
	
	public String retornaCliente(String cpf) {
		return this.controller.retornaCliente(cpf);
	}
	
	public String editarCliente(String cpf, String nome, String email, String localizacao) {
		return this.controller.editarCliente(cpf, nome, email, localizacao);
	}
	
	public String removerCliente(String cpf) {
		return this.controller.removerCliente(cpf);
	}

}
