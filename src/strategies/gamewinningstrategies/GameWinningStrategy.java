package strategies.gamewinningstrategies;

import models.Board;
import models.Cell;
import models.Move;
import models.Player;

public interface GameWinningStrategy {
    public boolean checkIfWon(Board board, Player player, Cell moveCell);

}
