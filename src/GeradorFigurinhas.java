import java.awt.image.BufferedImage;
import java.io.File;
// import java.io.FileInputStream;
import java.io.InputStream;
// import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class GeradorFigurinhas {
    public void criar(InputStream inputStream, String nomeArquivo) throws Exception {
        // ? Leitura da Imagem

        // * LEITURA DE ARQUIVO
        // * InputStream inputStream = new FileInputStream(new
        // * File("entrada/filme.jpg"));

        // * LEITURA DE URL
        // * InputStream inputStream = new URL(
        // *"https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
        // * .openStream();

        BufferedImage imgOriginal = ImageIO.read(inputStream);

        // ? Cria nova Imagem em Memória com Transparência e com tamanho novo
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();

        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // ? Copiar a Imagem original para novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        // ? Configurar a Fonte
        graphics.setColor(Color.YELLOW);
        Font fonte = new Font("Comic Sans MS", Font.BOLD, 80);
        graphics.setFont(fonte);

        // ? Escrever uma frase na nova imagem
        graphics.drawString("TOP DMS!!", 150, novaAltura - 100);

        // ? Escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
    }

    // ! MAIN PARA TESTES
    /*
     * public static void main(String[] args) throws Exception {
     * var geradora = new GeradorFigurinhas();
     * geradora.criar();
     * }
     */
}
