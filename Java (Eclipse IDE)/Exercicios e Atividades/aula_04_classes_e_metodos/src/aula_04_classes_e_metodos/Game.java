package aula_04_classes_e_metodos;

public class Game {

	public static void main(String[] args) {
	
		Player player = new Player();
		
		player.perderVida();
		
		System.out.println(player.vida);
		
	}
}
