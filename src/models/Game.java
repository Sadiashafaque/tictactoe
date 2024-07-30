package models;

import strategies.gamewinningstrategies.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<GameWinningStrategy> gameWinningStrategies;

    private List<Move> moves;  //used for undo
    private int lastMovedPlayerIndex; //used for undo and makemove

    private GameStatus gameStatus;
    private Player winner;

    private Game()
    {
        this.players = new ArrayList<>();
        this.moves = new ArrayList<>();
        this.gameWinningStrategies = new ArrayList<>();
        this.lastMovedPlayerIndex = -1;
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public GameStatus getGameStatus()
    {
        return gameStatus;
    }

    public Player getWinner()
    {
        return winner;
    }

    public Board getBoard()
    {
        return this.board;
    }


    public boolean makeMove()
    {
        lastMovedPlayerIndex += 1;
        this.lastMovedPlayerIndex %= this.players.size();
       //Symbol symbol = this.players.get(this.lastMovedPlayerIndex).getSymbol();

       Move move = this.players.get(this.lastMovedPlayerIndex).makeMove(this.board);
       if(move == null)
       {
           this.lastMovedPlayerIndex -= 1;
           this.lastMovedPlayerIndex = (this.lastMovedPlayerIndex + this.players.size()) % this.players.size();
           return false;
       }
       this.moves.add(move);

       //set the symbol of the player in the corresponding cell in which move is done
        move.getCell().setSymbol(move.getSymbol());



       //check if this movement led to last player to win
        for(GameWinningStrategy strategy : gameWinningStrategies)
        {
            if(strategy.checkIfWon(move))
            {
                this.gameStatus = GameStatus.ENDED;
                winner = this.players.get(lastMovedPlayerIndex);
                return true;
            }
        }

            //also check for draw
        if (moves.size() == this.board.getDimension() * this.board.getDimension()) {
            gameStatus = GameStatus.DRAW;
            return true;
        }
        return  true;
    }

    public boolean Undo()
    {
//        if (this.moves.size() == 0) {
//            // Handle Edge Case
//            throw new EmptyMovesUndoOperationException();
//        }
//
        Move lastMove = moves.get(moves.size()-1);
        //lastMove.cell.clearCell();
        Cell releventcell = lastMove.getCell();
        releventcell.clearCell();
        this.lastMovedPlayerIndex -= 1;
        this.lastMovedPlayerIndex = (this.lastMovedPlayerIndex + this.players.size()) % this.players.size();
        this.moves.remove(lastMove);
        return true;
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {
        private List<Player> players;
        private int dimension;
        private List<GameWinningStrategy> gameWinningStrategies;

        Builder() {
            this.players = new ArrayList<>();
            this.gameWinningStrategies = new ArrayList<>();
        }

        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public Builder addPlayers(List<Player> players) {
            this.players.addAll(players);

            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }


        public Builder addGameWinningStrategy(GameWinningStrategy strategy) {
            this.gameWinningStrategies.add(strategy);
            return this;
        }

        public Builder addGameWinningStrategies(List<GameWinningStrategy> strategies) {
            this.gameWinningStrategies.addAll(strategies);
            return this;
        }

        private boolean checkIfSingleBotMax() {
            int count = 0;

            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    count += 1;
                }
            }

            return count <= 1;
        }

        public Game build() {
//                if (!checkIfSingleBotMax()) {
//                    throw new MultipleBotsException();
//                }

//            if (players.size() < 2) {
//                //
//            }
//
//            if (gameWinningStrategies.size() < 1) {
//                //
//            }
//
//            if (dimension < 3) {
//
//            }

            Game game = new Game();
            game.players.addAll(this.players);
            game.gameWinningStrategies.addAll(this.gameWinningStrategies);
            game.board = new Board(this.dimension);

            return game;


        }
    }

}
