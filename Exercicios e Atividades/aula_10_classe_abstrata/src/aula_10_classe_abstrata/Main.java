package aula_10_classe_abstrata;

public class Main extends testAbstract{ 
	//para utilizarmos os métodos de uma classe abstrada, preicsamos dar o comando extends em nosso método principal
//não é possivel chamar os métodos de uma classe abstrata sem isso.
	//quando damos o extends de uma classe abstrata, estamos herdando TODOS os métodos dela.
	//então tecnicamente ela não é um objeto 100%, e sim algo abstrato para organizar os métodos de uma melhor forma na hora de chama-los ao código principal.
	
	public static void main(String[] args) {

	}
	
	public void chamarMetodoAbstrato() {
		escrever();
	}
	
}

//OBS: a classe abstrata são utilizadas em casos BEEEM especificos.