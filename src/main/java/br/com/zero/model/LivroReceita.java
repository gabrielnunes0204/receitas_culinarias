package br.com.zero.model;

import java.util.List;
import javax.persistence.*;

/**
 * Classe para objetos do tipo LivroReceita, onde serão contidos valores e
 * métodos para o mesmo
 * 
 * @author Gabriel Lagrota
 * @author Dayane Martins
 * @author Fernanda Viana
 * @author Fernando Silveira
 * @author Gabriel Nunes
 * @author Izabella Giovana
 * @author João Carlos
 * @author Rodrigo Cavalcante
 * @version 1.0
 * @since 08/02/2022 - 14:43pm
 */
@Entity
@Table(name = "TB_LIVRO_RECEITA")
@SequenceGenerator(name = "livro_receita", allocationSize = 1, sequenceName = "sq_livro_receita")
public class LivroReceita {

	@Id
	@GeneratedValue(generator = "livro_receita", strategy = GenerationType.IDENTITY)
	@Column(name = "id_livro_receita")
	private Long id;

	@Column(name = "nm_nome")
	private String nome;

	@Column(name = "ds_categoria")
	private String categoria;
	/*private TipoCategoria categoria;*/
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Receita> receitas;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	/** Método construtor sem argumentos da classe LivroReceita */
	public LivroReceita() {}

	/**
	 * Método construtor com argumentos da classe LivroReceita
	 * 
	 * @param nome      String - Inicializa o nome da classe LivroReceita
	 * @param categoria TipoCategoria - Inicializa a categoria da classe
	 *                  LivroReceita
	 * @param receitas  List - Inicializa a lista de receitas da classe LivroReceita
	 */
	public LivroReceita(String nome, String categoria /*List<Receita> receitas*/) {
		this.nome = nome;
		this.categoria = categoria;
		/*this.receitas = receitas;*/
	}

	/**
	 * Método que retorna o ID da classe LivroReceita
	 * 
	 * @return Long - Retorna o id da classe LivroReceita
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método que seta o ID da classe LivroReceita
	 * 
	 * @param id Long - Seta o id da classe LivroReceita
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que retorna o nome da classe LivroReceita
	 * 
	 * @return String - Retorna o nome do livro de receitas
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que seta o nome da classe LivroReceita
	 * 
	 * @param nome String - seta um nome para o livro de receitas
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que retorna a categoria da classe LivroReceita
	 * 
	 * @return TipoCategoria - Retorna a categoria do livro de receitas. (Ex:
	 *         Salgados, drinks, etc)
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Método que seta a categoria da classe LivroReceita
	 * 
	 * @param categoria TipoCategoria - Seta a categoria do livro de receitas. (Ex:
	 *                  Salgados, drinks, etc)
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Método que retorna a lista de receitas da classe LivroReceita
	 * 
	 * @return List - Retorna as receitas do livro de receitas
	 */
	public List<Receita> getReceitas() {
		return receitas;
	}

	/**
	 * Método que seta a lista de receitas da classe LivroReceita
	 * 
	 * @param receitas List - Seta as receitas do livro de receitas
	 */
	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	/**
	 * Método que retorna o usuário da classe LivroReceita
	 * 
	 * @return Usuario - Retorna o usuário livro de receitas
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Método que seta o usuário da classe LivroReceita
	 * 
	 * @param usuario Usuario - Seta o usuário em livro de receitas
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Método para retornar uma String com os valores dos atributos de LivroReceita
	 * 
	 * @return String - Atributos de LivroReceita
	 */
	public String toString() {
		return "Livro Receita [nome=" + nome + ", categoria=" + categoria + "]";
	}
}
