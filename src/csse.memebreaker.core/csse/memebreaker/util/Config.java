package csse.memebreaker.util;

import java.util.*;
import csse.memebreaker.util.Option;
/**
 * <b>Config Class</b></p>
 * 
 * This class will be instantiated once, as an interpreted Singleton, and will have it's 
 *   Option set and reset during operation. </p>
 * 
 * input: Map&lt;Option, String> </p>
 * output: Value<String> | ValueList<String> | EnumMap<Option, OptionValue>
 */ 
public final class Config {

    private final Map<String, Option> options;

    public Config() {
        Map<String, Option> tempMap = new HashMap<>();
        for (Option opt : Option.values()) {
            tempMap.put(opt.name(), opt);
        }
        this.options= Map.copyOf(tempMap);
    }
    public Config(final Option key, final Object value) {
        this();
        this.setOption(key, value);
    }
    public Config(final Map<Option, String> optionMap) {
        this();
        optionMap.entrySet().stream()
            .forEach(e -> this.setOption(e.getKey(), e.getValue()));
    }
    // --- --- ---

    public List<Option> listOption() {
        return(List.copyOf(this.options.values()));
    }

    public Object getOption(final String option) {
        return(this.options.get(option).get());
    }
    public Object getOption(final Option option) { return(this.getOption(option.name())); }

    public Boolean setOption(final String option, Object value) {
        return(this.options.get(option).set(value));
    }
    public Boolean setOption(final Option option, final Object value) { return(this.setOption(option.name(), value)); }
}

// Copyright (C) 2019 CSSE Club. Licensed under the Educational Community License, Version 2.0.
// See LICENSE.