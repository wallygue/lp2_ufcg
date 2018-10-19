package sp2fy;

import java.util.ArrayList;

public class Album {

	private String titulo;
	private String artista;
	private String ano;
	private int duracaoAlbum = 0;
	private ArrayList<Musica> musicas;

	public Album(String titulo, String artista, String ano) {
		this.titulo = titulo;
		this.artista = artista;
		this.ano = ano;

		if (titulo == null || artista == null || ano == null)
			throw new NullPointerException("");

		if (titulo.equals("") || artista.equals("") || ano.equals(""))
			throw new IllegalArgumentException("");

		musicas = new ArrayList<>();

	}

	public void adicionaMusica(String titulo, int duracao, String genero) {
		this.musicas.add(new Musica(titulo, duracao, genero));

	}

	public String retiraMusica(int posicao) {
		if (this.musicas.get(posicao - 1) != null) {
			duracaoAlbum -= this.musicas.get(posicao - 1).getDuracao();
			this.musicas.remove(posicao - 1);
			return "Musica removida com sucesso!";

		}
		return "Nao possivel fazer esta operacao, musica nao encontrada.";

	}

	public String pesquisaMusica(int posicao) {
		return this.validaMusica(posicao);

	}

	public String tocarMusica(int posicao) {
		return this.validaMusica(posicao);
	}

	private String validaMusica(int posicao) {
		if (musicas.get(posicao - 1) != null)
			return this.musicas.get(posicao - 1).toString();
		return "Musica nao encontrada!";

	}

	public String getArtista() {
		return this.artista;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public int duracaoAlbum() {
		return this.duracaoAlbum;
	}

	@Override
	public String toString() {
		return titulo + "\n" + "Artista: " + artista + "\n" + "Ano da musica: " + ano + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Album novoAlbum = (Album) obj;
		return this.getArtista().equals(novoAlbum.getArtista()) && this.getTitulo().equals(novoAlbum.getTitulo());

	}

}
