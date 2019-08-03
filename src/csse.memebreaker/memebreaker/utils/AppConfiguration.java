package memebreaker.utils;
/**
 * AppConfiguration (Singleton) Class
 */
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Optional;

public final class AppConfiguration {
    private static enum AllowedOptions { ANIMATED_BACKGROUND, SOUND, MUSIC, OFFLINE; }
    private EnumSet<AllowedOptions> options;

    private static Boolean match(String option, Collection<AllowedOptions> c) {
        return(c.stream()
                .anyMatch(opt -> opt.name().equals(option))
        );
    }
    private static Boolean isOption(String option) {
        return( match(option, Arrays.asList(AllowedOptions.values())) );
    }
    private static AllowedOptions toOption(String option) {
        return(AllowedOptions.valueOf(option));
    }

    public Boolean contains(String option) {
        if (isOption(option)) {
            return( this.options.contains(toOption(option)) );
        }
        return(false);
    }

    public void set(String option) {
        if (isOption(option)) { this.options.add(toOption(option)); }
    }
    public void unset(String option) {
        if (isOption(option)) { this.options.remove(toOption(option)); }
    }

    public Optional<AllowedOptions> getOption(String option) {
        return(Optional.ofNullable(
            isOption(option) ? AllowedOptions.valueOf(option) : null
        ));
    }
}