package memebreaker.util;

import java.util.*;
import memebreaker.util.ConfigOptions;
/**
 * <b>Config Class</b></p>
 * 
 * This class will be instantiated once, as an interpreted Singleton, and will have it's 
 *   options set and reset during operation. </p>
 * 
 * input: Map&lt;ConfigOptions, String> </p>
 * output: Value<String> | ValueList<String> | EnumMap<ConfigOptions, OptionValue>
 */ 
public final class Config {
    private final static class OptionValue {
        private final Object defaultValue;
        private Optional<Object> value;

        public OptionValue(final Object defaultValue) { this((defaultValue == null) ? "" : defaultValue, null); }
        public OptionValue(final Object defaultValue, final Object initialValue) {
            this.defaultValue = defaultValue;
            this.value = Optional.ofNullable(initialValue);
        }
        public final Object get() {
            return(this.value.isPresent() ? this.value.get() : this.defaultValue);
        }
        public final void set(final Object value) {
            this.value = Optional.ofNullable(value);
        }
    }

    private EnumMap<ConfigOptions, OptionValue> options;

    public Config() {
        options = new EnumMap<>(ConfigOptions.class);
        EnumSet.allOf(ConfigOptions.class)
            .stream().forEach(e -> options.putIfAbsent(e, new OptionValue(e.defaultValue)));
    }
    public Config(final ConfigOptions optionKey, final Object optionValue) {
        this();
        this.setDefault(optionKey, optionValue);
    }
    public Config(final Map<ConfigOptions, String> optionMap) {
        this();
        optionMap.entrySet().stream()
            .forEach(e -> this.setDefault(e.getKey(), e.getValue()));
    }
    // --- --- ---

    private void setDefault(final ConfigOptions optionKey, final Object optionValue) {
        options.put(optionKey, new OptionValue(optionKey.defaultValue, optionValue));
    }

    public Object getOption(final ConfigOptions optionKey) {
        return(this.options.get(optionKey).get());
    }

    public void setOption(final ConfigOptions optionKey, final Object optionValue) {
        this.options.get(optionKey).set(optionValue);
    }

    public List<Object> listOptions(final Collection<ConfigOptions> optionKeys) {
        List<Object> result = new ArrayList<>();
        optionKeys.forEach(
            option -> {
                result.add(option);
                result.add(this.options.get(option).get());
            }
        );

        return(List.copyOf(result));
    }
}

// Copyright (C) 2019 CSSE Club. Licensed under the Educational Community License, Version 2.0.
// See LICENSE.