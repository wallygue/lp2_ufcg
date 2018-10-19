package sp2fy;

public class Musica {
	private String titulo;
	private String genero;
	private int duracao;

	public Musica(String titulo, int duracao, String genero) {
		this.titulo = titulo;
		this.duracao = duracao;
		this.genero = genero;

		if (titulo == null && titulo == null && genero == null)
			throw new NullPointerException("");
		
		if (titulo.equals("") && duracao <= 0 && genero.equals(""))
			throw new IllegalArgumentException("");
		
	}

	public String getTitulo() {
		return this.titulo;
	}

	public int getDuracao() {
		return this.duracao;
	}

	@Override
	public String toString() {
		return titulo + "\n" + "Genero: " + genero + "\n" + "Duracao: " + duracao + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Musica other = (Musica) obj;
		return (this.getTitulo().equals(other.getTitulo()) && this.getDuracao() == other.getDuracao());

	}

}
