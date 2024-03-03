package aula_11_exemplo_completo_poo;

public class Player {

	private int life = 100; //Declarando a quantidade de vida do player
	
	public void atacarInimigo(Inimigo inimigo) { //Criando o método de atacar inimigo
		inimigo.life--; //Removendo -1 de life no inimigo.
	}
	
}
