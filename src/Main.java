import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.input.VideoOmdb;
import model.Video;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String buscar = "";
        List<Video> videos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while(!buscar.equalsIgnoreCase("sair")) {

            System.out.println("Digite o filme que deseja buscar");
            var busca = scanner.nextLine();
            if(busca.equalsIgnoreCase("sair")) {
                break;
            }
            try {
                String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=b1d5ee01";

                HttpClient cliente = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco)).build();
                HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                String json = response.body();

                VideoOmdb videoOmdbInput = gson.fromJson(json, VideoOmdb.class);

                Video video = new Video(videoOmdbInput);
                System.out.println(video);

                videos.add(video);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        FileWriter arquivo = new FileWriter("filmes.json");
        arquivo.write(gson.toJson(videos));
        arquivo.close();
        System.out.println(videos);

    }
}
