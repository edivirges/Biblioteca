package padrao;

import java.util.Scanner;
import java.util.ArrayList;

public class Livro {
	private String titulo;
	private String autor;
	private int isbn;
	private String editora;
	private String genero;
//	private boolean status;
    private Aluno aluno;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void emprestimo(Livro livro) {
		
	}
	// Scanner do tipo static para que toda a clase possa usar
	public static Scanner entrada = new Scanner(System.in);

	// Construtor
	public Livro(String titulo, String autor, int isbn, String editora, String genero) {

		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.editora = editora;
		this.genero = genero;

	}

//Construtor
	public Livro() {
	}

//A ArrayList serve para conter uma lista de objetos, nesse caso, do tipo livro. 
	static ArrayList<Livro> listaLivro = new ArrayList<Livro>();

	public static void menuGerenciarLivro() {

		// Variável para controlar o while
		boolean iniciar = true;

		// Mostra o menu de forma repetitiva até o usuário usar a opção de voltar menu anterior
		while (iniciar == true) {

			System.out.println("\n\n:: G E R E N C I A R   L I V R O S ::\n");
			System.out.println("Escolha a opção desejada");
			System.out.println("1 - Cadastrar livro");
			System.out.println("2 - Listar livros");
			System.out.println("3 - Pesquisar livro");
			System.out.println("4 - Excluir livro");
			System.out.println("5 - Atualizar livro");
			System.out.println("6 - Voltar Menu Anterior");
			System.out.println("Sua opção: ");

			// lê a opção do usuário()
			int opcao = entrada.nextInt();

			switch (opcao) {

			// Cadastro de Livro.
			case 1:
				System.out.println("Digite o título do livro: ");
				String titulo = entrada.next();

				System.out.println("Digite o nome do autor do livro: ");
				String autor = entrada.next();
				System.out.println("Digite o isbn do livro: ");
				int isbn = entrada.nextInt();
				System.out.println("Digite a editora do livro: ");
				String editora = entrada.next();
				System.out.println("Digite o gênero do livro: ");
				String genero = entrada.next();

				// Criando Objetos e passando os valores capturados como parametro para o construtor.
				Livro l = new Livro(titulo, autor, isbn, editora, genero);
				listaLivro.add(l);

				System.out.println("\nO livro foi cadastrado com sucesso!");
				break;

			// Livros Cadastrados.
			case 2:
				System.out.println("\nLivros Cadastrados");

				// O size() é um metodo da classe ArrayList que retorna o numero de elementos atuais presentes na lista.
				// O for percorre e mostra a lista dos livros.
				for (int i = 0; i < listaLivro.size(); i++) {
					System.out.println("\nLivro " + i);
					System.out.println("\tTítulo: " + listaLivro.get(i).getTitulo());
					System.out.println("\tAutor: " + listaLivro.get(i).getAutor());
					System.out.println("\tISBN: " + listaLivro.get(i).getIsbn());
					System.out.println("\tEditora: " + listaLivro.get(i).getEditora());
					System.out.println("\tGênero: " + listaLivro.get(i).getGenero());

				}
				break;

			case 3:
				System.out.println("~~~Pesquisar livro~~~");
				System.out.println("Digite o ISBN do livro desejado:");

				// Controla em qual if ele entra
				boolean encontrouLivro = false;

				// Captura o ISBN digitado.
				int num = entrada.nextInt();
				for (int i = 0; i < listaLivro.size(); i++) {

					if (num == listaLivro.get(i).getIsbn()) {
						System.out.println("~> Livro encontrado!");
						System.out.println("\nLivro " + i);
						System.out.println("\tTítulo: " + listaLivro.get(i).getTitulo());
						System.out.println("\tAutor: " + listaLivro.get(i).getAutor());
						System.out.println("\tISBN: " + listaLivro.get(i).getIsbn());
						System.out.println("\tEditora: " + listaLivro.get(i).getEditora());
						System.out.println("\tGênero: " + listaLivro.get(i).getGenero());

						encontrouLivro = true;
					}
				}
				if (encontrouLivro == false) {
					System.out.println("Livro não encontrado");
				}

				break;
			case 4:
				System.out.println("~~~Remover Livro~~~");

				// Variavel para controlar o while.
				boolean remover = true;

				// mostra o menu de forma repetitiva até o usuário usar a opção de voltar menu anterior
				while (remover == true) {

					for (int i = 0; i < listaLivro.size(); i++) {
						System.out.println("\nLivro " + i);
						System.out.println("\tTítulo: " + listaLivro.get(i).getTitulo());
						System.out.println("\tAutor: " + listaLivro.get(i).getAutor());
						System.out.println("\tISBN: " + listaLivro.get(i).getIsbn());
						System.out.println("\tEditora: " + listaLivro.get(i).getEditora());
						System.out.println("\tGênero: " + listaLivro.get(i).getGenero());
					}

					System.out.println("Digite o valor de referência:");
					int ref = entrada.nextInt();
					listaLivro.remove(ref);
					System.out.println("Livro removido com sucesso");

					for (int i = 0; i < listaLivro.size(); i++) {
						System.out.println("\nLivro " + i);
						System.out.println("\tTítulo: " + listaLivro.get(i).getTitulo());
						System.out.println("\tAutor: " + listaLivro.get(i).getAutor());
						System.out.println("\tISBN: " + listaLivro.get(i).getIsbn());
						System.out.println("\tEditora: " + listaLivro.get(i).getEditora());
						System.out.println("\tGênero: " + listaLivro.get(i).getGenero());
					}

					System.out.println("\nDeseja remover mais algum livro?\n 1 - Sim\n 2 - Não");
					int rem = entrada.nextInt();
					if (rem == 2) {
						remover = false;
					}
				}
				break;

			// Voltar ao Menu Anterior.
			case 6:
				iniciar = false;
				break;

			default:
				System.out.println("Opção inválida!");
			}
		}

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
