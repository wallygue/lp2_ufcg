package lab2;

/**
 * 
 * Representação do estado de saúde em que o aluno se encontra no momento, vendo
 * sua condição fisica e psicológica no momento.
 *
 * 
 * @author Wallyngson Guedes
 * 
 */

public class Saude {

	private String statusMental = "boa";
	private String statusFisico = "boa";

	/**
	 * Recebe o estado de saúde mental do aluno no momento.
	 * 
	 * @param valor = status de saúde mental do aluno.
	 */
	public void defineSaudeMental(String valor) {
		this.statusMental = valor;
	}

	/**
	 * Recebe o estado de saúde fisica do aluno no momento.
	 * 
	 * @param valor = status de saúde fisica do aluno.
	 */
	public void defineSaudeFisica(String valor) {
		this.statusFisico = valor;
	}

	/**
	 * Verifica qual o estado do aluno, e retorna em valor de true ou false essa
	 * verificação.
	 * 
	 * @return boa para a situação de ambas boa, fraca para a situação de ambas
	 *         fracas, e OK para condições diferentes, ex: "boa" e "fraca".
	 */
	public String getStatusGeral() {
		if (this.statusFisico == "boa" && this.statusMental == "boa")
			return "boa";
		else if (this.statusFisico == "fraca" && this.statusMental == "fraca")
			return "fraca";
		else
			return "ok";

	}
}
