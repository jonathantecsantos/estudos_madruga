package services;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import records.EnderecoRecord;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class ConsultaCepService {

    private static final Gson gson = new Gson();

    public EnderecoRecord buscaEndereco(String cep){

        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = null;

        try {
//            response = client
//                    .send(request, HttpResponse.BodyHandlers.ofString());

            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(httpResponse.body(), EnderecoRecord.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Dados não obtidos através do cep " + cep);
        }

        //return new Gson().fromJson(response.body(), EnderecoRecord.class);

    }
}
