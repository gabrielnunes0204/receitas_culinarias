const menu = document.querySelector("header");
const titulo = document.querySelector("#titulo");
const botao = document.querySelector(".botao-abrir");

function abrirMenu() {
	const texto = document.querySelector("#itens");

	if (texto == null) {
		console.log("Erro");
	} else {
		const estiloTexto = getComputedStyle(texto);

		if (botao != null) {
			botao.addEventListener("click", (event) => {
				if (estiloTexto.display === "none") {
					menu.style.width = "200px";
					menu.style.transition = "all 0.3s";

					texto.style.display = "block";
					titulo.style.display = "block";

					botao.style.left = "180px";
					botao.style.transition = "all 0.3s";
					event.preventDefault();
				} else if (estiloTexto.display === "block") {
					menu.style.width = "80px";
					menu.style.transition = "all 0.3s";

					texto.style.display = "none";
					titulo.style.display = "none";

					botao.style.left = "60px";
					botao.style.transition = "all 0.3s";
					event.preventDefault();
				}
			});
		}
	}
}
abrirMenu();

function validarLogin() {
	const botao = document.querySelector(".botao_logar");
	const login = document.querySelector("#login");
	const senha = document.querySelector("#senha");

	if (botao != null) {
		botao.addEventListener("click", (event) => {

			if (login.value == "") {
				alert("Preencha o login corretamente");
				event.preventDefault();
			} else if (senha.value == "") {
				alert("Preencha a senha corretamente");
				event.preventDefault();
			} else {
				console.log("Foi");
			}
		});
	}
}
validarLogin();

function validarCadastro() {
	const botao = document.querySelector(".botao_cadastrar");
	const nome = document.querySelector("#nome");
	const sobrenome = document.querySelector("#sobrenome");
	const login = document.querySelector("#login");
	const senha = document.querySelector("#senha");

	const modal = document.querySelector(".modal_cadastro");

	if (botao != null) {
		botao.addEventListener("click", (event) => {
			
			if (nome.value == "") {
				alert("Preencha o campo de nome corretamente");
				event.preventDefault();
			} else if (sobrenome.value == "") {
				alert("Preencha o campo de sobrenome corretamente");
				event.preventDefault();
			} else if (login.value == "") {
				alert("Preencha o campo de login corretamente");
				event.preventDefault();
			} else if (senha.value == "") {
				alert("Preencha o campo de senha corretamente");
				event.preventDefault();
			} else {
				alert("Usuário cadastrado com sucesso.");
			}
		})
	}
}
validarCadastro();

function validarLivro() {
	const botaoCadastro = document.querySelector(".botao_cadastro_livro");
	const nomeCadastro = document.querySelector(".nome_cadastro_livro");
	const CategoriaCadastro = document.querySelector(".categoria_cadastro_livro");


	if (botaoCadastro != null) {
		botaoCadastro.addEventListener("click", (event) => {

			if (nomeCadastro.value == "") {
				alert("Preencha o campo de nome corretamente");
				event.preventDefault();
			} else if (CategoriaCadastro.value == "") {
				alert("Preencha o campo de categoria corretamente");
				event.preventDefault();
			} else {
				console.log("Foi");
			}
		});
	}

	const botaoEditar = document.querySelector(".botao_editar_livro");
	const idEditar = document.querySelector(".id_editar_livro");
	const nomeEditar = document.querySelector(".nome_editar_livro");
	const CategoriaEditar = document.querySelector(".categoria_editar_livro");

	if (botaoEditar != null) {
		botaoEditar.addEventListener("click", (event) => {

			if (idEditar.value == "") {
				alert("Preencha o ID corretamente");
				event.preventDefault();
			} else if (nomeEditar.value == "") {
				alert("Preencha o campo de nome corretamente");
				event.preventDefault();
			} else if (CategoriaEditar.value == "") {
				alert("Preencha o campo de categoria corretamente");
				event.preventDefault();
			} else {
				console.log("Foi");
			}
		});
	}

	const botaoExcluir = document.querySelector(".botao_excluir_livro");
	const idExcluir = document.querySelector(".id_excluir_livro");

	if (botaoExcluir != null) {
		botaoExcluir.addEventListener("click", (event) => {

			if (idExcluir.value == "") {
				alert("Preencha o ID corretamente");
				event.preventDefault();
			} else {
				console.log("Foi");
			}
		});
	}
}
validarLivro();

