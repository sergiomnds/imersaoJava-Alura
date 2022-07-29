import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // ? PEGAR OS DADOS DO IMDB - Fazer uma conexão HTTP e buscar o Top 250 Filmes
        // String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        // ! URL Alternativa, pois o API do IMDB está fora do ar!
        String url = "https://api.nasa.gov/planetary/apod?api_key=QbKfDf00kyvdWOrgfDfeUCVO4jQjhIxgs8eGCMRv&start_date=2022-06-12&end_date=2022-06-14";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // ? Pegar só os dados que interessam (título, pôster, nota).
        var parser = new JsonParser();
        List<Map<String, String>> listaConteudos = parser.parse(json);

        // ? Exibir e Manipular os dados.
        var gerador = new GeradorFigurinhas();
        for (int i = 0; i < 10; i++) {
            Map<String, String> conteudo = listaConteudos.get(i);
            String urlImagem = conteudo.get("image").replace("(@+)(.*).jpg$", "$1.jpg");

            String titulo = conteudo.get("title").replace(" ", "");

            try {
                InputStream inputStream = new URL(urlImagem).openStream();
                String nomeArquivo = titulo + ".png";
                gerador.criar(inputStream, nomeArquivo);
            } catch (Exception e) {
                System.out.println("Erro ao baixar a imagem: " + urlImagem);
            }
        }
    }
}