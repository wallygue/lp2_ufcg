package lab2;

/**
 * 
 * Representação de uma cantina de uma universidade onde o estudante come e
 * possui uma conta que acumula seus debitos e realiza pagamentos.
 * 
 * @author Wallyngson Guedes
 * 
 */

public class ContaCantina {

	private String nomeCantina;
	private int contaPagar;
	private int itensConsumidos;
	private int valorTotal;

	/**
	 * Este Construtor constroi o nome da cantina onde o aluno comeu.
	 * 
	 * @param nomeCantina = Nome da Cantina em formato de String.
	 */
	public ContaCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
	}

	/**
	 * Este método recebe a quantidade de itens e o preço do lanche que o aluno
	 * comeu e as atribui a seus devidos atributos.
	 * 
	 * @param qtdItens      = Quantidade de itens que o aluno consumiu, em formato
	 *                      inteiro.
	 * @param valorCentavos = Preço em centavos que o aluno consuiu, em formato
	 *                      inteiro.
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.valorTotal += valorCentavos;
		this.contaPagar += valorCentavos;
		this.itensConsumidos += qtdItens;
	}

	/**
	 * Método responsavel por realizar a subtração do valor que o aluno deve a
	 * cantina.
	 * 
	 * @param valorCentavos = Valor que o aluno está pagando a cantina em centavos.
	 */
	public void pagaConta(int valorCentavos) {
		this.contaPagar -= valorCentavos;

	}

	public int getFaltaPagar() {
		return this.contaPagar;
	}

	/**
	 * Método ToString() que retorna uma representação textual desejada.
	 */
	@Override
	public String toString() {
		return this.nomeCantina + " " + this.itensConsumidos + " " + this.valorTotal;
	}

//	BÔNUS (Ainda falta terminar!!!)
	
	private String[] detalhes = new String[5];
	
	/**
	 * MÉTODO PARA CADASTRAR OS DETALH
	 * @param qtdItens
	 * @param valorCentavos
	 * @param detalhes
	 */
	public void cadastrarLanche(int qtdItens, int valorCentavos, String detalhes) {
		this.valorTotal += valorCentavos;
		this.contaPagar += valorCentavos;
		this.itensConsumidos += qtdItens;
		adicionarDetalhe(detalhes);
	}

	/**
	 * LISTA AS STRINGS
	 * @return
	 */
	public String listarDetalhes() {
		String saida = "";
		
		for (String string : detalhes) {
			
			if(string != null) {
				saida += string + System.lineSeparator();
			} 

		}
		saida = saida.substring(0, saida.length() - 1);
		return saida;
		
		
	}

	/**
	 * SHIFT
	 * @param detalhe
	 */
	private void adicionarDetalhe(String detalhe) {
		
		for (int i = 1; i < detalhes.length; i++) {
			detalhes[i - 1] = detalhes[i];
		}
		
		detalhes[4] = detalhe;
		
		}
		
		
}
	

