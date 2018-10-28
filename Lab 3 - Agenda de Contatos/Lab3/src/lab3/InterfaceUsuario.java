package lab3;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InterfaceUsuario {

	public void start() {
		Agenda agenda = new Agenda();

		Scanner sc = new Scanner(System.in);
		String entrada = "";

		/**
		 * DO WHILE QUE FUNCIONAR� PARA A INTERA��O ENTRE O USU�RIO E AS DEMAIS CLASSES
		 * CONTIDAS NESSE PROGRAMA;
		 */
		do {

			System.out.print("(C)adastrar Contato \n" + "(L)istar Contatos \n" + "(E)xibir Contato \n" + "(S)air \n"
					+ System.lineSeparator() + "Opcao> ");

			entrada = sc.nextLine().toLowerCase();

			switch (entrada) {

			/**
			 * CASE DIGITE "C" ESTE BLOCO DEVE SER EXECUTADO; RESPONSAVEL POR CADASTRAR OS
			 * CONTATOS EM UMA POSICAO, CADASTRANDO O CONTATO COM NOME, SOBRENOME E
			 * TELEFONE;
			 */
			case "c":

				try {

					System.out.print("Posicao: ");
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
					 * EXCEPTION, SE O USU�RIO N�O INFORMAR O NOME, O SOBRENOME, TELEFONE OU ENT�O
					 * TENTAR CADASTRAR O CONTATO EM UMA POSI��O INV�LIDA, IREMOS CAPTURAR AS
					 * EXCE��ES E TRATA-LAS;
					 */
				} catch (NullPointerException nulo) {
					System.err.println(nulo.getMessage());

				} catch (IllegalArgumentException argIllegal) {
					System.err.println(argIllegal.getMessage());

				} catch (IndexOutOfBoundsException indexException) {
					System.err.println(indexException.getMessage());

				}
				break;

			/**
			 * CASO DIGITE "E" ESTE BLOCO DEVE SER EXECUTADO; EXIBE AO USUARIO OS CONTATOS
			 * CADASTRADOS EM UMA DETERMINADA POSI��O FORNECIDA PELO USU�RIO;
			 */
			case "e":
				try {

					System.out.print("Contato> ");
					int posicaoContato = sc.nextInt();
					sc.nextLine();

					System.out.println(System.lineSeparator() + agenda.exibirContato(posicaoContato));

					break;

					/**
					 * EXCEPTION, SE O USU�RIO DIGITAR UMA POSI��O INV�LIDA OU N�O TIVER NENHUM
					 * CONTATO CADASTRADO NA POSI��O INFORMADA DEVEMOS ENT�O CAPTURAR AS EXCE��ES E
					 * TRATA-LAS;
					 */
				} catch (NoSuchElementException posicaoInvalida) {
					System.err.println(posicaoInvalida.getMessage());

				} catch (IndexOutOfBoundsException indexException) {
					System.err.println(indexException.getMessage());

				}
				break;

			/**
			 * CASO DIGITE "L" ESTE BLOCO DEVE SER EXECUTADO; EXIBE UMA LISTA LINHA A LINHA
			 * COM TODOS OS CONTATOS CADASTRADOS NA AGENDA;
			 */
			case "l":
				try {

					System.out.println(System.lineSeparator() + agenda.listarContatos());
					break;

					/**
					 * EXCEPTION, CASO O N�O HAJA NENHUM CONTATO CADASTRADO NA AGENDA, DEVEMOS
					 * CAPTURAR E TRATAR AS EXCE��ES;
					 */
				} catch (IllegalArgumentException argumentoIlegal) {
					System.err.println(argumentoIlegal.getMessage());

				}
				break;

			/**
			 * CASO DIGITE "S" ESTE BLOCO DEVE SER EXECUTADO; SAIR� DO SWITCH E QUEBRAR� O
			 * DO WHILE;
			 */
			case "s":
				System.exit(0);
				break;

			/**
			 * SE DIGITAR QUALQUER OUTRA LETRA, IMPRIMIR� ESTA MENSAGEM;
			 */
			default:
				System.out.print("OP��O INV�LIDA!" + System.lineSeparator());
				break;
			}
			sc.nextLine();

		} while (!entrada.equals("s"));

		sc.close();
	}
}
