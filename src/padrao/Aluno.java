package padrao;

import java.util.Scanner;
import padrao.Livro;
import java.util.ArrayList;

public class Aluno extends Usuario {
	private int matricula;
	private int anoEscolar;

	// Scanner do tipo static para que toda a clase possa usar
	public static Scanner ler = new Scanner(System.in);

//	A ArrayList serve para conter uma lista de objetos, nesse caso, do tipo livro.
	static ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();

	// Construtor
	public Aluno() {

	}

	// Construtor
	public Aluno(String nome, String email, int cpf, String sexo, int matricula, int anoEscolar) {
		super(nome, email, cpf, sexo);
		this.matricula = matricula;
		this.anoEscolar = anoEscolar;
	}

	public static void menuGerenciarAluno() {

		// Variavel para controlar o While.
		boolean iniciar = true;

		// mostra o menu de forma repetitiva até o usuário usar a opção de Voltar Menu
		// Anterior
		while (iniciar == true) {

			// limparTela();
			System.out.println("\n:: G E R E N C I A R   A L U N O S ::\n");
			System.out.println("Escolha a opção desejada");
			System.out.println("1 - Cadastrar Aluno");
			System.out.println("2 - Listar Aluno");
			System.out.println("3 - Pesquisar Aluno");
			System.out.println("4 - Excluir Aluno");
			System.out.println("5 - Atualizar Aluno");
			System.out.println("6 - Voltar Menu Anterior");
			System.out.print("Sua opção: ");

			// lê a opção do usuário
			int opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("~~~ Cadastrar Aluno ~~~");
				System.out.println("Digite o nome do aluno: ");
				String nome = ler.next();

				System.out.println("Digite o e-mail do aluno: ");
				String email = ler.next();

				System.out.println("Digite o cpf do aluno: ");
				int cpf = ler.nextInt();

				System.out.println("Digite o sexo do aluno: [F/M]");
				String sexo = ler.next();

				System.out.println("Digite a matricula do aluno: ");
				int matricula = ler.nextInt();

				System.out.println("Digite a série do aluno: ");
				int anoEscolar = ler.nextInt();

				// Criando Objetos e passando os valores capturados como parametro para o
				// construtor.
				Aluno a = new Aluno(nome, email, cpf, sexo, matricula, anoEscolar);
				listaAluno.add(a);

				System.out.println("\nO Aluno foi cadastrado com sucesso!");

				break;
			case 2:
				System.out.println("\n~~~ Alunos Cadastrados ~~~");

				// O size() é um metodo da classe ArrayList que retorna o numero de elementos
				// atuais presentes na lista.
				// O for percorre e mostra a lista dos livros.
				for (int i = 0; i < listaAluno.size(); i++) {
					System.out.println("\nAluno " + i);
					System.out.println("\tNome: " + listaAluno.get(i).getNome());
					System.out.println("\tE-mail: " + listaAluno.get(i).getEmail());
					System.out.println("\tCPF: " + listaAluno.get(i).getCpf());
					System.out.println("\tSexo: " + listaAluno.get(i).getSexo());
					System.out.println("\tMatrícula: " + listaAluno.get(i).getMatricula());
					System.out.println("\tSérie: " + listaAluno.get(i).getAnoEscolar());
				}
				break;

			case 3:

				System.out.println("~~~ Pesquisar Aluno ~~~");
				System.out.println("Digite o CPF do Aluno desejado:");

				boolean x = false;

				int num = ler.nextInt();
				for (int i = 0; i < listaAluno.size(); i++) {
					if (num == listaAluno.get(i).getCpf()) {
						System.out.println("Aluno encontrado com sucesso!");
						System.out.println("\nAluno " + i);
						System.out.println("\tNome: " + listaAluno.get(i).getNome());
						System.out.println("\tE-mail: " + listaAluno.get(i).getEmail());
						System.out.println("\tCPF: " + listaAluno.get(i).getCpf());
						System.out.println("\tSexo: " + listaAluno.get(i).getSexo());
						System.out.println("\tMatrícula: " + listaAluno.get(i).getMatricula());
						System.out.println("\tSérie: " + listaAluno.get(i).getAnoEscolar());
						x = true;
					}
				}
				if (x == false) {
					System.out.println("Aluno não encontrado");
				}
				break;

			case 4:
				System.out.println("~~~ Remover Aluno ~~~");

				boolean remover = true;
				while (remover == true) {

					for (int i = 0; i < listaAluno.size(); i++) {
						System.out.println("\nAluno " + i);
						System.out.println("\tNome: " + listaAluno.get(i).getNome());
						System.out.println("\tE-mail: " + listaAluno.get(i).getEmail());
						System.out.println("\tCPF: " + listaAluno.get(i).getCpf());
						System.out.println("\tSexo: " + listaAluno.get(i).getSexo());
						System.out.println("\tMatrícula: " + listaAluno.get(i).getMatricula());
						System.out.println("\tSérie: " + listaAluno.get(i).getAnoEscolar());
					}

					System.out.println("Digite o valor de referência:");
					int ref = ler.nextInt();
					listaAluno.remove(ref);
					System.out.println("Aluno removido com sucesso!");

					for (int i = 0; i < listaAluno.size(); i++) {
						System.out.println("\nAluno " + i);
						System.out.println("\tNome: " + listaAluno.get(i).getNome());
						System.out.println("\tE-mail: " + listaAluno.get(i).getEmail());
						System.out.println("\tCPF: " + listaAluno.get(i).getCpf());
						System.out.println("\tSexo: " + listaAluno.get(i).getSexo());
						System.out.println("\tMatrícula: " + listaAluno.get(i).getMatricula());
						System.out.println("\tSérie: " + listaAluno.get(i).getAnoEscolar());
					}

					System.out.println("\nDeseja remover mais algum Luno?\n 1 - Sim\n 2 - Não");
					int rem = ler.nextInt();
					if (rem == 2) {
						remover = false;
					}
				}
				break;

			case 5:
				System.out.println("~~~ Atualização de Alunos ~~~");
				for (int i = 0; i < listaAluno.size(); i++) {
					System.out.println("\nAluno " + i);
					System.out.println("\tNome: " + listaAluno.get(i).getNome());
					System.out.println("\tE-mail: " + listaAluno.get(i).getEmail());
					System.out.println("\tCPF: " + listaAluno.get(i).getCpf());
					System.out.println("\tSexo: " + listaAluno.get(i).getSexo());
					System.out.println("\tMatrícula: " + listaAluno.get(i).getMatricula());
					System.out.println("\tSérie: " + listaAluno.get(i).getAnoEscolar());
				}
				System.out.println("Digite o valor de referência:");
				int ref = ler.nextInt();

				break;

			case 6:

				// Voltar ao Menu Anterior
				iniciar = false;
				break;

			}
		}
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getAnoEscolar() {
		return anoEscolar;
	}

	public void setAnoEscolar(int anoEscolar) {
		this.anoEscolar = anoEscolar;
	}

}
