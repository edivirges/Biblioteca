package padrao;

import java.util.Scanner;
import java.util.ArrayList;

public class Bibliotecaria extends Usuario {
	private String login;
	private String senha;
	public static Scanner scanner = new Scanner(System.in);

	// Construtor
	public Bibliotecaria() {

	}

	// Construtor
	public Bibliotecaria(String nome, String email, int cpf, String sexo, String login, String senha) {
		super(nome, email, cpf, sexo);
		this.login = login;
		this.senha = senha;
	}

	// A ArrayList serve para conter uma lista de objetos, nesse caso, do tipo
	// livro.
	static ArrayList<Bibliotecaria> listaBibliotecaria = new ArrayList<Bibliotecaria>();

	public static void menuGerenciarBibliotecaria() {

		// Vari�vel para controlar o while.
		boolean iniciar = true;

		// mostra o menu de forma repetitiva at� o usu�rio usar a op��o de Voltar Menu
		// Anterior
		while (iniciar == true) {

			System.out.println("\n:: G E R E N C I A R   B I B L I O T E C A R I A ::\n");
			System.out.println("Escolha a op��o desejada");
			System.out.println("1 - Cadastrar Bibliotecaria");
			System.out.println("2 - Listar Bibliotecaria");
			System.out.println("3 - Pesquisar Bibliotecaria");
			System.out.println("4 - Excluir Bibliotecaria");
			System.out.println("5 - Atualizar Bibliotecaria");
			System.out.println("6 - Voltar Menu Anterior");
			System.out.print("Sua op��o: ");
			// l� a op��o do usu�rio

			int opcao = scanner.nextInt();

			switch (opcao) {
			case 1: // vamos cadastrar um novo livro
				System.out.println("~~~ Cadastrar Bibliotec�rio(a) ~~~");
				System.out.println("Digite o nome do(a) Bibliotec�rio(a):");
				String nome = scanner.next();

				System.out.println("Digite o e-mail do(a) Bibliotec�rio(a): ");
				String email = scanner.next();

				System.out.println("Digite o cpf do(a) Bibliotec�rio(a): ");
				int cpf = scanner.nextInt();

				System.out.println("Digite o sexo do(a) Bibliotec�rioa(a): ");
				String sexo = scanner.next();

				System.out.println("Digite o login do(a) Bibliotec�rio(a): ");
				String login = scanner.next();

				System.out.println("Digite a senha do(a) Bibliotec�rio(a): ");
				String senha = scanner.next();

				// Criando Objetos e passando os valores capturados como parametro para o
				// construtor.
				Bibliotecaria b = new Bibliotecaria(nome, email, cpf, sexo, login, senha);
				listaBibliotecaria.add(b);

				System.out.println("\nO(a) Bibliotec�rio(a) foi cadastrado(a)com sucesso!");
				break;
			case 2:
				System.out.println("\n~~~ Bibliotec�rios(as) Cadastrados ~~~");
				for (int i = 0; i < listaBibliotecaria.size(); i++) {
					System.out.println("\nBibliotec�rios(as):" + i);
					System.out.println("\tNome: " + listaBibliotecaria.get(i).getNome());
					System.out.println("\tE-mail: " + listaBibliotecaria.get(i).getEmail());
					System.out.println("\tCPF: " + listaBibliotecaria.get(i).getCpf());
					System.out.println("\tSexo: " + listaBibliotecaria.get(i).getSexo());
					System.out.println("\tLogin: " + listaBibliotecaria.get(i).getLogin());
					System.out.println("\tSenha: " + listaBibliotecaria.get(i).getSenha());
				}
				break;
			case 3:
				System.out.println("~~~Pesquisar Bibliotec�rio(a)~~~");
				System.out.println("Digite o CPF do(a) Bibliotec�rio(a) desejado:");

				// Controlar em qual if ele entra
				boolean x = false;

				int num = scanner.nextInt();
				for (int i = 0; i < listaBibliotecaria.size(); i++) {
					if (num == listaBibliotecaria.get(i).getCpf()) {
						System.out.println("Bibliotec�rio(a) encontrado com sucesso!");
						System.out.println("\nBibliotec�rio(a) " + i);
						System.out.println("\tNome: " + listaBibliotecaria.get(i).getNome());
						System.out.println("\tE-mail: " + listaBibliotecaria.get(i).getEmail());
						System.out.println("\tCPF: " + listaBibliotecaria.get(i).getCpf());
						System.out.println("\tSexo: " + listaBibliotecaria.get(i).getSexo());
						System.out.println("\tLogin: " + listaBibliotecaria.get(i).getLogin());
						System.out.println("\tSenha: " + listaBibliotecaria.get(i).getSenha());
						x = true;
					}
				}
				if (x == false) {
					System.out.println("Bibliotec�rio(a)n�o encontrado");
				}
				break;

			case 4:
				System.out.println("~~~Remover Bibliotecario(a)~~~");

				boolean remover = true;

				// mostra o menu de forma repetitiva at� o usu�rio usar a op��o de voltar menu
				// anterior
				while (remover == true) {

					for (int i = 0; i < listaBibliotecaria.size(); i++) {
						System.out.println("\nBibliotec�rio(a) " + i);
						System.out.println("\tNome: " + listaBibliotecaria.get(i).getNome());
						System.out.println("\tE-mail: " + listaBibliotecaria.get(i).getEmail());
						System.out.println("\tCPF: " + listaBibliotecaria.get(i).getCpf());
						System.out.println("\tSexo: " + listaBibliotecaria.get(i).getSexo());
						System.out.println("\tLogin: " + listaBibliotecaria.get(i).getLogin());
						System.out.println("\tSenha: " + listaBibliotecaria.get(i).getSenha());
					}

					System.out.println("Digite o valor de refer�ncia:");
					int ref = scanner.nextInt();
					listaBibliotecaria.remove(ref);
					System.out.println("Biliotec�rio(a) removido(a) com sucesso!");

					for (int i = 0; i < listaBibliotecaria.size(); i++) {
						System.out.println("\nBibliotec�rio(a) " + i);
						System.out.println("\tNome: " + listaBibliotecaria.get(i).getNome());
						System.out.println("\tE-mail: " + listaBibliotecaria.get(i).getEmail());
						System.out.println("\tCPF: " + listaBibliotecaria.get(i).getCpf());
						System.out.println("\tSexo: " + listaBibliotecaria.get(i).getSexo());
						System.out.println("\tLogin: " + listaBibliotecaria.get(i).getLogin());
						System.out.println("\tSenha: " + listaBibliotecaria.get(i).getSenha());
					}

					System.out.println("\nDeseja remover mais algum bibliotec�rio(a)?\n 1 - Sim\n 2 - N�o");
					int rem = scanner.nextInt();
					if (rem == 2) {
						remover = false;
					}
				}
				break;

			case 5:
				// O size() � um metodo da classe ArrayList que retorna o numero de elementos
				// atuais presentes na lista.
				// O for percorre e mostra a lista dos livros.
				System.out.println("~~~ Atualiza��o de dados do(a) bibliotec�rio(a) ~~~");
				for (int i = 0; i < listaBibliotecaria.size(); i++) {
					System.out.println("\nBibliotec�rio(a) " + i);
					System.out.println("\tNome: " + listaBibliotecaria.get(i).getNome());
					System.out.println("\tE-mail: " + listaBibliotecaria.get(i).getEmail());
					System.out.println("\tCPF: " + listaBibliotecaria.get(i).getCpf());
					System.out.println("\tSexo: " + listaBibliotecaria.get(i).getSexo());
					System.out.println("\tLogin: " + listaBibliotecaria.get(i).getLogin());
					System.out.println("\tSenha: " + listaBibliotecaria.get(i).getSenha());
				}
				System.out.println("Digite o valor de refer�ncia:");
				int referencia = scanner.nextInt();
				System.out.print("Digite o novo e-mail: ");
				String novoEmail = scanner.next();
				System.out.print("Digite o novo login: ");
				String novoLogin = scanner.next();
				System.out.print("Digite a nova senha: ");
				String novaSenha = scanner.next();

				b = listaBibliotecaria.get(referencia);
				b.setEmail(novoEmail);
				b.setLogin(novoLogin);
				b.setSenha(novaSenha);
				System.out.println("Dados atualizados com sucesso!");

				for (int i = 0; i < listaBibliotecaria.size(); i++) {
					System.out.println("\nBibliotec�rio(a) " + i);
					System.out.println("\tNome: " + listaBibliotecaria.get(i).getNome());
					System.out.println("\tE-mail: " + listaBibliotecaria.get(i).getEmail());
					System.out.println("\tCPF: " + listaBibliotecaria.get(i).getCpf());
					System.out.println("\tSexo: " + listaBibliotecaria.get(i).getSexo());
					System.out.println("\tLogin: " + listaBibliotecaria.get(i).getLogin());
					System.out.println("\tSenha: " + listaBibliotecaria.get(i).getSenha());
				}
				break;

			// Voltar ao Menu Anterior
			case 6:
				iniciar = false;
				break;

			default:
				System.out.println("Op��o inv�lida!");

			}
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
