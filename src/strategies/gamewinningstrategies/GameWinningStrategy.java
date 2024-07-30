package strategies.gamewinningstrategies;

import models.Move;

public interface GameWinningStrategy {
    public boolean checkIfWon(Move move);

}
