import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.omdbapi.com/?t=divertidamente&apikey=b1d5ee01")).build();
        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
