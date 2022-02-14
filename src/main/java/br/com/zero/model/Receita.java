package br.com.zero.model;

import javax.persistence.*;

/** Classe para objetos do tipo Receita, onde serão contidos valores e métodos para o mesmo
 * @author Gabriel Lagrota
 * @author Dayane Martins
 * @author Fernanda Viana
 * @author Fernando Silveira
 * @author Gabriel Nunes
 * @author Izabella Giovana
 * @author João Carlos
 * @author Rodrigo Cavalcante
 * @version 1.0
 * @since 08/02/2022 - 13:23pm */
@Entity
@Table(name = "TB_RECEITA")
@SequenceGenerator(name = "receita", allocationSize = 1, sequenceName = "sq_receita")
public class Receita {
	
	@Id
	@GeneratedValue(generator = "receita", strategy = GenerationType.IDENTITY)
	@Column(name = "id_receita")
    private Long id;
	
	@Column(name = "nm_nome")
    private String nome;
	
	@Column(name = "ds_descricao")
	private String descricao;
    
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Preparo preparo;
	
	@ManyToOne
	@JoinColumn(name = "_id_livro_receita")
	private LivroReceita livroReceita;

    /** Método construtor sem argumentos da classe Receita */
    public Receita() {
    }

    /** Método construtor com argumentos da classe Receita
     * @param nome String - Inicializa o nome da classe Receita
     * @param preparo Preparo - Inicializa a classe preparo da classe Receita
     * @param descricao String - Inicializa a descrição da classe Receita */
    public Receita(String nome, String descricao /*Preparo preparo, LivroReceita livroReceita*/) {
        this.nome = nome;
        this.descricao = descricao;
        /*this.preparo = preparo;
        this.livroReceita = livroReceita;*/
    }

    /** Método para retornar ID da receita
     * @return Long - Retorna id da receita */
    public Long getId() {
        return id;
    }

    /** Método para setar ID da receita
     * @param id Long - Seta o id da receita */
    public void setId(Long id) {
        this.id = id;
    }

    /** Método para retornar nome da Receita
     * @return String - Retorna nome da receita */
    public String getNome() {
        return nome;
    }

    /** Método pra setar nome da Receita
     * @param nome String - Seta nome da receita */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Método para retornar classe preparo da Receita
     * @return Preparo - Retorna classe preparo da receita */
    public Preparo getPreparo() {
        return preparo;
    }

    /** Método para setar classe preparo da Receita
     * @param preparo Preparo - Seta classe preparo da receita */
    public void setPreparo(Preparo preparo) {
        this.preparo = preparo;
    }

    /** Método para retornar descrição da Receita
     * @return String - retorna descrição da receita */
    public String getDescricao() {
        return descricao;
    }

    /** Método para setar descrição da Receita
     * @param descricao String - seta descrição da receita */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /** Método que retorna o LivroReceita da classe Receita
     * @return LivroReceita - Retorna o LivroReceita de receita */
    public LivroReceita getLivroReceita() {
		return livroReceita;
	}

    /** Método que seta o LivroReceita da classe Receita
     * @param livroReceita LivroReceita - Seta o LivroReceita em receita */
	public void setLivroReceita(LivroReceita livroReceita) {
		this.livroReceita = livroReceita;
	}
    
    /** Método para retornar uma String com os valores dos atributos de Receita
     * @return String - Atributos de Receita */
	public String toString() {
		return "Ingrediente [nome=" + nome + ", descricao =" + descricao + "]";
	}
}