function validarReceita() {
	const botaoCadastro = document.querySelector(".botao_cadastro_receita");
	const nomeCadastro = document.querySelector(".nome_cadastro_receita");
	const descricaoCadastro = document.querySelector(".descricao_cadastro_receita");

	if (botaoCadastro != null) {
		botaoCadastro.addEventListener("click", (event) => {

			if (nomeCadastro.value == "") {
				alert("Preencha o campo de nome corretamente");
				event.preventDefault();
			} else if (descricaoCadastro.value == "") {
				alert("Preencha o campo de descrição corretamente");
				event.preventDefault();
			} else {
				console.log("Foi");
			}
		});
	}

	const botaoEditar = document.querySelector(".botao_editar_receita");
	const idEditar = document.querySelector(".id_editar_receita");
	const nomeEditar = document.querySelector(".nome_editar_receita");
	const descricaoEditar = document.querySelector(".descricao_editar_receita");

	if (botaoEditar != null) {
		botaoEditar.addEventListener("click", (event) => {

			if (idEditar.value == "") {
				alert("Preencha o ID corretamente");
				event.preventDefault();
			} else if (nomeEditar.value == "") {
				alert("Preencha o campo de nome corretamente");
				event.preventDefault();
			} else if (descricaoEditar.value == "") {
				alert("Preencha o campo de descrição corretamente");;
				event.preventDefault();
			} else {
				console.log("Foi");
			}
		});
	}

	const botaoExcluir = document.querySelector(".botao_excluir_receita");
	const idExcluir = document.querySelector(".id_excluir_receita");

	if (botaoExcluir != null) {
		botaoExcluir.addEventListener("click", (event) => {

			if (idExcluir.value == "") {
				alert("Preencha o ID corretamente");
				event.preventDefault();
			} else {
				console.log("Foi");
			}
		});
	}
}
validarReceita();

function validarPreparo() {
	const botaoCadastro = document.querySelector(".botao_cadastro_preparo");
	const nomeCadastro = document.querySelector(".nome_cadastro_preparo");
	const tempoCadastro = document.querySelector(".tempo_cadastro_preparo");
	const rendimentoCadastro = document.querySelector(".rendimento_cadastro_preparo");

	if (botaoCadastro != null) {
		botaoCadastro.addEventListener("click", (event) => {

			if (nomeCadastro.value == "") {
				alert("Preencha o campo de nome corretamente");
				event.preventDefault();
			} else if (tempoCadastro.value == "") {
				alert("Preencha o campo de tempo corretamente");
				event.preventDefault();
			} else if (rendimentoCadastro.value == "") {
				alert("Preencha o campo de rendimento corretamente");
				event.preventDefault();
			} else {
				console.log("Foi");
			}
		});
	}

	const botaoEditar = document.querySelector(".botao_editar_preparo");
	const idEditar = document.querySelector(".id_editar_preparo");
	const nomeEditar = document.querySelector(".nome_editar_preparo");
	const tempoEditar = document.querySelector(".tempo_editar_preparo");
	const rendimentoEditar = document.querySelector(".rendimento_editar_preparo");

	if (botaoEditar != null) {
		botaoEditar.addEventListener("click", (event) => {

			if (idEditar.value == "") {
				alert("Preencha o ID corretamente");
				event.preventDefault();
			} else if (nomeEditar.value == "") {
				alert("Preencha o campo de nome corretamente");
				event.preventDefault();
			} else if (tempoEditar.value == "") {
				alert("Preencha o campo de tempo corretamente");
				event.preventDefault();
			} else if (rendimentoEditar.value == "") {
				alert("Preencha o campo de rendimento corretamente");
				event.preventDefault();
			} else {
				console.log("Foi");
			}
		});
	}

	const botaoExcluir = document.querySelector(".botao_excluir_preparo");
	const idExcluir = document.querySelector(".id_excluir_preparo");

	if (botaoExcluir != null) {
		botaoExcluir.addEventListener("click", (event) => {

			if (idExcluir.value == "") {
				alert("Preencha o ID corretamente");
				event.preventDefault();
			} else {
				console.log("Foi");
			}
		});
	}
}
validarPreparo();

function validarIngrediente() {
	const botaoCadastro = document.querySelector(".botao_cadastro_ingrediente");
	const nomeCadastro = document.querySelector(".nome_cadastro_ingrediente");
	const qtdCadastro = document.querySelector(".qtd_cadastro_ingrediente");

	if (botaoCadastro != null) {
		botaoCadastro.addEventListener("click", (event) => {

			if (nomeCadastro.value == "") {
				alert("Preencha o campo de nome corretamente");;
				event.preventDefault();
			} else if (qtdCadastro.value == "") {
				alert("Preencha o campo de quantidade corretamente");
				event.preventDefault();
			} else {
				console.log("Foi");
			}
		});
	}

	const botaoEditar = document.querySelector(".botao_editar_ingrediente");
	const idEditar = document.querySelector(".id_editar_ingrediente");
	const nomeEditar = document.querySelector(".nome_editar_ingrediente");
	const qtdEditar = document.querySelector(".qtd_editar_ingrediente");

	if (botaoEditar != null) {
		botaoEditar.addEventListener("click", (event) => {

			if (idEditar.value == "") {
				alert("Preencha o ID corretamente");
				event.preventDefault();
			} else if (nomeEditar.value == "") {
				alert("Preencha o campo de nome corretamente");
				event.preventDefault();
			} else if (qtdEditar.value == "") {
				alert("Preencha o campo de quantidade corretamente");
				event.preventDefault();
			} else {
				console.log("Foi");
			}
		});
	}

	const botaoExcluir = document.querySelector(".botao_excluir_ingrediente");
	const idExcluir = document.querySelector(".id_excluir_ingrediente");

	if (botaoExcluir != null) {
		botaoExcluir.addEventListener("click", (event) => {

			if (idExcluir.value == "") {
				alert("Preencha o ID corretamente");;
				event.preventDefault();
			} else {
				console.log("Foi");
			}
		});
	}
}
validarIngrediente();