package memebreaker.core;
/**
 * AppConfiguration Class (Optional: Singleton)
 */
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

/**
 * Configuration Class </p>
 * 
 * This class will take a List<Options> (Options -> { name, default, value })
 *   inserts them into a <Set>  </p>
 * 
 * input: List<AllowedOptions>
 * output: Value<Option> | List<AllowedOptions> | List<SetOptions> | SetValue(<Value>)
 */
public final class AppConfig<E extends Enum> {
    private static class OptionValue {
        private final String defaultValue;
        private Optional<String> value;

        protected OptionValue() { this("", null); }
        protected OptionValue(final String defaultValue) { this((defaultValue == null) ? "" : defaultValue, null); }
        protected OptionValue(final String defaultValue, String initialValue) {
            this.defaultValue = defaultValue;
            this.value = Optional.ofNullable(initialValue);
        }
        public String get() {
            return(this.value.isPresent() ? this.value.get() : this.defaultValue);
        }
        public void set(String value) {
            this.value = Optional.ofNullable(value);
        }
    }

    private final Class<E> allowedOptions;
    private EnumMap<E, OptionValue> options;

    public AppConfig(final Class<E> c) {
        this.allowedOptions = c;
        for (E option : allowedOptions.getEnumConstants()) {
            options.putIfAbsent(option, new OptionValue());
        }
    }
    public AppConfig(final Class<E> c, E optionKey, String optionValue) {
        this(c);
        this.setDefault(optionKey, optionValue);
    }
    public AppConfig(final Class<E> c, Map<E, String> optionMap) {
        this(c);
        optionMap.entrySet().stream()
            .forEach(e -> this.setDefault(e.getKey(), e.getValue()));
    }
    private void setDefault(E optionKey, String optionValue) {
        options.put(optionKey, new OptionValue(optionValue));
    }

    public String getOption(E optionKey) {
        return(this.options.get(optionKey).get());
    }
    public void setOption(E optionKey, String optionValue) {
        this.options.get(optionKey).set(optionValue);
    }
}

// Copyright (C) 2019 CSSE Club. Licensed under the Educational Community License, Version 2.0.
// See LICENSE.