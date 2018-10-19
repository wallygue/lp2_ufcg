package sp2fy;

import java.util.HashSet;

public class Perfil {

	private String nomeUsuario;
	private HashSet<Album> albuns;
	private HashSet<Album> albunsFavoritos;

	public Perfil(String nome) {
		this.nomeUsuario = nome;
		albuns = new HashSet<>();
		albunsFavoritos = new HashSet<>();

	}

	public String adicionaAlbum(Album album) {
		if (validaAlbum(album))
			return "Esta album ja esta cadastrado!";

		this.albuns.add(album);
		return "Album cadastrado com sucesso!";

	}

	public String adicionaAosFavoritos(Album album) {
		if (validaAlbum(album))
			return "Nao foi possivel adicionar o album!";

		this.albunsFavoritos.add(album);
		return "Album adicionado aos favoritos!";
	
	}

	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public boolean validaAlbum(Album album) {
		return this.albunsFavoritos != null && this.albunsFavoritos.contains(album);
	}

}
