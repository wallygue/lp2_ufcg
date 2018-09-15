package lab3;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		Scanner sc = new Scanner(System.in);
		String entrada = "";
		String nome;
		String sobrenome;
		String telefone;
		int posicao;

		do {

			System.out.print("(C)adastrar Contato" + System.lineSeparator() + "(L)istar Contatos"
					+ System.lineSeparator() + "(E)xibir Contato" + System.lineSeparator() + "(S)air"
					+ System.lineSeparator() + System.lineSeparator() + "Opção> ");

			entrada = sc.nextLine();

			switch (entrada) {

			case "C":

				try {

					System.out.print("Posição: ");
					posicao = sc.nextInt();
					sc.nextLine();

					System.out.print("Nome: ");
					nome = sc.nextLine();

					System.out.print("Sobrenome: ");
					sobrenome = sc.nextLine();

					System.out.print("Telefone: ");
					telefone = sc.nextLine();

					agenda.cadastraContato(posicao, nome, sobrenome, telefone);

				} catch (IndexOutOfBoundsException indexException) {
					System.err.println(indexException.getMessage() + System.lineSeparator());
					System.exit(1);

				} catch (IllegalArgumentException argIllegal) {
					System.err.println(argIllegal.getMessage() + System.lineSeparator());
					System.exit(1);
				
				} catch (NullPointerException nuloException) {
					System.err.println(nuloException.getMessage() + System.lineSeparator());
					System.exit(1);
				}

				break;

			case "L":

				System.out.println(System.lineSeparator() + agenda.listarContatos());
				break;

			case "E":
				System.out.print("Contato> ");
				int posicaoContato = sc.nextInt();
				sc.nextLine();

				System.out.println(System.lineSeparator() + agenda.exibirContato(posicaoContato));
				break;

			case "S":
				break;

			default:
				System.out.println("OPÇÃO INVÁLIDA!" + System.lineSeparator());
				break;
			}

		} while (!entrada.equals("S"));

		sc.close();
	}

}
