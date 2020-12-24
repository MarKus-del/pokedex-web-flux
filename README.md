# Pokedex web flux

este projeto consiste em uma api reativa feito em spring-flux um ecossitema java
para criar aplicações reativas, foi utilizado o mongodb embedded para persistir os
dados durante a api

## endpoints
+ http://localhost:8080/pokemons
    + metodos diponiveis: get, post, put, delete

+ http://localhost:8080/pokemons/event
    + metodos diponiveis: get

## rotas
### rotas get
    + para mostrar todos os pokemons: http://localhost:8080/pokemons
    + para mostrar um pokemon pelo id: http://localhost:8080/pokemons/{id}

### rotas post
    + para criar um novo pokemon, necessario enviar via body um objeto JSON com os campos: nome, habilidade, categoria, peso;
    OBS: todos os campos são string exceto o peso ele é do tipo Double, o id é gerado automaticamente pelo mongodb
    ;URI: http://localhost:8080/pokemons
### rotas put
    + para atualizar um pokemons enviar um objeto do mesmo tipo do de criar porem com o id do pokemon para atualiza-lo;
    URI: http://localhost:8080/pokemons/{id}
### rotas delete
    + para deletar um pokemon é necessario enviar o id do pokemon na uri;
        URI: http://localhost:8080/pokemons/{id}

