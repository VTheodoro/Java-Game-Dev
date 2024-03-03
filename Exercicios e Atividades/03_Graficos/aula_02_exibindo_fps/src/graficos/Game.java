package graficos;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{	
	public static JFrame frame; 
	private Thread thread;
	private boolean isRunning = true;
	private final int WIDHT = 160;
	private final int HEIGHT = 120;
	private final int SCALE = 3;

	
	public Game() {
		this.setPreferredSize(new Dimension(WIDHT*SCALE,HEIGHT*SCALE));		//definindo do Game os tamanhos pré-definidos anteriormente.
		initFrame();
	}
	
	public void initFrame() { //criando um método para exibir graficos
		frame = new JFrame("Game");//define o nome do game
		frame.add(this); 
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public synchronized void start() { //método de verificar se o jogo está rodando
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void stop() {
		
	}
	
	public static void main(String args[]) {
	Game game = new Game();
	game.start();
	}
	
	public void tick() {
		
	}
	
	public void render() {
		
	}
	
	public void run() { // Controla a execução do jogo
		long lastTime = System.nanoTime(); // Captura o tempo atual em nanossegundos
		double amountOfTicks = 60.0; // Quantidade desejada de atualizações por segundo
		double ns = 1000000000 / amountOfTicks; // Calcula o tempo em nanossegundos por atualização
		double delta = 0; // Armazena a quantidade de tempo acumulada desde a última atualização
		
		int frames = 0; // Contador de quadros renderizados
		double timer = System.currentTimeMillis(); // Captura o tempo atual em milissegundos
		
		while(isRunning) { // Loop principal enquanto o jogo está em execução
			long now = System.nanoTime(); // Captura o tempo atual em nanossegundos
			delta+= (now - lastTime)/ ns; // Calcula a quantidade de tempo acumulada desde a última atualização
			lastTime = now; // Atualiza o tempo da última atualização
			
			if(delta>=1) { // Verifica se é hora de atualizar
				tick(); // Chama o método de atualização
				render(); // Chama o método de renderização
				frames++; // Incrementa o contador de quadros renderizados
				delta--; // Reduz o delta para indicar que uma atualização ocorreu
			}
			
			if(System.currentTimeMillis() -  timer >= 1000) { // Verifica se passou 1 segundo
				System.out.println("FPS: "+frames); // Exibe o número de quadros renderizados no último segundo
				frames = 0; // Reinicia o contador de quadros
				timer+=1000; // Atualiza o temporizador para o próximo segundo
			}
			
		}
	}

		

	}
	
	
