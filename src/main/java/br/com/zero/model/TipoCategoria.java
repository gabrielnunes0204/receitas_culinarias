package br.com.zero.model;

/** ENUM contendo as categorias de Livros de Receitas
 * @author Gabriel Lagrota
 * @author Dayane Martins
 * @author Fernanda Viana
 * @author Fernando Silveira
 * @author Gabriel Nunes
 * @author Izabella Giovana
 * @author João Carlos
 * @author Rodrigo Cavalcante
 * @version 1.0
 * @since 08/02/2022 - 9:22am */
public enum TipoCategoria {
    SALGADO(1, "Salgado"),
    LANCHE(2, "Lanche"),
    DOCE(3, "Doce"),
    MASSA(4, "Massa"),
    BRASILEIRA(5, "Brasileira"),
    DRINK(6, "Drink"),
    MEXICANA(7, "Mexicana"),
    JAPONESA(8, "Japonesa");
	
	private Integer codigo;
	private String descricao;
	
	private TipoCategoria(Integer cod, String desc) {
		this.codigo = cod;
		this.descricao = desc;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
