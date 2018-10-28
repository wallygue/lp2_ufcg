package lab2;

/**
 * 
 * Representação de uma conta de lab que um estudante usa, podendo armazenar
 * dados, excluir e verificar se já alcançou e ultrapassou o limite de cota.
 * 
 * @author Wallyngson Guedes
 * 
 */

public class ContaLaboratorio {

	private String nomeLaboratorio;
	private int cota;
	private int espacoConsumido;

	/**
	 * Este contrutor recebe o nome do laboratório onde o estudante está logando e
	 * possui uma quantidade padrão da sua cota de arquivos armazenados.
	 * 
	 * @param laboratorio = nome do laboratório.
	 */
	public ContaLaboratorio(String laboratorio) {
		this.nomeLaboratorio = laboratorio;
		this.cota = 2000;
	}

	/**
	 * Este contrutor recebe o nome do laboratório onde o estudante está logando e
	 * também recebe e constroi uma quantidade de cota que o aluno possui para
	 * armazenar seus aquivos.
	 * 
	 * @param laboratorio = nome do laboratório.
	 * @param cota        = quantidade de espaço que o aluno possui para armazenar.
	 */
	public ContaLaboratorio(String laboratorio, int cota) {
		this.nomeLaboratorio = laboratorio;
		this.cota = cota;
	}

	/**
	 * Este método verifica se o espaço que o aluno consumiu ultrapassou o limite de
	 * armazenamento, e faz isso atravez de uma comparação retornando true ou false.
	 * 
	 * @return true se o aluno ultrapassou a cota, false se o aluno ainda está
	 *         dentro do limite.
	 */
	public boolean atingiuCota() {
		if (this.espacoConsumido >= this.cota) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Soma a quantidade de cota que o aluno está armazenando ao total de espaço que
	 * ele possui.
	 * 
	 * @param cotaOcupada = quantidade de dados que o aluno deseja armazenar.
	 */
	public void consomeEspaco(int cotaOcupada) {
		this.espacoConsumido += cotaOcupada;
	}

	/**
	 * Libera a quantidade de espaço que o aluno deseja elimitar dos seus dados.
	 * 
	 * @param i = recebe uma quantidade de dados a ser excluida do espaço total
	 *          consumida.
	 */
	public void liberaEspaco(int i) {
		this.espacoConsumido -= i;

	}

	/**
	 * Representação textual, nos mostra o nome do laboratório, o espaço consumido e
	 * a quantidade de cota.
	 */
	@Override
	public String toString() {
		return this.nomeLaboratorio + " " + espacoConsumido + "/" + this.cota;
	}

	public int getCota() {
		return cota;
	}

	public void setCota(int cota) {
		this.cota = cota;
	}

	public String getNomeLaboratorio() {
		return nomeLaboratorio;
	}

	public void setNomeLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
	}

}
