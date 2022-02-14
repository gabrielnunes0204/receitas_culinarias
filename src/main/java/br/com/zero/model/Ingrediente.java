package br.com.zero.model;

import javax.persistence.*;

/** Classe para objetos do tipo Ingrediente, onde serão contidos valores e métodos para o mesmo
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

@Entity
@Table(name = "TB_INGREDIENTE")
@SequenceGenerator(name = "ingrediente", allocationSize = 1, sequenceName = "sq_ingrediente")
public class Ingrediente {
	
	@Id
	@GeneratedValue(generator = "ingrediente", strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingrediente")
    private Long id;
	
	@Column(name = "nm_nome")
    private String nome;
	
	@Column(name = "qtd_quantidade")
    private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name = "preparo_id")
	private Preparo preparo;

    /** Método construtor sem argumentos da Classe Ingrediente */
    public Ingrediente() {}

    /** Método construtor com argumentos da Classe Ingrediente
     * @param nome String -  inicializa o nome do ingrediente
     * @param quantidade Integer - inicializa a quantidade de ingredientes */
    public Ingrediente(String nome, Integer quantidade /*Preparo preparo*/) {
        this.nome = nome;
        this.quantidade = quantidade;
        /*this.preparo = preparo;*/
    }

    /** Método para retorno do id do ingrediente
     * @return Long - Número de identificação do ingrediente */
    public Long getId() {
        return id;
    }

    /** Método para setar id do ingrediente
     * @param id Long - Seta o número de identificação do ingrediente*/
    public void setId(Long id) {
        this.id = id;
    }

    /** Método para retorno do nome do ingrediente
     * @return String - Nome do ingrediente */
    public String getNome() {
        return nome;
    }

    /** Método para setar o nome do ingrediente
     * @param nome String - Nome do ingrediente */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Método para retornar a quantidade de ingredientes
     * @return Integer - Quantidade de ingredientes */
    public Integer getQuantidade() {
        return quantidade;
    }

    /** Método para setar a quantidade de ingredientes
     * @param quantidade Integer - Quantidade de ingredientes */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    /** Método que retorna o Preparo da classe Ingrediente
     * @return Preparo - Retorna o Preparo de ingrediente */
    public Preparo getPreparo() {
		return preparo;
	}

    /** Método que seta o Preparo da classe Ingrediente
     * @param preparo Preparo - Seta o Preparo em ingrediente */
	public void setPreparo(Preparo preparo) {
		this.preparo = preparo;
	}

	/** Método para retornar uma String com os valores dos atributos de ingrediente
     * @return String - Atributos de Ingrediente */
	public String toString() {
		return "Ingrediente [nome=" + nome + ", quantidade=" + quantidade + "]";
	}
}
