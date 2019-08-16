package memebreaker.util;

import java.util.*;
import memebreaker.util.Options;
/**
 * <b>Config Class</b></p>
 * 
 * This class will be instantiated once, as an interpreted Singleton, and will have it's 
 *   options set and reset during operation. </p>
 * 
 * input: Map&lt;Options, String> </p>
 * output: Value<String> | ValueList<String> | EnumMap<Options, OptionValue>
 */ 
public final class Config {

    private final Map<String, Options> options;

    public Config() {
        Map<String, Options> tempMap = new HashMap<>();
        for (Options opt : Options.values()) {
            tempMap.put(opt.name(), opt);
        }
        this.options = Map.copyOf(tempMap);
    }
    public Config(final Options key, final Object value) {
        this();
        this.setOption(key, value);
    }
    public Config(final Map<Options, String> optionMap) {
        this();
        optionMap.entrySet().stream()
            .forEach(e -> this.setOption(e.getKey(), e.getValue()));
    }
    // --- --- ---

    public List<Options> listOptions() {
        return(List.copyOf(this.options.values()));
    }

    public Object getOption(final String option) {
        return(options.get(option).get());
    }
    public Object getOption(final Options option) { return(this.getOption(option.name())); }

    public Boolean setOption(final String option, Object value) {
        return(this.options.get(option).set(value));
    }
    public Boolean setOption(final Options option, final Object value) { return(this.setOption(option.name(), value)); }
}

// Copyright (C) 2019 CSSE Club. Licensed under the Educational Community License, Version 2.0.
// See LICENSE.