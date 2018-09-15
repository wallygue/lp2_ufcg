package lab2;

import java.util.Arrays;

/**
 * 
 * Representação de uma determinada disciplia que o aluno está cursando, recebe
 * notas e ainda tem as suas horas trabalhadas nesta diciplina.
 *
 * 
 * @author Wallyngson Guedes
 * 
 */

public class Disciplina {

	private String disciplina;
	private int horasTrabalhadas;
	private double[] notas;
	private double media;

	/**
	 * Constroi uma disciplina pelo seu nome.
	 * 
	 * @param nomeDisciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.disciplina = nomeDisciplina;
		this.notas = new double[4];
	}

	/**
	 * Recebe a quantidade de horas que o aluno trabalhos para esta disciplína.
	 * 
	 * @param horas = horas trabalhadas.
	 */
	public void cadastraHoras(int horas) {
		this.horasTrabalhadas = horas;
	}

	/**
	 * Este método armazena os valores das notas em sua respectiva sequência de
	 * prova.
	 * 
	 * @param nota      = qual prova esta nota vai ser armazenada, usando como
	 *                  índice.
	 * @param valorNota = valor da nota propriamente dito.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}

	/**
	 * Calcula a média das notas informadas pelo aluno.
	 */
	private void calculaMedia() {
		double soma = 0;
		for (double d : notas) {
			soma += d;
		}
		this.media = soma / 4;
	}

	/**
	 * Este método retorna true e false, indica se o aluno foi aprovado ou
	 * reprovado.
	 * 
	 * @return true se o aluno foi aprovado e falso se o alunos foi reprovado.
	 */
	public boolean aprovado() {
		this.calculaMedia();
		if (this.media >= 7.0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Representação Textual, com o nome da disciplína, horas trabalhadas, média das
	 * notas e todas as notas do aluno.
	 */
	@Override
	public String toString() {
		return this.disciplina + " " + this.horasTrabalhadas + " " + this.media + " " + Arrays.toString(notas);
	}

//	BÔNUS... (Este terminado precisando apenas alterar o preenchimento do int[] pesoNotas!!!	)

	private int numNotas;
	private int[] pesoNotas = null;
	private int[] notasBonus;

	/**
	 * NOVO CONTRUTOR RECEBENDO APENAS NUMERO DE NOTAS E NOME;
	 * @param nomeDisciplina
	 * @param numNotas
	 */
	public Disciplina(String nomeDisciplina, int numNotas) {
		this.disciplina = nomeDisciplina;
		this.numNotas = numNotas;
		
	}

	/**
	 * NOVO CONTRUTOR RECEBENDO NUMERO DE NOTAS, NOME E PESO DA NOTAS;
	 * @param nomeDisciplina
	 * @param numNotas
	 */
	public Disciplina(String nomeDisciplina, int numNotas, int[] pesoNotas) {
		this.disciplina = nomeDisciplina;
		this.pesoNotas = pesoNotas;
		this.numNotas = numNotas;
		
	}

	/**
	 * CADASTRA AS NOTAS NUM ARRAY INTEIROS
	 * @param posicaoNota
	 * @param valorNota
	 */
	public void cadastraNotaBonus(int posicaoNota, int valorNota) {
		this.notasBonus[posicaoNota - 1] = valorNota;
		
	}

	/**
	 * CALCULA MEDIA COM PESOS DAS NOTAS
	 * @return
	 */
	private int calculaMediaComPesos() {
		int media = 0;
		
		for (int i = 0; i < notasBonus.length; i++) {
			media += notasBonus[i] * pesoNotas[i];
		}
		
		int mediaPonderada = (media / 10);
		return mediaPonderada;
		
	}
	/**
	 * CALCULA PESOS SEM PESOS
	 * @return
	 */
	private int calculaMediaSemPesos() {
		int media = 0;
		
		for (int i : notasBonus) {
			media += i;
		}
		
		int mediaPonderada = (media / this.numNotas);
		return mediaPonderada;
	}
	
	/**
	 * METODOS PRIVADOS PARA VERIFICAR QUAL SAIDA USAR
	 * @return
	 */
	private int calculaMediaBonus() {
		if(pesoNotas == null) 
			return calculaMediaSemPesos();
		else
			return calculaMediaComPesos();
	}
			
	/**
	 * METODO PARA RETORNAR VALORES
	 * @return
	 */
	public int mediaBonus() {
		return this.calculaMediaBonus();

	}
	
}
	

