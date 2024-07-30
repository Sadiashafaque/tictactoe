package controllers;

import models.Game;
import models.GameStatus;
import models.Player;
import strategies.gamewinningstrategies.GameWinningStrategy;

import java.util.List;

public class GameController {
    public Game createGame(int dimensionOfBoard,
                           List<Player> players,
                           List<GameWinningStrategy> strategies)
    {
        Game game = Game.create().
                setDimension(dimensionOfBoard).
                addGameWinningStrategies(strategies).
                addPlayers(players).build();

        return game;
    }
    public boolean makeMove(Game game)
    {
        //System.out.println("Wrong row or col given try again");
        return game.makeMove();
    }

    public boolean undo(Game game) {
        return game.Undo();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void display(Game game) {
        game.getBoard().printBoard();
    }

}
