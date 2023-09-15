# Middle usando Spring boot

## Descrição do Projeto

Este é um exemplo de aplicativo Spring Boot que faz uma solicitação POST para outro serviço da web. Ele também inclui uma classe de modelo chamada `PersonModel` para representar os dados enviados na solicitação.

## Como Funciona

1. O aplicativo Spring Boot define um controlador chamado `DemoController` que lida com solicitações POST na rota `/middle/teste`.

2. Quando uma solicitação POST é feita para `/middle/teste`, o controlador `DemoController` é acionado.

3. Ele usa a classe `RestTemplate` para criar uma solicitação POST para `http://localhost:8081/maven/primeiroservlet`.

4. Os dados do `PersonModel` fornecidos no corpo da solicitação são serializados como JSON.

5. A resposta do serviço em `http://localhost:8081/maven/primeiroservlet` é capturada e processada.

6. A resposta é retornada como uma string que inclui o status da resposta e a resposta do servlet.

## Como Usar

Para usar este projeto como exemplo:

1. Configure um projeto Spring Boot e adicione as dependências necessárias, como `spring-web` e `jackson-databind`.

2. Copie o código-fonte do controlador `DemoController` e da classe `PersonModel` para o seu projeto.

3. Certifique-se de que o serviço em `http://localhost:8081/maven/primeiroservlet` esteja em execução para que você possa testar a solicitação POST.

4. Faça uma solicitação POST para `http://localhost:8080/middle/teste` com dados JSON no corpo da solicitação para ver o exemplo em ação.

5. A resposta será uma mensagem que inclui o status da resposta e a resposta do servlet.

Isso conclui a descrição de alto nível de como o código funciona e como usá-lo em seu projeto Spring Boot. Certifique-se de ajustar o código e as configurações de acordo com suas necessidades específicas.
