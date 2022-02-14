package br.com.zero.model;

import java.util.List;
import javax.persistence.*;

/** Classe para objetos do tipo Preparo, onde serão contidos valores e métodos para o mesmo
 * @author Gabriel Lagrota
 * @author Dayane Martins
 * @author Fernanda Viana
 * @author Fernando Silveira
 * @author Gabriel Nunes
 * @author Izabella Giovana
 * @author João Carlos
 * @author Rodrigo Cavalcante
 * @version 1.0
 * @since 08/02/2022 - 14:26pm */
@Entity
@Table(name = "TB_PREPARO")
@SequenceGenerator(name = "preparo", allocationSize = 1, sequenceName = "sq_preparo")
public class Preparo {
	
	@Id
	@GeneratedValue(generator = "preparo", strategy = GenerationType.IDENTITY)
	@Column(name = "id_preparo")
    private Long id;
	
	@Column(name = "nm_nome")
    private String nome;

	@Column(name = "ds_tempo_preparo")
    private String tempoPreparo;
	
	@Column(name = "ds_rendimento")
    private String rendimento;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingrediente> ingredientes;

	@OneToOne(mappedBy = "preparo")
	private Receita receita;
	
    /** Método construtor sem argumentos da classe Preparo */
    public Preparo() {}

    /** Método construtor com argumentos da classe Preparo
     * @param nome String - Inicializa o nome do Preparo
     * @param ingredientes List - Inicializa os ingredientes do Preparo
     * @param tempoPreparo String - Inicializa o tempo de preparo do Preparo
     * @param rendimento String - Inicializa o rendimento do preparo */
   public Preparo(String nome, String tempoPreparo, String rendimento /*List<Ingrediente> ingredientes*/) {
        this.nome = nome;
        this.tempoPreparo = tempoPreparo;
        this.rendimento = rendimento;
       /* this.ingredientes = ingredientes;*/
    }
    
    /** Método para retornar ID do preparo
     * @return Long - Retorna id do preparo */
    public Long getId() {
        return id;
    }

    /** Método para setar ID do preparo
     * @param id Long - Seta id do preparo */
    public void setId(Long id) {
        this.id = id;
    }

    /** Método para retornar Nome do preparo
     * @return String - Retorna nome do preparo */
    public String getNome() {
        return nome;
    }

    /** Métodos para setar Nome do preparo
     * @param nome String - Seta nome do preparo */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Método para retornar Lista de ingredientes do Preparo
     * @return List - Retorna Lista de ingredientes do Preparo */
    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    /** Método para setar Lista de ingredientes do Preparo
     * @param ingredientes List - Seta lista de ingredientes do preparo */
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    /** Método para retornar tempo de preparo do Preparo
     * @return String - Retorna tempo de preparo do Preparo */
    public String getTempoPreparo() {
        return tempoPreparo;
    }

    /** Método para setar tempo de preparo do Preparo
     * @param tempoPreparo String - Seta tempo de preparo do Preparo */
    public void setTempoPreparo(String tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    /** Método para retornar tempo de rendimento do Preparo
     * @return String - Retorna tempo de rendimento do Preparo */
    public String getRendimento() {
        return rendimento;
    }

    /** Método para setar tempo de rendimento do Preparo
     * @param rendimento String - Seta tempo de rendimento do preparo */
    public void setRendimento(String rendimento) {
        this.rendimento = rendimento;
    }
    
    /** Método que retorna a receita da classe Preparo
     * @return Receita - Retorna a receita de Preparo */
    public Receita getReceita() {
		return receita;
	}

    /** Método que seta a Receita da classe Preparo
     * @param receita Receita - Seta a Receita em preparo */
	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	/** Método para retornar uma String com os valores dos atributos de Preparo
     * @return String - Atributos de Preparo */
	public String toString() {
		return "Ingrediente [nome=" + nome + ", tempoPreparo=" + tempoPreparo + "rendimento=" + rendimento + "]";
	}
}
