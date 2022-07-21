import java.net.URI;
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
        for (Map<String, String> filme : listaFilmes) {
            System.out.println();
            System.out.println(
                    "\u001b[1m\u001b[34mTitle: " + filme.get("title") + "\u001b[0m");
            System.out.println("\u001b[1mFilm Poster: \u001b[0m" + filme.get("image"));
            System.out.println("\u001b[1m\u001b[41mRating: " + filme.get("imDbRating") + "\u001b[0m");
            for (int i = 0; i < Double.parseDouble(filme.get("imDbRating")); i++) {
                System.out.print("★"); // Unicode: U+2B50
            }
            System.out.println();
            System.out.println("---------------------------------");
        }
    }
}