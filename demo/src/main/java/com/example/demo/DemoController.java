package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class DemoController {

    @PostMapping("/middle/teste")
    public String teste(@RequestBody PersonModel dadosUsuario) {
        String result = "Método teste\n";
        final String endereco = "http://localhost:8081/maven/primeiroservlet";

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(endereco)
                    .queryParam("nome", dadosUsuario.getNome())
                    .queryParam("email", dadosUsuario.getEmail())
                    .queryParam("idade", dadosUsuario.getIdade())
                    .queryParam("sexo", dadosUsuario.getSexo());

            HttpEntity<String> requestEntity = new HttpEntity<>(headers);

            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );

            int status = responseEntity.getStatusCodeValue();
            result += "Status da resposta: " + status + "\n";
            result += "Resposta do servlet: " + responseEntity.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}


