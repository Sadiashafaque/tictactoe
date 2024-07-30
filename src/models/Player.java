package models;

public abstract class Player {
    private Symbol symbol;
    private PlayerType playerType;

    Player(PlayerType playerType,Symbol symbol)
    {
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
    public Symbol getSymbol()
    {
        return this.symbol;
    }

    public abstract Move makeMove(Board board);
}
