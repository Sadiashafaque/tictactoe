package strategies;

import models.*;

import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeNextMove(Board board, Player player) {
        int row = -1;
        for(List<Cell> ls : board.getBoard())
        {
            row++;
            int col = -1;
            for(Cell cell : ls)
            {
                col++;
                if(cell.getSymbol() == null) //1st cell whose symbol is null
                {
                    cell.setRow(row);
                    cell.setColumn(col);
                    cell.setSymbol(player.getSymbol());
                    Move move = new Move();
                    move.makeMove(cell, player);
                    return move;
                }
            }
        }
    return null;
    }
}
