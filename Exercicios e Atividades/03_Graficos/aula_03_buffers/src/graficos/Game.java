package graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{	
	public static JFrame frame; 
	private Thread thread;
	private boolean isRunning = true;
	private final int WIDHT = 160;
	private final int HEIGHT = 120;
	private final int SCALE = 3;

	private BufferedImage image;
	
	public Game() {
		this.setPreferredSize(new Dimension(WIDHT*SCALE,HEIGHT*SCALE));		//definindo do Game os tamanhos pré-definidos anteriormente.
		initFrame();
		image = new BufferedImage(120,120,BufferedImage.TYPE_INT_RGB);
	}
	
	public void initFrame() { 
		frame = new JFrame("Game");
		frame.add(this); 
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public synchronized void start() { 
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
	
	public void render() { // Método responsável por renderizar o jogo
		BufferStrategy bs = this.getBufferStrategy(); // Obtém a estratégia de buffer da tela
		if(bs == null) { // Verifica se a estratégia de buffer é nula
			this.createBufferStrategy(3); // Se for nula, cria uma nova estratégia de buffer tripla
			return; // Retorna para evitar exceções e sair do método
		}
		Graphics g = bs.getDrawGraphics(); // Obtém o contexto gráfico para desenhar
		g.setColor(new Color(19,19,19)); // Define a cor de fundo
		g.fillRect(0, 0, WIDHT, HEIGHT); // Preenche o fundo com a cor especificada
		
		// Redesenha a imagem na tela com o tamanho escalado
		g.drawImage(image, 0,0,WIDHT*SCALE,HEIGHT*SCALE,null);
		
		bs.show(); // Mostra o conteúdo desenhado
		g.dispose(); // Libera os recursos gráficos
	}

	
	public void run() { 
		long lastTime = System.nanoTime(); 
		double amountOfTicks = 60.0; 
		double ns = 1000000000 / amountOfTicks; 
		double delta = 0; 
		
		int frames = 0;
		double timer = System.currentTimeMillis(); 
		
		while(isRunning) { 
			long now = System.nanoTime(); 
			delta+= (now - lastTime)/ ns; 
			lastTime = now; 
			
			if(delta>=1) { 
				tick(); 
				render(); 
				frames++; 
				delta--; 
			}
			
			if(System.currentTimeMillis() -  timer >= 1000) { 
				System.out.println("FPS: "+frames);
				frames = 0;
				timer+=1000;
			}
			
		}
		
		stop();
		
	}

		

	}
	
	
