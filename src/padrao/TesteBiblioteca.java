package padrao;

import java.util.ArrayList;
import java.util.Scanner;
import padrao.Aluno;
import padrao.Bibliotecaria;
import padrao.Livro;

public class TesteBiblioteca {

	// O Scanner � static para servir pra toda a classe
	public static Scanner leitor = new Scanner(System.in);

	// Vari�vel para controlar se a bibliotec�ria est� logada ou n�o
	public static Bibliotecaria bibliotecariaOn = null;

	// Menu inicial
	public static void menuLogin() {

		// Vari�vel para controlar o while.
		boolean x = true;

		// Mostra o menu de forma repetitiva at� o usu�rio usar a op��o de voltar menu
		// anterior
		while (x == true) {
			System.out.println("\nAten��o: Para entrar no sistema a bibliotec�ria precisa estar cadastrada\n");

			System.out.println(":: P � G I N A  I N I C I A L ::");
			System.out.println("1 - Cadrastar");
			System.out.println("2 - Entrar com login");
			System.out.print("Digite o n�mero da op��o desejada:\n ");

			int op = leitor.nextInt();
			switch (op) {

			case 1:
				// Acessa o menu gerenciar bibliotec�ria onde fica o cadastro
				System.out.println("~~~ Cadastrar Bibliotec�rio(a) ~~~");
				System.out.println("Digite o nome do(a) Bibliotec�rio(a):");
				String nome = leitor.next();

				System.out.println("Digite o e-mail do(a) Bibliotec�rio(a): ");
				String email = leitor.next();

				System.out.println("Digite o cpf do(a) Bibliotec�rio(a): ");
				int cpf = leitor.nextInt();

				System.out.println("Digite o sexo do(a) Bibliotec�rioa(a): ");
				String sexo = leitor.next();

				System.out.println("Digite o login do(a) Bibliotec�rio(a): ");
				String login = leitor.next();

				System.out.println("Digite a senha do(a) Bibliotec�rio(a): ");
				String senha = leitor.next();

				// Criando Objetos e passando os valores capturados como parametro para o
				// construtor
				Bibliotecaria b = new Bibliotecaria(nome, email, cpf, sexo, login, senha);
				Bibliotecaria.listaBibliotecaria.add(b);

				System.out.println("\nO(a) Bibliotec�rio(a) foi cadastrado(a)com sucesso!");
				break;

			// Verifica se o login e senha est�o corretos
			case 2:

				// Captura login e senha
				System.out.println("Login: ");
				String log = leitor.next();
				System.out.println("Senha: ");
				String sen = leitor.next();

				// Vari�vel para saber se o acesso foi permitido
				boolean acessoPermitido = false;

				// Percorre o ArrayList listaBibliotecaria
				for (Bibliotecaria c : Bibliotecaria.listaBibliotecaria) {

					// Verifica se o login e a senha digitada pelo usu�rio � igual a algum login e
					// senha do ArrayList
					// M�todo equals() � usado para compara��o

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
				// Se digitar uma op��o diferente, aparecer� essa mensagem
				System.out.println("Op��o inv�lida!\n");
			}
		}
	}

	public static void menuPrincipal() {

		// Vari�vel para controlar o while
		boolean comecar = true;

		// Mostra o menu de forma repetitiva at� o usu�rio usar a op��o de voltar menu
		// anterior
		while (comecar == true) {
			System.out.println("\n:: B I B L I O T E C A ::\n");
			System.out.println("Bem-vindo(a) ao sistema! Escolha a op��o desejada:");
			System.out.println("1 - Livros");
			System.out.println("2 - Alunos");
			System.out.println("3 - Bibliotec�rios(as)");
			System.out.println("4 - Sair");
			System.out.print("Sua op��o: ");

			// l� a op��o do usu�rio
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
				// chama o menu de gerenciamento de Bibliotec�ria
				Bibliotecaria.menuGerenciarBibliotecaria();
				break;

			case 4:
				System.out.println("Saindo do sistema...");
				comecar = false;
				bibliotecariaOn = null;
				break;
			default:
				System.out.println("\nOp��o inv�lida!\n\n");
			}
		}
	}

	public static void main(String[] args) {
		menuLogin();

	}
}
