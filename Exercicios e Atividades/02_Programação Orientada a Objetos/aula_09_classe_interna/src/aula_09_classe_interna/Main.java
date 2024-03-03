package aula_09_classe_interna;

public class Main {

	public static void main (String[] args) { //metodo principal do java
		new Main().intanceMain2();
	}
	
	//tudo daqui para baixo está fora do método principal do java
	
	public void intanceMain2() {
		new Main2().print1();//chamando método da classe main2
	}
	
	private class Main2{ //criando classe privada interna
		public void print1() { //métodos somente acessiveis dentro da classe
			System.out.println("Método Chamado!");
		}
	}
	
	
}
