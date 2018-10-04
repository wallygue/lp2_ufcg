package lab4;

import java.util.Scanner;

public class Interface {

	Sistema sistema = new Sistema();
	Scanner sc = new Scanner(System.in);

	public void start() {

		String condicao = "";

		do {

			System.out.print("(C)adastrar Aluno\n" + "(E)xibir Aluno\n" + "(N)ovo Grupo\n"
					+ "(A)locar Aluno no Grupo e Imprimir Grupos\n" + "(R)egistrar Aluno que Respondeu\n"
					+ "(I)mprimir Alunos que Responderam\n" + "(O)ra, vamos fechar o programa!\n"
					+ System.lineSeparator() + "Opcao> ");

			condicao = sc.nextLine().trim().toLowerCase();

			switch (condicao) {
			case "o":
				break;

			case "c":
				System.out.print("Matricula: ");
				String matricula = sc.nextLine().trim();

				System.out.print("Nome: ");
				String nome = sc.nextLine();

				System.out.print("Curso: ");
				String curso = sc.nextLine();

				// AQUI DEVE SER TRATADO UMA EXECECAO;

				System.out.println(sistema.cadastraAluno(matricula, nome, curso) + System.lineSeparator());

				break;

			case "e":
				System.out.print("Matricula: ");
				matricula = sc.nextLine().trim();

				System.out.println(sistema.exibeAluno(matricula) + System.lineSeparator());

				break;

			case "n":
				System.out.print("Grupo: ");
				String grupo = sc.nextLine();
				
				System.out.println(sistema.cadastraGrupo(grupo) + System.lineSeparator());
				
				break;

			case "a":
				System.out.print("(A)locar Alunou ou (I)mprimir Grupo? ");
				String op = sc.nextLine().toLowerCase().trim();
				
				switch (op) {
				case "a":
					System.out.print("Matricula: ");
					matricula = sc.nextLine().trim();
					
					System.out.print("Grupo: ");
					grupo = sc.nextLine();
					
					System.out.println(sistema.alocarAluno(matricula, grupo) + System.lineSeparator());
					
					break;
				case "i":
				
					break;
				default:
					System.out.println("Operacao invalida!");
					break;
				}
				
				break;

			case "r":
				break;

			case "i":
				break;

			default:
				System.out.println("Nao foi possivel realizar esta operacao, digite um parametro valido!");
				break;
			}

		} while (!condicao.equals("o"));

	}

}
