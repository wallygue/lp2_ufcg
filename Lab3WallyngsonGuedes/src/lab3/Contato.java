package lab3;

/**
 * ESTA CLASSE REPRESENTA OS CONTATOS QUE DEVEM SER CADASTRADOS NUMA AGENDA,
 * CONTROI E � ADICIONADO NO ARRAY;
 * 
 * @author Wallyngson Guedes
 *
 */
public class Contato {
	private String[] telefones = new String[3];

	private String nome;
	private String sobrenome;
	private String telefone;
	private String numeroTelefone;
	private int ddd;
	private int codigoPais;
	private int nivelAmizade = 0;

	/**
	 * RESPONSAVEL POR CONSTRUIR O CONTATO A SER ADICIONADO NA AGENDA. RECEBENDO
	 * COMO PARAMETRO O NOME, SOBRENOME E TELEFONE;
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 */
	public Contato(String nome, String sobrenome, String telefone) {

		/*
		 * EXCEPTIONS, RESPOSAVEIS POR SABER SE O NOME, SOBRENOME E TELEFONE SAO
		 * INVALIDOS OU NULOS;
		 */
		if (nome == null)
			throw new NullPointerException(
					"Cadastro nao realizado!\n" + "O Nome informado foi nulo, por favor digite um nome.");

		if (nome.trim().equals(""))
			throw new IllegalArgumentException(
					"Cadastro nao realizado!\n" + "O Nome informado foi invalido, por favor digite um nome valido.");

		if (sobrenome == null)
			throw new NullPointerException(
					"Cadastro nao realizado!\n" + "O Sobrenome informado foi nulo, por favor digite um sobrenome.");

		if (sobrenome.trim().equals(""))
			throw new IllegalArgumentException(
					"Cadastro nao realizado!\n" + "O Sobrenome informado foi nulo, por favor digite um sobrenome.");

		if (telefone == null)
			throw new NullPointerException("Cadastro não realizado!\n"
					+ "O Sobrenome informado foi invalido, por favor digite um sobrenome valido.");

		if (telefone.trim().equals(""))
			throw new IllegalArgumentException(
					"Cadastro nao realizado!\n" + "O Telefone informado foi nulo, por favor digite um telefone.");

		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}

	public String getNome() {
		return this.nome;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public String getTelefone() {
		return this.telefone;

	}

	public int getNivelAmizade() {
		return this.nivelAmizade;
	}

	/**
	 * RETORNA A AGENDA REPRESENTA��O TEXTUAL DO CONTATO;
	 */
	public String toString() {
		return nome + " " + sobrenome + " - " + telefone;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/*
	 * METODO EQUALS QUE COMPARA SE DOIS CONTATOS SAO IGUAIS; VERIFICA SE O NOME E O
	 * SOBRENOME FOREM IGUAL, ENTAO OS CONTATOS TAMBEM SAO;
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Contato) {
			Contato other = (Contato) obj;
			return this.getNome().equals(other.getNome()) && this.getSobrenome().equals(other.getSobrenome());

		} else
			return false;

	}

	// BONUS

	/**
	 * ESTE METODO PERCORRE O ARRAY DE TELEFONES, SE ENCONTRAR UMA POSICAO NULL,
	 * ADICIONA O CONTATO NAQUELA POSICAO E RETORNA UMA STRING INFORMANDO SE FOI
	 * CADASTRADO E EM QUE POSICAO O TELEFONE FOI ADICIONADOM, SE NAO RETORNA UMA
	 * STRING INFORMANDO QUE NAO FOI POSSIVEL O CADASTRO;
	 * 
	 * @param codigoPais
	 * @param ddd
	 * @param numeroTelefone
	 * @return
	 */
	public String adicionaTelefone(int codigoPais, int ddd, String numeroTelefone) {
		for (int i = 0; i < telefones.length; i++) {
			if (telefones[i] == null) {
				telefones[i] = formataTelefone(codigoPais, ddd, numeroTelefone);
				String posicao = Integer.toString(i);
				return "Seu telefone foi adicionado com sucesso!\n" + "Adicionado na posicao " + posicao + ".";
			}
		}
		return "Telefone nao pode ser adicionado, todas as posicoes estao lotadas!";
	}

	/**
	 * ESTE METODO CRIAR UMA REPRESENTACAO TEXTUAL DO TELEFONE COM O CODIGO DO PAIS,
	 * O DDD E O NUMERO DO TELEFONE, PARA SER ADICIONADO AO ARRAY DE TELEFONES;
	 * 
	 * @param codigoPais
	 * @param ddd
	 * @param numeroTelefone
	 * @return
	 */
	private String formataTelefone(int codigoPais, int ddd, String numeroTelefone) {
		this.codigoPais = codigoPais;
		this.ddd = ddd;
		this.numeroTelefone = numeroTelefone;
		return this.codigoPais + " " + this.ddd + " " + this.numeroTelefone;
	}

	/**
	 * ESTE METODO SET RECEBE UM NIVEL DE AMIZADE E ADICIONA AO ATRIBUTO DESTA
	 * CLASSE;
	 * 
	 * @param nivelAmizade
	 */
	public void SetNivelAmizade(int nivelAmizade) {
		if (nivelAmizade < 1 || nivelAmizade > 5) {
			throw new IllegalArgumentException(
					"Nivel de amizade nao adicionado!\n" + "Existem apenas 5 niveis de amizades, escolhar um deles.");
		}

		this.nivelAmizade = nivelAmizade;
	}
}