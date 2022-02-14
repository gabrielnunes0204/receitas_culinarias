package br.com.zero.model;

import java.util.List;
import javax.persistence.*;

/** Classe para objetos do tipo Usuario, onde serão contidos valores e métodos para o mesmo
 * @author Gabriel Lagrota
 * @author Dayane Martins
 * @author Fernanda Viana
 * @author Fernando Silveira
 * @author Gabriel Nunes
 * @author Izabella Giovana
 * @author João Carlos
 * @author Rodrigo Cavalcante
 * @version 1.0
 * @since 08/02/2022 - 10:31am */
@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "usuario", allocationSize = 1, sequenceName = "sq_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(generator = "usuario", strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
    private Long id;
	
	@Column(name = "ds_login")
    private String login;
	
	@Column(name = "ds_senha")
    private String senha;
	
	@Column(name = "nm_nome")
    private String nome;
	
	@Column(name = "ds_sobrenome")
    private String sobrenome;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LivroReceita> livrosReceita;

    /** Método construtor sem argumentos da classe Usuario */
    public Usuario() {}

    /** Método construtor com argumentos da Classe Usuario
     * @param login String - Inicializa o login do usuário
     * @param senha String - Inicializa a senha do usuário
     * @param nome String - Inicializa o nome do usuário
     * @param sobrenome String - Inicializa o sobrenome do usuário
     * @param livrosReceita LivroReceita - Inicializa os livros de receita do usuário */
    public Usuario(String login, String senha, String nome, String sobrenome /*List<LivroReceita> livrosReceita*/) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        /*this.livrosReceita = livrosReceita;*/
    }
    
    /** Método para retornar do ID do usuário
     * @return Long - Retorna número de identificação do usuário */
    public Long getId() {
        return id;
    }

    /** Método para setar ID do usuário
     * @param id Long - Seta número de identificação do usuário */
    public void setId(Long id) {
        this.id = id;
    }

    /** Método para retornar login do usuário
     * @return String - Retorna login do usuário */
    public String getLogin() {
        return login;
    }

    /** Método para setar login do usuário
     * @param login String - Seta login do usuário */
    public void setLogin(String login) {
        this.login = login;
    }

    /** Método para retornar senha do usuário
     * @return String - Retorna senha do usuário */
    public String getSenha() {
        return senha;
    }

    /** Método para setar senha do usuário
     * @param senha String - Seta senha do usuário */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /** Método para retornar nome do usuário
     * @return String - Retorna nome do usuário */
    public String getNome() {
        return nome;
    }

    /** Método para setar nome do usuário
     * @param nome String - Seta nome do usuário */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Método para retornar sobrenome do usuário
     * @return String - Retorna sobrenome do usuário */
    public String getSobrenome() {
        return sobrenome;
    }

    /** Método para setar sobrenome do usuário
     * @param sobrenome String - Seta sobrenome do usuário */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /** Método para retornar Lista de livros de receita do usuário
     * @return LivroReceita - Retorna lista de livros de receita do usuário */
    public List<LivroReceita> getLivrosReceita() {
        return livrosReceita;
    }

    /** Método para setar Lista de livros de receita do usuário
     * @param livrosReceita LivroReceita - Seta lista de livros de receita do usuário */
    public void setLivrosReceita(List<LivroReceita> livrosReceita) {
        this.livrosReceita = livrosReceita;
    }
    
    /** Método para retornar uma String com os valores dos atributos de Preparo
     * @return String - Atributos de Preparo */
	public String toString() {
		return "Ingrediente [login=" + login + ", senha=" + senha + "nome=" + nome + "sobrenome=" + sobrenome + "]";
	}
}

