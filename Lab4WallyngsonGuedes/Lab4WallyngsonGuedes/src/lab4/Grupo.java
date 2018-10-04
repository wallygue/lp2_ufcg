package lab4;

import java.util.HashSet;

public class Grupo {

	private HashSet<Aluno> alunos = new HashSet<Aluno>();
	
	private String grupo;
	
	public Grupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return grupo;
	}

	public String cadastraAlunoEmGrupo(Aluno aluno) {
		alunos.add(aluno);
		return "ALUNO ALOCADO";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		return true;
	}
	
	
	
	
}
