# API RESTful para um game incremental baseado em clicks.

O game é baseado em clicar em um formiga para ganhar pontos.

### Como rodar:
>```docker run --name clicker -p 8080:8080 mss1569/clicker```

1) Para iniciar o game o jogador precisa se cadastrar e estar logado.
>```POST /user```
>```
>{
>    "username":"user"
>    "password":"pass"
>}
>```

A autenticação é feita usando Basic Authentication.

2) Cada usuario precisa criar uma nova formiga para iniciar o game.
>```POST /ant```

A formiga inicia no nivel 0, e possui 0 pontos.

3) O game consiste em clicar na formiga e acumular pontos.
>```GET /ant/click```

4) Conforme for acumulando pontos a formiga pode ser melhorada para niveis maiores, quanto maior o nivel mais pontos ela ira receber por clique.
>```GET /ant/upgrade```

### [Swagger](http://localhost:8080/swagger-ui.html)


### Tecnologias utilizadas:


Java 11

Spring Boot 2x

H2

Swagger 3