package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConvesaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("Sair")) {

            System.out.println("Digite o nome do filme para busca: ");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            String buscaCodificada = URLEncoder.encode(busca, StandardCharsets.UTF_8);
            String endereco = "http://www.omdbapi.com/?t=" + buscaCodificada + "&apikey=2ce2eada";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                TituloOmdb meuTituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);
                System.out.println(meuTituloOmdb);
                //try{
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo convertido: ");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Não foi possível converter o ano de lançamento para número inteiro");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Ocorreu um erro de argumento inválido: ");
                System.out.println(e.getMessage());
            } catch (ErroDeConvesaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Titulos buscados: " + titulos);

        FileWriter escrita = new FileWriter("titulos.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("Fim do programa");


    }
}
