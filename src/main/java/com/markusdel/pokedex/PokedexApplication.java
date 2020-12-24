package com.markusdel.pokedex;

import com.markusdel.pokedex.model.Pokemon;
import com.markusdel.pokedex.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class PokedexApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedexApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ReactiveMongoOperations operations, PokemonRepository repository){
		return args -> {
			Flux<Pokemon> pokemonFlux = Flux.just(
					new Pokemon(null,"Blastoise", "Marisco", "Torrente", 9.0),
					new Pokemon(null,"Catepie", "Minhoca", "Poeira do excuto", 2.08),
					new Pokemon(null,"Bulbasauro", "Semente", "Grandeza", 10.0))
					.flatMap(repository::save);

			pokemonFlux
					.thenMany(repository.findAll())
					.subscribe(System.out::println);
		};
	}
}
