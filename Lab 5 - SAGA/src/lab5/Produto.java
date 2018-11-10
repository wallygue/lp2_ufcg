package lab5;

/**
 * Interface que representa um produto, tanto simples quanto um combo.
 * 
 * @author Wallyngson Guedes
 *
 */
public interface Produto extends Comparable<Produto>{

	boolean equals(String nomeProduto, String descricao);

}
