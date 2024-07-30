package models;

import factories.BotPlayingStrategyFactory;
import strategies.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(PlayerType.BOT, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = new BotPlayingStrategyFactory().createBotPlayingStrategyForDifficultyLevel(
                botDifficultyLevel);

    }
    @Override
        public Move makeMove(Board board)
        {
            return this.botPlayingStrategy.makeNextMove(board,this);
        }
}
