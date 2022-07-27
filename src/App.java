import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // ? PEGAR OS DADOS DO IMDB - Fazer uma conexão HTTP e buscar o Top 250 Filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        // ! URL Alternativa, pois o API do IMDB está fora do ar!

        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // ? Pegar só os dados que interessam (título, pôster, nota).
        var parser = new JsonParser();
        List<Map<String, String>> listaFilmes = parser.parse(body);

        // ? Exibir e Manipular os dados.
        var gerador = new GeradorFigurinhas();
        for (Map<String, String> filme : listaFilmes) {
            String urlImagem = filme.get("image");

            if (urlImagem.contains("._V1_UY176_CR0,0,128,176_AL_")) {
                urlImagem = urlImagem.replace("._V1_UY176_CR0,0,128,176_AL_", "");
            }
            if (urlImagem.contains("._V1_UX128_CR0,3,128,176_AL_")) {
                urlImagem = urlImagem.replace("._V1_UX128_CR0,3,128,176_AL_", "");
            }
            if (urlImagem.contains("._V1_UX128_CR0,1,128,176_AL_")) {
                urlImagem = urlImagem.replace("._V1_UX128_CR0,1,128,176_AL_", "");
            }

            String titulo = filme.get("title").replace(" ", "");

            if (titulo.contains(":")) {
                titulo = titulo.replace(":", "");
            }

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