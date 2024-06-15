package com.Games.games.Service.impl;

import com.Games.games.Entity.Game;
import com.Games.games.Repository.GameRepository;
import com.Games.games.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {

        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {

        return gameRepository.findAll();
    }

    public Game getGame(Long idJuego) {

        return gameRepository.findById(idJuego).orElse(null);
    }

    public Game createGame(Game game) {

        return gameRepository.save(game);
    }

    public Game updateGame(Long idJuego, Game game) {
        Game gameId = getGame(idJuego);
        if (gameId != null) {
            gameId.setTitulo(game.getTitulo());
            gameId.setDescripcion(game.getDescripcion());
            gameId.setPrecio(game.getPrecio());

            return gameRepository.save(gameId);
        }
        return null;
    }

    public void deleteGame(Long idJuego) {
        gameRepository.deleteById(idJuego);
    }

}
