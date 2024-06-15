package com.Games.games.Mapper;

import com.Games.games.DTO.GameDTO;
import com.Games.games.Entity.Game;

public class GameMapper {

    public static Game toEntity(GameDTO gameDTO) {
        if (gameDTO == null) {
            return null;
        }

        Game game = new Game();
        game.setIdJuego(gameDTO.getIdJuego());
        game.setTitulo(gameDTO.getTitulo());
        game.setDescripcion(gameDTO.getDescripcion());
        game.setPrecio(gameDTO.getPrecio());

        return game;
    }

    public static GameDTO toDTO(Game game) {
        if (game == null) {
            return null;
        }

        GameDTO gameDTO = new GameDTO(
                game.getIdJuego(),
                game.getTitulo(),
                game.getDescripcion(),
                game.getPrecio()
        );

        return gameDTO;
    }
}
