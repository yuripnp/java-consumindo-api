import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.input.VideoOmdb;
import model.Video;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o filme que deseja buscar");
        var busca = scanner.nextLine();
        try {
            String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=b1d5ee01";

            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco)).build();
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String json = response.body();
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            VideoOmdb videoOmdbInput = gson.fromJson(json, VideoOmdb.class);

            Video video = new Video(videoOmdbInput);
            System.out.println(video);
        }catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }


    }
}
