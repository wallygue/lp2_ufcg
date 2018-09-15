package lab3;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		Scanner sc = new Scanner(System.in);
		String entrada = "";

		do {

			System.out.print("(C)adastrar Contato" + System.lineSeparator() + "(L)istar Contatos"
					+ System.lineSeparator() + "(E)xibir Contato" + System.lineSeparator() 
					+ "(S)air" + System.lineSeparator()
					+ System.lineSeparator() + "Opção> ");

			entrada = sc.nextLine().toLowerCase();

			switch (entrada) {

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

					if (agenda.cadastraContato(posicao, nome, sobrenome, telefone) == true)
						System.out.println("CADASTRO REALIZADO COM SUCESSO!!");

				} catch (IndexOutOfBoundsException indexException) {
					System.err.println(indexException.getMessage());

				} catch (IllegalArgumentException argIllegal) {
					System.err.println(argIllegal.getMessage());

				}

				break;

			case "l":
				try {

					System.out.println(System.lineSeparator() + agenda.listarContatos());
					break;
					
				} catch (IllegalArgumentException argumentoIlegal) {
					System.err.println(argumentoIlegal.getMessage());
				}

			case "e":
				try {

					System.out.print("Contato> ");
					int posicaoContato = sc.nextInt();
					sc.nextLine();

					System.out.println(System.lineSeparator() + agenda.exibirContato(posicaoContato));
					break;

				} catch (NoSuchElementException posicaoInvalida) {
					System.err.println(posicaoInvalida.getMessage());

				} catch (IndexOutOfBoundsException indexException) {
					System.err.println(indexException.getMessage());

				}

			case "s":
				break;

			default:
				System.out.print("OPÇÃO INVÁLIDA!" + System.lineSeparator());
				break;
			}
			sc.nextLine();

		} while (!entrada.equals("s"));

		sc.close();
	}

}
