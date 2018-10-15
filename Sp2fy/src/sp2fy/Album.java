package sp2fy;

import java.util.HashMap;

public class Album {

	private String titulo;
	private String artista;
	private String ano;
	private HashMap<String, Musica> musicas;

	public Album(String titulo, String artista, String ano) {
		this.titulo = titulo;
		this.artista = artista;
		this.ano = ano;
		musicas = new HashMap<>();

	}
	
	/**
	 * Este metodo adiciona uma musica a colecao de musicas;
	 * 
	 * @param titulo
	 * @param duracao
	 * @param genero
	 * @return
	 */
	public boolean adicionaMusica(String titulo, int duracao, String genero) {
		this.musicas.put(titulo, new Musica(titulo, duracao, genero));
		return true;
	}

	@Override
	public String toString() {
		return titulo + ", " + artista + ", " + ano + ".";
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	

}
