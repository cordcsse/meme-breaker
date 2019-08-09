package memebreaker.gui;

import memebreaker.core.AppConfiguration;

/**
 * GameConfig
 */
public class GameConfig {

    /** Add new options here */
    private static enum AllowedOptions {
        ANIMATED_BACKGROUND, SOUND, MUSIC, OFFLINE;
    }

    public static final AppConfiguration config = new AppConfig(AllowedOptions.class); 
}