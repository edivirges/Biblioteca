package padrao;

import java.util.ArrayList;
import java.util.Scanner;
import padrao.Aluno;
import padrao.Bibliotecaria;
import padrao.Livro;

public class TesteBiblioteca {

	// O Scanner é static para servir pra toda a classe
	public static Scanner leitor = new Scanner(System.in);

	// Variável para controlar se a bibliotecária está logada ou não
	public static Bibliotecaria bibliotecariaOn = null;

	// Menu inicial
	public static void menuLogin() {

		// Variável para controlar o while.
		boolean x = true;

		// Mostra o menu de forma repetitiva até o usuário usar a opção de voltar menu
		// anterior
		while (x == true) {
			System.out.println("\nAtenção: Para entrar no sistema a bibliotecária precisa estar cadastrada\n");

			System.out.println(":: P Á G I N A  I N I C I A L ::");
			System.out.println("1 - Cadrastar");
			System.out.println("2 - Entrar com login");
			System.out.print("Digite o número da opção desejada:\n ");

			int op = leitor.nextInt();
			switch (op) {

			case 1:
				// Acessa o menu gerenciar bibliotecária onde fica o cadastro
				System.out.println("~~~ Cadastrar Bibliotecário(a) ~~~");
				System.out.println("Digite o nome do(a) Bibliotecário(a):");
				String nome = leitor.next();

				System.out.println("Digite o e-mail do(a) Bibliotecário(a): ");
				String email = leitor.next();

				System.out.println("Digite o cpf do(a) Bibliotecário(a): ");
				int cpf = leitor.nextInt();

				System.out.println("Digite o sexo do(a) Bibliotecárioa(a): ");
				String sexo = leitor.next();

				System.out.println("Digite o login do(a) Bibliotecário(a): ");
				String login = leitor.next();

				System.out.println("Digite a senha do(a) Bibliotecário(a): ");
				String senha = leitor.next();

				// Criando Objetos e passando os valores capturados como parametro para o
				// construtor
				Bibliotecaria b = new Bibliotecaria(nome, email, cpf, sexo, login, senha);
				Bibliotecaria.listaBibliotecaria.add(b);

				System.out.println("\nO(a) Bibliotecário(a) foi cadastrado(a)com sucesso!");
				break;

			// Verifica se o login e senha estão corretos
			case 2:

				// Captura login e senha
				System.out.println("Login: ");
				String log = leitor.next();
				System.out.println("Senha: ");
				String sen = leitor.next();

				// Variável para saber se o acesso foi permitido
				boolean acessoPermitido = false;

				// Percorre o ArrayList listaBibliotecaria
				for (Bibliotecaria c : Bibliotecaria.listaBibliotecaria) {

					// Verifica se o login e a senha digitada pelo usuário é igual a algum login e
					// senha do ArrayList
					// Método equals() é usado para comparação

					boolean loginCerto = log.equals(c.getLogin());
					boolean senhaCerta = sen.equals(c.getSenha());

					// Se loginCerto e senhaCerta forem verdadeiros, ele executa o if
					if (loginCerto && senhaCerta) {
						acessoPermitido = true;

						// Armazena a Bibliotecaria logada atualmente
						bibliotecariaOn = c;

						menuPrincipal();
					}
				}
				if (acessoPermitido == false) {
					System.out.println("Login/senha incorretos!");
				}

				break;

			default:
				// Se digitar uma opção diferente, aparecerá essa mensagem
				System.out.println("Opção inválida!\n");
			}
		}
	}

	public static void menuPrincipal() {

		// Variável para controlar o while
		boolean comecar = true;

		// Mostra o menu de forma repetitiva até o usuário usar a opção de voltar menu
		// anterior
		while (comecar == true) {
			System.out.println("\n:: B I B L I O T E C A ::\n");
			System.out.println("Bem-vindo(a) ao sistema! Escolha a opção desejada:");
			System.out.println("1 - Livros");
			System.out.println("2 - Alunos");
			System.out.println("3 - Bibliotecários(as)");
			System.out.println("4 - Sair");
			System.out.print("Sua opção: ");

			// lê a opção do usuário
			int opcao = leitor.nextInt();

			switch (opcao) {
			case 1:
				// chama o menu de gerenciamento de livros
				Livro.menuGerenciarLivro();
				break;

			case 2:
				// chama o menu de gerenciamento de alunos
				Aluno.menuGerenciarAluno();
				break;

			case 3:
				// chama o menu de gerenciamento de Bibliotecária
				Bibliotecaria.menuGerenciarBibliotecaria();
				break;

			case 4:
				System.out.println("Saindo do sistema...");
				comecar = false;
				bibliotecariaOn = null;
				break;
			default:
				System.out.println("\nOpção inválida!\n\n");
			}
		}
	}

	public static void main(String[] args) {
		menuLogin();

	}
}
