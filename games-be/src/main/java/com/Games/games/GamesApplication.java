package com.Games.games;

import com.Games.games.Entity.Game;
import com.Games.games.Repository.GameRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class GamesApplication implements CommandLineRunner {

	@Autowired
	private GameRepository gameRepository;

	public static void main(String[] args) {
		SpringApplication.run(GamesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		loadDefaultGames();
	}

	private void loadDefaultGames() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Game>> typeReference = new TypeReference<>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/defaultGames.json");

		try {
			List<Game> games = mapper.readValue(inputStream, typeReference);
			gameRepository.saveAll(games);
			System.out.println("Default games loaded.");
		} catch (IOException e) {
			System.out.println("Unable to load default games: " + e.getMessage());
		}
	}

}
