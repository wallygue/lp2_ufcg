package lab3;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * ESTA CLASSE É UM MENU QUE VAI SER RESPONSÁVEL PELA INTERAÇÃO
 * ENTRE O USUÁRIO E AS DEMAIS CLASSES, RESPONSÁVEL POR 
 * TODAS AS ENTRADAS E SAIDA DE DADOS;
 * 
 * @author Wallyngson Guedes
 * Matrícula: 117110835
 * Matéria: LP2
 */

public class Menu {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		Scanner sc = new Scanner(System.in);
		String entrada = "";

		/**
		 * DO WHILE QUE FUNCIONARÁ PARA A INTERAÇÃO ENTRE O USUÁRIO
		 * E AS DEMAIS CLASSES CONTIDAS NESSE PROGRAMA;
		 */
		do {

			System.out.print("(C)adastrar Contato \n" 
					+ "(L)istar Contatos \n"
					+ "(E)xibir Contato \n"	
					+ "(S)air \n" 
					+ System.lineSeparator() 
					+ "Opção> ");

			entrada = sc.nextLine().toLowerCase();

			switch (entrada) {

			/**
			 * CASE DIGITE "C" ESTE BLOCO DEVE SER EXECUTADO;
			 * RESPONSAVEL POR CADASTRAR OS CONTATOS EM UMA POSICAO,
			 * CADASTRANDO O CONTATO COM NOME, SOBRENOME E TELEFONE;
			 */
			case "c":

				try {

					System.out.print("Posição: ");
					int posicao = sc.nextInt();
					sc.nextLine();

					System.out.print("Nome: ");
					String nome = sc.nextLine();

					System.out.print("Sobrenome: ");
					String sobrenome = sc.nextLine();

					System.out.print("Telefone: ");
					String telefone = sc.nextLine();

					System.out.println(agenda.cadastraContato(posicao, nome, sobrenome, telefone));
					
				/**
				 * EXCEPTION, SE O USUÁRIO NÃO INFORMAR O NOME, O SOBRENOME,
				 * TELEFONE OU ENTÃO TENTAR CADASTRAR O CONTATO EM UMA POSIÇÃO
				 * INVÁLIDA, IREMOS CAPTURAR AS EXCEÇÕES E TRATA-LAS;
				 */
				} catch (NullPointerException nulo) {
					System.err.println(nulo.getMessage());

				} catch (IllegalArgumentException argIllegal) {
					System.err.println(argIllegal.getMessage());

				} catch (IndexOutOfBoundsException indexException) {
					System.err.println(indexException.getMessage());

				} break;

			/**
			 * CASO DIGITE "E" ESTE BLOCO DEVE SER EXECUTADO;
			 * EXIBE AO USUARIO OS CONTATOS CADASTRADOS EM UMA DETERMINADA
			 * POSIÇÃO FORNECIDA PELO USUÁRIO;
			 */
			case "e":
				try {
					
					System.out.print("Contato> ");
					int posicaoContato = sc.nextInt();
					sc.nextLine();
					
					System.out.println(System.lineSeparator() 
							+ agenda.exibirContato(posicaoContato)); 
					
					break;
					
				/**
				 * EXCEPTION, SE O USUÁRIO DIGITAR UMA POSIÇÃO INVÁLIDA
				 * OU NÃO TIVER NENHUM CONTATO CADASTRADO NA POSIÇÃO INFORMADA
				 * DEVEMOS ENTÃO CAPTURAR AS EXCEÇÕES E TRATA-LAS;
				 */
				} catch (NoSuchElementException posicaoInvalida) {
					System.err.println(posicaoInvalida.getMessage());
					
				} catch (IndexOutOfBoundsException indexException) {
					System.err.println(indexException.getMessage());
					
				} break;

			/**
			 * CASO DIGITE "L" ESTE BLOCO DEVE SER EXECUTADO;
			 * EXIBE UMA LISTA LINHA A LINHA COM TODOS OS CONTATOS CADASTRADOS
			 * NA AGENDA;
			 */
			case "l":
				try {

					System.out.println(System.lineSeparator() + agenda.listarContatos());
					break;
					
				/**
				 * EXCEPTION, CASO O NÃO HAJA NENHUM CONTATO CADASTRADO
				 * NA AGENDA, DEVEMOS CAPTURAR E TRATAR AS EXCEÇÕES;
				 */
				} catch (IllegalArgumentException argumentoIlegal) {
					System.err.println(argumentoIlegal.getMessage());
				
				} break;

			/**
			 * CASO DIGITE "S" ESTE BLOCO DEVE SER EXECUTADO;
			 * SAIRÁ DO SWITCH E QUEBRARÁ O DO WHILE;
			 */
			case "s":
				break;
			
			/**
			 * SE DIGITAR QUALQUER OUTRA LETRA, IMPRIMIRÁ ESTA MENSAGEM;
			 */
			default:
				System.out.print("OPÇÃO INVÁLIDA!" + System.lineSeparator());
				break;
			}
			sc.nextLine();

		} while (!entrada.equals("s"));
		
		sc.close();
	}
}
