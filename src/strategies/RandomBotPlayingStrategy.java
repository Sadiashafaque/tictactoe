package strategies;

import models.*;

import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeNextMove(Board board, Player player) {
        for(List<Cell> ls : board.getBoard())
        {
            for(Cell cell : ls)
            {
                if(cell.getSymbol() == null)
                {
                    Move move = new Move();
                    move.makeMove(cell, player, player.getSymbol());
                    return move;
                }
            }
        }
    return null;
    }
}
