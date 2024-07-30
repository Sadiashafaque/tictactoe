package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int dimension;

    Board(int dimension) // a board of n dim is formed
    {
        this.dimension = dimension;

        board = new ArrayList<>();
        for(int i=0;i<dimension;i++)
        {
            board.add(new ArrayList<>());
            for(int j=0;j<dimension;j++)
            {
                board.get(i).add(new Cell());
            }
        }
    }
    public List<List<Cell>> getBoard()
    {
        return this.board;
    }



    public int getDimension()
    {
        return this.dimension;
    }
    public Cell getCell(int row, int col)
    {
        return this.board.get(row).get(col);
    }

    public void printBoard()
    {
        for(List<Cell> ls : board)
        {
            for(Cell cell:ls)
            {
                if(cell.getSymbol() == null)
                {
                    System.out.print("| |");
                }
                else
                {
                    System.out.print("| " + cell.getSymbol().getSymbol() + " |");
                }
            }
            System.out.print("\n");
        }
    }


}
