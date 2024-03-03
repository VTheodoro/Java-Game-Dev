package aula_08_poo;

public class Main {

	public static void main(String[] args) {
		Player player = new Player(); //instanciando uma herança com a classe player
		player.startPlayer(); //chamando um méto instanciado em outra classe
		
		Enemy enemy = new Enemy(); //isso declara como um "tipo" e cria um objeto
		enemy.startEnemy();
		
		Player player2 = new Player(); //podemos criar dois do mesmo tipo, herdando os métodos da classe definida, no caso desta, player
		player2.startPlayer();
	}
	
}
