package lab4;

import java.util.HashMap;

public class Sistema {

	private HashMap<String, Aluno> alunos = new HashMap<>();
	private HashMap<String, Grupo> grupos = new HashMap<>();

	public Sistema() {

	}

	public String cadastraAluno(String matricula, String nome, String curso) {
		if (alunos.containsKey(matricula))
			return "MATRICULA JA CADASTRADA!";

		Aluno aluno = new Aluno(matricula, nome, curso);
		alunos.put(matricula, aluno);
		return "CADASTRO REALIZADO!";
	}

	public String exibeAluno(String matricula) {
		if (alunos.containsKey(matricula))
			return "Aluno: " + alunos.get(matricula);

		return "ALUNO NAO CADASTRADO!";
	}

	public String cadastraGrupo(String grupo) {
		if (grupos.containsKey(grupo))
			return "GRUPO JA CADASTRADO!";

		Grupo novoGrupo = new Grupo(grupo);
		grupos.put(grupo, novoGrupo);
		return "CADASTRO REALIZADO!";
	}

	public String alocarAluno(String matricula, String grupo) {
		if (validaAluno(matricula) && validaGrupo(grupo)) {
			if (grupos.containsKey(grupo)) {
				grupos.get(grupo).cadastraAlunoEmGrupo(alunos.get(matricula));
				return "ALUNO ALOCADO COM SUCESSO!";
			}
		}
		return "a";
	}

	private boolean validaAluno(String matricula) {
		return alunos.containsKey(matricula);
	}

	private boolean validaGrupo(String grupo) {
		return grupos.containsKey(grupo);
	}

//	public String 

}
