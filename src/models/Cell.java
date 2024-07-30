package models;

public class Cell {
    private int row;
    private int column;
    private Symbol symbol;

    public void clearCell()
    {
        this.symbol = null;
    }
    public void setSymbol(Symbol symbol)
    {
        this.symbol = symbol;
    }
    public Symbol getSymbol()
    {
        return this.symbol;
    }
}
