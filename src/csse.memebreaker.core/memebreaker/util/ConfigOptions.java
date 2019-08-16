package memebreaker.util;

/**
 * ConfigOptions
 */
public enum ConfigOptions {
    WIDTH_UNITS(""), HEIGHT_UNITS(""), GAME_SPEED(Integer.valueOf(200)),
    DIFFICULTY(Integer.valueOf(0)), DEBUG(Boolean.FALSE), LOG(Boolean.FALSE);

    public final Object defaultValue;

    ConfigOptions(Object defaultValue) {
        this.defaultValue = defaultValue;
    }
}