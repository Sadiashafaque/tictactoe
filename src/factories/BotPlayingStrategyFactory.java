package factories;

import models.BotDifficultyLevel;
import strategies.BotPlayingStrategy;
import strategies.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public BotPlayingStrategy createBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel)
    {
        if(difficultyLevel == BotDifficultyLevel.MEDIUM || difficultyLevel == BotDifficultyLevel.EASY || difficultyLevel == BotDifficultyLevel.HARD)
        {
            return new RandomBotPlayingStrategy();
        }
        return null;
    }
}
