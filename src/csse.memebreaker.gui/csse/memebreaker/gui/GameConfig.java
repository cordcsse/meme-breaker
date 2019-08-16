package csse.memebreaker.gui;

import csse.memebreaker.core.AppConfig;
/**
 * GameConfig
 */
public class GameConfig {

    /** Add new options here */
    private static enum AllowedOptions {
        ANIMATED_BACKGROUND, SOUND, MUSIC, OFFLINE;
    }

    public static final AppConfig config = new AppConfig(AllowedOptions.class); 
}