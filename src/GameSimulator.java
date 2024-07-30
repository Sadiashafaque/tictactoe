import controllers.GameController;
import models.*;
import strategies.gamewinningstrategies.GameWinningStrategy;
import strategies.gamewinningstrategies.OrderOneGameWinningStrategy;

import java.util.List;

public class GameSimulator {

    public static void main(String[] args) {
        int dimension = 3;
        Player p1 = new HumanPlayer(new Symbol('S'));
        Player p2 = new Bot(new Symbol('O'), BotDifficultyLevel.EASY);
        GameWinningStrategy strategy = new OrderOneGameWinningStrategy();
        ////GameWinningStrategy strategy2 = new OrderNGameWinningStrategy();
        GameController gameController = new GameController();

        Game game = gameController.createGame(dimension, List.of(p1, p2), List.of(strategy));
//
        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            System.out.println("Please Make the Next Move. This is current Status");
            gameController.display(game);
            while(!gameController.makeMove(game))
            {
                System.out.println("Wrong row or col given try again");
                gameController.display(game);
            }
        }
//
        if (gameController.getGameStatus(game).equals(GameStatus.ENDED)) {
            System.out.println("WINNER WINNER CHICKEN DINNER " + game.getWinner().getSymbol().getCharacter() + " Has won the game");
            gameController.display(game);
        }
//
        if (gameController.getGameStatus(game).equals(GameStatus.DRAW)) {
            System.out.println("UH OH. Try AGain. No one won");
            gameController.display(game);
        }
    }
}
