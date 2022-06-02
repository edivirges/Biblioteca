package padrao;

public class Usuario {
	private String nome;
	private String email;
	private int cpf;
	private String sexo;
	
	//Construtor
	public Usuario(){
	  
}
	//Construtor
	public Usuario (String nome, String email, int cpf, String sexo) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}

