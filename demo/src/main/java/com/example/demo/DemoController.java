package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

//    @GetMapping("/middle/teste")
//    public String testeD() {
//        String nome = "Vitor";
//        String email = "vitor@gmail.com";
//        int idade = 19;
//        String sexo = "Masculino";
//
//        String servletUrl = "http://localhost:8081/maven/primeiroservlet?nome=" + nome + "&email=" + email + "&idade=" + idade + "&sexo=" + sexo;
//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
//
//        ResponseEntity<String> responseEntity = restTemplate.exchange(
//                servletUrl,
//                HttpMethod.GET,
//                requestEntity,
//                String.class
//        );
//
//        int status = responseEntity.getStatusCodeValue();
//        String respostaDoServlet = responseEntity.getBody();
//
//        String result = "Status da resposta: " + status + "\n";
//        result += "Resposta do servlet: " + respostaDoServlet;
//        return result;
//    }
    
    @GetMapping("/middle/teste/{id}")
    public ResponseEntity<String> comID(@PathVariable(required = false) Integer id) {
        if (id == null) {
            return new ResponseEntity<>("Nenhum ID fornecido", HttpStatus.BAD_REQUEST);
        }
        String servletUrl = "http://localhost:8081/maven/primeiroservlet/" + id;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                servletUrl,
                HttpMethod.GET,
                requestEntity,
                String.class
        );
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity;
        } else {
            return new ResponseEntity<>("Erro ao acessar o servlet", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/middle/teste")
    public ResponseEntity<String> semID() {

        String servletUrl = "http://localhost:8081/maven/primeiroservlet";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                servletUrl,
                HttpMethod.GET,
                requestEntity,
                String.class
        );
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity;
        } else {
            return new ResponseEntity<>("Erro ao acessar o servlet", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


