package graficos;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Spritesheet {
    private BufferedImage spritesheet; // Armazena a spritesheet como uma BufferedImage

    // Construtor: carrega a spritesheet a partir do caminho especificado
    public Spritesheet(String path) {
        try {
            spritesheet = ImageIO.read(getClass().getResource(path)); // Carrega a spritesheet do arquivo especificado
        } catch (IOException e) {
            e.printStackTrace(); // Em caso de erro, imprime a exceção
        }
    }
    
    // Método para obter um sprite específico da spritesheet
    public BufferedImage getSprite(int x, int y, int width, int height) {
        // Retorna um recorte (subimagem) da spritesheet nas coordenadas (x, y) com a largura e altura especificadas
        return spritesheet.getSubimage(x, y, width, height);
    }
}
