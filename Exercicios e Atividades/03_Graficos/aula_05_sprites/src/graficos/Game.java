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
	
	private Spritesheet sheet;
	private BufferedImage player;
	
	public Game() {
		sheet = new Spritesheet("/spritesheet.png");
		player = sheet.getSprite(0, 0, 16, 16);
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
		isRunning = false;
		try {
			thread.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) {
	Game game = new Game();
	game.start();
	}
	
	public void tick() {
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(19,19,19));
		g.fillRect(0, 0, WIDHT, HEIGHT);

//renderização do jogo.
		g.drawImage(player,20,20,null);
		
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0,0,WIDHT*SCALE,HEIGHT*SCALE,null);
		bs.show();
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
	
	
