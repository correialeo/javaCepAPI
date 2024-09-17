package com.fiap.api.services;

import com.fiap.api.model.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ViaCepService {

    public Endereco getEndereco(String cep){
        Endereco endereco = null;
        try {

            HttpGet request = new HttpGet("https://viacep.com.br/ws/"+cep+"/json/");
            CloseableHttpClient httpClient = HttpClientBuilder.create().
                    disableRedirectHandling().build();
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null){
                String result = EntityUtils.toString(entity);
                //gson transforma tudo em objeto
                Gson gson = new Gson();
                endereco = gson.fromJson(result, Endereco.class);
            } else {
                System.out.println("CEP inválido");
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }

        return endereco;
    }
}
