package strategies;

import models.Board;
import models.Move;
import models.Player;
import models.Symbol;

public interface BotPlayingStrategy {
    public Move makeNextMove(Board board, Player player);
}
