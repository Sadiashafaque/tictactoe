package models;

public class Move {
    private Cell cell;
    private Player player;
    //private Symbol symbol;

    public void makeMove(Cell cell, Player player)
    {
        this.cell = cell;
        this.player = player;
        //this.symbol = symbol;
    }
    public void setCell(Cell cell)
    {
        this.cell = cell;
    }
    public Cell getCell()
    {
        return this.cell;
    }

    public Symbol getSymbol()
    {
        return this.player.getSymbol();
    }
}
