package memebreaker.util;

import java.util.Optional;
/**
 * Options
 */
public enum Options {
    /** ADD NEW OPTIONS HERE
     *  Format: NAME(defaultValue)
     */
    WIDTH_UNITS(400), HEIGHT_UNITS(300),
    GAME_SPEED(Integer.valueOf(200)),
    DIFFICULTY(Integer.valueOf(0)),
    DEBUG(Boolean.FALSE), LOG(Boolean.FALSE);

    // FINAL Implementation
    public final Object defaultValue;
    private transient Optional<Object> value;

    Options(Object defaultValue) {
        this.defaultValue = defaultValue;
        this.value = Optional.ofNullable(null);
    }

    public final Object get() {
        return(this.value.isPresent() ? this.value.get() : this.defaultValue);
    }
    public final Boolean set(final Object value) {
        if (this.defaultValue.getClass().isInstance(value)) {
            this.value = Optional.ofNullable(value);
            return(true);
        }
        return(false);
    }
}