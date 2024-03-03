package aula_11_exemplo_completo_poo;

public class Game {

	private Player player; // Declaração da variável 'player' do tipo Player, que será utilizada para representar o jogador do jogo.
	private Inimigo inimigo; 
	
	public Game() { // Construtor da classe Game.
		player = new Player(); // Instanciação de um novo objeto Player e atribuição à variável 'player'.
		inimigo = new Inimigo(); 
	}
	
	public Player getPlayer() { // Retorna o objeto Player.
		return player; 
	}
	
	public Inimigo getInimigo() { 
		return inimigo;
	}

	public static void main(String[] args) { // Método principal.
		Game game = new Game(); // Instanciação novo objeto da classe Game.
	
		Player player = game.getPlayer();
		player.atacarInimigo(game.getInimigo()); //Chama o método do player de atacar o inimigo onde ele remove a vida no inimigo.
			
		System.out.println(" A vida do inimigo atual é :"+game.getInimigo().life); 
		//Solicitando para que mostre a vida no Inimigo
	}
	
}

