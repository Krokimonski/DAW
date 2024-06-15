package com.Games.games.Service;

import com.Games.games.Entity.Game;

import java.util.List;

public interface GameService {
    List<Game> getAllGames();
    Game getGame(Long idJuego);
    Game createGame(Game game);
    Game updateGame(Long idJuego, Game game);
    void deleteGame(Long idJuego);
}
