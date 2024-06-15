package com.Games.games.Controller;

import com.Games.games.DTO.GameDTO;
import com.Games.games.Entity.Game;
import com.Games.games.Mapper.GameMapper;
import com.Games.games.Service.impl.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/juegos")
public class GameController {

    private final GameServiceImpl gameServiceImpl;

    @Autowired
    public GameController(GameServiceImpl gameServiceImpl) {

        this.gameServiceImpl = gameServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameServiceImpl.getAllGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/{idJuego}")
    public ResponseEntity<Game> getGame(@PathVariable Long idJuego) {
        Game gameId = gameServiceImpl.getGame(idJuego);
        if (gameId != null) {
            return new ResponseEntity<>(gameId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createGame(@RequestBody GameDTO gameDTO) {
        Game game = GameMapper.toEntity(gameDTO);
        Game gameSaved = gameServiceImpl.createGame(game);
        return new ResponseEntity<>(gameSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{idJuego}")
    public ResponseEntity<?> updateGame(@PathVariable Long idJuego, @RequestBody GameDTO gameDTO) {
        Game gameId = gameServiceImpl.getGame(idJuego);
        if (gameId != null) {
            Game gameUpdated = GameMapper.toEntity(gameDTO);
            gameUpdated.setIdJuego(idJuego);
            Game gameSaved = gameServiceImpl.updateGame(idJuego, gameUpdated);
            return new ResponseEntity<>(gameSaved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idJuego}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long idJuego) {
        gameServiceImpl.deleteGame(idJuego);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
