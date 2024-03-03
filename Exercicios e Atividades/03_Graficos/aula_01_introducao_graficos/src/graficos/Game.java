package graficos;

//Improtando os metodos do java.
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{	//criando o metodo Canvas para criar graficos.
	public static JFrame frame; //chamando o meotodo JFrame.
	private final int WIDHT = 10;
	private final int HEIGHT = 120;
	private final int SCALE = 3;
	//definindo o tamanho da tela.
	
	public Game() {
		this.setPreferredSize(new Dimension(WIDHT*SCALE,HEIGHT*SCALE));		//definindo do Game os tamanhos pré-definidos anteriormente.
		frame = new JFrame();
		frame.add(this); //chamando o tamanho definido
		frame.setResizable(false); //impedindo que o usuario possa redimensionar a janela.
		frame.pack(); //calcular as dimensões e exibi-las na tela.
		frame.setLocationRelativeTo(null); //centralizando a janela.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //define que quando clicar para fechar a janela ele de fato feche.
		frame.setVisible(true); //para deixar a janela visivel
	}
	
	
	public static void main(String args[]) {
	Game game = new Game(); //colocando o obj game no método principal
	}
	
	
	public void run() {
	}
	
}
	
