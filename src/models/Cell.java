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

    public void setRow(int row)
    {
        this.row = row;
    }
    public void setColumn(int column)
    {
        this.column = column;
    }
    public int getRow()
    {
        return this.row;
    }
    public int getColumn()
    {
        return this.column;
    }

}
