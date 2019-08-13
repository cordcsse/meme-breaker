package memebreaker.core;

import java.util.*;
/**
 * AppConfig<E> Class (optionally: Singleton)</p>
 * 
 * This class will take a List<Options> (Options -> { name, default, value })
 *   inserts them into a <Map>  </p>
 * 
 * input: List<AllowedOptions>
 * output: Value<Option> | List<AllowedOptions> | List<SetOptions> | SetValue(<Value>)
 */ 
public final class AppConfig<E extends Enum<E>> {
    private final static class OptionValue {
        private final String defaultValue;
        private Optional<String> value;

        public OptionValue() { this("", null); }
        public OptionValue(final String defaultValue) { this((defaultValue == null) ? "" : defaultValue, null); }
        public OptionValue(final String defaultValue, final String initialValue) {
            this.defaultValue = defaultValue;
            this.value = Optional.ofNullable(initialValue);
        }
        public final String get() {
            return(this.value.isPresent() ? this.value.get() : this.defaultValue);
        }
        public final void set(final String value) {
            this.value = Optional.ofNullable(value);
        }
    }

    private final Class<E> allowedOptions;
    private EnumMap<E, OptionValue> options;

    public AppConfig(final Class<E> c) {
        this.allowedOptions = c;
        this.options = new EnumMap<>(c);
        for (final E option : allowedOptions.getEnumConstants()) {
            options.putIfAbsent(option, new OptionValue());
        }
    }
    public AppConfig(final Class<E> c, final E optionKey, final String optionValue) {
        this(c);
        this.setDefault(optionKey, optionValue);
    }
    public AppConfig(final Class<E> c, final Map<E, String> optionMap) {
        this(c);
        optionMap.entrySet().stream()
            .forEach(e -> this.setDefault(e.getKey(), e.getValue()));
    }
    private void setDefault(final E optionKey, final String optionValue) {
        options.put(optionKey, new OptionValue(optionValue));
    }

    public String getOption(final E optionKey) {
        return(this.options.get(optionKey).get());
    }
    public void setOption(final E optionKey, final String optionValue) {
        this.options.get(optionKey).set(optionValue);
    }
}

// Copyright (C) 2019 CSSE Club. Licensed under the Educational Community License, Version 2.0.
// See LICENSE.