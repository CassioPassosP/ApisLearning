import a2025.Filme;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Scanner leitura = new Scanner(System.in);
//        System.out.println("Digite um filme para busca:");
//
//        var busca  = leitura.nextLine();
//
//        String endereco = "http://www.omdbapi.com/?i" + busca + "&apikey=f4e5e46c";
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://www.omdbapi.com/?i=tt3896198&apikey=f4e5e46c"))
//                .build();
//
//        HttpResponse<String> response = client
//                .send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());

        var busca = "";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        List<Titulo> titulos = new ArrayList<>();

        while (!busca.equalsIgnoreCase("sair")) {
            Scanner leitura = new Scanner(System.in);
            System.out.println("Digite o nome do filme para busca:");
            busca = leitura.nextLine();


            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            String chave = "f4e5e46c";
            String nomeCodificado = URLEncoder.encode(busca, StandardCharsets.UTF_8.toString());
            String endereco = "https://www.omdbapi.com/?t=" + nomeCodificado + "&apikey=" + chave;

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
//            System.out.println(json);

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido");
//                System.out.println(meuTitulo);
//                FileWriter escrita = new FileWriter("Filmes.txt");
//                escrita.write(meuTitulo.toString());
//                escrita.close();

                titulos.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(titulos);

            FileWriter escrita = new FileWriter("filmes.json");
            escrita.write(gson.toJson(titulos));
            escrita.close();
            System.out.println("O programa finalizou corretamente!");

        }
    }
}

