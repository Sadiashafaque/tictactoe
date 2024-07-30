package models;

import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(Symbol symbol)
    {
        super(PlayerType.HUMAN,symbol);
    }
    @Override
    public Move makeMove(Board board)
    {
        //ask for row and col from user in which they want to make move
        Scanner myObj = new Scanner(System.in);

        System.out.println("Tell Row Number starting from 1 to" + " "+board.getDimension());
        int row = myObj.nextInt();

        System.out.println("Tell Column Number where you want to make the move from 1" + " "+board.getDimension());
        int col = myObj.nextInt();

        if(row<=0 || row>board.getDimension() || col<=0 || col>board.getDimension())
        {
            return null;
        }

//        Symbol symbol = this.getSymbol();
//        board.getCell(row-1,col-1).setSymbol(symbol);

        Cell cell = board.getCell(row-1,col-1); // get the cell of the given indices
        cell.setRow(row-1);
        cell.setColumn(col-1);
        if(cell.getSymbol() != null)
        {
            return null;
        }
        cell.setSymbol(this.getSymbol());
        Move move = new Move();
        move.makeMove(cell, this);

        return move;

    }
}
